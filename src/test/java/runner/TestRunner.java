package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import org.testng.annotations.DataProvider;

@CucumberOptions(
		features = {"src/test/resources/features/pet.feature",
					"src/test/resources/features/petStore.feature"},
		glue = {"stepDefinition"},
		dryRun = false,
		monochrome = false,
		plugin = {
				"pretty",
				"html:target/cucumber-reports/petStore.html",
				"json:target/cucumber-reports/petStore.json",
				"junit:target/cucumber-reports/petStore.xml"
		})
	
public class TestRunner extends AbstractTestNGCucumberTests{

//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios(){
//		return super.scenarios();
//	}
}
