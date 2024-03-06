package data;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	static FileInputStream fis = null;
	public FileInputStream getFileInputStream()
	{
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\Data\\userData.xlsx";
		File srcFile =new File(filePath);
		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test DAta File not found! check  the filepath of testData");
		}
		return fis;
	}
	public  Object[][] getExcelData() throws IOException
	{
		fis = getFileInputStream();
		XSSFWorkbook workBk = new XSSFWorkbook(fis);
		XSSFSheet sheet = workBk.getSheet("Sheet1");

		int TotalNumberOfRows = (sheet.getLastRowNum()+1) ;
		int TotalNumberOfCols = 4 ;

		String[] [] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols];

		for (int i = 0; i < TotalNumberOfRows; i++) 
		{
			
			for (int j = 0; j < TotalNumberOfCols; j++) {

				XSSFRow  row = sheet.getRow(i);
				
				arrayExcelData[i] [j] = row.getCell(j).toString();
			}
		}

		workBk.close();
		return arrayExcelData;
	}
}
