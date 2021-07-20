package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Elements_Logout {
	
	@FindBy(how=How.XPATH,using="//div[@class='profileTrigger branding-user-profile bgimg slds-avatar slds-avatar_profile-image-small circular forceEntityIcon']")
	public static WebElement profilepic;
	@FindBy(how=How.LINK_TEXT,using="Log Out")
	public static WebElement logoutbtn;
	
	@FindBy(how=How.ID,using="Login")
	public static WebElement loginbtn;

}
