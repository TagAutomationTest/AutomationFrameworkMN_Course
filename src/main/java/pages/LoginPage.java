package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.UUID;
public class LoginPage extends PageBase
{
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="Email")
	WebElement emailTxtBox ; 

	@FindBy(id="Password")
	WebElement passwordTxtBox ; 
//$(".button-1.login-button");
	@FindBy(css=".button-1.login-button")
	WebElement loginBtn ; 
	
	public void UserLogin(String email , String password) 
	{
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		clickButton(loginBtn);
	}
	public static String getUniqueId() {
		return String.format("%s_%s", UUID.randomUUID().toString().substring(0, 5), System.currentTimeMillis() / 1000);
	}
	public static String generateMailinatorEmail() {
		return String.format("%s@%s", getUniqueId(), "yourHostName.com");
	}
}
