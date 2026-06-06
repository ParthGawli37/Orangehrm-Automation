package executor;

import pages.DashboardPage;

public class DashboardExecutor
        extends BaseExecutor {

    private DashboardExecutor() {
    }

    public static boolean execute(
            String scenarioId) {

        System.out.println(
                "DASHBOARD EXECUTOR RECEIVED : ["
                        + scenarioId
                        + "]"
        );

        resetToLoginPage();

        switch (scenarioId) {

            case "TS-DASH-001":
                return executeDashboardVisibility();

            case "TS-DASH-002":
                return executeTimeAtWorkVerification();

            case "TS-DASH-003":
                return executeQuickLaunchVerification();

            case "TS-DASH-004":
                return executeDashboardRefreshVerification();

            case "TS-DASH-005":
                return executeProfileMenuVerification();

            default:

                System.out.println(
                        "DASHBOARD EXECUTOR DEFAULT HIT : ["
                                + scenarioId
                                + "]"
                );

                return false;
        }
    }

    private static DashboardPage openDashboard() {

        login();

        return new DashboardPage();
    }

    private static boolean executeDashboardVisibility() {

        return openDashboard()
                .isDashboardDisplayed();
    }

    private static boolean executeTimeAtWorkVerification() {

        System.out.println(
                "EXECUTING TS-DASH-002"
        );

        return openDashboard()
                .isTimeAtWorkDisplayed();
    }

    private static boolean executeQuickLaunchVerification() {

        return openDashboard()
                .isQuickLaunchDisplayed();
    }

    private static boolean executeDashboardRefreshVerification() {

        System.out.println(
                "EXECUTING TS-DASH-004"
        );

        DashboardPage dashboardPage =
                openDashboard();

        base.DriverFactory.getDriver()
                .navigate()
                .refresh();

        return dashboardPage
                .isDashboardDisplayed();
    }

    private static boolean executeProfileMenuVerification() {

        return openDashboard()
                .isLogoutDisplayed();
    }
}