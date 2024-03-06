package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FullName")
	WebElement fullnameTextBox;
	
	@FindBy(id = "Email")
	WebElement emailTextBox ;
	
	@FindBy(id = "Enquiry")
	WebElement enquiryTextBox ;
	
	 @FindBy(name = "send-email")
	 WebElement submitBtn ;
	 
	 @FindBy(css="div.result")
	 public WebElement successMessage ;

	 public void ContactUs(String fullName , String email ,String message)
	 {
		 SettextElementTxt(fullnameTextBox, fullName);
		 SettextElementTxt(emailTextBox, email);
		 SettextElementTxt(enquiryTextBox, message);
		 clickButton(submitBtn);
	 }
}
