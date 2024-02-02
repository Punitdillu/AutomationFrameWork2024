package SelfAutomationScenariosPractice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollScenarios {

	@Test
	public void scrollUpAndDown() throws InterruptedException, AWTException
	{
		WebDriver driver;
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("https://www.flipkart.com/");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("Iphone", Keys.ENTER);
	  
	    // By Robot Class
	    
	    Robot r = new Robot();
	    //page down
	    r.keyPress(KeyEvent.VK_PAGE_DOWN);
	    r.keyRelease(KeyEvent.VK_PAGE_DOWN);
	    Thread.sleep(3000);
	    r.keyPress(KeyEvent.VK_PAGE_DOWN);
	    r.keyRelease(KeyEvent.VK_PAGE_DOWN);
	    Thread.sleep(3000);
	    
	    //page down
	    r.keyPress(KeyEvent.VK_PAGE_UP);
	    r.keyRelease(KeyEvent.VK_PAGE_UP);
	    Thread.sleep(3000);
	    r.keyPress(KeyEvent.VK_PAGE_UP);
	    r.keyRelease(KeyEvent.VK_PAGE_UP);
	    Thread.sleep(3000);

	    //By JavaScriptExecutor
	    
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,2000)");
	    Thread.sleep(2000);
	    js.executeScript("window.scrollBy(0,1000)");
	    Thread.sleep(2000);
	    js.executeScript("window.scrollBy(0,-3000)");
	    Thread.sleep(2000);
	    js.executeScript("window.scrollBy(0,2000)");
	    Thread.sleep(2000);
	    driver.quit();

	}
}
