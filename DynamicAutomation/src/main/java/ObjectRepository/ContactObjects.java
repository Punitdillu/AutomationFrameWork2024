package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import GenericUtility.WebDriverUtility;

public class ContactObjects {

	WebDriver driver= null;
	WebDriverUtility wu = new WebDriverUtility();

	public  ContactObjects(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	private WebElement contactHeader;
	
	public WebElement getContactHeader() {
		return contactHeader;
	}
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement contactNewIcon;
	
	public WebElement getContactNewIcon() {
		return contactNewIcon;
	}
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastName;
	
	public WebElement getLastName() {
		return lastName;
	}
	@FindBy(xpath="(//td[text()=' Contact Information']/parent::tr/../../../../following-sibling::tr/descendant::input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactCreated;
	
	public WebElement getContactCreated() {
		return contactCreated;
	}
	
	//****Business logic****//
	
	public void clickOnContactHeader(WebDriver driver) {
		wu.waitForElementToBeVisible(driver, contactHeader, 20);
		wu.mouseOverOnElement(driver, contactHeader);
		contactHeader.click();
	}
	
    public void clickOncontactNewIcon(WebDriver driver) {
    	wu.waitForElementToBeVisible(driver, contactNewIcon, 20);
		wu.mouseOverOnElement(driver, contactNewIcon);
    	contactNewIcon.click();
	}
    
    public void sendLastName(WebDriver driver,String Lastname) {
    	wu.waitForElementToBeVisible(driver, lastName, 20);
		wu.mouseOverOnElement(driver, lastName);
		lastName.sendKeys(Lastname);;
	}
    
    public void clickOnSaveButton(WebDriver driver) {
    	wu.waitForElementToBeVisible(driver, saveButton, 20);
		wu.mouseOverOnElement(driver, saveButton);
		saveButton.click();
	}
    
    public void verfyContactCreated(WebDriver driver, String LastNameVal) {
    	wu.waitForElementToBeVisible(driver, contactCreated, 20);
    	if(wu.element(driver, contactCreated).getText().contains(LastNameVal))
    		{
    			System.out.println("Contact created");
    		}
    		else
    		{
    			Assert.fail("Contact not created");
    
    		}
	}
	

}
