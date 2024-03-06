package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.HomePage;

public class HoverTest extends TestBase {
	
	HomePage homeObject ;
	
	
	 @Test
	 public void UserCanSelectHoverMenu() throws InterruptedException 
	 {
		 homeObject = new HomePage(driver);
		 homeObject.SelecNotebooksMenu();
		 Thread.sleep(1);
		 Assert.assertTrue(homeObject.notebookmessage.getText().contains("Notebooks"));
		 
	 }
}
