package pages;

import base.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementActions;

public class RecruitmentPage {

    public RecruitmentPage() {

        PageFactory.initElements(
                DriverFactory.getDriver(),
                this
        );
    }

    @FindBy(xpath = "//h5[text()='Candidates']")
    private WebElement candidatesHeader;

    @FindBy(xpath = "//button[contains(@class,'oxd-button--secondary')]")
    private WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(@class,'oxd-table-body')]")
    private WebElement candidatesTable;

    public boolean isRecruitmentDisplayed() {

        return ElementActions.isDisplayed(
                candidatesHeader
        );
    }

    public boolean isAddButtonDisplayed() {

        return ElementActions.isDisplayed(
                addButton
        );
    }

    public boolean isSearchButtonDisplayed() {

        return ElementActions.isDisplayed(
                searchButton
        );
    }

    public boolean isCandidatesTableDisplayed() {

        return ElementActions.isDisplayed(
                candidatesTable
        );
    }
}