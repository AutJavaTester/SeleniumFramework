package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "My account")
	WebElement myaccountLink;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[7]/a")
	WebElement changepasswordLink;

	@FindBy(id = "OldPassword")
	WebElement oldpasswordTxt;

	@FindBy(id = "NewPassword")
	WebElement newpasswordTxt;

	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmpasswordTxt;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/button")
	WebElement changepasswordBtn ;
	
	@FindBy(css = "p.content")
	public WebElement PopupMessage;

	@FindBy(css = "span.close")
	public WebElement successMessage;

	@FindBy(linkText = "Log out")
	public WebElement logoutLink;
	
	@FindBy(linkText = "Customer info")
	WebElement gotoLoginPage;

	@FindBy(css  = "a.ico-login")
	WebElement LoginLink;

	@FindBy(id = "Email")
	WebElement emailTxt;

	@FindBy(id = "Password")
	WebElement passwordTxt;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")
	WebElement LoginBtn ;

	public void MyAccountLink() 
	{
		clickButton(myaccountLink);
	}


	public void openChangepasswordpage() 
	{
		clickButton(changepasswordLink);
	}

	public void ChangePassword(String oldPassword,String newPassword) 
	{
		SettextElementTxt(oldpasswordTxt, oldPassword);
		SettextElementTxt(newpasswordTxt, newPassword);
		SettextElementTxt(confirmpasswordTxt, newPassword);
		clickButton(changepasswordBtn);
	}

	public void messageDismiss() 
	{
		clickButton(successMessage);

	}

	public void UserRelogin(String email, String newPassword) 
	{
		clickButton(gotoLoginPage);
		SettextElementTxt(emailTxt, email);
		SettextElementTxt(passwordTxt, newPassword);
		clickButton(LoginBtn);
	}
}
