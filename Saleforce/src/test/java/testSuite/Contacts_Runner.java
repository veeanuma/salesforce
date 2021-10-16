package testSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features= {"src\\test\\java\\testSuite\\Contacts.feature"},
		glue= {"testSuite"},
		tags= "@Contacts",
		monochrome=true,
		plugin= {"pretty","html:target/smoketesters.html","rerun:target/failedsmoketestscenarios.txt"}
		
		)
public class Contacts_Runner extends AbstractTestNGCucumberTests
{

}
