package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.ProductDetailPage;
import pages.SearchPage;

public class SearchProductUsingAutosuggestTest
extends TestBase {

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage  searchobject ;
	ProductDetailPage detailObject ;
	
	@Test
	public void UserCanSearchWithAutoSuggest() 
	{
		try {
			
			searchobject = new SearchPage(driver);
			searchobject.ProductsearchUsingautoSuggest("Mac");
			detailObject = new ProductDetailPage(driver);
			Assert.assertEquals(detailObject.productNameBread.getText(),productName);
		} catch (Exception e) {
			System.out.println("Erreur occured "+ e.getMessage());
		}
		
	}

}
