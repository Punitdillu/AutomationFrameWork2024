package JavaSelenium;


import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericFunctions.ContactGenericFunc;
import GenericUtility.BaseClass;
import GenericUtility.ExcelDataUtility;
import GenericUtility.JavaUtility;
import ObjectRepository.ContactObjects;
@Listeners(GenericUtility.Listneres_Implementation_Class.class)
public class CreateContactWithDataproviderTest extends BaseClass {
	
	
	ContactGenericFunc cG = new ContactGenericFunc();
	ExcelDataUtility edu = new ExcelDataUtility();
	JavaUtility ju = new JavaUtility();
	
	@Test(dataProvider = "dataProvider", groups = {"sanity"})
	public  void createContactWithDifferentSetsOfData(String FirstName, String LastName ) throws Throwable 
	{
		Random ran = new Random();
		ran.nextInt(100000);
		ContactObjects co = new ContactObjects(driver);
		
		co.clickOnContactHeader(driver);
		co.clickOncontactNewIcon(driver);
		co.sendFirstName(driver, FirstName);
		co.sendLastName(driver, LastName+ran);
		co.clickOnSaveButton(driver);
		co.verfyContactCreated(driver, LastName+ran);

	}
	@DataProvider
	public Object[][] dataProvider()
	{
		Object[][] obArr =new Object[3][2];
		
		obArr[0][0] = "Ramesh";
		obArr[0][1] = "Singh";
		
		obArr[1][0] = "Mahesh";
		obArr[1][1] = "Singh";
		
		obArr[2][0] = "Suresh";
		obArr[2][1] = "Singh";
		
		return obArr;
	}
	
	
	
	


	
}
