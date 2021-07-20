package pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.Base;
import objectRepository.Elements_Contacts;
import objectRepository.Elements_Leads;

public class ContactsPage extends Base 
{
	NewLeadFormPage nl=new NewLeadFormPage();
	public  ContactsPage() 
	{
		
		AjaxElementLocatorFactory af=new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(af, objcon);
		PageFactory.initElements(af, objrep);
		//this.Driver=driver;
		//this.Wait=wait;
	}

	public void ClickOnContacts() throws Exception
	{
		exttest=report.createTest(" Contacts Module Test");
		try {
			wait.until(ExpectedConditions.visibilityOf(Elements_Contacts.Contactslink)).click();
		//	WebElement e=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Contacts']")));
			
			//driver.executeScript("arguments[0].click();",Elements_Contacts.Contactslink);
		exttest.log(Status.PASS,"Contacts Link clicked ");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Contacts Link not clicked ");
			takescreenshot();
		}
	}
	public Boolean isAlllContactsvisible() throws Exception
	{
		
		try
		{
			Verifyandclicklead();
			Makedelay(Elements_Contacts.Contactsafterclick,driver);
			exttest.log(Status.PASS,"All Contracts are Visabl");
			
		return(true);
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"All Contracts are Not Visable");
			takescreenshot();
			return(false);
		}
	}
	public void Crosscheck(String x) throws Exception
	{
		
		try {
				String s=wait.until(ExpectedConditions.visibilityOf(Elements_Contacts.Phonenum)).getText();
				if(s.equalsIgnoreCase(x))
				{
				exttest.log(Status.PASS," Cross check of contact Test Pass ");
				}
				
				}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Cross check of contact Test Fail ");
			takescreenshot();
		}
	}
	
	public void clickshowmoreoptions() throws Exception
	{
		
		try {
			//wait.until(ExpectedConditions.visibilityOf(Elements_Contacts.Showmoreoptions)).click();
			Makedelay(Elements_Contacts.updatedfewago,driver);
			ReadTable();
			exttest.log(Status.PASS,"Click more options Triangle Pass");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Click more options Triangle Fail ");
			takescreenshot();
		}
	}
	
	
	public void isOptionsvisible() throws Exception
	{
		
		try {
			
				if(	wait.until(ExpectedConditions.visibilityOf(Elements_Contacts.Deletelink)).isDisplayed())
				{
					driver.executeScript("arguments[0].style.border='3px solid red'",Elements_Contacts.Deletelink);
					exttest.log(Status.PASS,"isOptionsvisible Pass");
				}
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"isOptionsvisible Fail ");
			takescreenshot();
		}
	}
	
	public void isDeleteConfirmationVisible() throws Exception
	{
		
		try {
				if(wait.until(ExpectedConditions.visibilityOf(Elements_Contacts.Deletebtn)).isDisplayed())
				{
				exttest.log(Status.PASS,"Delete Confirmation Visiblee Pass");
				}
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Delete Confirmation Visible");
			takescreenshot();
		}
	}
	

	public void clickdeletelink() throws Exception
	{
		
		try {
			wait.until(ExpectedConditions.visibilityOf(Elements_Contacts.Deletelink)).click();
			exttest.log(Status.PASS,"Click delete link Pass");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Click delete link Fail ");
			takescreenshot();
		}
	}
	
	public void clickdeletebtn() throws Exception
	{
		
		try {
			wait.until(ExpectedConditions.visibilityOf(Elements_Contacts.Deletebtn)).click();
			exttest.log(Status.PASS,"Click delete btn Pass");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Click delete btn Fail ");
			takescreenshot();
		}
	}
	
	public Boolean isContactdeleted() throws Exception
	{
	
		try {
				if(wait.until(ExpectedConditions.visibilityOf(Elements_Contacts.statusofelement)).isDisplayed())
				{
				driver.executeScript("arguments[0].style.border='3px solid red'",Elements_Contacts.statusofelement);
				exttest.log(Status.PASS,"Contact delete Pass ");
				}
			return(true);
			}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,ex.getMessage());
			takescreenshot();
			return(false);
		}
		}
	public void Verifyandclicklead() throws Exception
	{
		
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(Elements_Leads.Drptriangle)).click();
		WebElement drpLead =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='slds-dropdown__list slds-show']")));
		Makedelay(drpLead,driver);
		List<WebElement>l=drpLead.findElements(By.xpath("//li[contains(@class,'item has-icon')]//span[@class=' virtualAutocompleteOptionText']"));
		for(WebElement ee:l)
		{
			driver.executeScript("arguments[0].scrollIntoView(true);", ee);
			String x=(String)driver.executeScript("return arguments[0].textContent;", ee);
				x=x.trim();
				if(x.equalsIgnoreCase("Today"))
				{
					ee.click();
					
					break;
					
				}
					
		}
			  
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,ex.getMessage());
			takescreenshot();
		}
		
		
		
	}
	
	
	public void ReadTable() throws Exception
	{
	
		int rc=nl.getRowCount();
		
			for(int i=1;i<=rc;i++)
		{
				WebElement temp=Elements_Leads.wtbody.findElement(By.xpath("child::tr["+i+"]/th/span/a"));
				String value=(String)driver.executeScript("return arguments[0].textContent;",temp);
				if(value.contains(Base.lname))
				{
					driver.executeScript("arguments[0].style.border='3px solid red'",temp);
					WebElement temp2=Elements_Leads.wtbody.findElement(By.xpath("child::tr["+i+"]/td[8]/span/div/a/span/span"));
					temp2.click();
					break ;
				}
				
				
			
		}
		
	}

}
