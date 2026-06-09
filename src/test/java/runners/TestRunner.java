package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import listeners.TestListener;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)

@CucumberOptions(features = "src/test/resources/features", glue = { "steps" }, plugin = { "pretty",
		"html:reports/cucumber-report.html" }, monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
}