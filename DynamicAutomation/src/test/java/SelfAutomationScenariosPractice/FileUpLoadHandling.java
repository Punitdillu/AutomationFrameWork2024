package SelfAutomationScenariosPractice;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpLoadHandling {

	@Test
	public void UploadFile() throws Throwable 
	{
		WebDriver driver;
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("https://www.naukri.com/registration/createAccount?othersrcp=23531&wExp=N&utm_source=google&utm_medium=cpc&utm_campaign=Brand&gad_source=1&gclid=Cj0KCQiAn-2tBhDVARIsAGmStVkuqjwGXs01Tb5kil7KxkzRrsXl0tFDDblc_IrBpEPRgLPBGivd5oEaArd0EALw_wcB&gclsrc=aw.ds");
	     Thread.sleep(5000);
	     
	    JavascriptExecutor js =(JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,2000)");
	    
	     Thread.sleep(5000);
	    driver.findElement(By.xpath("//button[@class='uploadResume resman-btn-primary resman-btn-small']")).click();
	    
	     //js.executeScript("arguments[0].click;", UploadButton);
	     
	    Robot rb =new Robot();
	    rb.delay(3000);
	    
	    //*********// Copy the path of File
	    StringSelection str = new StringSelection("C:\\Users\\Dell\\git\\AutomationFrameWork2024\\DynamicAutomation\\src\\main\\resources\\DATA\\Punitupdated_1655993130968_Punit Ranjan.pdf");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	    rb.delay(3000);
	    
	    
	    //*********// Upload the File
	    rb.keyPress(KeyEvent.VK_CONTROL);
	    rb.keyPress(KeyEvent.VK_V);
	    rb.delay(3000);
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	    rb.delay(3000);
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	    rb.delay(8000);
	    driver.quit();
	}
}
