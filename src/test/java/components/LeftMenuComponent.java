package components;

import base.DriverFactory;
import pages.LoginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConfigReader;
import utils.ElementActions;

public class LeftMenuComponent {

    public LeftMenuComponent() {

        PageFactory.initElements(
                DriverFactory.getDriver(),
                this
        );
    }

    @FindBy(xpath = "//span[text()='Dashboard']")
    private WebElement dashboardMenu;

    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminMenu;

    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement pimMenu;

    @FindBy(xpath = "//span[text()='Leave']")
    private WebElement leaveMenu;

    @FindBy(xpath = "//span[text()='Time']")
    private WebElement timeMenu;

    @FindBy(xpath = "//span[text()='Recruitment']")
    private WebElement recruitmentMenu;

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoMenu;

    @FindBy(xpath = "//span[text()='Directory']")
    private WebElement directoryMenu;

    private void hoverAndClick(
            WebElement element) {

        Actions actions =
                new Actions(
                        DriverFactory.getDriver()
                );

        actions.moveToElement(
                element
        ).perform();

        ElementActions.click(
                element
        );
    }
    
    protected static void login() {

        LoginPage loginPage =
                new LoginPage();

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        System.out.println(
                "AFTER LOGIN URL : "
                + DriverFactory.getDriver()
                        .getCurrentUrl()
        );
    }

    public void navigateToDashboard() {

        hoverAndClick(
                dashboardMenu
        );
    }

    public void navigateToAdmin() {

        hoverAndClick(
                adminMenu
        );
    }

    public void navigateToPIM() {

        hoverAndClick(
                pimMenu
        );
    }

    public void navigateToLeave() {

        hoverAndClick(
                leaveMenu
        );
    }

    public void navigateToTime() {

        hoverAndClick(
                timeMenu
        );
    }

    public void navigateToRecruitment() {

        hoverAndClick(
                recruitmentMenu
        );
    }

    public void navigateToMyInfo() {

        hoverAndClick(
                myInfoMenu
        );
    }

    public void navigateToDirectory() {

        hoverAndClick(
                directoryMenu
        );
    }
}