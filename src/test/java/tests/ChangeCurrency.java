package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.SearchPage;

public class ChangeCurrency extends TestBase{

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage  searchobject ;
	ProductDetailPage detailObject ;
	HomePage homeObject ;
	
	@Test(priority = 1)
	public void UserCanChangeCurrency() 
	{
		homeObject = new HomePage(driver);
		homeObject.ChangeCurrency();
	}
	
	@Test(priority = 2)
	public void UserCanSearchForProduct() 
	{
		searchobject = new SearchPage(driver);
		detailObject = new ProductDetailPage(driver);
		searchobject.ProductSearch(productName);
		//searchobject.OpenProductDetailPage();
		Assert.assertTrue(detailObject.productNameBread.getText().equalsIgnoreCase(productName));
		//Assert.assertEquals(detailObject.productNameBread.getText(),productName);
		Assert.assertTrue(detailObject.productpricelabel.getText().contains("1"));
		System.out.println(detailObject.productpricelabel.getText());
	}
}
