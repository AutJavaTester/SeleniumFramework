package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToWishlistPage extends PageBase {

	public AddToWishlistPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText  ="Apple MacBook Pro 13-inch")
	public WebElement productCell;
	
	@FindBy(linkText = "wishlist")
	WebElement wishlistLink ; 

	@FindBy(css="div.page-title")
	public WebElement wishlistHeader ;
	
	 @FindBy(css="input.qty-input")
	 public WebElement quantityBox ;

	@FindBy(id="updatecart")
	WebElement updateWishlistbtn ;
	
	@FindBy(css="span.product-subtotal")
	public WebElement priceMessage ;

	@FindBy(name ="updatecart")
	WebElement removeFromCartbtn ;

	@FindBy(css="div.no-data")
	public WebElement emptyCartMessage ;


	public void wishlist() 
	{
		clickButton(wishlistLink);
	}
	
	public void updateQuantity() throws InterruptedException 
	{
		clearText(quantityBox);
		SettextElementTxt(quantityBox, "3");
		clickButton(updateWishlistbtn);
		Thread.sleep(2);
	}
	public void RemoveProductFromWishlist() 
	{
		clickButton(removeFromCartbtn);
	}
}
