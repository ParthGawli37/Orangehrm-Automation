package steps;

import executor.DirectoryExecutor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DirectorySteps {

    private boolean result;

    @When("user executes directory scenario {string}")
    public void user_executes_directory_scenario(
            String scenarioId) {

        result =
                DirectoryExecutor.execute(
                        scenarioId
                );
    }

    @Then("directory scenario should pass")
    public void directory_scenario_should_pass() {

        Assert.assertTrue(result);
    }
}