package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(id = "Email")
	WebElement usernameTxt;

	@FindBy(id = "Password")
	WebElement passwordTxt;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")
	WebElement loginbtn;

	@FindBy(css = "a.ico-logout")
	WebElement logoutBtn ;


	public void openloginPage() 
	{
		clickButton(loginbtn);
	}


	public void UserLogin(String username,String password) 
	{
		SettextElementTxt(usernameTxt, username);
		SettextElementTxt(passwordTxt, password);
		clickButton(loginbtn);
	}

	public void UserLogout() 
	{
		clickButton(logoutBtn);	
	}
}
