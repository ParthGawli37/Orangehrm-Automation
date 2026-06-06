package executor;

import components.LeftMenuComponent;
import pages.LeavePage;

public class LeaveExecutor extends BaseExecutor {

    private LeaveExecutor() {
    }

    public static boolean execute(String scenarioId) {

        resetToLoginPage();

        switch (scenarioId) {

            case "TS-LEAVE-001":
                return executeLeavePageVerification();

            case "TS-LEAVE-002":
                return executeLeaveListVerification();

            case "TS-LEAVE-003":
                return executeLeaveSearchButtonVerification();

            case "TS-LEAVE-004":
                return executeLeaveResetButtonVerification();

            case "TS-LEAVE-005":
                return executeLeaveTableVerification();

            default:
                return false;
        }
    }

    private static LeavePage openLeave() {

        login();

        LeftMenuComponent menu =
                new LeftMenuComponent();

        menu.navigateToLeave();

        return new LeavePage();
    }

    private static boolean executeLeavePageVerification() {

        return openLeave()
                .isLeavePageDisplayed();
    }

    private static boolean executeLeaveListVerification() {

        return openLeave()
                .isLeavePageDisplayed();
    }

    private static boolean executeLeaveSearchButtonVerification() {

        return openLeave()
                .isSearchButtonDisplayed();
    }

    private static boolean executeLeaveResetButtonVerification() {

        return openLeave()
                .isResetButtonDisplayed();
    }

    private static boolean executeLeaveTableVerification() {

        return openLeave()
                .isLeaveTableDisplayed();
    }
}