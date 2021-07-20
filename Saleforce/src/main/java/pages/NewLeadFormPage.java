package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.Base;
import objectRepository.Elements_Leads;

public class NewLeadFormPage extends Base
{
	
	/*public HomePage(RemoteWebDriver driver,FluentWait<RemoteWebDriver> Wait)
	{
		AjaxElementLocatorFactory af=new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(af, this);
		this.driver=driver;
		this.Wait=Wait;
	}
	*/
	
	public  NewLeadFormPage()
	{
		AjaxElementLocatorFactory af=new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(af, objrep);
		//this.Driver=driver;
		//this.Wait=wait;
	}
	
	public void FillFirstname(String l) throws Exception
	{
		
		try {
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.firstName)).sendKeys(l);
		exttest.log(Status.PASS,"Fill First name  Test Passed ");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Fill First name  Test Fail ");
			takescreenshot();
		}
	}
	
	public void FillLastname(String l) throws Exception
	{
		
		try {
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.lastname)).sendKeys(l);
		lname=l;
		exttest.log(Status.PASS,"Fill Lastname  Test Passed ");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Fill Lastname  Test Fail ");
			takescreenshot();
		}
	}
	public void FillMiddlename(String l) throws Exception
	{
		
		try {
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.middleName)).sendKeys(l);
		exttest.log(Status.PASS,"Fill Middlename  Test Passed ");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Fill Middlename  Test Fail ");
			takescreenshot();
		}
	}
	public void FillWebsite(String l) throws Exception
	{
		
		try {
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.Website)).sendKeys(l);
		exttest.log(Status.PASS,"Website txtbox   Test Passed ");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Website txtbox   Test Fail ");
			takescreenshot();
		}
	}
	public void FillSuffix(String l) throws Exception
	{
	
		try {
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.suffix)).sendKeys(l);
		exttest.log(Status.PASS,"Suffix txtbox   Test Passed ");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Suffix txtbox   Test Fail ");
			takescreenshot();
		}
	}
	public void FillCompany(String l) throws Exception
	{
		
		try {
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.Company)).sendKeys(l);
		exttest.log(Status.PASS,"Company txtbox  Test Pass ");
		}
	catch(Exception ex)
	{
		exttest.log(Status.FAIL,"Company txtbox  Test Fail ");
		takescreenshot();
	}
	}
	public void FillEmail(String l) throws Exception
	{
		
		try {
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.Email)).sendKeys(l);
		exttest.log(Status.PASS,"Email txtbox  Test Pass ");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Email txtbox  Test Fail ");
			takescreenshot();
		}
	}
	public void FillPhonenumber(String l) throws Exception
	{
		
		try {
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.Phone)).sendKeys(l);
		exttest.log(Status.PASS,"Phone txtbox  Test Pass ");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Phone txtbox  Test Fail ");
			takescreenshot();
		}
	}
	public void ClickSavebtn() throws Exception
	{
	
		try {
		wait.until(ExpectedConditions.visibilityOf(Elements_Leads.Savebtn)).click();
		Thread.sleep(1000);
		
		exttest.log(Status.PASS,"Savebtn Test Pass ");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Savebtn  Test Fail ");
			takescreenshot();
		}
	}
	
	public void Selectsalutation(String y) throws Exception
	{
		
		try
		{
		WebElement drpsalutation =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='salutation']//parent::div)/following-sibling::div")));
		driver.executeScript("arguments[0].click();",drpsalutation);
		List<WebElement>l=drpsalutation.findElements(By.xpath("//*[@class='slds-media__body']//*"));
		for(WebElement ee:l)
		{
			driver.executeScript("arguments[0].scrollIntoView(true);", ee);
			String x=(String)driver.executeScript("return arguments[0].textContent;", ee);
				x=x.trim();
				if(x.equalsIgnoreCase(y))
				{
					ee.click();
					exttest.log(Status.PASS,"Salitation  item selected");
					break;
					
				}
					
		}
	}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Salitation  item  Not selected");
			takescreenshot();
		}
				
	}
	
	public void Selectindustry(String y) throws Exception
	{
		
		try
		{
		WebElement drpIndustry =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='slds-combobox_container'])[4]//child::div[2]")));
		driver.executeScript("arguments[0].scrollIntoView(true);", drpIndustry);
		driver.executeScript("arguments[0].click();",drpIndustry);
		List<WebElement>l=drpIndustry.findElements(By.xpath("child::*[contains(@data-value,'')]/following-sibling::*//*[@class='slds-media__body']//*"));
		for(WebElement ee:l)
		{
			driver.executeScript("arguments[0].scrollIntoView(true);", ee);
			String x=(String)driver.executeScript("return arguments[0].textContent;", ee);
				x=x.trim();
				if(x.equalsIgnoreCase(y))
				{
					ee.click();
					exttest.log(Status.PASS,"Industry  item selected");
					break;
					
				}
					
		}
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Industry  item Not selected");
			takescreenshot();
		}
		
		
		
		
	}
	public void SelectLeadsource(String y) throws Exception
	{
		
		try
		{
		WebElement drpLeadsource =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='slds-combobox_container'])[5]//child::div[2]")));
		driver.executeScript("arguments[0].scrollIntoView(true);", drpLeadsource);
		driver.executeScript("arguments[0].click();",drpLeadsource);
		List<WebElement>l=drpLeadsource.findElements(By.xpath("child::*[contains(@data-value,'')]/following-sibling::*//*[@class='slds-media__body']//*"));
		for(WebElement ee:l)
		{
			driver.executeScript("arguments[0].scrollIntoView(true);", ee);
			String x=(String)driver.executeScript("return arguments[0].textContent;", ee);
				x=x.trim();
				if(x.equalsIgnoreCase(y))
				{
					ee.click();
					exttest.log(Status.PASS,"Lead Source item selected");
					break;
					
				}
					
		}
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Lead Source item  Not  selected");
			takescreenshot();
		}
	}
	
	public Boolean isleadsaved() throws Exception
	{
		
		try {
			wait.until(ExpectedConditions.visibilityOf(Elements_Leads.statusfornewlead)).isDisplayed();
			driver.executeScript("arguments[0].style.border='3px solid red'",Elements_Leads.statusfornewlead);
			exttest.log(Status.PASS,"Lead saved ");
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
		//wait.until(ExpectedConditions.visibilityOf(Elements_Leads.Drptriangle)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Elements_Leads.Drptriangle)).click();
		//Thread.sleep(5000);
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
			   	Makedelay(Elements_Leads.fewsecago,driver);
				ReadTable(lname);
				exttest.log(Status.PASS,"find and verify Saved Lead Pass");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,ex.getMessage());
			takescreenshot();
		}
		
		
		
	}
	
	public int getRowCount()
	{
		int value =Elements_Leads.wtbody.findElements(By.xpath("child::tr")).size();
		return(value);
	}
	public int getColumnCount(int rownum)
	{
		int value =Elements_Leads.wtbody.findElements(By.xpath("child::tr["+rownum+"]/td")).size();
		return(value);
		
	}
	

	
	public void ReadTable(String s) throws Exception
	{

		int rc=getRowCount();
		
		for(int i=1;i<=rc;i++)
		{
			
				WebElement temp=Elements_Leads.wtbody.findElement(By.xpath("child::tr["+i+"]/th[1]/span/a"));
				String value=(String)driver.executeScript("return arguments[0].textContent;",temp);
				if(value.contains(s))
				{
					driver.executeScript("arguments[0].style.border='3px solid red'",temp);
					temp.click();
					break ;
				}
				
				
			
		}
		
	}

	
	
}
