package tests;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationpage;

public class UserRegistrationTestWithDDTAndCsv extends TestBase{

	HomePage homePageObject ;
	UserRegistrationpage registerPageObject ;
	LoginPage loginObject;

	CSVReader reader ;


	@Test(alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws CsvValidationException, IOException
	{

		String  CSV_File = System.getProperty("user.dir")+"\\src\\test\\java\\data\\DDT.csv";

		reader = new CSVReader(new FileReader(CSV_File));

		String [] csvCell ;

		while((csvCell  = reader.readNext()) != null)
		{
			String firstname = csvCell[0];
			String lastname = csvCell [1];
			String email = csvCell [2];
			String password = csvCell[3];

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
}

