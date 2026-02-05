package SelfAutomationScenariosPractice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SahdowRootHandling {
	@Test
	public void shadowRootHandling() throws Throwable 
	{
		
		WebDriver driver;
	    WebDriverManager.chromedriver().setup();
	   
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("https://books-pwakit.appspot.com/");
	    
	    WebElement root = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']"));
	    SearchContext shadowRoot = root.getShadowRoot();
	   	    
	   shadowRoot.findElement(By.cssSelector("app-header>app-toolbar.toolbar-bottom>book-input-decorator>input")).sendKeys("Automation",Keys.ENTER);
	    
	   
	    driver.quit();

	   
	}
}
