package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

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
		}

		return extentReports;
	}
}