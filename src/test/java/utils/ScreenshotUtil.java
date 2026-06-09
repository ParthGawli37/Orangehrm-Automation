package utils;

import base.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    private ScreenshotUtil() {
    }
    public static String captureScreenshot(
            String testName) {

        System.out.println(
                "CAPTURING SCREENSHOT"
        );

        System.out.println(
                "DRIVER INSTANCE = "
                        + DriverFactory.getDriver()
        );

        String timestamp =
                LocalDateTime.now()
                        .format(
                                DateTimeFormatter.ofPattern(
                                        "yyyyMMdd_HHmmss"
                                )
                        );

        String browser =
                ConfigReader.getBrowser();

        String screenshotDir =
                System.getProperty("user.dir")
                        + "/reports/screenshots/";

        File directory =
                new File(screenshotDir);

        if (!directory.exists()) {

            directory.mkdirs();
        }

        String screenshotPath =
                screenshotDir
                        + testName
                        + "_"
                        + browser
                        + "_"
                        + timestamp
                        + ".png";

        try {

            File sourceFile =
                    ((TakesScreenshot)
                            DriverFactory.getDriver())
                            .getScreenshotAs(
                                    OutputType.FILE
                            );

            File destinationFile =
                    new File(
                            screenshotPath
                    );

            FileUtils.copyFile(
                    sourceFile,
                    destinationFile
            );

            System.out.println(
                    "SCREENSHOT SAVED = "
                            + screenshotPath
            );

            return screenshotPath;

        } catch (Exception e) {

            System.out.println(
                    "SCREENSHOT CAPTURE FAILED"
            );

            e.printStackTrace();

            throw new RuntimeException(
                    "Failed to capture screenshot",
                    e
            );
        }
    }

    public static String captureFailureScreenshot(
            String testName) {

        return captureScreenshot(
                testName + "_FAIL"
        );
    }

    public static String capturePassScreenshot(
            String testName) {

        return captureScreenshot(
                testName + "_PASS"
        );
    }

    public static String captureRetryScreenshot(
            String testName) {

        return captureScreenshot(
                testName + "_RETRY"
        );
    }
}