package pages;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.Base;
import objectRepository.Elements_Leads;

public class Verify_Picklist_ObjectManager extends Base
{
	HomePage hp=new HomePage();
	public List<String> items=new ArrayList<>();
	public List<String> ditems=new ArrayList<>();
	public Set<String> s; 
	public ArrayList<String> a;
	public Verify_Picklist_ObjectManager()
	{
    	AjaxElementLocatorFactory af=new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(af, objrep);
		//this.Driver=driver;
		//this.Wait=wait;
	}
	
	public Boolean clickonGearSymbol() throws Exception
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.setupgear)).click();
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.setupbtn)).click();
		
		return (true);
		}
		catch(Exception ex)
		{
			takescreenshot();
			return (false);
		}
		
	}

		public Boolean waituntillsetuphomepage() throws Exception
		{
			try
			{
				s=driver.getWindowHandles();
		    	a=new ArrayList<String>(s);
		    	driver.switchTo().window(a.get(1));
			while(!driver.getTitle().contains("Home"))
			{
				Thread.sleep(1000);
			} 
		
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Leads.getstarted)).isDisplayed();
			exttest.log(Status.PASS,"Get Started visible  pass");
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Leads.objectmanager)).click();
			
			return(true);
			}
			catch(Exception ex)
			{
				takescreenshot();
				return (false);
			}	
		
			}
		
		public Boolean clickonlable() throws Exception
		{
			try
			{
			wait.until(ExpectedConditions.visibilityOf(Elements_Leads.clickonlable)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Details']"))).isDisplayed();
			
			return (true);
			}
			catch(Exception ex)
			{
				takescreenshot();
				return (false);
			}
			
		}
		
		
		public Boolean clickonfieldsandrelations() throws Exception
		{
			try
			{
			wait.until(ExpectedConditions.visibilityOf(Elements_Leads.clickoFiledsandrelations)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Custom Field']"))).isDisplayed();
			
			return (true);
			}
			catch(Exception ex)
			{
				takescreenshot();
				return (false);
			}
			
		}
		
		public Boolean clickonitem() throws Exception
		{
			try
			{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Industry'])[1]"))).click();
			
			return (true);
			}
			catch(Exception ex)
			{
				takescreenshot();
				return (false);
			}
			
		}
		public Boolean picklistvalues() throws Exception
		{
			try
			{
				Thread.sleep(10000);
			
		WebElement wtable=	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@class='list'])[3]")));
			List<WebElement>l=wtable.findElements(By.xpath("//th[@scope='row']"));
			for(WebElement ee:l)
			{
				String x=(String)driver.executeScript("return arguments[0].textContent;",ee);
				items.add(x);
				items.sort(Comparator.comparing( String::toString ));
			
			}
			System.out.println(items);
			driver.switchTo().parentFrame();
		
			
			return (true);
			}
			catch(Exception ex)
			{
				takescreenshot();
				return (false);
			}
			
		}
		
		public void backtosalesforcedb() throws Exception
		{
			Thread.sleep(5000);
			driver.close();
			s=driver.getWindowHandles();
		    	a=new ArrayList<String>(s);
	    	driver.switchTo().window(a.get(0));
	    	//Makedelay(Elements_Leads.leadslink,driver);
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.leadslink)).isDisplayed();
	    	hp.clicknewleads();	
	    
		}
		
		
		public void Readindustry() throws Exception
		{
			exttest=report.createTest("Read Industry Test");
			try
			{
				//Thread.sleep(2000);
			WebElement drpIndustry =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='slds-combobox_container'])[4]//child::div[2]")));
			driver.executeScript("arguments[0].scrollIntoView(true);", drpIndustry);
			driver.executeScript("arguments[0].click();",drpIndustry);
			List<WebElement>l=drpIndustry.findElements(By.xpath("child::*[contains(@data-value,'')]/following-sibling::*//*[@class='slds-media__body']//*"));
			for(WebElement ee:l)
			{
				driver.executeScript("arguments[0].scrollIntoView(true);", ee);
				String x=(String)driver.executeScript("return arguments[0].textContent;", ee);
					x=x.trim();
					ditems.add(x);
						
			}
			ditems.sort(Comparator.comparing( String::toString ));
			exttest.log(Status.PASS,"Read Industry");
			
			}
			catch(Exception ex)
			{
				exttest.log(Status.FAIL,"Read Industry");
				takescreenshot();
			}
		}	
		
		public void comparelist()
		{
			exttest=report.createTest("List s compare  Test");
			 if (items.equals(ditems) == true) {
		            exttest.log(Status.PASS,"Both lists are same");
		        }
		        else {
		            System.out.println(" Array List are not equal");
		            
		            List<String> tempitems=items;
		            tempitems.removeAll(ditems);
		            System.out.println(tempitems);
		            exttest.log(Status.FAIL,"Both lists not same missing items are "+tempitems);
		        }
			 
			 wait.until(ExpectedConditions.visibilityOf(Elements_Leads.Cancelbtn)).click();
			
		}
		
		
}
