package utils;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {

    private static final int EXPLICIT_WAIT =
            ConfigReader.getExplicitWait();

    private static final int POLLING_INTERVAL =
            ConfigReader.getPollingIntervalMillis();

    private static final int MAX_WAIT_RETRY =
            ConfigReader.getMaxWaitRetry();

    private static final int STALE_RETRY_COUNT =
            ConfigReader.getStaleElementRetryCount();

    private WaitUtil() {
    }

    private static WebDriverWait getWait() {

        WebDriverWait wait =
                new WebDriverWait(
                        DriverFactory.getDriver(),
                        Duration.ofSeconds(EXPLICIT_WAIT)
                );

        wait.pollingEvery(
                Duration.ofMillis(POLLING_INTERVAL)
        );

        return wait;
    }

    public static WebElement waitForVisibility(
            WebElement element) {

        int attempt = 0;

        while (attempt < MAX_WAIT_RETRY) {

            try {

                return getWait().until(
                        ExpectedConditions.visibilityOf(
                                element
                        )
                );

            } catch (StaleElementReferenceException e) {

                attempt++;

                System.out.println(
                        "Retrying visibility check. Attempt: "
                                + attempt
                );

            } catch (TimeoutException e) {

                attempt++;

                System.out.println(
                        "Visibility timeout. Attempt: "
                                + attempt
                );
            }
        }

        throw new RuntimeException(
                "Element not visible after "
                        + MAX_WAIT_RETRY
                        + " retries."
        );
    }

    public static WebElement waitForClickable(
            WebElement element) {

        int attempt = 0;

        while (attempt < MAX_WAIT_RETRY) {

            try {

                return getWait().until(
                        ExpectedConditions.elementToBeClickable(
                                element
                        )
                );

            } catch (StaleElementReferenceException e) {

                attempt++;

                System.out.println(
                        "Retrying clickable check. Attempt: "
                                + attempt
                );

            } catch (TimeoutException e) {

                attempt++;

                System.out.println(
                        "Clickable timeout. Attempt: "
                                + attempt
                );
            }
        }

        throw new RuntimeException(
                "Element not clickable after "
                        + MAX_WAIT_RETRY
                        + " retries."
        );
    }

    public static WebElement waitForPresence(
            By locator) {

        int attempt = 0;

        while (attempt < MAX_WAIT_RETRY) {

            try {

                return getWait().until(
                        ExpectedConditions.presenceOfElementLocated(
                                locator
                        )
                );

            } catch (TimeoutException e) {

                attempt++;

                System.out.println(
                        "Presence timeout. Attempt: "
                                + attempt
                );
            }
        }

        throw new RuntimeException(
                "Element not present after "
                        + MAX_WAIT_RETRY
                        + " retries."
        );
    }

    public static boolean waitForUrlContains(
            String text) {

        int attempt = 0;

        while (attempt < MAX_WAIT_RETRY) {

            try {

                return getWait().until(
                        ExpectedConditions.urlContains(
                                text
                        )
                );

            } catch (TimeoutException e) {

                attempt++;

                System.out.println(
                        "URL wait timeout. Attempt: "
                                + attempt
                );
            }
        }

        return false;
    }

    public static boolean waitForTitleContains(
            String text) {

        int attempt = 0;

        while (attempt < MAX_WAIT_RETRY) {

            try {

                return getWait().until(
                        ExpectedConditions.titleContains(
                                text
                        )
                );

            } catch (TimeoutException e) {

                attempt++;

                System.out.println(
                        "Title wait timeout. Attempt: "
                                + attempt
                );
            }
        }

        return false;
    }

    public static void sleep(
            int seconds) {

        try {

            Thread.sleep(
                    seconds * 1000L
            );

        } catch (InterruptedException e) {

            Thread.currentThread()
                    .interrupt();
        }
    }
}