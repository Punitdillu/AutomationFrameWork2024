package JavaSelenium;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelDataUtility;
import GenericUtility.JavaUtility;
import ObjectRepository.ContactObjects;

@Listeners(GenericUtility.Listneres_Implementation_Class.class)

public class NewJan extends BaseClass {

	
	ExcelDataUtility edu = new ExcelDataUtility();
	JavaUtility ju = new JavaUtility();
	@Test(retryAnalyzer = GenericUtility.Retry_Analyzer_Implementation_class.class)
	public  void createContactgf() throws Throwable 
	{
		ContactObjects co = new ContactObjects(driver);
		int ran=ju.getRandomNum();
		String LastName= edu.getExcelsheetdata("Sheet1", 1, 0)+ran;
		
		co.clickOnContactHeader(driver);
		co.clickOncontactNewIcon(driver);
		co.sendLastName(driver, LastName);
		co.clickOnSaveButton(driver);
		
		

	}

}
