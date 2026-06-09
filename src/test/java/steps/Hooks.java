package steps;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;
import org.testng.SkipException;
import utils.FailureManager;

public class Hooks {

	private static boolean executionStarted = false;

	@Before
	public void setup() {

		if (!executionStarted) {

			FailureManager.reset();

			executionStarted = true;
		}

		if (FailureManager.shouldStopExecution()) {

			throw new SkipException(
					"Execution stopped. Failure threshold reached: " + FailureManager.getFailureCount());
		}

		DriverFactory.initDriver(ConfigReader.getProperty("browser"));
	}

	@After
	public void tearDown() {

		DriverFactory.quitDriver();
	}
}