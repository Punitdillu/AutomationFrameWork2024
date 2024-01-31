package SelfAutomationScenariosPractice;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRobotClassUses {

	WebDriverUtility wu = new WebDriverUtility();
	@Test
	public void logIntoActiTime() throws AWTException, InterruptedException
	{
		WebDriver driver;
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("http://localhost:8888/");
	    driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	    wu.keyPress(KeyEvent.VK_CONTROL);
	    wu.keyPress(KeyEvent.VK_A);
	    Thread.sleep(5000);
	    wu.keyRelease(KeyEvent.VK_CONTROL);
	    wu.keyRelease(KeyEvent.VK_A);
	    Thread.sleep(5000);
	    wu.keyPress(KeyEvent.VK_DELETE);
	    wu.keyRelease(KeyEvent.VK_DELETE);
	    Thread.sleep(5000);



	}
}
