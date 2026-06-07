package steps;

import executor.RecruitmentExecutor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RecruitmentSteps {

    private boolean result;

    @When("user executes recruitment scenario {string}")
    public void user_executes_recruitment_scenario(
            String scenarioId) {

        result =
                RecruitmentExecutor.execute(
                        scenarioId
                );
    }

    @Then("recruitment scenario should pass")
    public void recruitment_scenario_should_pass() {

        Assert.assertTrue(result);
    }
}