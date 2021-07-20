package siteutilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

public class WebsiteUtility {
	
	public RemoteWebDriver openBrowser(String browsername)
	{
		
		RemoteWebDriver driver;
		if(browsername.equalsIgnoreCase("chrome"))
		{
			ChromeOptions co=new ChromeOptions();
			String[] s=new String[] {"enable-automation"};
			co.setExperimentalOption("excludeSwitches",s);
			co.addArguments("--disable-notifications");
			
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);

			co.setExperimentalOption("prefs", prefs);
			
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(co);
			
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("opera"))
		{
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else 
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		
		return(driver);
		
	}
	
	
	public FluentWait<RemoteWebDriver> defineWait(RemoteWebDriver driver) throws Exception
	{
		String temp1=PropertiesFileUtilities.getValueInPropertiesFile("maxwait");
		int value1=Integer.parseInt(temp1);
		String temp2=PropertiesFileUtilities.getValueInPropertiesFile("interval");
		int value2=Integer.parseInt(temp2);
		FluentWait<RemoteWebDriver> wait =new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(value1));
		wait.pollingEvery(Duration.ofMillis(value2));
		wait.ignoring(NoSuchElementException.class);
		return(wait);
	}
	
	public void launchSite(RemoteWebDriver driver) throws Exception
	{
		String temp=PropertiesFileUtilities.getValueInPropertiesFile("url");
		driver.get(temp);
		driver.manage().window().maximize();
	}
	
	public void launchSiteWithurl(RemoteWebDriver driver,String url) throws Exception
	{
		String temp=url;
		driver.get(temp);
		driver.manage().window().maximize();
	}
	
	
	
	public String captureScreenshot(RemoteWebDriver driver) throws Exception
	{
		SimpleDateFormat sf= new SimpleDateFormat("dd-mmm-yyyy-hh-mm-ss");
		Date dt=new Date();
		String fn=System.getProperty("user.dir")+"\\target\\screenshots\\"+sf.format(dt)+".png";
		File dest=new File(fn);
		File src=driver.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, dest);
		return(dest.getAbsolutePath());
		
		
	}
	public String FullPageScreenshot(RemoteWebDriver driver) throws Exception
	{
		SimpleDateFormat sf= new SimpleDateFormat("dd-mmm-yyyy-hh-mm-ss");
		Date dt=new Date();
		String fn=System.getProperty("user.dir")+"\\target\\screenshots\\"+sf.format(dt)+".png";
		File dest=new File(fn);
		AShot as=new AShot();
		ShootingStrategy shs=ShootingStrategies.viewportPasting(1000);
		Screenshot ss=as.shootingStrategy(shs).takeScreenshot(driver);
		ImageIO.write(ss.getImage(), ".PNG", dest);
		return(dest.getAbsolutePath());
		
		
	}
	public By getByFromWebElement(WebElement e)
	{
		String p[] =e.toString().split("->");
		String q[]=p[1].split(":");
		String locatortype=q[0].trim();
		String LocatorValue=q[1].substring(0,q[1].length()-1).trim();
		By b= null;
		if(locatortype.equals("name"))
		{
			b=By.name(LocatorValue);
		}
		else if(locatortype.equals("id"))
		{
			b=By.id(LocatorValue);
		}
		else if(locatortype.equalsIgnoreCase("classname"))
		{
			b=By.className(LocatorValue);
		}
		else if(locatortype.equalsIgnoreCase("linktext"))
		{
			b=By.linkText(LocatorValue);
		}
		else if(locatortype.equalsIgnoreCase("partial link text"))
		{
			b=By.partialLinkText(LocatorValue);
		}
		else if(locatortype.equalsIgnoreCase("tagname"))
		{
			b=By.tagName(LocatorValue);
		}
		else if(locatortype.equalsIgnoreCase("xpath"))
		{
			b=By.xpath(LocatorValue);
		}
		else if(locatortype.equalsIgnoreCase("cssselector"))
		{
			b=By.cssSelector(LocatorValue);
		}
		return (b);
	}
	
	
	
	public void closeSite(RemoteWebDriver driver)
	{
		driver.close();
	}
}
