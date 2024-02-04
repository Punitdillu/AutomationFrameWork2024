package SelfAutomationScenariosPractice;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadScenario {

	@Test
	public void downloadFile() throws Throwable 
	{
		WebDriver driver;
		String path = "C:\\Users\\Dell\\git\\AutomationFrameWork2024\\DynamicAutomation\\Downloads\\"+"info.txt";
	    WebDriverManager.chromedriver().setup();
	    
	    //delete existing file.
	    File f = new  File(path);
	    boolean bool = f.delete();
	    System.out.println(bool);
	    
	    //Setting Path to folder, where to download
	    ChromeOptions option = new ChromeOptions();
	     HashMap<String, String> pref = new HashMap<String, String>();
	    
	    //Setting directory to download
	    pref.put("download.default_directory", "C:\\Users\\Dell\\git\\AutomationFrameWork2024\\DynamicAutomation\\Downloads");
	    option.setExperimentalOption("prefs", pref);
		
	    
	    driver=new ChromeDriver(option);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("https://demo.automationtesting.in/FileDownload.html");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//textarea[@id='textbox']")).sendKeys("TextFile");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[@id='createTxt']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//a[@id='link-to-download']")).click();

	    Thread.sleep(2000);
	    driver.quit();

	   
	}
}
