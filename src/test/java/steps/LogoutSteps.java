package steps;

import executor.LogoutExecutor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LogoutSteps {

    private boolean result;

    @When("user executes logout scenario {string}")
    public void user_executes_logout_scenario(
            String scenarioId) {

        result =
                LogoutExecutor.execute(
                        scenarioId
                );
    }

    @Then("logout scenario should pass")
    public void logout_scenario_should_pass() {

        Assert.assertTrue(result);
    }
}