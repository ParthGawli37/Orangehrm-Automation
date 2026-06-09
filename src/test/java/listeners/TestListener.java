package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentManager;
import utils.ConfigReader;
import utils.ScreenshotUtil;
import utils.FailureManager;

public class TestListener implements ITestListener {

	private static final ExtentReports extent = ExtentManager.getInstance();

	private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	private static int passedCount = 0;
	private static int failedCount = 0;
	private static int skippedCount = 0;

	@Override
	public void onTestStart(ITestResult result) {

		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());

		test.set(extentTest);

		test.get().info("Test Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		passedCount++;

		test.get().pass("Test Passed");

		if (ConfigReader.isScreenshotOnPass()) {

			attachScreenshot(result, "PASS");
		}
	}

	@Override
	public void onTestFailure(
	        ITestResult result) {

	    System.out.println(
	            "FAILURE MANAGER RECORDING FAILURE"
	    );

	    failedCount++;

	    FailureManager.recordFailure();

	    test.get().fail(
	            result.getThrowable()
	    );

	    System.out.println(
	            "SCREENSHOT ON FAIL = "
	                    + ConfigReader.isScreenshotOnFail()
	    );

	    if (ConfigReader.isScreenshotOnFail()) {

	        attachScreenshot(
	                result,
	                "FAIL"
	        );
	    }
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		skippedCount++;

		test.get().skip("Test Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {

		testSummary(context);

		extent.flush();
	}

	private void attachScreenshot(
	        ITestResult result,
	        String status) {

	    try {

	        System.out.println(
	                "ATTACH SCREENSHOT CALLED"
	        );

	        String screenshotPath =
	        		
	                ScreenshotUtil.captureScreenshot(
	                		
	                        result.getMethod()
	                                .getMethodName()
	                                + "_"
	                                + status
	                );

	        System.out.println(
	                "SCREENSHOT PATH = "
	                        + screenshotPath
	        );

	        test.get()
	                .addScreenCaptureFromPath(
	                        screenshotPath
	                );

	        System.out.println(
	                "SCREENSHOT ATTACHED TO EXTENT"
	        );

	    } catch (Exception e) {

	        System.out.println(
	                "SCREENSHOT ATTACHMENT FAILED"
	        );

	        e.printStackTrace();

	        test.get().warning(
	                "Screenshot could not be attached."
	        );
	    }
	}

	private void testSummary(ITestContext context) {

	    System.out.println();
	    System.out.println("========================================");
	    System.out.println("CUCUMBER EXECUTION SUMMARY");
	    System.out.println("========================================");

	    System.out.printf("%-25s %s%n",
	            "Suite :",
	            context.getSuite().getName());

	    System.out.printf("%-25s %s%n",
	            "Browser :",
	            ConfigReader.getBrowser());

	    System.out.printf("%-25s %s%n",
	            "Framework Mode :",
	            ConfigReader.getFrameworkMode());

	    System.out.printf("%-25s %d%n",
	            "Passed :",
	            passedCount);

	    System.out.printf("%-25s %d%n",
	            "Failed :",
	            failedCount);

	    System.out.printf("%-25s %d%n",
	            "Skipped :",
	            skippedCount);

	    System.out.printf("%-25s %d%n",
	            "Total :",
	            (passedCount + failedCount + skippedCount));

	    System.out.printf("%-25s %d%n",
	            "Failure Threshold :",
	            ConfigReader.getFailureThreshold());

	    System.out.println("========================================");
	}
}