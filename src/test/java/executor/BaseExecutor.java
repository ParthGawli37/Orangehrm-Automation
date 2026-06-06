package executor;

import base.DriverFactory;
import pages.LoginPage;
import utils.ConfigReader;

public abstract class BaseExecutor {

    protected static void resetToLoginPage() {

        var driver =
                DriverFactory.getDriver();

        if (driver == null) {

            throw new RuntimeException(
                    "Driver is null"
            );
        }

//        driver.manage().deleteAllCookies();

        driver.get(
                ConfigReader.getProperty(
                        "app.url"
                )
        );
    }

    protected static void login() {

        LoginPage loginPage =
                new LoginPage();

        loginPage.login(
                ConfigReader.getProperty(
                        "username"
                ),
                ConfigReader.getProperty(
                        "password"
                )
        );
    }
}