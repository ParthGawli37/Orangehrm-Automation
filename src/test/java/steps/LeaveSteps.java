package steps;

import executor.LeaveExecutor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LeaveSteps {

    private boolean result;

    @When("user executes leave scenario {string}")
    public void user_executes_leave_scenario(
            String scenarioId) {

        result =
                LeaveExecutor.execute(
                        scenarioId
                );
    }

    @Then("leave scenario should pass")
    public void leave_scenario_should_pass() {

        Assert.assertTrue(result);
    }
}