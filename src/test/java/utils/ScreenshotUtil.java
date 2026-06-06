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

        try {

            FileUtils.copyFile(
                    sourceFile,
                    destinationFile
            );

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to capture screenshot",
                    e
            );
        }

        return screenshotPath;
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