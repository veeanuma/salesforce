package siteutilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class OperateElement {
 static WebsiteUtility su=new WebsiteUtility(); ;
	public static void divdropdown(RemoteWebDriver driver,WebElement p,WebElement child,String y)
	{
		driver.executeScript("arguments[0].click();",p);
		
		List<WebElement>l=p.findElements(su.getByFromWebElement(child));
		for(WebElement ee:l)
		{
			driver.executeScript("arguments[0].scrollIntoView(true);", ee);
			String x=(String)driver.executeScript("return arguments[0].textContent;", ee);
				x=x.trim();
				if(x.equalsIgnoreCase(y))
				{
					ee.click();
					break;
					
				}
					
		}	
		
		
	}
	public static List<String>  divdropdownList(RemoteWebDriver driver,WebElement p,WebElement child)
	{
		driver.executeScript("arguments[0].click();",p);
		
		List<WebElement>l=p.findElements(su.getByFromWebElement(child));
		List<String> list = new ArrayList<String>();
		for(WebElement ee:l)
		{
			driver.executeScript("arguments[0].scrollIntoView(true);", ee);
			String x=(String)driver.executeScript("return arguments[0].textContent;", ee);
				x=x.trim();
				list.add(x);
					
		}	
		driver.executeScript("arguments[0].click();",p);
		
		return list;
		
	}

	
	
	public static void divDropDownMultiAdd(RemoteWebDriver driver,WebElement parent,WebElement child,List<String> list) throws Exception
	{
		if(parent.getAttribute("class").contains("multiple"))
		{
			List<WebElement> items=parent.findElements(su.getByFromWebElement(child));
			for(String l:list)
			{
				for(WebElement item:items)
				{
					parent.click();
					Thread.sleep(1000);
					//2.Check for item visibility
					if(item.isDisplayed())
					{
						//3.Remember text of item to be selected
						String expected=item.getText();
						//4.select that item
						if(l.equalsIgnoreCase(expected))
						{
							item.click();
							Thread.sleep(1000);
							break;
						}
						
					
				}
			}
				
			
		}
		
		
		
		
	}
		else
		{
			System.out.println("this is not multi select drop down");
		}
	
	}
	
	

}