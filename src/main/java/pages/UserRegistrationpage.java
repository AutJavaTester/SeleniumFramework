package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationpage extends  PageBase{

	public UserRegistrationpage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(id = "gender-male")
	WebElement genderbtn ;

	@FindBy(id = "FirstName")
	WebElement fstNameTxt ;

	@FindBy(id = "LastName")
	WebElement lstNameTxt ;

	@FindBy(id = "Email")
	WebElement emailTxt ;

	@FindBy(id = "Password")
	WebElement passwordTxt ;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmpasswordTxt ;

	@FindBy(id = "register-button")
	WebElement registerBtn ;

	@FindBy(css = "div.result")
	public WebElement successMessage ;

	@FindBy(linkText = "CONTINUE")
	WebElement continueLink;

	@FindBy(linkText = "My account")
	WebElement myaccountLink;
	
	@FindBy(css="a.ico-login")
	WebElement loginlink ;
	
	@FindBy(css="a.ico-logout")
	WebElement logoutbtn ;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")
	WebElement loginbtn;
	
	

	public void UserRegistration(String firstName ,String lastName , String email, String password) 
	{
		clickButton(genderbtn);
		SettextElementTxt(fstNameTxt,firstName);
		SettextElementTxt(lstNameTxt, lastName);
		SettextElementTxt(emailTxt, email);
		SettextElementTxt(passwordTxt, password);
		SettextElementTxt(confirmpasswordTxt, password);
		clickButton(registerBtn);
	}
	
	public void Continue () 
	{
		
		clickButton(continueLink);
	}

	public void UserLogin(String email, String password) 
	{
		clickButton(loginlink);
		SettextElementTxt(emailTxt, email);
		SettextElementTxt(passwordTxt, password);
		clickButton(loginbtn);
	}
	
	public void UserLogout() 
	{
		clickButton(logoutbtn);
	}
	
	public void openMyAccountPage() 
	{
		clickButton(myaccountLink);
	}
}
