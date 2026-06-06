package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentManager;
import utils.ConfigReader;
import utils.ScreenshotUtil;

public class TestListener
        implements ITestListener {

    private static final ExtentReports extent =
            ExtentManager.getInstance();

    private static final ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    private static int passedCount = 0;
    private static int failedCount = 0;
    private static int skippedCount = 0;

    @Override
    public void onTestStart(
            ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(
                        result.getMethod()
                                .getMethodName()
                );

        test.set(extentTest);

        test.get().info(
                "Test Started"
        );
    }

    @Override
    public void onTestSuccess(
            ITestResult result) {

        passedCount++;

        test.get().pass(
                "Test Passed"
        );

        if (ConfigReader.isScreenshotOnPass()) {

            attachScreenshot(
                    result,
                    "PASS"
            );
        }
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        failedCount++;

        test.get().fail(
                result.getThrowable()
        );

        if (ConfigReader.isScreenshotOnFail()) {

            attachScreenshot(
                    result,
                    "FAIL"
            );
        }
    }

    @Override
    public void onTestSkipped(
            ITestResult result) {

        skippedCount++;

        test.get().skip(
                "Test Skipped"
        );
    }

    @Override
    public void onFinish(
            ITestContext context) {

        testSummary(context);

        extent.flush();
    }

    private void attachScreenshot(
            ITestResult result,
            String status) {

        try {

            String screenshotPath =
                    ScreenshotUtil.captureScreenshot(
                            result.getMethod()
                                    .getMethodName()
                                    + "_"
                                    + status
                    );

            test.get()
                    .addScreenCaptureFromPath(
                            screenshotPath
                    );

        } catch (Exception e) {

            test.get().warning(
                    "Screenshot could not be attached."
            );
        }
    }

    private void testSummary(
            ITestContext context) {

        ExtentTest summary =
                extent.createTest(
                        "Execution Summary"
                );

        summary.info(
                "Passed : " + passedCount
        );

        summary.info(
                "Failed : " + failedCount
        );

        summary.info(
                "Skipped : " + skippedCount
        );

        summary.info(
                "Total : "
                        + (passedCount
                        + failedCount
                        + skippedCount)
        );

        summary.info(
                "Suite : "
                        + context.getSuite()
                                 .getName()
        );
    }
}