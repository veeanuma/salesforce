package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.Base;
import objectRepository.Elements_Leads;

public class HomePage extends Base 
{
	//private RemoteWebDriver Driver;
	//private FluentWait<RemoteWebDriver> Wait;	
	
	/*public HomePage(RemoteWebDriver driver,FluentWait<RemoteWebDriver> Wait)
	{
		AjaxElementLocatorFactory af=new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(af, this);
		this.driver=driver;
		this.Wait=Wait;
	}
	*/
	
	public HomePage()
	{
		AjaxElementLocatorFactory af=new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(af, objrep);
		//this.Driver=driver;
		//this.Wait=wait;
	}
	public void closebtn() throws Exception
	{ 
		
		try
	   {
			
			if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Close']"))).isDisplayed())
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Close']"))).click();
			}
			
			
			
	   }
		catch(Exception ex)
		{
		
		}
		
	}
	
	
	public void clickleads() throws Exception
	{
		exttest=report.createTest("Leads Test");
			try
			{
			WebElement e =wait.until(ExpectedConditions.visibilityOf(Elements_Leads.leadslink));
			driver.executeScript("arguments[0].click();",e);
			
			exttest.log(Status.PASS,"Leads item click Pass");
			}
			catch(Exception ex)
			{
				exttest.log(Status.FAIL,"Leads item click Failed");
				takescreenshot();
			}
	 }
	public Boolean isAllleadsvisible() throws Exception
	{
		
		try
		{
		if(wait.until(ExpectedConditions.visibilityOf(Elements_Leads.leadsafterclick)).isDisplayed())
			{
			exttest.log(Status.PASS,"All Leads are Visabled");
			}
		return(true);
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"All Leads are Not Visabled");
			takescreenshot();
			return(false);
		}
	}
	public void clicknewleads() throws Exception
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.newlead)).click();
		exttest.log(Status.PASS,"New Lead is click Pass");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"New Lead is click Fail");
			takescreenshot();
		}
		}
	
	public Boolean isNewleadFormDisplyed() throws Exception
	{
		
		Thread.sleep(5000);
		try {
				if(wait.until(ExpectedConditions.visibilityOf(Elements_Leads.newleadform)).isDisplayed())
				{
				exttest.log(Status.PASS,"Leads Form Visable");
				}
				return(true);
		     }
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Leads Form Not Visable");
			takescreenshot();
			return(false);
		}
	}
	
	public Boolean isHomeDisplyed() throws Exception
	{
	
		try {
				if(wait.until(ExpectedConditions.visibilityOf(Elements_Leads.Homebtn)).isDisplayed())
				{
				exttest.log(Status.PASS,"Home Page Displayed");
				closebtn();
				}
				return(true);
			}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Home Page Displayed");
			takescreenshot();
			return(false);
			
		}
	}
	
	
	}
	


