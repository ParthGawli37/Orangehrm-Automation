package pages;

import base.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementActions;

public class LeavePage {

    public LeavePage() {

        PageFactory.initElements(
                DriverFactory.getDriver(),
                this
        );
    }

    @FindBy(xpath = "//h5[text()='Leave List']")
    private WebElement leaveListHeader;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[normalize-space()='Reset']")
    private WebElement resetButton;

    @FindBy(xpath = "//div[contains(@class,'oxd-table-body')]")
    private WebElement leaveTable;

    public boolean isLeavePageDisplayed() {

        return ElementActions.isDisplayed(
                leaveListHeader
        );
    }

    public boolean isSearchButtonDisplayed() {

        return ElementActions.isDisplayed(
                searchButton
        );
    }

    public boolean isResetButtonDisplayed() {

        return ElementActions.isDisplayed(
                resetButton
        );
    }

    public boolean isLeaveTableDisplayed() {

        return ElementActions.isDisplayed(
                leaveTable
        );
    }
}