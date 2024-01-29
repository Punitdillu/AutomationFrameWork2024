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
		
		wD.waitForElementToBeVisible(driver,lobj.userName, 30);
		
		wD.element(driver,lobj.userName).sendKeys(username);
		
		wD.waitForElementToBeVisible(driver,lobj.passWord, 30);
		wD.element(driver,lobj.passWord).sendKeys(password);
		
		wD.waitForElementToBeVisible( driver,lobj.loginButton,30);
		wD.element(driver,lobj.loginButton).click();
	}

	//Method to log out 

	public void  Logout(WebDriver driver)
	{
		wD.waitForElementToBeVisible(driver,(lobj.LogOutIcon), 30);
		wD.element(driver,lobj.LogOutIcon).click();
		wD.waitForElementToBeVisible( driver,(lobj.LogOutButton),30);
		wD.element(driver,lobj.LogOutButton).click();
		
		
	}

}
