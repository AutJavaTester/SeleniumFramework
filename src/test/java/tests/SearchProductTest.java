package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.ProductDetailPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase {

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage  searchobject ;
	ProductDetailPage detailObject ;

	@Test
	public void UserCanSearchForProduct() 
	{
		searchobject = new SearchPage(driver);
		detailObject = new ProductDetailPage(driver);
		searchobject.ProductSearch(productName);
		searchobject.OpenProductDetailPage();
		Assert.assertEquals(detailObject.productNameh1.getText(),productName);
	}

}
