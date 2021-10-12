package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Elements_Leads 
{
	
	////Home Page
	@FindBy(how=How.XPATH,using="(//*[text()='Home'])[1]")
	public static WebElement Homebtn;
	@FindBy(how=How.XPATH,using="(//*[text()='Leads'])[1]")
	public static WebElement leadslink;
	@FindBy(how=How.XPATH,using="(//*[text()='Leads'])[2]")
	public static WebElement leadsafterclick;
	@FindBy(how=How.XPATH,using="//*[text()='New']")
	public static WebElement newlead;
	@FindBy(how=How.XPATH,using="//*[text()='New Lead']")
	public static WebElement newleadform;
	
	////NewLead Page
	
	@FindBy(xpath="//input[@name='lastName']") 
	public static WebElement lastname;
	
	@FindBy(how=How.XPATH,using="//input[@name='firstName']")
	public static WebElement firstName;
	
	@FindBy(how=How.XPATH,using="//input[@name='middleName']")
	public static WebElement middleName;
	
	@FindBy(how=How.XPATH,using="//input[@name='Website']")
	public static WebElement Website;
	
	@FindBy(how=How.XPATH,using="//input[@name='suffix']")
	public static WebElement suffix;
	
	@FindBy(how=How.XPATH,using="//input[@name='Company']")
	public static WebElement Company;
	
	@FindBy(how=How.XPATH,using="//input[@name='Email']")
	public static WebElement Email;
	
	@FindBy(how=How.XPATH,using="//input[@name='Phone']")
	public static WebElement Phone;
	
	@FindBy(how=How.XPATH,using="//*[@name='SaveEdit']")
	public static WebElement Savebtn;
	@FindBy(how=How.XPATH,using="//button[@title='Close this window']")
	public static WebElement Cancelbtn;
	@FindBy(how=How.XPATH,using="//*[@class='slds-media__body']//*")
	public static WebElement divchild;
	
	
	
	
	@FindBy(how=How.XPATH,using="//span[@data-aura-class='forceActionsText']/parent::*")
	public static WebElement statusfornewlead;
	
	//@FindBy(how=How.XPATH,using="//div[contains(@class,'slds-theme--success slds-notify--toast')]")
	//public static WebElement statusfornewlead;
	
	/////////////////EditLead class
	
	@FindBy(how=How.XPATH,using="//button[text()='Edit']")
	public static WebElement Edit_btn;
	@FindBy(how=How.XPATH,using="//div[@class='slds-modal__header']//*[contains(text(),'Edit')]")
	public static WebElement Editleadform;

	///////////////////////Leadconvert class
	
	
	@FindBy(how=How.XPATH,using="(//*[contains(text(),'Mark Status')])")
	public static WebElement MarkStatus;
	
	@FindBy(how=How.XPATH,using="(//*[text()='Chatter'])[2]")
	public static WebElement clickchatter;
	
	@FindBy(how=How.XPATH,using="//button[@title='Share an update...']")
	public static WebElement shareupdatebtn;
	

	@FindBy(how=How.XPATH,using="//span[text()='Share']")
	public static WebElement sharefirst;
	
	@FindBy(how=How.XPATH,using="(//div[@class='ql-clipboard']/preceding-sibling::div)//*")
	public static WebElement shareupdatetxt;
	
	@FindBy(how=How.XPATH,using="//button[text()='Share']")
	public static WebElement sharebtn;
	
	@FindBy(how=How.XPATH,using="//*[text()='Select Converted Status']")
	public static WebElement Convertstatusbtn;
	@FindBy(how=How.XPATH,using="//h2[text()='Convert Lead ']")
	public static WebElement Convertleadform;

	@FindBy(how=How.XPATH,using="//*[text()='Convert']")
	public static WebElement Convertbtn;
	@FindBy(how=How.XPATH,using="//button[text()='Go to Leads']")
	public static WebElement Goto_leads;
	
	@FindBy(how=How.XPATH,using="(//input[@class=' input'])[1]")
	public static WebElement beforeconvert;
	@FindBy(how=How.XPATH,using="//div[text()='Contact']")
	public static WebElement beforegotoleads;
	
	
	
	
	
	///////////////////////web to lead
	@FindBy(how=How.NAME,using="first_name")
	public static WebElement firstname;
	@FindBy(how=How.NAME,using="last_name")
	public static WebElement wllastname;
	@FindBy(how=How.NAME,using="phone")
	public static WebElement phone;
	@FindBy(how=How.NAME,using="email")
	public static WebElement email;
	@FindBy(how=How.NAME,using="city")
	public static WebElement city;
	@FindBy(how=How.NAME,using="state")
	public static WebElement state;
	@FindBy(how=How.NAME,using="company")
	public static WebElement company;
	@FindBy(how=How.NAME,using="salutation")
	public static WebElement salutation;
	@FindBy(how=How.NAME,using="submit")
	public static WebElement submit;
	
	
	////////////find and verify lead
	@FindBy(how=How.XPATH,using="//table[contains(@class,'slds-table forceRecordLayout')]/tbody[1]")
	public static WebElement wtbody;
	@FindBy(how=How.XPATH,using="//button[contains(@class,'slds-button slds-button--reset')]")
	public static WebElement Drptriangle;
	@FindBy(how=How.XPATH,using="//ul[@class='slds-dropdown__list slds-show']")
	public static WebElement selectlist;
	@FindBy(how=How.XPATH,using="//span[text()='Updated a few seconds ago']")
	public static WebElement fewsecago;
	
	
	
	
	//Import Lead
	@FindBy(how=How.XPATH,using="(//*[text()='Import'])")
	public static WebElement importlink;
	@FindBy(how=How.LINK_TEXT,using="Leads")
	public static WebElement importLeads;
	@FindBy(how=How.XPATH,using="(//div[@class='progress-marker-caption-content'])[2]")
	public static WebElement progressmarker2;
	
	@FindBy(how=How.LINK_TEXT,using="Add new records")
	public static WebElement clicknewrecords;
	@FindBy(how=How.XPATH,using="(//div[@class='progress-marker-caption-content'])[3]")
	public static WebElement progressmarker3;
	@FindBy(how=How.XPATH,using="//span[text()='CSV']")
	public static WebElement CSVbtn;
	@FindBy(how=How.XPATH,using="//input[@type='file']/parent::*")
	public static WebElement choosefile;
	@FindBy(how=How.LINK_TEXT,using="Next")
	public static WebElement importNextbtn;
	@FindBy(how=How.XPATH,using="(//div[@class='progress-marker-caption-content'])[4]")
	public static WebElement progressmarker4;
	@FindBy(how=How.XPATH,using="(//div[@class='progress-marker-caption-content'])[5]")
	public static WebElement progressmarker5;
	@FindBy(how=How.LINK_TEXT,using="Start Import")
	public static WebElement startimport;
	@FindBy(how=How.LINK_TEXT,using="OK")
	public static WebElement okbtnm;
	
	@FindBy(how=How.XPATH,using="//a[text()='Help for this page']")
	public static WebElement helplink;
	
	@FindBy(how=How.XPATH,using="//a[text()='Get Started']")
	public static WebElement getstarted;
	
	
	////getdata from object manager
	@FindBy(how=How.XPATH,using="//div[@class='setupGear']")
	public static WebElement setupgear;
	@FindBy(how=How.XPATH,using="//div[@role='menu']//li[1]")
	public static WebElement setupbtn;
	
	@FindBy(how=How.XPATH,using="//span[text()='Object Manager']")
	public static WebElement objectmanager;
	@FindBy(how=How.XPATH,using="//a[text()='Lead']")
	public static WebElement clickonlable;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Fields &')]")
	public static WebElement clickoFiledsandrelations;
	
	@FindBy(how=How.XPATH,using="//h3[text()='Field Information']")
	public static WebElement filedinfo;
	
	
	
	

	
	
	
	
	
	
	
	
	
}
