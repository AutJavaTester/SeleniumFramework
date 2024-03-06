package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.CompareProductPage;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.SearchPage;

public class CompareProductTest extends TestBase {

	public String productName1 = "Apple MacBook Pro 13-inch";
	public String productName2 ="Lenovo IdeaCentre 600 All-in-One PC";

	SearchPage searchobject;
	ProductDetailPage detailobject ;
	CompareProductPage compareObject ;
	HomePage homeObject;


	@Test
	public void UserCanCompareProducts()
	{
		searchobject = new SearchPage(driver);
		detailobject = new ProductDetailPage(driver);
		compareObject = new CompareProductPage(driver);

		searchobject.ProductsearchUsingautoSuggest("Mac");
		Assert.assertEquals(detailobject.productNameh1.getText(),productName1);
		detailobject.AddCompareProduct();

		searchobject.ProductsearchUsingautoSuggest("Lenovo IdeaCentre");
		Assert.assertEquals(detailobject.productNameh1.getText(),productName2);
		detailobject.AddCompareProduct();
		
		detailobject.goToComparePage();
		compareObject.compareproduct();
		Assert.assertEquals(compareObject.allCols.size(),12);
	}
	
	@Test(dependsOnMethods = {"UserCanCompareProducts"})
	public void UserCanRemoveProduct() 
	{
		detailobject.removeProduct();
		Assert.assertEquals(compareObject.allCols.size(),14);
	}

	@Test(dependsOnMethods = {"UserCanRemoveProduct"})
	public void UserCanClearCompareList() 
	{
		compareObject.clearCompareList();
	}
}
