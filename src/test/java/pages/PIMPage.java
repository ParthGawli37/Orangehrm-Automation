package pages;

import base.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementActions;

public class PIMPage {

    public PIMPage() {

        PageFactory.initElements(
                DriverFactory.getDriver(),
                this
        );
    }

    // ==========================
    // Add Employee
    // ==========================

    @FindBy(linkText = "Add Employee")
    private WebElement addEmployeeLink;

    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    @FindBy(css = "button[type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//h6[text()='Personal Details']")
    private WebElement personalDetailsHeader;

    // ==========================
    // Employee List / Search
    // ==========================

    @FindBy(xpath = "//a[text()='Employee List']")
    private WebElement employeeListLink;

    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
    private WebElement employeeSearchBox;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[normalize-space()='Reset']")
    private WebElement resetButton;

    @FindBy(xpath = "//div[@class='oxd-table-body']")
    private WebElement searchResultsTable;

    // ==========================
    // Edit Employee
    // ==========================

    @FindBy(xpath = "(//i[contains(@class,'bi-pencil-fill')])[1]")
    private WebElement editEmployeeButton;

    @FindBy(xpath = "//input[@name='middleName']")
    private WebElement middleNameInput;

    // ==========================
    // Delete Employee
    // ==========================

    @FindBy(xpath = "(//i[contains(@class,'bi-trash')])[1]")
    private WebElement deleteEmployeeButton;

    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    private WebElement confirmDeleteButton;

    // ==========================
    // Common Methods
    // ==========================

    public void clickAddEmployee() {

        ElementActions.click(
                addEmployeeLink
        );
    }

    public void enterFirstName(String firstName) {

        ElementActions.type(
                firstNameInput,
                firstName
        );
    }

    public void enterLastName(String lastName) {

        ElementActions.type(
                lastNameInput,
                lastName
        );
    }

    public void clickSave() {

        ElementActions.click(
                saveButton
        );
    }

    // ==========================
    // Add Employee
    // ==========================

    public void addEmployee(
            String firstName,
            String lastName) {

        clickAddEmployee();

        enterFirstName(firstName);

        enterLastName(lastName);

        clickSave();
    }

    public boolean isPersonalDetailsPageDisplayed() {

        return ElementActions.isDisplayed(
                personalDetailsHeader
        );
    }

    // ==========================
    // Employee Search
    // ==========================

    public void openEmployeeList() {

        ElementActions.click(
                employeeListLink
        );
    }

    public void searchEmployee(
            String employeeName) {

        openEmployeeList();

        ElementActions.type(
                employeeSearchBox,
                employeeName
        );

        ElementActions.click(
                searchButton
        );
    }

    public void resetEmployeeSearch() {

        ElementActions.click(
                resetButton
        );
    }

    public boolean isSearchResultDisplayed() {

        return ElementActions.isDisplayed(
                searchResultsTable
        );
    }

    // ==========================
    // Edit Employee
    // ==========================

    public void editEmployee(
            String employeeName,
            String middleName) {

        searchEmployee(employeeName);

        ElementActions.click(
                editEmployeeButton
        );

        ElementActions.type(
                middleNameInput,
                middleName
        );

        ElementActions.click(
                saveButton
        );
    }

    // ==========================
    // Delete Employee
    // ==========================

    public void deleteEmployee(
            String employeeName) {

        searchEmployee(employeeName);

        ElementActions.click(
                deleteEmployeeButton
        );

        ElementActions.click(
                confirmDeleteButton
        );
    }
}