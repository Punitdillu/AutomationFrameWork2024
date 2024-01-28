package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtitlity {

	/**
	 * this method used to fetch data from property file
	 * @param key
	 * @return String
	 * @throws Throwable 
	 * @throws IOException
	 */
	
	public String getCommonProperty(String key) throws Throwable  {
		
		FileInputStream fis=new FileInputStream("./src/main/resources/DATA/commonproperty");
		Properties prop=new Properties();
		prop.load(fis);
		String value=prop.getProperty(key);
		
		return value;
		
	}
}
