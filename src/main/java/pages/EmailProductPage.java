package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailProductPage extends PageBase {

	public EmailProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="button.button-2.email-a-friend-button")
	WebElement emailAFriendBtn;
	
	@FindBy(id="FriendEmail")
	WebElement friendsEmail;
	
	@FindBy(id="PersonalMessage")
	WebElement messageTxt;
	
	@FindBy(name="send-email")
	WebElement sendBtn ;
	
	@FindBy(css="div.result")
	public WebElement successEmailMessage ;
	
	@FindBy(css = "a.ico-logout")
	WebElement logoutBtn ;
	
	public void emailproduct(String friendemail , String message) 
	{
		clickButton(emailAFriendBtn);
		SettextElementTxt(friendsEmail, friendemail);
		SettextElementTxt(messageTxt, message);
		clickButton(sendBtn);
	}
	
	public void logout() 
	{
		clickButton(logoutBtn);
	}
	
	

	

}
