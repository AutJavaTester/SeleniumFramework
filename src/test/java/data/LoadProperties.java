package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	
	//load the properties file from folder
	
	public static Properties userData = loadpProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\userdata.properties");
	
	private static Properties loadpProperties(String path)
	
	{
		Properties prop = new Properties();
		//stream for reading file
		try {
			FileInputStream stream = new FileInputStream(path);
			try {
				prop .load(stream);
			} catch (IOException e) {
				System .out.println("Error ocuured "+ e.getMessage());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error occured :" + e.getMessage());
		}
		return prop;
	}
	
}
