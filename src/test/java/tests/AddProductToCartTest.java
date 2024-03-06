package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.AddProductToCArtPage;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.SearchPage;

public class AddProductToCartTest extends TestBase{

	public String productName1 = "Apple MacBook Pro 13-inch";
	public String productName2 ="Lenovo IdeaCentre 600 All-in-One PC";

	SearchPage searchobject ;
	ProductDetailPage detailobject;
	HomePage homeobject ;
	AddProductToCArtPage addtocartobject ;


	@Test
	public void UserCanAddProductToCart() throws InterruptedException 
	{
		searchobject = new SearchPage(driver);
		detailobject = new ProductDetailPage(driver);
		addtocartobject = new AddProductToCArtPage(driver);

		searchobject.ProductsearchUsingautoSuggest("Mac");
		Assert.assertEquals(detailobject.productNameh1.getText(),productName1);
		detailobject.addProductToCart();
	}
	@Test(dependsOnMethods = {"UserCanAddProductToCart"})
	public void UserCanUpdateCartQuantity() throws InterruptedException 
	{

		searchobject = new SearchPage(driver);
		detailobject = new ProductDetailPage(driver);
		addtocartobject = new AddProductToCArtPage(driver);

		searchobject.ProductsearchUsingautoSuggest("Lenovo IdeaCentre");
		Assert.assertEquals(detailobject.productNameh1.getText(),productName2);
		addtocartobject.updateQuantity2();
		Assert.assertEquals(addtocartobject.allCols.size(),22);
	}


	@Test(dependsOnMethods = {"UserCanUpdateCartQuantity"})
	public void UserCanRemoveProduct() 
	{
		searchobject = new SearchPage(driver);
		detailobject = new ProductDetailPage(driver);
		addtocartobject = new AddProductToCArtPage(driver);

		addtocartobject.removeProductFromCart();
		Assert.assertEquals(addtocartobject.allCols.size(),15);
		addtocartobject.removeProductFromCart();
		Assert.assertTrue(addtocartobject.emptycartMessage.getText().contains("Your Shopping Cart is empty!"));
	}
}
