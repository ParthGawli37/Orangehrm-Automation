package executor;

import components.LeftMenuComponent;
import pages.PIMPage;

public class PIMExecutor
        extends BaseExecutor {

    private PIMExecutor() {
    }

    public static boolean execute(
            String scenarioId) {

        resetToLoginPage();

        switch (scenarioId) {

            case "TS-PIM-001":
                return executeAddEmployee();

            case "TS-PIM-002":
                return executeEditEmployee();

            case "TS-PIM-003":
                return executeSearchEmployee();

            case "TS-PIM-004":
                return executeDeleteEmployee();

            case "TS-PIM-005":
                return executeResetSearch();

            default:
                return false;
        }
    }

    private static PIMPage openPIM() {

        login();

        LeftMenuComponent menu =
                new LeftMenuComponent();

        menu.navigateToPIM();

        return new PIMPage();
    }

    private static boolean executeAddEmployee() {

        PIMPage pimPage =
                openPIM();

        pimPage.addEmployee(
                "John",
                "Automation"
        );

        return pimPage
                .isPersonalDetailsPageDisplayed();
    }

    private static boolean executeEditEmployee() {

        PIMPage pimPage =
                openPIM();

        pimPage.editEmployee(
                "John",
                "Updated"
        );

        return true;
    }

    private static boolean executeSearchEmployee() {

        PIMPage pimPage =
                openPIM();

        pimPage.searchEmployee(
                "John"
        );

        return pimPage
                .isSearchResultDisplayed();
    }

    private static boolean executeDeleteEmployee() {

        PIMPage pimPage =
                openPIM();

        pimPage.deleteEmployee(
                "John"
        );

        return true;
    }

    private static boolean executeResetSearch() {

        PIMPage pimPage =
                openPIM();

        pimPage.openEmployeeList();

        pimPage.resetEmployeeSearch();

        return true;
    }
}