package executor;

import components.LeftMenuComponent;
import pages.DirectoryPage;

public class DirectoryExecutor extends BaseExecutor {

    private DirectoryExecutor() {
    }

    public static boolean execute(String scenarioId) {

        resetToLoginPage();

        switch (scenarioId) {

            case "TS-DIR-001":
                return executeDirectoryPageVerification();

            case "TS-DIR-002":
                return executeDirectorySearchFieldVerification();

            case "TS-DIR-003":
                return executeDirectorySearchButtonVerification();

            case "TS-DIR-004":
                return executeDirectoryResetButtonVerification();

            case "TS-DIR-005":
                return executeDirectoryCardsVerification();

            default:
                return false;
        }
    }

    private static DirectoryPage openDirectory() {

        login();

        LeftMenuComponent menu =
                new LeftMenuComponent();

        menu.navigateToDirectory();

        return new DirectoryPage();
    }

    private static boolean executeDirectoryPageVerification() {

        return openDirectory()
                .isDirectoryPageDisplayed();
    }

    private static boolean executeDirectorySearchFieldVerification() {

        return openDirectory()
                .isSearchFieldDisplayed();
    }

    private static boolean executeDirectorySearchButtonVerification() {

        return openDirectory()
                .isSearchButtonDisplayed();
    }

    private static boolean executeDirectoryResetButtonVerification() {

        return openDirectory()
                .isResetButtonDisplayed();
    }

    private static boolean executeDirectoryCardsVerification() {

        return openDirectory()
                .isEmployeeCardDisplayed();
    }
}