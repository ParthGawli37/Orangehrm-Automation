package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test(
            description = "Verify successful login with valid credentials"
    )
    public void verifyValidLogin() {

        LoginPage loginPage =
                new LoginPage();

        DashboardPage dashboardPage =
                new DashboardPage();

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        Assert.assertTrue(
                dashboardPage.isDashboardDisplayed(),
                "Dashboard is not displayed after login"
        );
    }

    @Test(
            description = "Verify login with invalid credentials"
    )
    public void verifyInvalidLogin() {

        LoginPage loginPage =
                new LoginPage();

        loginPage.login(
                "InvalidUser",
                "InvalidPassword"
        );

        Assert.assertEquals(
                loginPage.getInvalidLoginMessage(),
                "Invalid credentials"
        );
    }
}