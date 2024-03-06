package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
  
	HomePage home;
	ContactUsPage contactpageobject;
	String fullName = "dod Doudi";
	String email = "dod@test.com";
	String message = "Hi Admin , this is for test";
	
	@Test
	public void UserCanUseContactUs() 
	{
		home = new HomePage(driver);
		home.opencontactUsPage();
		contactpageobject = new ContactUsPage(driver);
		contactpageobject.ContactUs(fullName, email, message);
		Assert.assertTrue(contactpageobject.successMessage.getText().equalsIgnoreCase("Your enquiry has been successfully sent to the store owner."));
	}	
}
