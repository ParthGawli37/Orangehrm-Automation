package tests;

import base.BaseTest;

import org.testng.annotations.Test;

import components.LeftMenuComponent;
import pages.LoginPage;
import pages.PIMPage;

import utils.ConfigReader;
import utils.RandomDataUtil;

public class PIMTest extends BaseTest {

    @Test(
            description = "Verify employee can be added"
    )
    public void verifyAddEmployee() {

        LoginPage loginPage =
                new LoginPage();

        LeftMenuComponent menu =
                new LeftMenuComponent();

        PIMPage pimPage =
                new PIMPage();

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        menu.navigateToPIM();

        pimPage.clickAddEmployee();

        pimPage.enterFirstName(
                RandomDataUtil.getRandomFirstName()
        );

        pimPage.enterLastName(
                RandomDataUtil.getRandomLastName()
        );

        pimPage.clickSave();
    }
}