package GenericUtility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFunctions {

	public void webdriverWait(By by , WebDriver driver,int duration )
	{
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
}
