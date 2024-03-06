package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.AddProductReviewPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailPage;
import pages.SearchPage;

public class AddProductReviewTest extends TestBase {

	HomePage homePageObject ;
	LoginPage loginObject;
	String email ="udemy19@test.com";
	String newPassword = "87654321";
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage  searchobject ;
	ProductDetailPage detailObject ;
	AddProductReviewPage reviewObject ;
	
		
		//1- Search product 
		
		@Test(priority = 1)
		public void UserSearchForProduct() 
		{
			searchobject = new SearchPage(driver);
			searchobject.ProductsearchUsingautoSuggest("Mac");
			detailObject = new ProductDetailPage(driver);
			Assert.assertEquals(detailObject.productNameh1.getText(),(productName));
		}
		
		// 3- Add product review
		@Test(priority = 2)
		public void UserCanAddReview() 
		{
			detailObject = new ProductDetailPage(driver);
			detailObject.OpenAddReviewPage();
			reviewObject = new AddProductReviewPage(driver);
			reviewObject.Addproductreview("Review Title", "Review Message");
			Assert.assertTrue(reviewObject.successReviewMessage.getText().contains("Product review is successfully added"));
			System.out.println("The success review message was : "+reviewObject.successReviewMessage.getText());
		}
		
}
