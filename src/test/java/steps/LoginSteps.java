package steps;

import executor.LoginExecutor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {

    private boolean result;

    @When("user executes login scenario {string}")
    public void user_executes_login_scenario(
            String scenarioId) {

        result =
                LoginExecutor.execute(
                        scenarioId
                );
    }

    @Then("scenario should pass")
    public void scenario_should_pass() {

        Assert.assertTrue(result);
    }
}