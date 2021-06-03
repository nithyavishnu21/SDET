package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/test/resources/features",
		glue = {"stepDefinition"},
		plugin= {"pretty","html:target/cucumber-reports/report.html","json:target/cucumber-reports/report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	    //tags= "@Functional",
	    monochrome=true,
	    dryRun= false
		)
public class TestRunner {

}