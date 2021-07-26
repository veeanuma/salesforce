package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.Base;
import objectRepository.Elements_Leads;

public class ImportLead extends Base
{

	public  ImportLead ()
	{
		
		AjaxElementLocatorFactory af=new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(af, objrep);
		//this.Driver=driver;
		//this.Wait=wait;
	}

	
	public Boolean clickonimportbutton() throws Exception
	{
		exttest=report.createTest(" Import   Test");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Leads.importlink)).click();
			
			exttest.log(Status.PASS,"click on Import btn pass");
			return(true);
			}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"click on Import btn failed");
			takescreenshot();
			return(false);
		}
	}
	
	public Boolean isProgressbarvisible() throws Exception
	{
		
		try {
			
		while(!driver.getTitle().contains("Home"))
			{
				Thread.sleep(1000);
			} 
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Leads.getstarted)).isDisplayed();
			exttest.log(Status.PASS,"Get Started visible  pass");
			return(true);
			}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Get Started not  visible  failed");
			takescreenshot();
			return(false);
		}
	}
	public Boolean ismarkstatus1displayed() throws Exception
	{

		try {
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.visibilityOf(Elements_Leads.progressmarker2)).isDisplayed();
			driver.switchTo().defaultContent();
			exttest.log(Status.PASS,"Mark Status visible  pass");
			return(true);
			}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Mark Status visible  failed");
			takescreenshot();
			return(false);
		}
	}
	
	public Boolean isfileselectordisplayed() throws Exception
	{
		
		try {
			driver.switchTo().frame(0);
		
			wait.until(ExpectedConditions.visibilityOf(Elements_Leads.choosefile)).isDisplayed();
			
			driver.switchTo().defaultContent();
			exttest.log(Status.PASS,"File selector visible  pass");
			return(true);
			}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"File selector visible failed");
			takescreenshot();
			return(false);
		}
	}
	
	
	
	public Boolean clickonStandardObjectLeads() throws Exception
	{
		
		try {
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Leads.importLeads)).click();
			driver.switchTo().defaultContent();
			exttest.log(Status.PASS,"click on  leads pass");
			return(true);
			}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"click on leads failed");
			takescreenshot();
			return(false);
		}
	}
	public Boolean clickonaddnewrecord() throws Exception
	{
		
		
		try {
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Leads.clicknewrecords)).click();
			driver.switchTo().defaultContent();
			exttest.log(Status.PASS,"click on New record pass");
			return(true);
			}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"click on New record failed");
			takescreenshot();
			return(false);
		}
	}
	
	public Boolean clickonCSV() throws Exception
	{
		
		try {
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Leads.CSVbtn)).click();
			driver.switchTo().defaultContent();
			exttest.log(Status.PASS,"click on CSV btn pass");
			return(true);
			}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"click on CSV btn failed");
			takescreenshot();
			return(false);
		}
	}
	public void clickonChoosefile() throws Exception
	{
		  Thread.sleep(5000);
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\Datafiles\\importlead.csv";
		driver.switchTo().frame(0);
		driver.executeScript("arguments[0].scrollIntoView(true);", Elements_Leads.helplink);
		driver.executeScript("arguments[0].style.display='block';",Elements_Leads.choosefile);
		Elements_Leads.choosefile.sendKeys(path);
		driver.switchTo().defaultContent();
		
	}
	
	public void AutomateOpenWindowdialoge() throws Exception
	{
		

	}
	
	public void clickNext() throws Exception
	{
		
		try {
			Thread.sleep(5000);
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Leads.importNextbtn)).click();
			driver.switchTo().defaultContent();
			exttest.log(Status.PASS,"Click on Next Btn Pass");
			takescreenshot();
			
			
			
		}
		
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Click on next btn failed");
			takescreenshot();
		}
	}
	public void clickstartimport() throws Exception
	{
		
		try {
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Leads.startimport)).click();
			driver.switchTo().defaultContent();
			exttest.log(Status.PASS,"Click on Start import btn Pass");
			
			
		}
		
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Click on Start import  btn failed");
			takescreenshot();
		}
	}
	
	
	public void clickokbutton() throws Exception
	{
		
		try {
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Leads.okbtnm)).click();
			driver.switchTo().defaultContent();
			exttest.log(Status.PASS,"Click on OK btn Pass");
			
			
		}
		
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Click on OK btn failed");
			takescreenshot();
		}
	}
	
}
