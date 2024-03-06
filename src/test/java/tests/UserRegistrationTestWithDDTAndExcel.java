package tests;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationpage;

public class UserRegistrationTestWithDDTAndExcel extends TestBase{

	HomePage homePageObject ;
	UserRegistrationpage registerPageObject ;
	LoginPage loginObject;
	


	@DataProvider(name ="ExcelData")
	public  Object[][] userRegistrationData() throws IOException
	{
		//get Data  from excel file
		ExcelReader  ExR = new ExcelReader();
		return ExR.getExcelData();
	}
	@Test(dataProvider = "ExcelData")
	public void UserCanRegisterSuccessfully(String firstname, String lastname, String email , String password) 
	{
		homePageObject = new HomePage(driver);
		loginObject = new LoginPage(driver);
		registerPageObject = new UserRegistrationpage(driver);
		homePageObject.openRegistrationPage();
		registerPageObject.UserRegistration(firstname , lastname , email , password);
		registerPageObject.Continue();
		registerPageObject.UserLogin(email,password);
		registerPageObject.UserLogout();
	}
}
