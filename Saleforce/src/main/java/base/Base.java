package base;



import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import siteutilities.PropertiesFileUtilities;
import siteutilities.WebsiteUtility;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import objectRepository.Elements_Leads;
import objectRepository.Elements_Contacts;
import objectRepository.Elements_Login;
import objectRepository.Elements_Logout;

public class Base 
{
	public static String lname=null;
	public static WebsiteUtility su;
	public static RemoteWebDriver driver;
	public static FluentWait<RemoteWebDriver> wait;
	
	public static ExtentHtmlReporter exthtml;
    public static ExtentTest exttest;
    public static ExtentReports report;
    
    public static Elements_Leads objrep=new Elements_Leads();
    public static Elements_Login objlogin=new Elements_Login();
    public static Elements_Logout objlogout=new Elements_Logout();
    public static Elements_Contacts objcon=new Elements_Contacts();
	
@BeforeSuite
public static void reportintialize() throws Exception
{
	String bn=PropertiesFileUtilities.getValueInPropertiesFile("browsername");
	//String bn=context.getSuite().getName();
	su=new WebsiteUtility();
	driver=su.openBrowser(bn);
	driver.setFileDetector(new LocalFileDetector());
	wait=su.defineWait(driver);
	su.launchSite(driver);
	driver.manage().window().maximize();
	
	
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	   //exthtml = new ExtentHtmlReporter(PropertiesFileUtilities.getValueInPropertiesFile("reportlocation"));
		String Reportspath="target\\Reports_"+bn+".html";
	   exthtml = new ExtentHtmlReporter(Reportspath);
	   report = new ExtentReports();
	   report.attachReporter(exthtml);
	   report.setSystemInfo("Host Name", "ADMIN-PC");  //name of thesystem
	   report.setSystemInfo("Environment", "Test Env");
	   report.setSystemInfo("User Name", "veeresh");
	   
	   exthtml.config().setDocumentTitle("Salesforce");
	   exthtml.config().setReportName("Salesforce Functional Testing");
	   exthtml.config().setTestViewChartLocation(ChartLocation.TOP);
	   exthtml.config().setTheme(Theme.STANDARD);
}



public static void takescreenshot() throws Exception
{
	try {
	String path=su.captureScreenshot(driver);
	exttest.addScreenCaptureFromPath(path);
	}
	catch(Exception e)
	{
		
	}
}

public static void Makedelay(WebElement e,RemoteWebDriver driver) throws Exception
{
	Boolean b=true;
	while(b)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(e)).isDisplayed();
		b=false;
		}
		catch(Exception ex)
		{
			Thread.sleep(1000);
		}
	}
}


@AfterSuite
public static  void CloseDriver()
{
	su.closeSite(driver);
	report.flush();
}	


}
