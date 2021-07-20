package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.Base;
import objectRepository.Elements_Leads;

public class EditLead extends Base
{

	
	public  EditLead ()
	{
		
		AjaxElementLocatorFactory af=new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(af, objrep);
		//this.Driver=driver;
		//this.Wait=wait;
	}
	public void isEditLead_Displayed() throws Exception
	{
		exttest=report.createTest("Edit Lead Test");

		try {
				if(wait.until(ExpectedConditions.visibilityOf(Elements_Leads.Edit_btn)).isDisplayed())
				{
				exttest.log(Status.PASS," Edit visible Pass");
				}
			}
			catch(Exception e)
			{
				exttest.log(Status.FAIL,"Edit visible Failed");
				takescreenshot();
			}
			
	}
	
	
	public void clickEdit() throws Exception
	{
		
		try {
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.Edit_btn)).click();
		exttest.log(Status.PASS,"Clicking on Edit Pass");
		}
		catch(Exception e)
		{
			exttest.log(Status.FAIL,"Clicking on Edit Fail");
			takescreenshot();
		}
	}
	public Boolean isleadFormDisplyed() throws Exception
	{
		
		try {
			if(wait.until(ExpectedConditions.visibilityOf(Elements_Leads.Editleadform)).isDisplayed())
			{
		
			exttest.log(Status.PASS,"Edit Leads Form Visable");
			}
			return(true);
			}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Edit Leads Form Not Visable");
			takescreenshot();
			return(false);
		}
	}
	public Boolean changephonenum(String s) throws Exception
	{
		
		try {
			wait.until(ExpectedConditions.visibilityOf(Elements_Leads.Phone)).clear();;
			wait.until(ExpectedConditions.visibilityOf(Elements_Leads.Phone)).sendKeys(s);
			exttest.log(Status.PASS,"Phone number changed");
			
			
			return(true);
			}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Phone number not changed");
			takescreenshot();
			return(false);
		}
	}
	public void ClickSavebtn() throws Exception
	{
		
		try
		{
			wait.until(ExpectedConditions.visibilityOf(Elements_Leads.Savebtn)).click();
			Thread.sleep(1000);
			exttest.log(Status.PASS,"Save Button clicked");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Save Button clicked");
			takescreenshot();
		}
		
	}
	

	
	

}
