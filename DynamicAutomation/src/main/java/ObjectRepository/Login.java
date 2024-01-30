package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;


public class Login {


	WebDriver driver=null;;

	WebDriverUtility wD = new WebDriverUtility();

	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//input[@name='user_name']")
	WebElement userName;
	@FindBy(xpath="//input[@name='user_password']")
	WebElement passWord;
	@FindBy(xpath="//input[@id='submitButton']")
	WebElement loginButton;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	WebElement LogOutIcon;
	@FindBy(xpath="//a[text()='Sign Out']")
	WebElement LogOutButton;
	
	//Method to log in 
	public void  login(WebDriver driver, String username, String password,String url) throws InterruptedException 
	{
		driver.manage().window().maximize();
		
		driver.get(url);
		
		wD.waitForElementToBeVisible(driver,userName, 30);
		
		wD.element(driver,userName).sendKeys(username);
		
		wD.waitForElementToBeVisible(driver,passWord, 30);
		wD.element(driver,passWord).sendKeys(password);
		
		wD.waitForElementToBeVisible( driver,loginButton,30);
		wD.element(driver,loginButton).click();
	}

	//Method to log out 

	public void  Logout(WebDriver driver)
	{
		wD.waitForElementToBeVisible(driver,LogOutIcon, 30);
		wD.element(driver,LogOutIcon).click();
		wD.waitForElementToBeVisible( driver,LogOutButton,30);
		wD.element(driver,LogOutButton).click();
		
		
	}



	
	
}
