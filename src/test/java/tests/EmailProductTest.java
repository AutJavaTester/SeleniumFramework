package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.EmailProductPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailPage;
import pages.SearchPage;
import pages.UserRegistrationpage;

public class EmailProductTest extends TestBase{

	HomePage homePageObject ;
	LoginPage loginObject;
	String email = "udemy19@test.com";
	String newPassword = "87654321";
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage  searchobject ;
	ProductDetailPage detailObject ;
	EmailProductPage emailProductobject ;
	String friendemail = "Dadou@test.com";
	String message  = "Nokia Lumia 1020";
	UserRegistrationpage registerPageObject;
	String Password = "12345678";

	
	//1- Search product 
	
	@Test(priority = 1)
	public void UserSearchForProduct() 
	{
		searchobject = new SearchPage(driver);
		searchobject.ProductsearchUsingautoSuggest("mac");
		detailObject = new ProductDetailPage(driver);
		Assert.assertEquals(detailObject.productNameh1.getText(),(productName));
	}
	
	// 3- Email Product
	
	@Test(priority = 2)
	public void UserCanEmailProduct() 
	{
		emailProductobject = new EmailProductPage(driver);
		emailProductobject.emailproduct(friendemail, message);
		Assert.assertTrue(emailProductobject.successEmailMessage.getText().contains("Your message has been sent"));
	}
	
	// 4- Logout
	@Test(priority = 3)
	public void UserCanlogout() 
	{
		emailProductobject.logout();
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://demo.nopcommerce.com/"));
	}
}
