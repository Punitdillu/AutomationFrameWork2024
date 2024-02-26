package SelfAutomationScenariosPractice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import GenericUtility.ExcelDataUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserNativePopupHandling {

	@Test
	public void popupHandlingBrowserNative() throws Throwable 
	{
		Random ran = new Random();
		int randomnum=ran.nextInt(50000);
		ExcelDataUtility ed = new ExcelDataUtility();
		WebDriver driver;
	    WebDriverManager.chromedriver().setup();
	   ChromeOptions option = new ChromeOptions();
	   option.addArguments("--disable-notifications");
	    driver=new ChromeDriver(option);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("https://www.yatra.com/");
	   ed.getRowCountExcelsheetdata("Sheet1", 1, 3, "Punit Ranjan256"+randomnum);

	    Thread.sleep(5000);
	    driver.quit();

	   
	}
}
