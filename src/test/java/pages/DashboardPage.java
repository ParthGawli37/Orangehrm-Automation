package pages;

import base.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementActions;

public class DashboardPage {

    public DashboardPage() {

        PageFactory.initElements(
                DriverFactory.getDriver(),
                this
        );
    }

    // ==========================
    // Dashboard Header
    // ==========================

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardHeader;

    // ==========================
    // Quick Launch
    // ==========================

    @FindBy(xpath = "//p[text()='Quick Launch']")
    private WebElement quickLaunchSection;

    // ==========================
    // Time At Work Widget
    // ==========================

    @FindBy(xpath = "//p[text()='Time at Work']")
    private WebElement timeAtWorkWidget;

    // ==========================
    // User Menu
    // ==========================

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    private WebElement userDropdown;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logoutOption;

    // ==========================
    // Login Page Verification
    // ==========================

    @FindBy(name = "username")
    private WebElement loginUsernameField;

    // ==========================
    // Dashboard Verification
    // ==========================

    public boolean isDashboardDisplayed() {

        return ElementActions.isDisplayed(
                dashboardHeader
        );
    }

    public boolean isQuickLaunchDisplayed() {

        return ElementActions.isDisplayed(
                quickLaunchSection
        );
    }

    public boolean isTimeAtWorkDisplayed() {

        return ElementActions.isDisplayed(
                timeAtWorkWidget
        );
    }

    // ==========================
    // User Menu Actions
    // ==========================

    public void openUserMenu() {

        ElementActions.click(
                userDropdown
        );
    }

    public boolean isLogoutDisplayed() {

        openUserMenu();

        return ElementActions.isDisplayed(
                logoutOption
        );
    }

    public void clickLogout() {

        openUserMenu();

        ElementActions.click(
                logoutOption
        );
    }

    // ==========================
    // Logout Verification
    // ==========================

    public boolean isLoginPageDisplayed() {

        return ElementActions.isDisplayed(
                loginUsernameField
        );
    }
}