package tests;

import base.BaseTest;
import base.DriverFactory;
import executor.ScenarioExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.FailureManager;
import utils.TestCaseReader;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ExcelDrivenRunner extends BaseTest {

	@Test
	public void executeScenariosFromExcel() {

		FailureManager.reset();

		LocalDateTime startTime = LocalDateTime.now();

		Set<String> scenarioIds = TestCaseReader.getExecutableScenarioIds();

		int totalWorkbookScenarios = TestCaseReader.getTotalScenarioCount();

		int selectedScenarios = scenarioIds.size();

		logger.info("========================================");
		logger.info("STARTING EXCEL EXECUTION");
		logger.info("========================================");

		logger.info("Executable Scenarios : {}", selectedScenarios);

		int passed = 0;
		int failed = 0;
		int notImplemented = 0;

		List<String> passedScenarioIds = new ArrayList<>();

		List<String> failedScenarioIds = new ArrayList<>();

		List<String> notImplementedScenarioIds = new ArrayList<>();

		for (String scenarioId : scenarioIds) {
			if (FailureManager.shouldStopExecution()) {

				logger.error("FAILURE THRESHOLD REACHED : {}", FailureManager.getFailureCount());

				logger.error("STOPPING EXCEL EXECUTION");

				break;
			}

			logger.info("Executing Scenario : {}", scenarioId);

			try {

				boolean result = ScenarioExecutor.execute(scenarioId);

				if (result) {

					passed++;

					passedScenarioIds.add(scenarioId);

					logger.info("{} PASSED", scenarioId);

				} else {

					notImplemented++;

					notImplementedScenarioIds.add(scenarioId);

					logger.warn("{} NOT_IMPLEMENTED", scenarioId);
				}

			} catch (Exception e) {

				failed++;

				FailureManager.recordFailure();

				failedScenarioIds.add(scenarioId);

				System.out.println("=================================");

				System.out.println("FAILED SCENARIO : " + scenarioId);

				e.printStackTrace();

				System.out.println("=================================");
			}

			try {

				DriverFactory.getDriver().getCurrentUrl();

			} catch (Exception driverException) {

				logger.error("DRIVER SESSION LOST AFTER SCENARIO : {}", scenarioId);

				break;
			}
		}
		LocalDateTime endTime = LocalDateTime.now();

		long executionSeconds = Duration.between(startTime, endTime).toSeconds();

		int automatedScenarios = passed + failed;

		double selectedCoverage = selectedScenarios == 0 ? 0 : ((double) automatedScenarios / selectedScenarios) * 100;

		double workbookCoverage = totalWorkbookScenarios == 0 ? 0
				: ((double) automatedScenarios / totalWorkbookScenarios) * 100;

		logger.info("");
		logger.info("========================================");
		logger.info("EXCEL EXECUTION SUMMARY");
		logger.info("========================================");

		logger.info("Workbook Scenarios      : {}", totalWorkbookScenarios);

		logger.info("Selected By Priority    : {}", selectedScenarios);

		logger.info("Automated Mapped        : {}", automatedScenarios);

		logger.info("Not Implemented         : {}", notImplemented);

		logger.info("Passed                  : {}", passed);

		logger.info("Failed                  : {}", failed);

		logger.info("Execution Time (sec)    : {}", executionSeconds);

		logger.info("Coverage (Selected)     : {}%", String.format("%.2f", selectedCoverage));

		logger.info("Coverage (Workbook)     : {}%", String.format("%.2f", workbookCoverage));

		logger.info("========================================");

		logger.info("");
		logger.info("========================================");
		logger.info("PASSED SCENARIOS");
		logger.info("========================================");

		if (passedScenarioIds.isEmpty()) {

			logger.info("None");

		} else {

			passedScenarioIds.forEach(id -> logger.info(id));
		}

		logger.info("");
		logger.info("========================================");
		logger.info("FAILED SCENARIOS");
		logger.info("========================================");

		if (failedScenarioIds.isEmpty()) {

			logger.info("None");

		} else {

			failedScenarioIds.forEach(id -> logger.info(id));
		}

		logger.info("");
		logger.info("========================================");
		logger.info("NOT IMPLEMENTED SCENARIOS");
		logger.info("========================================");

		if (notImplementedScenarioIds.isEmpty()) {

			logger.info("None");

		} else {

			notImplementedScenarioIds.forEach(id -> logger.info(id));
		}

		if (failed > 0) {

			Assert.fail(failed + " scenario(s) failed. Check execution logs.");
		}
	}
}