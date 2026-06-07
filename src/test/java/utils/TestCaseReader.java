package utils;

import java.util.LinkedHashSet;
import java.util.Set;

public class TestCaseReader {

    private static final String FILE_PATH =
            System.getProperty("user.dir")
                    + "/src/test/resources/testdata/"
                    + ConfigReader.getProperty("testdata.file");

    private static final String SCENARIO_SHEET =
            "Test Scenarios";

    private TestCaseReader() {
    }

    public static Set<String> getExecutableScenarioIds() {

        Set<String> executableScenarios =
                new LinkedHashSet<>();

        ExcelUtil excel =
                new ExcelUtil(
                        FILE_PATH,
                        SCENARIO_SHEET
                );

        String configuredPriority =
                ConfigReader.getProperty(
                        "execution.priority"
                );

        String configuredScenario =
                ConfigReader.getProperty(
                        "execution.scenario"
                );

        int rowCount =
                excel.getRowCount();

        for (int row = 1; row <= rowCount; row++) {

            String scenarioId =
                    excel.getCellData(row, 0);

            String priority =
                    excel.getCellData(row, 3);

            if (configuredScenario != null
                    && !configuredScenario.trim().isEmpty()) {

                if (scenarioId.equalsIgnoreCase(
                        configuredScenario.trim())) {

                    executableScenarios.add(
                            scenarioId
                    );
                }

                continue;
            }

            if (PriorityUtil.shouldExecute(
                    priority,
                    configuredPriority)) {

                executableScenarios.add(
                        scenarioId
                );
            }
        }

        excel.closeWorkbook();

        return executableScenarios;
    }

    public static int getTotalScenarioCount() {

        ExcelUtil excel =
                new ExcelUtil(
                        FILE_PATH,
                        SCENARIO_SHEET
                );

        int totalScenarios =
                excel.getRowCount();

        excel.closeWorkbook();

        return totalScenarios;
    }
}