package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationpage;

public class UserRegistrationTest extends TestBase{

	HomePage homePageObject ;
	UserRegistrationpage registerPageObject ;
	LoginPage loginObject;
	String email = "udemy19@test.com";


	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() 
	{
		homePageObject = new HomePage(driver);
		homePageObject.openRegistrationPage();
		registerPageObject = new UserRegistrationpage(driver);
		registerPageObject.UserRegistration("Mimo", "Nounou", email, "12345678");
		Assert.assertTrue(registerPageObject.successMessage.getText().equals("Your registration completed"));
	}

	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void UseContinueLink() 
	{
		registerPageObject.Continue();
	}

	@Test(dependsOnMethods = {"UseContinueLink"})
	public void UserCanLogin() 
	{
		homePageObject.openLoginpage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, "12345678");
	}
}
