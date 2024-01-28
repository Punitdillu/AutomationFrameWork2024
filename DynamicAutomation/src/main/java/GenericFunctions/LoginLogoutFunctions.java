package GenericFunctions;

import org.openqa.selenium.WebDriver;

import GenericUtility.WebDriverUtility;
import ObjectRepository.Login;

public class LoginLogoutFunctions {

	WebDriverUtility wD = new WebDriverUtility();
	Login lobj = new Login();
	//Method to log in 
	public void  login(WebDriver driver, String username, String password,String url) throws InterruptedException 
	{
		driver.manage().window().maximize();
		
		driver.get(url);
		
		wD.waitForElementToBeClickable(driver,lobj.userName, 30);
		
		wD.element(driver,lobj.userName).sendKeys(username);
		
		wD.waitForElementToBeClickable(driver,lobj.passWord, 30);
		wD.element(driver,lobj.passWord).sendKeys(password);
		
		wD.waitForElementToBeClickable( driver,lobj.loginButton,30);
		wD.element(driver,lobj.loginButton).click();
	}

	//Method to log out 

	public void  Logout(WebDriver driver)
	{
		wD.waitForElementToBeClickable(driver,(lobj.LogOutIcon), 30);
		wD.element(driver,lobj.LogOutIcon).click();
		wD.waitForElementToBeClickable( driver,(lobj.LogOutButton),30);
		wD.element(driver,lobj.LogOutButton).click();
		
		
	}

}
