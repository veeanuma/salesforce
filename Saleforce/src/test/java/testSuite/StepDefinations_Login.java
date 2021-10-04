package testSuite;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class StepDefinations_Login {
	LoginPage Lp=new LoginPage();
	HomePage hp=new HomePage();
	@Given("^User is on salesforce Login Page$")
    public void user_is_on_salesforce_login_page() throws Throwable {
	 Lp.validateurl();
    }

	
	 @And("^Enter userid$")
	    public void enter_userid() throws Throwable {
		 Lp.uidFill();
	    }
	 @And("^Enter password$")
	    public void enter_password() throws Throwable {
		 Lp.pwdFill();
	    }
	 @When("^click Login$")
    public void enter_userid_and_password_and_click_login() throws Throwable {
	 Lp.clicklogintbn();
    }

    @Then("^Home Page is displayed$")
    public void home_page_is_displayed() throws Throwable {
    	 hp.isHomeDisplyed();
    	 
    }


}
