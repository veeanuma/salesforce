package testSuite;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LogoutPage;

public class StepDefinations_Logout {
	
	
	LogoutPage Lo=new LogoutPage();
	
	
	 @And("^click on Profile Pic$")
	    public void click_on_profilepic() throws Throwable {
	        Lo.clickprofilepic();
	        
	    }
	    
	    @When("^click on Logout btn$")
	    public void click_on_logoutbtn() throws Throwable {
	        Lo.clicklogouttbtn();
	        
	    }
	    @Then("^Login Page is displayed$")
	    public void isloginpagedisplayed() throws Throwable {
	        Lo.isLoginpageDisplyed();
	        
	    }


}
