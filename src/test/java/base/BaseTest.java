package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.time.Duration;

public class BaseTest {

    protected final Logger logger =
            LogManager.getLogger(
                    this.getClass()
            );

    @BeforeMethod
    public void setUp() {

        logger.info(
                "========================================="
        );

        logger.info(
                "Starting Test Execution"
        );

        logger.info(
                "Browser : {}",
                ConfigReader.getBrowser()
        );

        logger.info(
                "Framework Mode : {}",
                ConfigReader.getFrameworkMode()
        );

        DriverFactory.initDriver(
                ConfigReader.getBrowser()
        );

        getDriver()
                .manage()
                .timeouts()
                .pageLoadTimeout(
                        Duration.ofSeconds(
                                ConfigReader
                                        .getPageLoadTimeout()
                        )
                );

        getDriver()
                .manage()
                .timeouts()
                .implicitlyWait(
                        Duration.ofSeconds(
                                ConfigReader
                                        .getImplicitWait()
                        )
                );

        getDriver().get(
                ConfigReader.getApplicationUrl()
        );

        logger.info(
                "Application URL Loaded : {}",
                ConfigReader.getApplicationUrl()
        );

        logger.info(
                "Execution Priority : {}",
                ConfigReader.getExecutionPriority()
        );

        logger.info(
                "========================================="
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        try {

            logger.info(
                    "Closing Browser"
            );

            DriverFactory.quitDriver();

            logger.info(
                    "Browser Closed Successfully"
            );

        } catch (Exception e) {

            logger.error(
                    "Error while closing browser",
                    e
            );
        }

        logger.info(
                "========================================="
        );
    }

    protected WebDriver getDriver() {

        return DriverFactory.getDriver();
    }
}