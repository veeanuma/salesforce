package pages;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
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
		exttest.log(Status.PASS," Click on gear symbol Pass");
		
		return (true);
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL," Click on gear symbol Fail");
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
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Leads.objectmanager)).click();
			exttest.log(Status.PASS,"Get Started visible  pass");
			
			return(true);
			}
			catch(Exception ex)
			{
				exttest.log(Status.FAIL,"get started  visible fail");
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
			exttest.log(Status.PASS,"click on Lable pass");
			return (true);
			}
			catch(Exception ex)
			{
				exttest.log(Status.FAIL,"click on Lable Fail");
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
			exttest.log(Status.PASS,"click on Filed and relations Pass");
			return (true);
			}
			catch(Exception ex)
			{
				exttest.log(Status.FAIL,"click on Filed and relations Fail");
				takescreenshot();
				return (false);
			}
			
		}
		
		public Boolean clickonitem() throws Exception
		{
			try
			{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Industry'])[1]"))).click();
			exttest.log(Status.PASS,"click on item pass");
			return (true);
			}
			catch(Exception ex)
			{
				exttest.log(Status.FAIL,"click on item failed");
				takescreenshot();
				return (false);
			}
			
		}
		public Boolean picklistvalues() throws Exception
		{
			try
			{
				Boolean b=true;
				while(b)
				{
					try
					{
					driver.switchTo().frame(0);
					wait.until(ExpectedConditions.visibilityOf(Elements_Leads.filedinfo)).isDisplayed();
					b=false;
					}
					catch(Exception e)
					{
						Thread.sleep(1000);
					}
				}
			
		WebElement wtable=	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@class='list'])[3]")));
			List<WebElement>l=wtable.findElements(By.xpath("//th[@scope='row']"));
			for(WebElement ee:l)
			{
				String x=(String)driver.executeScript("return arguments[0].textContent;",ee);
				items.add(x);
				items.sort(Comparator.comparing( String::toString ));
			
			}
			
			driver.switchTo().parentFrame();
		
			exttest.log(Status.PASS,"Picking values in list pass");
			return (true);
			}
			catch(Exception ex)
			{	exttest.log(Status.FAIL,"Picking values in list failed");
				takescreenshot();
				return (false);
			}
			
		}
		
		public void backtosalesforcedb() throws Exception
		{
			
			driver.close();
			System.out.println("driver closed");
	    	driver.switchTo().window(a.get(0));
		System.out.println("First window");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.Homebtn)).isDisplayed();
	    	//Makedelay(Elements_Leads.leadslink,driver);
		hp=new HomePage();
	       hp.clicknewleads();
	       System.out.println("new leads clicked");
	       hp.isNewleadFormDisplyed();
	    
		}
		
		
		public void Readindustry() throws Exception
		{
			exttest=report.createTest("Read Industry Test");
			try
			{
				Thread.sleep(2000);
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
			exttest.log(Status.PASS,"Read Industry pass ");
			
			}
			catch(Exception ex)
			{
				exttest.log(Status.FAIL,"Read Industry fail ");
				takescreenshot();
			}
		}	
		
		public void comparelist()
		{
			//exttest=report.createTest("List s compare  Test");
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
