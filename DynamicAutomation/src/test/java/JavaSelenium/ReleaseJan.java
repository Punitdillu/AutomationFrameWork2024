package JavaSelenium;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericFunctions.ContactGenericFunc;
import GenericUtility.BaseClass;
@Listeners(GenericUtility.Listneres_Implementation_Class.class)
public class ReleaseJan extends BaseClass {
	
	
	ContactGenericFunc cG = new ContactGenericFunc();

	
	@Test(retryAnalyzer = GenericUtility.Retry_Analyzer_Implementation_class.class)
	public  void createContactAndValidate() throws Throwable 
	{
		cG.createContact(driver);

	}
	
	


	
}
