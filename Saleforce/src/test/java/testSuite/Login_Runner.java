package testSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features= {"src\\test\\java\\testSuite\\Login.feature"},
		glue= {"testSuite"},
		tags= "@Login",
		monochrome=true,
		plugin= {"pretty","html:target/smoketesters.html","rerun:target/failedsmoketestscenarios.txt"}
		
		)
public class Login_Runner extends AbstractTestNGCucumberTests
{
	

}
