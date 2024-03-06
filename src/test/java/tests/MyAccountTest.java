package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationpage;

public class MyAccountTest extends TestBase{

	HomePage homePageObject ;
	UserRegistrationpage registerPageObject ;
	LoginPage loginObject;
	MyAccountPage myaccountobject ;
	String oldPassword = "12345678";
	String newPassword = "87654321";
	String firstName = "Mimo";
	String lastName = "Nounou";
	String email = "udemy19@test.com";


	
	
	@Test(priority = 2)
	public void RegisteredUserCanChangePassword() 
	{
		registerPageObject = new UserRegistrationpage(driver);
		myaccountobject = new MyAccountPage(driver);
		myaccountobject.MyAccountLink();
		myaccountobject.openChangepasswordpage();
		myaccountobject.ChangePassword(oldPassword, newPassword);
		Assert.assertTrue(myaccountobject.PopupMessage.getText().contains("Password was changed"));
	}

	@Test(priority = 2)
	public void UserCanloginWithNewPassword() 
	{
		myaccountobject = new MyAccountPage(driver);
		myaccountobject.messageDismiss();
		driver.switchTo().defaultContent();
		myaccountobject = new MyAccountPage(driver);
		myaccountobject.UserRelogin(email, newPassword);
		Assert.assertTrue(myaccountobject.logoutLink.isDisplayed());
	}
}

