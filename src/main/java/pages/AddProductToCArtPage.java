package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductToCArtPage extends PageBase{

	public AddProductToCArtPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="span.cart-label")
	WebElement shoppingcartLink;
	
	@FindBy(id="product_enteredQuantity_3")
	WebElement addquantitybeforetextbox;
	
	@FindBy(id="add-to-cart-button-3")
	WebElement addtocartbtn ;
	
	@FindBy(css="span.close")
	WebElement closeCartShoppingMessage ;
	
	@FindBy(css="span.product-subtotal")
	public WebElement totalprice;
	
	@FindBy(css="a.product-name")
	public WebElement macproductName;
	
	@FindBy(css="table.cart")
	public List<WebElement> cartTable;
	
	@FindBy(tagName = "tr")
	public List<WebElement> allRows ;
	
	@FindBy(tagName = "td")
	public List<WebElement> allCols ;
	
	@FindBy(id="itemquantity11244")
	WebElement quantitytextbox ;
	
	@FindBy(linkText = "shopping cart")
	WebElement shoppingcardbtn ;
	
	@FindBy(id="updatecart")
	WebElement updatecartbtn;
	
	 @FindBy(css="button.remove-btn")
	 WebElement removeproductbtn;
	 
	 @FindBy(css="div.no-data")
	 public WebElement emptycartMessage;
	 
	 public void openShoppingCartLink() 
	 {
		 clickButton(shoppingcartLink);
	 }
	 
	 public void  updateProductQuantity() 
	 {
		 clearText(quantitytextbox);
		 SettextElementTxt(quantitytextbox, "3");
		 clickButton(updatecartbtn);
	 }

	 
	 
	 public void updateQuantity2() 
	 {
		 clearText(addquantitybeforetextbox);
		 SettextElementTxt(addquantitybeforetextbox, "6");
		 clickButton(addtocartbtn);
		 clickButton(shoppingcardbtn);
	 }
	 public void removeProductFromCart() 
	 {
		 clickButton(removeproductbtn);
	 }
}
