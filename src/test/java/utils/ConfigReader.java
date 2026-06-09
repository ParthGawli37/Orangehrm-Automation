package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static final Properties properties = new Properties();

	static {

		try {

			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/config/config.properties");

			properties.load(file);

			file.close();

		} catch (IOException e) {

			throw new RuntimeException("Failed to load config.properties file", e);
		}
	}

	private ConfigReader() {
	}

	// ==========================
	// Generic Getter
	// ==========================

	public static String getProperty(String key) {

		return properties.getProperty(key);
	}

	// ==========================
	// String Getters
	// ==========================

	public static String getBrowser() {

		return getProperty("browser");
	}

	public static String getApplicationUrl() {

		String environment = getEnvironment();

		return getProperty(environment + ".url");
	}

	public static String getUsername() {

		return getProperty("username");
	}

	public static String getPassword() {

		return getProperty("password");
	}

	public static String getExecutionPriority() {

		return getProperty("execution.priority");
	}

	public static String getFrameworkMode() {

		return getProperty("framework.mode");
	}

	public static String getTestDataFile() {

		return getProperty("testdata.file");
	}

	public static String getEnvironment() {

		return getProperty("environment");
	}

	// ==========================
	// Integer Getters
	// ==========================

	public static int getImplicitWait() {

		return Integer.parseInt(getProperty("implicit.wait"));
	}

	public static int getExplicitWait() {

		return Integer.parseInt(getProperty("explicit.wait"));
	}

	public static int getPageLoadTimeout() {

		return Integer.parseInt(getProperty("page.load.timeout"));
	}

	public static int getRetryCount() {

		return Integer.parseInt(getProperty("retry.count"));
	}

	public static int getRetryWaitSeconds() {

		return Integer.parseInt(getProperty("retry.wait.seconds"));
	}

	public static int getMaxWaitRetry() {

		return Integer.parseInt(getProperty("max.wait.retry"));
	}

	public static int getPollingIntervalMillis() {

		return Integer.parseInt(getProperty("polling.interval.millis"));
	}

	public static int getFailureThreshold() {

		return Integer.parseInt(getProperty("execution.failure.threshold"));
	}

	public static int getStaleElementRetryCount() {

		return Integer.parseInt(getProperty("stale.element.retry.count"));
	}

	// ==========================
	// Boolean Getters
	// ==========================

	public static boolean isHeadless() {

		return Boolean.parseBoolean(getProperty("headless"));
	}

	public static boolean isScreenshotOnPass() {

		return Boolean.parseBoolean(getProperty("screenshot.on.pass"));
	}

	public static boolean isScreenshotOnFail() {

		return Boolean.parseBoolean(getProperty("screenshot.on.fail"));
	}

	public static boolean isScreenshotOnRetry() {

		return Boolean.parseBoolean(getProperty("screenshot.on.retry"));
	}

	public static boolean isRetryOnlyOnFailure() {

		return Boolean.parseBoolean(getProperty("retry.only.on.failure"));
	}

	public static boolean isRetryLoggingEnabled() {

		return Boolean.parseBoolean(getProperty("retry.log.attempts"));
	}

	public static boolean isWaitForVisibilityEnabled() {

		return Boolean.parseBoolean(getProperty("wait.for.visibility"));
	}

	public static boolean isWaitForClickableEnabled() {

		return Boolean.parseBoolean(getProperty("wait.for.clickable"));
	}

	public static boolean isWaitForPageReadyEnabled() {

		return Boolean.parseBoolean(getProperty("wait.for.page.ready"));
	}

	public static boolean isWaitForAjaxEnabled() {

		return Boolean.parseBoolean(getProperty("wait.for.ajax.complete"));
	}
}