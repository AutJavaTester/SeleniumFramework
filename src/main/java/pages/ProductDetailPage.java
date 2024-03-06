package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends PageBase {

	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText  ="Apple MacBook Pro 13-inch")
	public WebElement productNameBread;
	
	@FindBy(css="div.product-name")
	public WebElement productNameh1;
	
	@FindBy(css="span.price.actual-price")
	public WebElement productpricelabel ;
	
	@FindBy(linkText = "Add your review")
	WebElement addReviewLink ; 
	
	@FindBy(id="add-to-wishlist-button-4")
	WebElement addtowishlistLink;
	
	@FindBy(css="button.button-2.add-to-compare-list-button")
	WebElement addtocomparebtn ;

	@FindBy(css="div.product-name")
	public WebElement productNameLenov ;
	
	@FindBy(linkText = "product comparison")
	 WebElement comparePage;
	
	 @FindBy(css="button.button-2.remove-button")
	 WebElement removebtn ;
	 
	 @FindBy(id="add-to-cart-button-4")
	 WebElement addtocartbtn ;
	 
	
	public void OpenAddReviewPage() 
	{
		clickButton(addReviewLink);
	}
	
	public void AddProductToWishlist() 
	{
		clickButton(addtowishlistLink);
	}
	
	public void AddCompareProduct() 
	{
		clickButton(addtocomparebtn);
	}
	
	public void goToComparePage() 
	{
		clickButton(comparePage);
	}
	
	public void removeProduct() 
	{
		clickButton(removebtn);
	}
	
	public void addProductToCart() 
	{
		clickButton(addtocartbtn);
	}
}
