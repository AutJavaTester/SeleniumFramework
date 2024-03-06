package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationpage;

public class UserRegistrationTestWithDDTAndDataProvider extends TestBase{

	HomePage homePageObject ;
	UserRegistrationpage registerPageObject ;
	LoginPage loginObject;
	
	

	@DataProvider(name="testData")
	public static Object [][] userData()
	{
		return new Object [] [] {
			
			{"hed", "n","379@test.com","123456"},
			{"dod", "doudi","380@test.com","12345678"},
			{"doudi", "doud","381@test.com","1234567"},
			{"doud", "dod","382@test.com","12345670"}
		};
		
	}
	@Test(priority = 1, dataProvider = "testData")
	public void UserCanRegisterSuccessfully(String fstname,String lstname ,String email,String password ) throws InterruptedException 
	{
		homePageObject = new HomePage(driver);
		loginObject = new LoginPage(driver);
		registerPageObject = new UserRegistrationpage(driver);
		homePageObject.openRegistrationPage();
		registerPageObject.UserRegistration(fstname, lstname, email, password);
		registerPageObject.Continue();
		homePageObject.openLoginpage();
		registerPageObject.UserLogin(email, password);
		Thread.sleep(3);
		registerPageObject.UserLogout();
	}
}
	

