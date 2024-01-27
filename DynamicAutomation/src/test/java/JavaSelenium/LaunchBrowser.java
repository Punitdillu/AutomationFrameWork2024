package JavaSelenium;


import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

import ObjectRepository.ContactObject;
import WebDriverUtility.Findelement;
import WebDriverUtility.WaitFunctions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public  static void main(String args[]) throws InterruptedException
	{
		Findelement ele = new Findelement();
		ContactObject cb = new ContactObject();
		WaitFunctions wait = new WaitFunctions();
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		Thread.sleep(7000);
		wait.webdriverWait((cb.userName), driver,30);
		ele.element(driver,cb.userName).sendKeys("admin");
		Thread.sleep(3000);
		ele.element(driver,cb.userName).clear();
		Thread.sleep(3000);
		ele.element(driver,cb.userName).sendKeys("admin");
		wait.webdriverWait((cb.passWord), driver,30);
		ele.element(driver,cb.passWord).sendKeys("root");
		wait.webdriverWait((cb.loginButton), driver,30);
		ele.element(driver,cb.loginButton).click();
		Thread.sleep(7000);
		Navigation nav = driver.navigate();
		nav.refresh();
		Thread.sleep(5000);
		nav.back();
		Thread.sleep(5000);
		nav.forward();
		Thread.sleep(5000);
          driver.close();

	}
}
