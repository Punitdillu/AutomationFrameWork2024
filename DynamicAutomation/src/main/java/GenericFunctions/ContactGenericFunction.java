package GenericFunctions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import GenericUtility.WebDriverUtility;
import ObjectRepository.ContactObjects;

public class ContactGenericFunction {

	ContactObjects cb = new ContactObjects();
	WebDriverUtility wu = new WebDriverUtility();
	
	//This method CreateContact
	
	public void createNewContact(WebDriver driver ,String LastName) 
	{
		wu.waitForElementToBeVisible(driver, cb.ContactHeader, 20);
		wu.mouseOverOnElement(driver, cb.ContactHeader);
		wu.element(driver, cb.ContactHeader).click();
		
		wu.waitForElementToBeVisible(driver, cb.ContactNewIcon, 20);
		wu.mouseOverOnElement(driver, cb.ContactNewIcon);
		wu.element(driver, cb.ContactNewIcon).click();
		
		wu.waitForElementToBeVisible(driver, cb.LastName, 20);
		wu.mouseOverOnElement(driver, cb.LastName);
		wu.element(driver, cb.LastName).sendKeys(LastName);
		
		wu.waitForElementToBeVisible(driver, cb.SaveButton, 20);
		wu.mouseOverOnElement(driver, cb.SaveButton);
		wu.element(driver, cb.SaveButton).click();
		
		wu.waitForElementToBeVisible(driver, cb.ContactCreated, 20);
		wu.mouseOverOnElement(driver, cb.ContactCreated);
		
		if(wu.element(driver, cb.ContactCreated).getText().contains(LastName))
		{
			System.out.println("Contact created");
		}
		else
		{
			Assert.fail("Contact not created");

		}
	}
}
