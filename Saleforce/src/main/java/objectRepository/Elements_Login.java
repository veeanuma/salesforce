package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Elements_Login {
	@FindBy(name="username")
	public static WebElement uid;
	@FindBy(name="pw")
	public static WebElement pwd;
	@FindBy(id="Login")
	public static WebElement loginbtn;
	
	@FindBy(xpath="(//*[text()='Home'])[1]")
	public static WebElement Homebtn;

}
