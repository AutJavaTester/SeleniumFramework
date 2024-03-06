package tests;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import junit.framework.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationpage;

public class UserRegistrationTestWithJavaFaker extends TestBase{

	HomePage homePageObject ;
	UserRegistrationpage registerPageObject ;
	LoginPage loginObject;
	Faker fakeData = new Faker();
	String firstname = fakeData.name().firstName();
	String lastname = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(6);

	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() 
	{
		homePageObject = new HomePage(driver);
		homePageObject.openRegistrationPage();
		registerPageObject = new UserRegistrationpage(driver);
		registerPageObject.UserRegistration(firstname, lastname,email,password);
		System.out.println("User Data is : " + firstname + " "+ lastname + " " + email + " " + password);
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
	
	@Test(dependsOnMethods =  {"UserCanLogin"})
	public void UserCanLogout() 
	{
		registerPageObject.UserLogout();
	}
}
