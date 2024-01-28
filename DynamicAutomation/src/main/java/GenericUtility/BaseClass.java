package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ObjectRepository.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver=null;
	Login ln = new Login();

	@BeforeSuite
     public void database_connection() {
		
		System.out.println("data base connection ");
	}
	@BeforeTest
     public void executionMode() {
		
		System.out.println("Execution Mode ");
	}
	
	@BeforeClass
    public void LaunchBrowser() {
		
		WebDriverManager.firefoxdriver().setup();;
		driver = new FirefoxDriver();
		
		System.out.println("Browser Launched");
	}
	
	@BeforeMethod
    public void LoginApp() throws Throwable {
		
		ln.login(driver);
		System.out.println("Login Completed");
	}
	

	@AfterMethod
    public void LogOutApp() {
		ln.Logout(driver);
		System.out.println("Logout Completed");
	}
	
	@AfterClass
    public void CloseBrowser() {
		driver.close();
		System.out.println("Browser Closed");
	}
	
	@AfterTest
    public void closeexecutionMode() {
		
		System.out.println("Execution Mode Closed");
	}
	
	@AfterSuite
     public void closedatabase_connection() {
		
		System.out.println("data base connection closed");
	}
}
