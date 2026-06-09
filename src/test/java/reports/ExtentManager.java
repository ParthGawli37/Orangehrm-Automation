package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.ConfigReader;

public class ExtentManager {

	private static ExtentReports extentReports;

	private ExtentManager() {
	}

	public static ExtentReports getInstance() {

		if (extentReports == null) {

			String reportPath = System.getProperty("user.dir") + "/reports/extent/ExtentReport.html";

			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

			sparkReporter.config().setDocumentTitle("OrangeHRM Automation Report");

			sparkReporter.config().setReportName("OrangeHRM Test Execution Results");

			extentReports = new ExtentReports();

			extentReports.attachReporter(sparkReporter);

			extentReports.setSystemInfo("Project", "OrangeHRM Automation");

			extentReports.setSystemInfo("Framework", "Selenium + TestNG");

			extentReports.setSystemInfo("Tester", "Parth");

			extentReports.setSystemInfo("Environment", ConfigReader.getEnvironment().toUpperCase());

			extentReports.setSystemInfo("Browser", ConfigReader.getBrowser());

			extentReports.setSystemInfo("Execution Mode", ConfigReader.getFrameworkMode());

			extentReports.setSystemInfo("Application URL", ConfigReader.getApplicationUrl());
		}

		return extentReports;
	}
}