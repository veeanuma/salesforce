package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import com.aventstack.extentreports.Status;

import base.Base;
import objectRepository.Elements_Logout;

public class LogoutPage extends Base
{
	public  LogoutPage ()
	{
		
		AjaxElementLocatorFactory af=new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(af, objlogout);
		//this.Driver=driver;
		//this.Wait=wait;
	}

	
	public Boolean clickprofilepic() throws Exception
	{
		exttest=report.createTest("Logout Page Test");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Logout.profilepic)).click();
			
			exttest.log(Status.PASS,"Profile pic test pass");
			return(true);
			}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Profile pic test failed");
			takescreenshot();
			return(false);
		}
	}
	
	public Boolean clicklogouttbtn() throws Exception
	{
	
		try {
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Logout.logoutbtn)).click();
			exttest.log(Status.PASS,"logout btn test pass");
			return(true);
			}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"logout btn failed");
			takescreenshot();
			return(false);
		}
	}
	
	public Boolean isLoginpageDisplyed() throws Exception
	{
		//Thread.sleep(5000);
		
		try {
			wait.until(ExpectedConditions.visibilityOf(Elements_Logout.loginbtn));
			exttest.log(Status.PASS,"Login Page Displayed");
			return(true);
			}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Login Page  Not Displayed");
			takescreenshot();
			return(false);
		}
	}
	

}
