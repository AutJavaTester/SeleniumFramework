package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductCheckoutPage extends PageBase{

	public ProductCheckoutPage(WebDriver driver) {
		super(driver);
	
	}
	@FindBy(id="termsofservice")
	WebElement agreebtn ;

	@FindBy(id="checkout")
	WebElement checkoutbtn ;
	
	@FindBy(css="div.page-title")
	public WebElement tilteMessage  ;
	
	@FindBy(css="button.button-1.checkout-as-guest-button")
	WebElement guestcheckoutbtn ;
	
	@FindBy(id="BillingNewAddress_FirstName")
	WebElement  fistNameTextbox;
	
	@FindBy(id="BillingNewAddress_LastName")
	WebElement lastNameTextbox ;
	
	@FindBy(id="BillingNewAddress_Email")
	WebElement emailTextbox;
	
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement listOfcountries;
	
	@FindBy(id="BillingNewAddress_City")
	WebElement cityTextbox;
	
	@FindBy(linkText ="shopping cart")
	WebElement shoppingcartLink;
	
	 @FindBy(id="BillingNewAddress_City")
	WebElement cityTxtbox;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement adressTextbox;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement zipcodeTextbox;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phonenumberTextbox ;
	
	@FindBy(css="button.button-1.new-address-next-step-button")
	WebElement continuebtn ;
	
	@FindBy(css="label.shippingoption_1")
	WebElement shippingActionbtn ;
	
	@FindBy(css="button.button-1.shipping-method-next-step-button")
	WebElement continueShippingbtn;
	
	@FindBy(id="paymentmethod_0")
	WebElement paymentMethodbtn;
	
	@FindBy(css="button.button-1.payment-method-next-step-button")
	WebElement continuePayementbtn;
	
	@FindBy(css="span.number")
	public WebElement confirmOrderMessage;
	
	@FindBy(css="button.button-1.payment-info-next-step-button")
	WebElement confirmOrderbtn;
	
	@FindBy(css="button.button-1.confirm-order-next-step-button")
	WebElement confirmbtn ;
	
	@FindBy(css="div.order-number")
    public WebElement successOrderMessage;
	
	@FindBy(linkText = "Click here for order details.")
	WebElement orderdetailslink;
	
	@FindBy(linkText ="Print")
	WebElement printbtn ;
	
	@FindBy(css="cr-button.action-button")
	WebElement printerbtn ;
	
	@FindBy(css="div.container")
	WindowType printWindow;
	
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[1]/a[2]")
	WebElement downloadInvoicepdfLink;
	
	public void productCheckout() 
	{
		clickButton(shoppingcartLink);
		clickButton(agreebtn);
		clickButton(checkoutbtn);
	}
	
	public void checkoutAsAGuest(String firstName , String lastName, String email,String city,String adress,String codePostal,String phoneNumber) throws InterruptedException 
	{
		clickButton(guestcheckoutbtn);
		SettextElementTxt(fistNameTextbox, firstName);
		SettextElementTxt(lastNameTextbox, lastName);
		SettextElementTxt(emailTextbox, email);
		clickButton(listOfcountries);
		Select select = new Select((listOfcountries));
		select.selectByVisibleText("Tunisia");
		SettextElementTxt(cityTextbox, city);
		SettextElementTxt(adressTextbox, adress);
		SettextElementTxt(zipcodeTextbox, codePostal);
		SettextElementTxt(phonenumberTextbox, phoneNumber);
		clickButton(continuebtn);
		clickButton(continueShippingbtn);
		clickButton(continuePayementbtn);
	}
	
	public void ConfirmOrder() 
	{
		clickButton(confirmOrderbtn);
		clickButton(confirmbtn);
		clickButton(orderdetailslink);
	}
	
	public void downloadInvoice() 
	{
		clickButton(downloadInvoicepdfLink);
	}
	
	public void orderPrint() 
	{
		
		clickButton(printbtn);
	}

}