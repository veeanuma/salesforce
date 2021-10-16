package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.Base;
import objectRepository.Elements_Leads;

public class LeadConvert extends Base
{
	
	//private RemoteWebDriver Driver;
	//private FluentWait<RemoteWebDriver> Wait;

	
	public  LeadConvert()
	{
		
		AjaxElementLocatorFactory af=new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(af, objrep);
		//this.Driver=driver;
		//this.Wait=wait;
	}
	
	
	public void ClickMark_Status() throws Exception
	{
		
		try {
			
		//WebElement e =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(text(),'Mark Status')])")));
			WebElement e =wait.until(ExpectedConditions.presenceOfElementLocated(su.getByFromWebElement(Elements_Leads.MarkStatus)));
		driver.executeScript("arguments[0].click();",e);
		exttest.log(Status.PASS,"Working button clicked ");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Mark Status as Completebutton not clicked ");
			takescreenshot();
		}
	}
		public void ClickChatter() throws Exception
	{
		exttest=report.createTest(" Covert Lead to contact Test");
		try {
		
		//WebElement e =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()='Chatter'])[2]")));
			WebElement e =wait.until(ExpectedConditions.presenceOfElementLocated(su.getByFromWebElement(Elements_Leads.clickchatter)));
		driver.executeScript("arguments[0].scrollIntoView(true);", e);
		driver.executeScript("arguments[0].click();",e);
		exttest.log(Status.PASS," Chatter button clicked ");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL," Chatter button  Not clicked ");
			takescreenshot();
		}
	}
	public void clickshareupdatebtn() throws Exception
	{
		
		try {
		Thread.sleep(5000);
		//WebElement e =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Share an update...']")));
		WebElement e =wait.until(ExpectedConditions.presenceOfElementLocated(su.getByFromWebElement(Elements_Leads.shareupdatebtn)));
		driver.executeScript("arguments[0].scrollIntoView(true);", e);
		driver.executeScript("arguments[0].click();",e);
		exttest.log(Status.PASS," shareupdate button clicked ");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL," shareupdate button Not clicked ");
			takescreenshot();
		}
	}
	public void clickshareupdatetxt(String x) throws Exception
	{
		
		try {
			Thread.sleep(2000);
			WebElement e =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-clipboard']/preceding-sibling::div)//p")));
			//driver.executeScript("arguments[0].scrollIntoView(true);", e);
		driver.executeScript("arguments[0].innerHTML='"+x+"';",e);
		exttest.log(Status.PASS," shareupdate text sent ");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL," shareupdate text not sent ");
			takescreenshot();
		}
	}
	public void clicksharebtn() throws Exception
	{
		
		try {
			
		WebElement e =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Share']")));
		driver.executeScript("arguments[0].click();",e);
		exttest.log(Status.PASS," sharebutton test pass ");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL," sharebutton test Failed ");
			takescreenshot();
		}
		
	}
	public void isCovertLeadformdisplayed() throws Exception
	{
		
		try {
				if(wait.until(ExpectedConditions.visibilityOf(Elements_Leads.Convertleadform)).isDisplayed())
				{
				exttest.log(Status.PASS," Convert Lead form displayed ");
				}
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL," Convert Lead form not displayed ");
			takescreenshot();
		}
	}
	public void clickconvertbtn() throws Exception
	{
		
		try {
		Makedelay(Elements_Leads.beforeconvert,driver);
		if(wait.until(ExpectedConditions.visibilityOf(Elements_Leads.Convertbtn)).isDisplayed())
		{
		wait.until(ExpectedConditions.elementToBeClickable(Elements_Leads.Convertbtn)).click();
		}
		exttest.log(Status.PASS," convert button clicked ");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL," convert button not clicked ");
			takescreenshot();
		}
		
	}
	public void clickgotoleads() throws Exception
	{
	
		try {
			Makedelay(Elements_Leads.beforegotoleads,driver);
		//wait.until(ExpectedConditions.visibilityOf(Elements_Leads.Goto_leads)).click();
			if(wait.until(ExpectedConditions.elementToBeClickable(Elements_Leads.Goto_leads)).isDisplayed())
			{
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Leads.Goto_leads)).click();
			}
		exttest.log(Status.PASS," goto_leads button clicked ");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL," goto_leads button Not clicked ");
			takescreenshot();
		}
	}
	
	public void isthisrecentlyviewedpage() throws Exception
	{
		
		try {
				String x=driver.getTitle();
				if(x.contains("Recently Viewed")) 
				{
				exttest.log(Status.PASS," Recently Viewed  Leads Page Displayed");
				}
		
			}
			catch(Exception ex)
			{
				exttest.log(Status.FAIL," Recently Viewed  Leads Page Not Displayed");
				takescreenshot();
				
			}
		}

}
