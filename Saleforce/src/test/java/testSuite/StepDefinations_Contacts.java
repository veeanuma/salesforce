package testSuite;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactsPage;
import pages.HomePage;

public class StepDefinations_Contacts 
{
	HomePage hp=new HomePage();
	ContactsPage cp=new ContactsPage();
	@Given("^User Salesforce Dashboard Page$")
    public void user_is_on_Dashboard() throws Throwable {
		hp.isHomeDisplyed();
        
    }

    @When("^click on Contacts$")
    public void click_on_contacts() throws Throwable {
    	cp.ClickOnContacts();
    }

    @When("^Click on Triangle for Options$")
    public void click_on_triangle_for_options() throws Throwable {
    	cp.clickshowmoreoptions();
    }

    @When("^click Delete Option$")
    public void click_delete_option() throws Throwable {
    	cp.clickdeletelink();
    }

    @When("^Click on Delete btn$")
    public void click_on_btn() throws Throwable {
    	cp.clickdeletebtn();
    }

    @Then("^Recently Viewed Contacts Page will appear$")
    public void recently_viewed_contacts_page_will_appear() throws Throwable {
    	cp.isAlllContactsvisible();
    }

    @Then("^Options Will Display$")
    public void options_will_display() throws Throwable {
    	cp.isOptionsvisible();
    }

    @Then("^Agains Asks Delete Contact Confirmation$")
    public void agains_asks_delete_contact_confirmation() throws Throwable {
    	cp.isDeleteConfirmationVisible();
    }

    @Then("^Contact Deleted status will Appear$")
    public void contact_Delete_status__will_appear() throws Throwable {
    	Thread.sleep(1000);
    	cp.isContactdeleted();
    }

    @And("^Cross check Lead which is Lead Converted As Contact Appear or Not$")
    public void cross_check_lead_which_is_lead_converted_appear_or_not_as_contact() throws Throwable {
    	cp.Crosscheck("(891) 918-8076");
    	
        
    }


}
