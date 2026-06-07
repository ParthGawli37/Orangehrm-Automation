package steps;

import executor.DashboardExecutor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DashboardSteps {

    private boolean result;

    @When("user executes dashboard scenario {string}")
    public void user_executes_dashboard_scenario(
            String scenarioId) {

        result =
                DashboardExecutor.execute(
                        scenarioId
                );
    }

    @Then("dashboard scenario should pass")
    public void dashboard_scenario_should_pass() {

        Assert.assertTrue(result);
    }
}