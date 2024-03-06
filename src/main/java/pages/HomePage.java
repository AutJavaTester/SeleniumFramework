package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) 
	{		super(driver);

	jse = (JavascriptExecutor) driver ;
	action = new Actions(driver) ;
	}

	@FindBy(linkText = "Computers")
	WebElement computerMenuLink ;

	@FindBy(linkText = "Notebooks")
	WebElement notebooksMenuLink ;

	@FindBy( css = "div.page-title")
	public WebElement notebookmessage ;

	@FindBy(id="customerCurrency")
	WebElement currencyDropDownList;

	@FindBy(linkText = "Register")
	WebElement registerLink;

	@FindBy(linkText = "Log in")
	WebElement loginLink;

	@FindBy(linkText = "Contact us")
	WebElement contactUsLink ;


	public void openRegistrationPage() 
	{
		clickButton(registerLink);
	}

	public void openLoginpage() 
	{
		clickButton(loginLink);
	}

	public void opencontactUsPage() 
	{
		ScrollToBottom();
		clickButton(contactUsLink);
	}

	public void ChangeCurrency() 
	{
		select = new Select(currencyDropDownList);
		select.selectByVisibleText("Euro");
	}

	public void SelecNotebooksMenu() 

	{
		action.moveToElement(computerMenuLink).build().perform();
		action.moveToElement(notebooksMenuLink).click().build().perform();
	}


}
