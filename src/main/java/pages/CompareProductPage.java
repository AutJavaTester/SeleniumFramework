package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareProductPage extends PageBase{

	public CompareProductPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="table.compare-products-table")
	private WebElement comparetable ;

	@FindBy(tagName = "tr")
	public List<WebElement> allRows;

	@FindBy(tagName = "td")
	public List<WebElement> allCols;

	@FindBy(css="a.clear-list")
	private WebElement clearListLink;

	@FindBy(css="div.no-data")
	private WebElement noDataMessage;

	public void compareproduct() 
	{
		//get all rows
		System.out.println(allRows.size());
		//get data from each row
		for(WebElement row : allRows) 
		{
			System.out.println(row.getText()+"\t");
			//get data from all col
			for(WebElement col :allCols) 
			{
				System.out.println(col.getText()+"\t");
			}
		}
	}
	public void clearCompareList() 
	{
		clickButton(clearListLink);
	}

}
