package testSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features= {"src\\test\\java\\testSuite\\Logout.feature"},
		glue= {"testSuite"},
		tags= "@Logout",
		monochrome=true,
		plugin= {"pretty","html:target/smoketesters.html","rerun:target/failedsmoketestscenarios.txt"}
		
		)
public class Logout_Runner extends AbstractTestNGCucumberTests
{

}
