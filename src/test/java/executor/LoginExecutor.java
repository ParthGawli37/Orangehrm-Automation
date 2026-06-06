package executor;

import pages.LoginPage;

public class LoginExecutor
        extends BaseExecutor {

    private LoginExecutor() {
    }

    public static boolean execute(
            String scenarioId) {

        resetToLoginPage();

        switch (scenarioId) {

            case "TS-LOGIN-001":
                return executeValidLogin();

            case "TS-LOGIN-002":
                return executeInvalidLogin();

            case "TS-LOGIN-003":
                return executeMandatoryFieldValidation();

            case "TS-LOGIN-004":
                return executePasswordMaskValidation();

            case "TS-LOGIN-005":
                return executeForgotPasswordFlow();

            default:
                return false;
        }
    }

    private static boolean executeValidLogin() {

        login();

        return true;
    }

    private static boolean executeInvalidLogin() {

        LoginPage loginPage =
                new LoginPage();

        loginPage.login(
                "InvalidUser",
                "InvalidPassword"
        );

        return true;
    }

    private static boolean executeMandatoryFieldValidation() {

        LoginPage loginPage =
                new LoginPage();

        loginPage.login(
                "",
                ""
        );

        return loginPage
                .isRequiredMessageDisplayed();
    }

    private static boolean executePasswordMaskValidation() {

        LoginPage loginPage =
                new LoginPage();

        return loginPage
                .isPasswordMasked();
    }

    private static boolean executeForgotPasswordFlow() {

        LoginPage loginPage =
                new LoginPage();

        loginPage.clickForgotPassword();

        return loginPage
                .isResetPasswordPageDisplayed();
    }
}