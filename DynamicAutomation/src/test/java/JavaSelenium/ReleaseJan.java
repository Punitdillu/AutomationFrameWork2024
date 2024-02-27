package JavaSelenium;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericFunctions.ContactGenericFunc;
import GenericUtility.BaseClass;
@Listeners(GenericUtility.Listneres_Implementation_Class.class)
public class ReleaseJan extends BaseClass {
	
	
	ContactGenericFunc cG = new ContactGenericFunc();

	
	@Test(retryAnalyzer = GenericUtility.Retry_Analyzer_Implementation_class.class, priority = 1, invocationCount = 3, groups = {"regression"})
	public  void firstcreateContactAndValidate() throws Throwable 
	{
		System.out.println("firstcreateContactAndValidate Started");
		cG.createContact(driver);

	}
	
	@Test(retryAnalyzer = GenericUtility.Retry_Analyzer_Implementation_class.class, priority = 2, groups = {"regression"})
	public  void secondContactAndValidate() throws Throwable 
	{
		System.out.println("secondContactAndValidate Started");
		cG.createContact(driver);

	}
	
	
	@Test(retryAnalyzer = GenericUtility.Retry_Analyzer_Implementation_class.class, priority = 3, groups = {"regression"})
	public  void thirdContactAndValidate() throws Throwable 
	{
		System.out.println("thirdContactAndValidate Started");
		cG.createContact(driver);

	}
	
	


	
}
