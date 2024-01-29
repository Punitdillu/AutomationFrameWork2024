package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import GenericFunctions.LoginLogoutFunctions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	LoginLogoutFunctions ln = new LoginLogoutFunctions();
	PropertyFileUtitlity pfile = new PropertyFileUtitlity();
	public WebDriver driver=null;
	public static WebDriver sdriver;

	@BeforeSuite
     public void database_connection() {
		
		System.out.println("data base connection ");
	}
	@BeforeTest
     public void executionMode() {
		
		System.out.println("Execution Mode ");
	}
	
	@BeforeClass
    public void LaunchBrowser() throws Throwable {
		String browserName=pfile.getCommonProperty("browser");

		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else {
			throw new Exception("not campatible browser");

		}
		sdriver=driver;
	}
	
	@BeforeMethod
    public void LoginApp() throws Throwable {
		
		String Username = pfile.getCommonProperty("username");
		String Password = pfile.getCommonProperty("password");
		String url= pfile.getCommonProperty("url");
		ln.login(driver,Username,Password,url);
		System.out.println("Login Completed");
	}
	

	@AfterMethod
    public void LogOutApp() {
		ln.Logout(driver);
		System.out.println("Logout Completed");
	}
	
	@AfterClass
    public void CloseBrowser() {
		driver.quit();
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
