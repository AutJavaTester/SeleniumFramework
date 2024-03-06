package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductReviewPage extends PageBase{

	public AddProductReviewPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(css="input.review-title")
	WebElement reviewTitleBox;

	@FindBy(css="textarea.review-text")
	WebElement reviewTextBox ;
	
	@FindBy(id="addproductrating_4")
	WebElement ratingRadioBtn ;
	
	@FindBy(name="add-review")
	WebElement submitReviwBtn;
	
	@FindBy(css="div.result")
	public WebElement successReviewMessage ;
	
	public void Addproductreview(String reviewTitle , String reviewMessage) 
	{
		SettextElementTxt(reviewTitleBox, reviewTitle);
		SettextElementTxt(reviewTextBox, reviewMessage);
		clickButton(ratingRadioBtn);
		clickButton(submitReviwBtn);
	}
}
