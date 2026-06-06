package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.ConfigReader;
import utils.WaitUtil;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    private DriverFactory() {
    }

    public static void initDriver(
            String browser) {

        int retryCount = 0;

        while (retryCount <= ConfigReader.getRetryCount()) {

            try {

                switch (browser.toLowerCase()) {

                    case "firefox":

                        WebDriverManager
                                .firefoxdriver()
                                .setup();

                        FirefoxOptions firefoxOptions =
                                new FirefoxOptions();

                        if (ConfigReader.isHeadless()) {

                            firefoxOptions.addArguments(
                                    "--headless"
                            );
                        }

                        driver.set(
                                new FirefoxDriver(
                                        firefoxOptions
                                )
                        );

                        break;

                    case "edge":

                        WebDriverManager
                                .edgedriver()
                                .setup();

                        EdgeOptions edgeOptions =
                                new EdgeOptions();

                        if (ConfigReader.isHeadless()) {

                            edgeOptions.addArguments(
                                    "--headless=new"
                            );
                        }

                        driver.set(
                                new EdgeDriver(
                                        edgeOptions
                                )
                        );

                        break;

                    case "chrome":
                    default:

                        WebDriverManager
                                .chromedriver()
                                .setup();

                        ChromeOptions chromeOptions =
                                new ChromeOptions();

                        chromeOptions.addArguments(
                                "--remote-allow-origins=*"
                        );

                        chromeOptions.addArguments(
                                "--disable-notifications"
                        );

                        chromeOptions.addArguments(
                                "--disable-popup-blocking"
                        );

                        chromeOptions.addArguments(
                                "--start-maximized"
                        );

                        if (ConfigReader.isHeadless()) {

                            chromeOptions.addArguments(
                                    "--headless=new"
                            );
                        }

                        driver.set(
                                new ChromeDriver(
                                        chromeOptions
                                )
                        );

                        break;
                }

                return;

            } catch (Exception e) {

                retryCount++;

                System.out.println(
                        "Browser startup retry attempt: "
                                + retryCount
                );

                WaitUtil.sleep(
                        ConfigReader.getRetryWaitSeconds()
                );
            }
        }

        throw new RuntimeException(
                "Failed to initialize browser after retries."
        );
    }

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();

            driver.remove();
        }
    }
}