package pages;



import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;



import base.Base;
import objectRepository.Elements_Leads;
import siteutilities.PropertiesFileUtilities;

public class WebtoLead extends Base
{
	public Set<String> s; 
	public ArrayList<String> a;

	public WebtoLead()
	{
    	AjaxElementLocatorFactory af=new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(af, objrep);
		//this.Driver=driver;
		//this.Wait=wait;
	}
    
    public void navigatetourl() throws Exception
    {
    	String url=PropertiesFileUtilities.getValueInPropertiesFile("webtoleadurl");
    	driver.switchTo().newWindow(WindowType.WINDOW);
    	s=driver.getWindowHandles();
    	a=new ArrayList<String>(s);
    	driver.switchTo().window(a.get(1));
    	driver.get(url);
    	driver.manage().window().maximize();
    }

	public Boolean isFormDisplayed() throws Exception
	{
		try
		{
		if(wait.until(ExpectedConditions.visibilityOf(Elements_Leads.firstname)).isDisplayed())
		{
			
		}
		return (true);
		}
		catch(Exception ex)
		{
			takescreenshot();
			return (false);
		}
		
	}
	public Boolean Fillform(String fn,String ln,String Salu,String phone ,String Email,String city,String state,String company)
	{
		try
		{
		WebElement drp=wait.until(ExpectedConditions.visibilityOf(Elements_Leads.salutation));
		Select s=new Select(drp);
		s.selectByVisibleText(Salu);
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.firstname)).sendKeys(fn);
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.wllastname)).sendKeys(ln);
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.phone)).sendKeys(phone);
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.email)).sendKeys(Email);
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.city)).sendKeys(city);
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.state)).sendKeys(state);
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.company)).sendKeys(company);
		
		return (true);
		}
		catch(Exception ex)
		{
			return (false);
		}
	}
	
	
	public Boolean clicksubmit()
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.submit)).click();
		return (true);
		}
		catch(Exception ex)
		{
			return (false);
		}
		
	}
	
	public Boolean afterclicknavigation()
	{
		try
		{
				String x=driver.getTitle();
				if(!x.equalsIgnoreCase("WebtoLead.html"))
				{
					driver.close();
					driver.switchTo().window(a.get(0));	
				}
				return (true);
		}
		catch(Exception ex)
		{
			driver.close();
			driver.switchTo().window(a.get(0));
				return (false);
		}
		
	}
	
	
	
	
	
	
}
