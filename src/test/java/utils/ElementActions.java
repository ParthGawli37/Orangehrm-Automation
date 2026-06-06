package utils;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class ElementActions {

    private static final int RETRY_COUNT =
            ConfigReader.getRetryCount();

    private ElementActions() {
    }

    public static void click(
            WebElement element) {

        int attempt = 0;

        while (attempt <= RETRY_COUNT) {

            try {

                WaitUtil.waitForClickable(
                        element
                ).click();

                return;

            } catch (
            	    StaleElementReferenceException
            	    | ElementClickInterceptedException
            	    | org.openqa.selenium.TimeoutException e) {

                attempt++;

                System.out.println(
                        "Click Retry Attempt : "
                                + attempt
                );

                WaitUtil.sleep(
                        ConfigReader.getRetryWaitSeconds()
                );
            }
        }

        throw new RuntimeException(
                "Failed to click element after "
                        + RETRY_COUNT
                        + " retries."
        );
    }

    public static void type(
            WebElement element,
            String text) {

        int attempt = 0;

        while (attempt <= RETRY_COUNT) {

            try {

                WebElement webElement =
                        WaitUtil.waitForVisibility(
                                element
                        );

                webElement.clear();

                webElement.sendKeys(
                        text
                );

                return;

            } catch (
                    StaleElementReferenceException e) {

                attempt++;

                System.out.println(
                        "Type Retry Attempt : "
                                + attempt
                );

                WaitUtil.sleep(
                        ConfigReader.getRetryWaitSeconds()
                );
            }
        }

        throw new RuntimeException(
                "Failed to type into element after "
                        + RETRY_COUNT
                        + " retries."
        );
    }

    public static String getText(
            WebElement element) {

        int attempt = 0;

        while (attempt <= RETRY_COUNT) {

            try {

                return WaitUtil
                        .waitForVisibility(
                                element
                        )
                        .getText();

            } catch (
                    StaleElementReferenceException e) {

                attempt++;

                System.out.println(
                        "GetText Retry Attempt : "
                                + attempt
                );

                WaitUtil.sleep(
                        ConfigReader.getRetryWaitSeconds()
                );
            }
        }

        throw new RuntimeException(
                "Failed to get text after "
                        + RETRY_COUNT
                        + " retries."
        );
    }

    public static boolean isDisplayed(
            WebElement element) {

        try {

            return WaitUtil
                    .waitForVisibility(
                            element
                    )
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    public static String getAttribute(
            WebElement element,
            String attributeName) {

        int attempt = 0;

        while (attempt <= RETRY_COUNT) {

            try {

                return WaitUtil
                        .waitForVisibility(
                                element
                        )
                        .getAttribute(
                                attributeName
                        );

            } catch (
                    StaleElementReferenceException e) {

                attempt++;

                System.out.println(
                        "Attribute Retry Attempt : "
                                + attempt
                );

                WaitUtil.sleep(
                        ConfigReader.getRetryWaitSeconds()
                );
            }
        }

        throw new RuntimeException(
                "Failed to get attribute after "
                        + RETRY_COUNT
                        + " retries."
        );
    }

    public static void clear(
            WebElement element) {

        WaitUtil.waitForVisibility(
                element
        ).clear();
    }
}