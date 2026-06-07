package steps;

import executor.PIMExecutor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class PIMSteps {

    private boolean result;

    @When("user executes pim scenario {string}")
    public void user_executes_pim_scenario(
            String scenarioId) {

        result =
                PIMExecutor.execute(
                        scenarioId
                );
    }

    @Then("pim scenario should pass")
    public void pim_scenario_should_pass() {

        Assert.assertTrue(result);
    }
}