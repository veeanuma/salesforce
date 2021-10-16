package testSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features= {"src\\test\\java\\testSuite\\WebtoLead.feature"},
		glue= {"testSuite"},
		tags= "@WebtoLead",
		monochrome=true,
		plugin= {"pretty","html:target/smoketesters.html","rerun:target/failedsmoketestscenarios.txt"}
		
		)
public class WebtoLead_Runner extends AbstractTestNGCucumberTests
{

}
