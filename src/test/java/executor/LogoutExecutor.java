package executor;

import pages.DashboardPage;

public class LogoutExecutor extends BaseExecutor {

    private LogoutExecutor() {
    }

    public static boolean execute(String scenarioId) {

        resetToLoginPage();

        switch (scenarioId) {

            case "TS-LGOUT-001":
            case "TS-LGOUT-002":
            case "TS-LGOUT-003":
            case "TS-LGOUT-004":
            case "TS-LGOUT-005":
                return executeLogout();

            default:
                return false;
        }
    }

    private static boolean executeLogout() {

        login();

        DashboardPage dashboardPage =
                new DashboardPage();

        dashboardPage.clickLogout();

        return dashboardPage.isLoginPageDisplayed();
    }
}