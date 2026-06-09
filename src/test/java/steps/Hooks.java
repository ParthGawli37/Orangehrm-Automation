package steps;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;
import org.testng.SkipException;
import utils.FailureManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {

	private static boolean executionStarted = false;

	private static final Logger logger = LogManager.getLogger(Hooks.class);

	@Before
	public void setup() {

		if (!executionStarted) {

			FailureManager.reset();

			logger.info("========================================");

			logger.info("EXECUTING ON ENVIRONMENT : {}", ConfigReader.getEnvironment().toUpperCase());

			logger.info("TARGET URL : {}", ConfigReader.getApplicationUrl());

			logger.info("BROWSER : {}", ConfigReader.getBrowser().toUpperCase());

			logger.info("FRAMEWORK MODE : {}", ConfigReader.getFrameworkMode().toUpperCase());

			logger.info("FAILURE THRESHOLD : {}", ConfigReader.getFailureThreshold());

			logger.info("========================================");

			executionStarted = true;
		}

		if (FailureManager.shouldStopExecution()) {

			throw new SkipException(
					"Execution stopped. Failure threshold reached: " + FailureManager.getFailureCount());
		}

		DriverFactory.initDriver(ConfigReader.getBrowser());
	}

	@After
	public void tearDown() {

		DriverFactory.quitDriver();
	}
}