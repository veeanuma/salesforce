package pages;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import com.aventstack.extentreports.Status;

import base.Base;
import objectRepository.Elements_Leads;
import objectRepository.Elements_Login;
import siteutilities.PropertiesFileUtilities;

public class LoginPage  extends Base
{
	
	public LoginPage()
	{
		AjaxElementLocatorFactory af=new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(af,objlogin);
		//this.Driver=driver;
		//this.Wait=wait;
	}
	
	
	public Boolean closebtn() throws Exception
	{ 
		Boolean b=false;
		try
	   {
			
			if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Close']"))).isDisplayed())
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Close']"))).click();
				b=true;
				
			}
			
			return b;
			
	   }
		catch(Exception ex)
		{
		return false;
		}
		
	}
	
	
	
	public void uidFill() throws Exception
	{ 
		
		try
	   {
		String x = PropertiesFileUtilities.getValueInPropertiesFile("uid");
		wait.until(ExpectedConditions.visibilityOf(Elements_Login.uid)).sendKeys(x);
		exttest.log(Status.PASS,"Uid Entering Working Properly");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Uid Entering Not Working Properly");	
			takescreenshot();
		}
	}
	public void pwdFill() throws Exception
	{
		try
		   {
		String x = PropertiesFileUtilities.getValueInPropertiesFile("pwd");
		wait.until(ExpectedConditions.visibilityOf(Elements_Login.pwd)).sendKeys(x);
		exttest.log(Status.PASS,"Password Entering Working Properly");
		   }
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Password Entering Not Working Properly");
			takescreenshot();
		}
	    }
	public void clicklogintbn() throws Exception
	{
		try
		   {
		wait.until(ExpectedConditions.elementToBeClickable(Elements_Login.loginbtn)).click();
		exttest.log(Status.PASS,"Login Button Working Properly");
		closebtn();
		
		   }
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Login Button Not Working Properly");
			takescreenshot();
		}
	}
	
	public Boolean validateurl() throws Exception
	{
		exttest=report.createTest("Login-Page Test");
		String x = PropertiesFileUtilities.getValueInPropertiesFile("url");
		URL u=new URL(x);
		HttpURLConnection con=(HttpURLConnection)u.openConnection();
		con.connect();
		
		if(con.getResponseMessage().equalsIgnoreCase("OK"))
		{
			exttest.log(Status.PASS,"Url Working Properly");
		return true;
		}
		else
		{
			exttest.log(Status.FAIL,"Url Not Working Properly");
			return false;
		}
	}
	
	

}



