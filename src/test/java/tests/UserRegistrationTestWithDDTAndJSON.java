package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import data.JSONDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationpage;

public class UserRegistrationTestWithDDTAndJSON extends TestBase{

	HomePage homePageObject ;
	UserRegistrationpage registerPageObject ;
	LoginPage loginObject;


	@Test()
	public void UserCanRegisterSuccessfully() throws FileNotFoundException, IOException, ParseException 
	{
		JSONDataReader jsonReader = new JSONDataReader();
		jsonReader.JsonReader();
		
		homePageObject = new HomePage(driver);
		loginObject = new LoginPage(driver);
		registerPageObject = new UserRegistrationpage(driver);
		homePageObject.openRegistrationPage();
		registerPageObject.UserRegistration(jsonReader. firstname , jsonReader.lastname , jsonReader.email, jsonReader.password);
		registerPageObject.Continue();
		registerPageObject.UserLogin(jsonReader.email , jsonReader.password);
		registerPageObject.UserLogout();
	}
}
