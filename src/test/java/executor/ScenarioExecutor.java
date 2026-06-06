package executor;

public class ScenarioExecutor {

    private ScenarioExecutor() {
    }

    public static boolean execute(String scenarioId) {

        if (scenarioId.startsWith("TS-LOGIN")) {
            return LoginExecutor.execute(scenarioId);
        }

        if (scenarioId.startsWith("TS-DASH")) {
            return DashboardExecutor.execute(scenarioId);
        }

        if (scenarioId.startsWith("TS-PIM")) {
            return PIMExecutor.execute(scenarioId);
        }

        if (scenarioId.startsWith("TS-ADMIN")) {
            return AdminExecutor.execute(scenarioId);
        }

        if (scenarioId.startsWith("TS-DIR")) {
            return DirectoryExecutor.execute(scenarioId);
        }

        if (scenarioId.startsWith("TS-LEAVE")) {
            return LeaveExecutor.execute(scenarioId);
        }

        if (scenarioId.startsWith("TS-REC")) {
            return RecruitmentExecutor.execute(scenarioId);
        }

        if (scenarioId.startsWith("TS-LGOUT")) {
            return LogoutExecutor.execute(scenarioId);
        }

        System.out.println(
                "No automation mapped for: "
                        + scenarioId
        );

        return false;
    }
}