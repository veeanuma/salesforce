package testSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		
		features= {"src\\test\\java\\testSuite\\Leads.feature"},
		glue= {"testSuite"},
		tags= "@Leads or @sample",
		monochrome=true,
		plugin= {"pretty","html:target/smoketesters.html","rerun:target/failedsmoketestscenarios.txt"}
		
		)
public class Lead_Runner extends AbstractTestNGCucumberTests
{
	

}