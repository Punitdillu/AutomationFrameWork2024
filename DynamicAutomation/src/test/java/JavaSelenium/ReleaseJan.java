package JavaSelenium;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericFunctions.ContactGenericFunction;
import GenericUtility.BaseClass;
import GenericUtility.ExcelDataUtility;
import GenericUtility.JavaUtility;
@Listeners(GenericUtility.Listneres_Implementation_Class.class)
public class ReleaseJan extends BaseClass {
	
	ContactGenericFunction cgf = new ContactGenericFunction();
	ExcelDataUtility edu = new ExcelDataUtility();
	JavaUtility ju = new JavaUtility();
	@Test(retryAnalyzer = GenericUtility.Retry_Analyzer_Implementation_class.class)
	public  void createContact() throws Throwable 
	{
		int ran=ju.getRandomNum();
		String LastName= edu.getExcelsheetdata("Sheet1", 1, 0)+ran;
		
		cgf.createNewContact(driver,LastName);;

	}
	
	


	
}
