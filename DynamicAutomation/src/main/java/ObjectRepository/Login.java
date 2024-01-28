package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import GenericUtility.Findelement;
import GenericUtility.WaitFunctions;


public class Login {

	Findelement ele = new Findelement();
	WaitFunctions wait = new WaitFunctions();
	
	

	private final By userName= By.xpath("//input[@name='user_name']");
	private final By passWord= By.xpath("//input[@name='user_password']");
	private final By loginButton= By.xpath("//input[@id='submitButton']");
	private final By LogOutIcon= By.xpath("//img[@src='themes/softed/images/user.PNG']");
	private final By LogOutButton= By.xpath("//a[text()='Sign Out']");


//Method to log in 
public void  login(WebDriver driver) throws InterruptedException 
{
	driver.manage().window().maximize();
	
	driver.get("http://localhost:8888");
	Thread.sleep(7000);
	
	wait.webdriverWait((userName), driver,30);
	ele.element(driver,userName).sendKeys("admin");
	ele.element(driver,userName).clear();
	ele.element(driver,userName).sendKeys("admin");
	
	wait.webdriverWait((passWord), driver,30);
	ele.element(driver,passWord).sendKeys("root");
	
	wait.webdriverWait((loginButton), driver,30);
	ele.element(driver,loginButton).click();
}

//Method to log out 

public void  Logout(WebDriver driver)
{
	wait.webdriverWait((LogOutIcon), driver,30);
	ele.element(driver,LogOutIcon).click();
	wait.webdriverWait((LogOutButton), driver,30);
	ele.element(driver,LogOutButton).click();
	
	
}

	
	
}
