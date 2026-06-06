package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.DriverFactory;
import utils.ElementActions;

public class LoginPage {

    public LoginPage() {

        PageFactory.initElements(
                DriverFactory.getDriver(),
                this
        );
    }

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = ".oxd-alert-content-text")
    private WebElement invalidCredentialMessage;

    @FindBy(xpath = "//span[text()='Required']")
    private WebElement requiredFieldMessage;

    @FindBy(xpath = "//p[text()='Forgot your password? ']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//h6[text()='Reset Password']")
    private WebElement resetPasswordHeader;

    public void enterUsername(String username) {

        ElementActions.type(
                usernameInput,
                username
        );
    }

    public void enterPassword(String password) {

        ElementActions.type(
                passwordInput,
                password
        );
    }

    public void clickLogin() {

        ElementActions.click(
                loginButton
        );
    }

    public void login(String username,
                      String password) {

        enterUsername(username);

        enterPassword(password);

        clickLogin();
    }

    public String getInvalidLoginMessage() {

        return ElementActions.getText(
                invalidCredentialMessage
        );
    }

    public boolean isPasswordMasked() {

        String fieldType =
                ElementActions.getAttribute(
                        passwordInput,
                        "type"
                );

        return "password".equalsIgnoreCase(
                fieldType
        );
    }

    public void clickForgotPassword() {

        ElementActions.click(
                forgotPasswordLink
        );
    }

    public boolean isRequiredMessageDisplayed() {

        return ElementActions.isDisplayed(
                requiredFieldMessage
        );
    }

    public boolean isResetPasswordPageDisplayed() {

        return ElementActions.isDisplayed(
                resetPasswordHeader
        );
    }
}