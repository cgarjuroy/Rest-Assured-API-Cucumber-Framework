package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/features/user.feature"},
		glue = {"hooks", "stepDefinition"},
		dryRun = false,
		monochrome = false,
		plugin = {
				"pretty",
				"html:target/cucumber-reports/user.html"},
		tags = "@wiremock"
)
public class TestRunner2 extends AbstractTestNGCucumberTests{

}
