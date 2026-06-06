package executor;

import components.LeftMenuComponent;
import pages.RecruitmentPage;

public class RecruitmentExecutor extends BaseExecutor {

    private RecruitmentExecutor() {
    }

    public static boolean execute(String scenarioId) {

        resetToLoginPage();

        switch (scenarioId) {

            case "TS-REC-001":
                return executeRecruitmentPageVerification();

            case "TS-REC-002":
                return executeCandidatesPageVerification();

            case "TS-REC-003":
                return executeAddCandidateButtonVerification();

            case "TS-REC-004":
                return executeRecruitmentSearchButtonVerification();

            case "TS-REC-005":
                return executeCandidatesTableVerification();

            default:
                return false;
        }
    }

    private static RecruitmentPage openRecruitment() {

        login();

        LeftMenuComponent menu =
                new LeftMenuComponent();

        menu.navigateToRecruitment();

        return new RecruitmentPage();
    }

    private static boolean executeRecruitmentPageVerification() {

        return openRecruitment()
                .isRecruitmentDisplayed();
    }

    private static boolean executeCandidatesPageVerification() {

        return openRecruitment()
                .isCandidatesTableDisplayed();
    }

    private static boolean executeAddCandidateButtonVerification() {

        return openRecruitment()
                .isAddButtonDisplayed();
    }

    private static boolean executeRecruitmentSearchButtonVerification() {

        return openRecruitment()
                .isSearchButtonDisplayed();
    }

    private static boolean executeCandidatesTableVerification() {

        return openRecruitment()
                .isCandidatesTableDisplayed();
    }
}