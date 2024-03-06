package tests;

import org.testng.annotations.Test;

import data.LoadProperties;
import junit.framework.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationpage;

public class UserRegistrationTestDDTWithPropertiesFile extends TestBase{

	HomePage homePageObject ;
	UserRegistrationpage registerPageObject ;
	LoginPage loginObject;
	String firstname = LoadProperties.userData.getProperty("firstname");
	String lastname = LoadProperties.userData.getProperty("lastname");
	String email = LoadProperties.userData.getProperty("email");
	String password = LoadProperties.userData.getProperty("password");

	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() 
	{
		homePageObject = new HomePage(driver);
		homePageObject.openRegistrationPage();
		registerPageObject = new UserRegistrationpage(driver);
		registerPageObject.UserRegistration(firstname, lastname, email,password);
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
		loginObject.UserLogin(email, password);
	}
}
