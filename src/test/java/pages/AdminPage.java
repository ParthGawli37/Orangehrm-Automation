package pages;

import base.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementActions;

public class AdminPage {

    public AdminPage() {

        PageFactory.initElements(
                DriverFactory.getDriver(),
                this
        );
    }

    // ==========================
    // Search User
    // ==========================

    @FindBy(xpath = "//h5[text()='System Users']")
    private WebElement systemUsersHeader;

    @FindBy(xpath = "(//input[contains(@class,'oxd-input')])[2]")
    private WebElement usernameInput;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[normalize-space()='Reset']")
    private WebElement resetButton;

    @FindBy(xpath = "//div[contains(@class,'oxd-table-body')]")
    private WebElement resultsTable;

    // ==========================
    // Add User
    // ==========================

    @FindBy(xpath = "//button[contains(@class,'oxd-button--secondary')]")
    private WebElement addButton;

    @FindBy(xpath = "//label[text()='User Role']")
    private WebElement userRoleDropdown;

    // ==========================
    // Edit User
    // ==========================

    @FindBy(xpath =
            "(//i[contains(@class,'bi-pencil-fill')]/parent::button)[1]")
    private WebElement editButton;

    // ==========================
    // Delete User
    // ==========================

    @FindBy(xpath =
            "(//i[contains(@class,'bi-trash')]/parent::button)[1]")
    private WebElement deleteButton;

    @FindBy(xpath =
            "//button[contains(@class,'oxd-button--label-danger')]")
    private WebElement confirmDeleteButton;

    // ==========================
    // Verification
    // ==========================

    public boolean isAdminPageDisplayed() {

        return ElementActions.isDisplayed(
                systemUsersHeader
        );
    }

    public boolean isSearchResultDisplayed() {

        return ElementActions.isDisplayed(
                resultsTable
        );
    }

    public boolean isAddUserPageDisplayed() {

        System.out.println(
                "Current URL : "
                        + DriverFactory.getDriver()
                        .getCurrentUrl()
        );

        return ElementActions.isDisplayed(
                userRoleDropdown
        );
    }

    // ==========================
    // Search User
    // ==========================

    public void searchUser(
            String username) {

        ElementActions.type(
                usernameInput,
                username
        );

        ElementActions.click(
                searchButton
        );
    }

    // ==========================
    // Reset Search
    // ==========================

    public void resetSearch() {

        ElementActions.click(
                resetButton
        );
    }

    // ==========================
    // Add User
    // ==========================

    public void clickAddUser() {

        ElementActions.click(
                addButton
        );
    }

    // ==========================
    // Edit User
    // ==========================

    public void clickEditUser() {

        ElementActions.click(
                editButton
        );
    }

    // ==========================
    // Delete User
    // ==========================

    public void deleteFirstUser() {

        ElementActions.click(
                deleteButton
        );

        try {

            Thread.sleep(2000);

        } catch (Exception e) {

            e.printStackTrace();
        }

        ElementActions.click(
                confirmDeleteButton
        );
    }
}