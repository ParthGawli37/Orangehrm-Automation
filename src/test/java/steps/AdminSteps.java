package steps;

import executor.AdminExecutor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AdminSteps {

    private boolean result;

    @When("user executes admin scenario {string}")
    public void user_executes_admin_scenario(
            String scenarioId) {

        result =
                AdminExecutor.execute(
                        scenarioId
                );
    }

    @Then("admin scenario should pass")
    public void admin_scenario_should_pass() {

        Assert.assertTrue(result);
    }
}