package SelfAutomationScenariosPractice;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFileUsingFireFox {


	@Test
	public void downloadFile() throws Throwable 
	{
		WebDriver driver;

		 WebDriverManager.firefoxdriver().setup();
		 File f = new  File("C:\\Users\\Dell\\git\\AutomationFrameWork2024\\DynamicAutomation\\Downloads\\info.txt");
		 f.delete();
		    //Setting Path to folder, where to download
		    FirefoxOptions option = new FirefoxOptions();
		    FirefoxProfile profile = new FirefoxProfile();
		    
		    //1. Instructing Firefox for Custom download location
		    profile.setPreference("browser.download.folderList", 2);
		    //download.default_directory
		    //browser.download.dir
		    //2. Setting custom download directory
		    profile.setPreference("browser.download.dir", "C:\\Users\\Dell\\git\\AutomationFrameWork2024\\DynamicAutomation\\Downloads");
		   
		    option.setProfile(profile);
	    
	    driver=new FirefoxDriver(option);
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
