package testSuite;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EditLead;
import pages.HomePage;
import pages.ImportLead;
import pages.LeadConvert;
import pages.NewLeadFormPage;
import pages.Verify_Picklist_ObjectManager;
import pages.WebtoLead;

public class StepDefinations_Leads 
{
	
	HomePage hp=new HomePage();
	NewLeadFormPage nlfp=new  NewLeadFormPage();
	EditLead el=new EditLead ();
	LeadConvert lc=new LeadConvert();
	WebtoLead wbl=new WebtoLead();
	ImportLead il=new ImportLead();
	 Verify_Picklist_ObjectManager vpo=new  Verify_Picklist_ObjectManager();
	
	 @Given("^User is on salesforce Dashboard Page$")
	    public void user_is_on_salesforce_dashboard_page() throws Throwable {
		 hp.isHomeDisplyed();
		   
	        
	    }
	 
	    @When("^Click Lead Object and click new Lead$")
	    public void click_lead_object_and_click_new_lead() throws Throwable {
	       hp.clickleads();
	       hp.isAllleadsvisible();
	       hp.clicknewleads();
	    }

	    @Then("^Lead form Should be displayed$")
	    public void lead_form_should_be_displayed() throws Throwable {
	    	hp.isNewleadFormDisplyed();
	    }
	    @Given("^User is on load form page$")
	    public void user_is_on_load_form_page() throws Throwable {
	    	hp.isNewleadFormDisplyed();
	    }

	    @And("enter firstName as {string} middleName as {string} lastname as {string}  salutation as {string} Website as {string} suffix as {string} Company  as {string} Email as {string} MobilePhone as {string} industry as {string} Leadsource as {string}    details to fill")
	    public void enter_all_the_details(String firstName ,String middleName ,String lastname,String salutation ,String Website ,String suffix ,String Company,String Email ,String MobilePhone ,String industry ,String Leadsource ) throws Exception 
	    { 
	    	 nlfp.FillFirstname(firstName);
	    	 nlfp.FillLastname(lastname);
	    	 nlfp.FillMiddlename(middleName);
	    	 nlfp.FillSuffix(suffix);
	    	 nlfp.FillWebsite(Website);
	    	 nlfp.FillCompany(Company);
	    	 nlfp.FillEmail(Email);
	    	 nlfp.FillPhonenumber(MobilePhone);
	      nlfp.Selectsalutation(salutation);
	      nlfp.Selectindustry(industry);
	      nlfp.SelectLeadsource(Leadsource);	
	    }
	    
	    
	    @When("click save")
	    public void clickSaveLead() throws Throwable 
	    {
	    	nlfp.ClickSavebtn();
	    	
	    }
	    @Then("find and verify Lead and click that saved lead")
	    public void new_lead_should_be_created() throws Throwable {
	    	nlfp.isleadsaved();
			hp.clickleads();
	    	nlfp.Verifyandclicklead();
	    	//Thread.sleep(5000);
	    }
	    
	    
	    
	    @Given("^User is on   Present Saved Lead Deatils Page$")
	    public void user_is_on_present_saved_lead_deatils_page() throws Throwable {
	    	el.isEditLead_Displayed();
	 
	       
	    }

	    @And("^click on Edit$")
	    public void click_on_edit() throws Throwable {
	        el.clickEdit();
	        
	    }

	    @When("^Click Save_Btn$")
	    public void click_save_button() throws Throwable {
	        el.ClickSavebtn();
	    }

	    @And("change Phone Number as per {string}")
	    public void Change_Phonenum(String x) throws Throwable {
	        el.changephonenum(x);
	        
	    }
	    @Then("^mobile number upadted$")
	    public void chechmobilenumber() throws Throwable {
	    	nlfp.isleadsaved();
	    }

	    @And("^Click on MarkStatus$")
	    public void click_on_working() throws Throwable {
	        lc.ClickMark_Status();
	        
	    }
	    @And("^clickchatter$")
	    public void clickchatter() throws Throwable {
	        lc.ClickChatter();
	        lc.clickshareupdatebtn();
	        
	    }
	    
	    @And("Share on Update about lead {string}")
	    public void shareupdate1(String x) throws Throwable {
	        lc.clickshareupdatetxt(x);
	        lc.clicksharebtn();
	        
	    }
	    @Then("Recently Viewed lead Page will appear")
	    public void recentlyviewedpage() throws Throwable {
	        lc.isthisrecentlyviewedpage();
	        
	    }
	   
	    @Then("^Convert Lead form Will displayed$")
	    public void isConvertLeadformDisplayed() throws Throwable {
	        lc.isCovertLeadformdisplayed();
	        
	    }
	    @And("^Click on Convert Btn$")
	    public void click_on_Convertbtn() throws Throwable {
	        lc.clickconvertbtn();
	        
	    }
	    @When("^Click on goto leads Btn$")
	    public void click_on_GotoLeadsbtn() throws Throwable {
	        lc.clickgotoleads();
	        
	    }
	    
	    @When("Navigate to url")
	    public void navigate_to_url() throws Throwable {
	    	wbl.navigatetourl();
	    	}

	    @When("^Click on Submit button$")
	    public void click_on_submit_button() throws Throwable {
	    	 boolean b=wbl.clicksubmit();
	    }

	    @Then("^webtoLead form Should be displayed$")
	    public void webtolead_form_should_be_displayed() throws Throwable {
	    	  boolean b= wbl.isFormDisplayed();
	    }

	    @Then("its automatically Navigate to salesforce.com")
	    public void its_automatically_navigate_to_something() throws Throwable {
	    	boolean b= wbl.afterclicknavigation();
	    }

	    @And("Fill Form{string},{string},{string},{string},{string},{string},{string},{string}")
	    public void fill_form_with(String fn,String ln,String Salu ,String phone,String Email,String city,String state,String company) throws Throwable {
	    	 boolean b= wbl.Fillform(fn, ln, Salu, phone, Email, city, state,company);
	    }
	    
	    
	    
	    //import lead
        @When("^Click on leads link$")
    public void click_on_leads_link() throws Throwable {
    	  hp.clickleads();
	       
         
    }
	 @Then("^Page will navigates to Leads Pages$")
    public void page_will_navigates_to_leads_pages() throws Throwable {
    	hp.isAllleadsvisible();
    }

	
    @And("^click Import link$")
    public void click_import_link() throws Throwable {
    	il.clickonimportbutton();
         
    }


	 @Then("^it naviagtes to Import your Data into Salesforce page$")
    public void it_naviagtes_to_import_your_data_into_salesforce_page() throws Throwable {
		 il=new ImportLead();
         il.isProgressbarvisible();
    }


    @When("^Click on Standard object leads$")
    public void click_on_standard_object_leads() throws Throwable {
    	il=new ImportLead();
    	il.clickonStandardObjectLeads();
    }


    @Then("^progress marker shows Good job$")
    public void progress_marker_shows_good_job() throws Throwable {
    	il.ismarkstatus1displayed();
    }

    @When("^Click on add  new records$")
    public void click_on_add_new_records() throws Throwable {
         il.clickonaddnewrecord();
    }


    @When("^Click on add  CSV file to upload$")
    public void click_on_add_csv_file_to_upload() throws Throwable {
         il.clickonCSV();
    }

    @Then("^CSV file selector box will open$")
    public void csv_file_selector_box_will_open() throws Throwable {
         il.isfileselectordisplayed();
    }
      
       @When("^Click on choose file$")
    public void click_on_choose_file() throws Throwable {
         il.clickonChoosefile();
    }

    @Then("^Open window dialouge opens$")
    public void open_window_dialouge_opens() throws Throwable {
         
    }

    @When("^Send valid file path to that textbox$")
    public void send_valid_file_path_to_that_textbox() throws Throwable {
         il.AutomateOpenWindowdialoge();
    }

	 @And("^click on open button$")
    public void click_on_open_button() throws Throwable {
        
    }

	@When("^click Next button$")
    public void click_next_button() throws Throwable {
         il.clickNext();
    }

        
	@Then("^progress marker shows Almost done$")
    public void progress_marker_shows_almost_done() throws Throwable {
         
    }
	@Then("progress marker shows Great job")
    public void progress_marker_shows_greate_job() throws Throwable {
         
    }

        @When("^click start import button$")
    public void click_start_import_button() throws Throwable {
         il.clickstartimport();
    }

  @When("^click ok button$")
    public void click_ok_button() throws Throwable {
	  il.clickokbutton();
         
    }
	@Then("^page shows like Congratulations, your import has started$")
    public void page_shows_like_congratulations_your_import_has_started() throws Throwable {
		
         
    }

//////get data from picklist
	
		@When("^Click on setup Gear Symbol$")
	    public void click_on_setup_gear_symbol() throws Throwable {
	          vpo.clickonGearSymbol();
	    }

	    @When("^Click on Object Manager$")
	    public void click_on_object_manager() throws Throwable {
	          vpo.waituntillsetuphomepage();
	    }

	    @When("^Click on Module which we want to test$")
	    public void click_on_module_which_we_want_to_test() throws Throwable {
	          vpo.clickonlable();
	    }

	    @When("^Click on fields and relationships$")
	    public void click_on_fields_and_relationships() throws Throwable {
	          vpo.clickonfieldsandrelations();
	    }

	    @When("^Click on Required item$")
	    public void click_on_required_item() throws Throwable {
	          vpo.clickonitem();
	    }

	    @Then("^it should be navigates to Setup home page$")
	    public void it_should_be_navigates_to_setup_home_page() throws Throwable {
	          
	    }

	    @Then("^its opens New tab with Object Manager Title$")
	    public void its_opens_new_tab_with_object_manager_title() throws Throwable {
	          
	    }

	    @Then("^its displays  Module details  and with Title of module name$")
	    public void its_displays_module_details_and_with_title_of_module_name() throws Throwable {
	          
	    }

	    @Then("^all items in Module will appear here$")
	    public void all_items_in_module_will_appear_here() throws Throwable {
	          
	    }

	    @Then("^it will opens with picklist values$")
	    public void it_will_opens_with_picklist_values() throws Throwable {
	          
	    }

	    @And("^click on Setup button$")
	    public void click_on_setup_button() throws Throwable {
	          
	    }

	    @And("^Read table of list of item values$")
	    public void read_table_of_list_of_item_values() throws Throwable {
	          vpo.picklistvalues();
	    }

	    @And("close the tab and move to salesforce Dashboard Page open new lead form")
	    public void close_the_tab_and_move_to_salesforce_dashboard_page() throws Throwable {
	        vpo.backtosalesforcedb();
	        
	    }
	    @And("^Read List from Form")
	    public void Readlistfrom_form() throws Throwable {
	    	vpo.Readindustry();
	    	
	          
	    }
	    @And("Compare both Lists After Sort")
	    public void Comparelist_AfterSort() throws Throwable {
	    	vpo.comparelist();
	    	
	          
	    }

	   

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

	    


}
