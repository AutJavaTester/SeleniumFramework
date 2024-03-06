package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.HomePage;
import pages.UserRegistrationpage;
import tests.TestBase;

public class UserRegistration extends TestBase{

	HomePage homeObject;
	UserRegistrationpage registerobject;
	
	@Given("^the user is on the home page$")
	public void the_user_is_on_the_home_page(){
		
		
		homeObject = new HomePage(driver );
		homeObject.openRegistrationPage();
	}
	
	@When("^he clicks on register link$")
	public void he_clicks_on_register_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	
	@When("^he enters the user data$")
	public void he_enters_the_user_data() {
		registerobject = new UserRegistrationpage(driver);
		registerobject.UserRegistration("hedi", "naili", "123@test.com", "12345678");
	}
	
	@Then("^the registration page is displayed successfully$")
	public void the_registration_page_is_displayed_successfully() {
		registerobject.UserLogout();
	}
	
}
