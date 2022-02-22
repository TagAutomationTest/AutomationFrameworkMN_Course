package tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase
{
	String email;
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 

	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);




		//Usage
		String email=loginObject.generateMailinatorEmail();
		registerObject.userRegistration("Moataz", "Nabil", email, "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
			registerObject.userLogout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, "12345678");
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
	
	//@Test(dependsOnMethods= {"UserCanRegisterSuccssfully"})
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}
	
	//@Test(dependsOnMethods= {"RegisteredUserCanLogout"})
	public void RegisteredUserCanLogin(String email)
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin(email, "12345678");
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}
