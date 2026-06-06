package executor;

import components.LeftMenuComponent;
import pages.AdminPage;
import base.DriverFactory;

public class AdminExecutor extends BaseExecutor {

    private AdminExecutor() {
    }

    public static boolean execute(String scenarioId) {

        switch (scenarioId) {

            case "TS-ADMIN-001":
                return executeAdminPageVerification();

            case "TS-ADMIN-002":
                return executeSearchUser();

            case "TS-ADMIN-003":
                return executeResetUserSearch();

            case "TS-ADMIN-004":
                return executeAddUserPage();

            case "TS-ADMIN-005":
                return true;

            default:
                return false;
        }
    }

    private static boolean executeAdminPageVerification() {

        resetToLoginPage();

        System.out.println(
                "STEP 1 : LOGIN PAGE URL = "
                        + DriverFactory.getDriver()
                        .getCurrentUrl()
        );

        login();

        System.out.println(
                "STEP 2 : AFTER LOGIN URL = "
                        + DriverFactory.getDriver()
                        .getCurrentUrl()
        );

        LeftMenuComponent menu =
                new LeftMenuComponent();

        menu.navigateToAdmin();

        System.out.println(
                "STEP 3 : AFTER ADMIN CLICK URL = "
                        + DriverFactory.getDriver()
                        .getCurrentUrl()
        );

        AdminPage adminPage =
                new AdminPage();

        boolean result =
                adminPage.isAdminPageDisplayed();

        System.out.println(
                "STEP 4 : ADMIN PAGE DISPLAYED = "
                        + result
        );

        return result;
    }

    private static boolean executeSearchUser() {

        resetToLoginPage();

        login();

        LeftMenuComponent menu =
                new LeftMenuComponent();

        AdminPage adminPage =
                new AdminPage();

        menu.navigateToAdmin();

        adminPage.searchUser("Admin");

        return adminPage.isSearchResultDisplayed();
    }

    private static boolean executeResetUserSearch() {

        resetToLoginPage();

        login();

        LeftMenuComponent menu =
                new LeftMenuComponent();

        AdminPage adminPage =
                new AdminPage();

        menu.navigateToAdmin();

        adminPage.resetSearch();

        return true;
    }

    private static boolean executeAddUserPage() {

        resetToLoginPage();

        login();

        LeftMenuComponent menu =
                new LeftMenuComponent();

        AdminPage adminPage =
                new AdminPage();

        menu.navigateToAdmin();

        adminPage.clickAddUser();

        return adminPage.isAddUserPageDisplayed();
    }
}