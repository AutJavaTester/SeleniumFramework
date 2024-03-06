package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.AddToWishlistPage;
import pages.ProductDetailPage;
import pages.SearchPage;

public class AddToWishlistTest extends TestBase{

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage  searchobject ;
	ProductDetailPage detailObject ;
	AddToWishlistPage wishlistObject ;

	@Test(priority = 1)
	public void UserCanSearchWithAutoSuggest() 
	{
		searchobject = new SearchPage(driver);
		searchobject.ProductsearchUsingautoSuggest("Mac");
	}

	@Test(priority = 2)
	public void UserCanAddProductToWishList() 
	{
		detailObject = new ProductDetailPage(driver);
		detailObject.AddProductToWishlist();
		wishlistObject = new AddToWishlistPage(driver);
		wishlistObject.wishlist();
		Assert.assertTrue(wishlistObject.wishlistHeader.getText().contains("Wishlist"));
		Assert.assertTrue(wishlistObject.productCell.getText().contains("Apple MacBook Pro 13-inch"));
	}

	@Test(priority = 3)
	public void UserCanUpdateQuantity() throws InterruptedException
	{
		wishlistObject = new AddToWishlistPage(driver);
		wishlistObject.updateQuantity();
	}
	
	

	@Test(priority = 4)
	public void UserCanRemoveProductFromWishlist()
	{
		wishlistObject = new AddToWishlistPage(driver);
		wishlistObject.RemoveProductFromWishlist();
		Assert.assertTrue(wishlistObject.emptyCartMessage.getText().contains("wishlist is empty"));
	}
}
