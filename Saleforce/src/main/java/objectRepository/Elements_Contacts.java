package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Elements_Contacts 
{
	@FindBy(how=How.XPATH,using="//*[@data-id='Contact']")
	public static WebElement Contactslink;
	@FindBy(how=How.XPATH,using="(//*[text()='Contacts'])[2]")
	public static WebElement Contactsafterclick;
	@FindBy(how=How.XPATH,using="((//div[contains(@class,'slds-truncate disabled')])//*[@class='uiOutputPhone'])[2]")
	public static WebElement Phonenum;
	@FindBy(how=How.XPATH,using="(//div[contains(@class,'forceVirtualActionMa')])[1]")
	public static WebElement Showmoreoptions;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Updated')]")
	public static WebElement updatedfewago;
	
	@FindBy(how=How.XPATH,using="(//a[@title='Delete'])[1]")
	public static WebElement Deletelink;
	@FindBy(how=How.XPATH,using="//button[@title='Delete']")
	public static WebElement Deletebtn;
	@FindBy(how=How.XPATH,using="//span[@data-aura-class='forceActionsText']")
	public static WebElement statusofelement;
	
	
}
