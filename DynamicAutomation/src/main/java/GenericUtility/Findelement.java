package GenericUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ObjectRepository.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Findelement {
	
    
    //Return Webelement
    
	public WebElement element(WebDriver driver , By by)
	{
		WebDriverManager.chromedriver().setup();
		
		WebElement ele = driver.findElement(by);
		return ele;
	}
}
