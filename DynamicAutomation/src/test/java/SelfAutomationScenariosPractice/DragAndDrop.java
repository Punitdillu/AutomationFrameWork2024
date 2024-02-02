package SelfAutomationScenariosPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	@Test
	public void dragDrop() throws InterruptedException
	{
		WebDriver driver;
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("https://jqueryui.com/droppable/");
	    Thread.sleep(5000);
	    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
	    
	    WebElement dragEle = driver.findElement(By.xpath("//div[@id='draggable']"));
	    WebElement dropEle = driver.findElement(By.xpath("//div[@id='droppable']"));
	    Actions act= new Actions(driver);
	    //act.dragAndDrop(dragEle, dropEle).build().perform();
	    act.clickAndHold(dragEle).release(dropEle).build().perform();
	    driver.quit();
	}
}
