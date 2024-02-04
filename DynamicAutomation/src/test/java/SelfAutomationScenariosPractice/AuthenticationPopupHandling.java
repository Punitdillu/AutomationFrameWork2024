package SelfAutomationScenariosPractice;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopupHandling {

	@Test
	public void popupHandling() throws Throwable 
	{
		WebDriver driver;
	    WebDriverManager.chromedriver().setup();
	   
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	   

	    Thread.sleep(2000);
	    driver.quit();

	   
	}
}
