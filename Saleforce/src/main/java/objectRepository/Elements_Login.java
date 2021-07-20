package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Elements_Login {
	@FindBy(how=How.NAME,using="username")
	public static WebElement uid;
	@FindBy(how=How.NAME,using="pw")
	public static WebElement pwd;
	@FindBy(how=How.ID,using="Login")
	public static WebElement loginbtn;
	
	@FindBy(how=How.XPATH,using="(//*[text()='Home'])[1]")
	public static WebElement Homebtn;

}
