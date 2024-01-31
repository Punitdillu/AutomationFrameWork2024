package SelfAutomationScenariosPractice;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAcionsClassWthRobotClass {
	WebDriverUtility wu = new WebDriverUtility();
	@Test
	public void logIntoActiTime() throws AWTException, InterruptedException
	{
		WebDriver driver;
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("https://www.google.com/");
	    WebElement gmaillink = driver.findElement(By.xpath("//a[@aria-label='Gmail (opens a new tab)']"));
	    Actions act = new Actions(driver);
	    act.contextClick(gmaillink).perform();
	    wu.ThinkTime(10);

	    // open new Tab
	    wu.keyPress(KeyEvent.VK_T);
	    wu.keyRelease(KeyEvent.VK_T);
	    wu.ThinkTime(1);
	    
	    wu.switchToWindow(driver, "Gmail: Private and secure email");
	    String title = driver.getTitle();
	    System.out.println(title);
	 // open new Window
	    wu.keyPress(KeyEvent.VK_W);
	    wu.keyRelease(KeyEvent.VK_W);
	    wu.ThinkTime(5);
     // inspect
	    wu.keyPress(KeyEvent.VK_N);
	    wu.keyRelease(KeyEvent.VK_N);
	    wu.ThinkTime(5);
	 // incognitowindow
	    wu.keyPress(KeyEvent.VK_G);
	    wu.keyRelease(KeyEvent.VK_G);


	}
}
