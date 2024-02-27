package GenericFunctions;

import org.openqa.selenium.WebDriver;

import GenericUtility.BaseClass;
import GenericUtility.ExcelDataUtility;
import GenericUtility.JavaUtility;
import ObjectRepository.ContactObjects;

public class ContactGenericFunc extends BaseClass{

	ExcelDataUtility edu = new ExcelDataUtility();
	JavaUtility ju = new JavaUtility();
	
	
	public  void createContact(WebDriver driver) throws Throwable 
	{
		ContactObjects co = new ContactObjects(driver);
		int ran=ju.getRandomNum();
		String LastName= edu.getExcelsheetdata("Sheet1", 1, 0) + ran;
		co.clickOnContactHeader(driver);
		co.clickOncontactNewIcon(driver);
		co.sendLastName(driver, LastName);
		co.clickOnSaveButton(driver);
		co.verfyContactCreated(driver, LastName);
		

	}
}
