package tests;

import java.io.File;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.AddProductToCArtPage;
import pages.HomePage;
import pages.ProductCheckoutPage;
import pages.ProductDetailPage;
import pages.SearchPage;
import pages.UserRegistrationpage;

public class ProductCheckoutTest extends TestBase{

	String productName1 = "Apple MacBook Pro 13-inch";

	HomePage homePageObject;
	SearchPage searchobject ;
	ProductDetailPage detailobject ;
	AddProductToCArtPage addtocartobject ;
	ProductCheckoutPage checkoutobject ;
	UserRegistrationpage registerPageObject ;
	Select select ;
	@Test
	public void SearchForProduct() 
	{
		searchobject = new SearchPage(driver);
		detailobject = new ProductDetailPage(driver);
		searchobject.ProductsearchUsingautoSuggest("Mac");
		Assert.assertEquals(detailobject.productNameh1.getText(),productName1);
		detailobject.addProductToCart();
	}

	@Test(dependsOnMethods = {"SearchForProduct"})
	public void UserCanCheckOutProductAsAGuest() throws InterruptedException 
	{
		checkoutobject = new ProductCheckoutPage(driver);
		checkoutobject.productCheckout();
		checkoutobject.checkoutAsAGuest("loulou", "lili", "342@test.com", "Tunis", "Street 1", "2040", "13579246");
	}

	@Test(dependsOnMethods = {"UserCanCheckOutProductAsAGuest"})
	public void UserCanConfirmOrder() 
	{
		checkoutobject = new ProductCheckoutPage(driver);
		checkoutobject.ConfirmOrder();
		Assert.assertEquals(checkoutobject.successOrderMessage.getText(),"ORDER #1042");
	}
	
	@Test(dependsOnMethods = {"UserCanConfirmOrder"})
	public void UserCanDownloadInvoicePdf()
	{
		checkoutobject = new ProductCheckoutPage(driver);
		File file = new File(downloadPath+"//order_1042.pdf");
		checkoutobject.downloadInvoice();
		if (file.exists()) {
			System.out.println("File got successfully downloaded");
		}
		else {
			System.out.println("File is not downloaded");
		}
	}
	
	@Test(dependsOnMethods = {"UserCanDownloadInvoicePdf"})
	public void UserCanPrintOrderInvoice() 
	{
		checkoutobject = new ProductCheckoutPage(driver);
		checkoutobject.orderPrint();
	}
}

