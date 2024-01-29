package GenericUtility;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	/**
	 * wait for identifying any synchronized element in dom (html- document)
	 * @param driver
	 */
	
	@SuppressWarnings("deprecation")
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * wait for page to load before identifying any asynchronized [java scripts actions] 
	 * element in DOM [HTML-Document]
	 * @param
	 */
	@SuppressWarnings("deprecation")
	public void waitForPageToLoadJSElement(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

	}
	/**
	 * used to wait for element to be clickable in GUI , & check for specific element for 
	 * every 500 milli seconds
	 * @param
	 */
	public void waitForElementToBeVisible(WebDriver driver, By element, int time) {
		
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));

	}
	  /**
     * used to wait for element to be clickable in GUI , & check for specific element for every 500 milli seconds
     * @param driver
     * @param element
     * @param pollingTime in the form second
	 * @throws Throwable 
     */
	public void waitForElementWithCumtomTimeOut(WebDriver driver, WebElement element, int pollingTime) throws Throwable {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		/**wait.pollingEvery(pollingTime, TimeUnit.SECONDS);*/
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	

	/**
	 * this method is used to switch to any window based on window title
	 * @param driver
	 * @param partialWindowTitle
	 */
	
	public void switchToWindow(WebDriver driver,String partialWindowTitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			
			String window_id = it.next();
			driver.switchTo().window(window_id);
			if(driver.getTitle().contains(partialWindowTitle)) 
			{

				break;
			}
	}
	}
	/**
	 * this method used to click on the element present inside the icon on gui
	 * @param driver
	 * @param element
	 */
		public void mouseOverOnElement(WebDriver driver, By element)
		{
			
			Actions act=new Actions(driver);
			act.moveToElement(element(driver, element)).perform();
		}
		public void getmaxSizeWindow(WebDriver driver) {
			driver.manage().window().maximize();
		}
		 /** @param driver
		 * @param elemnet
		 */
		
		public void rightClickOnElement(WebDriver driver , WebElement element)
		{
			Actions act = new Actions(driver);
			act.contextClick(element).perform();
		}
		
		/**
		 * this method id used to execute java script by using javaScript executor
		 * @param driver
		 * @param javaScript
		 */
		public void executeJavaScript(WebDriver driver , String javaScript) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeAsyncScript(javaScript, null);
		}
		
		/**
		 * this method is for customize wait
		 * @param element
		 * @throws InterruptedException
		 */
		   public void waitAndClick(WebElement element) throws InterruptedException
		   {
			   int count = 0;
		       while(count<20) {
			    	   try {
			    	       element.click();
			    	       break;
			    	   }catch(Throwable e){
			    		   Thread.sleep(1000);
			    		   count++;
			    	   }
		       }
		   }
		   /** this method use to take screenshot and store it 
		    * 
		    * @param driver
		    * @param screenshotName
		    * @throws Throwable
		    */
		    public String takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
		    	String dateAndtime=LocalDateTime.now().toString().substring(0, 23).replace(":", "-");
		    	TakesScreenshot ts=(TakesScreenshot)driver;
		    	File src = ts.getScreenshotAs(OutputType.FILE);
		    	File dst=new File("./screenshot/"+screenshotName+dateAndtime+".png");
		    	FileUtils.copyFile(src, dst);
		    	return dst.getAbsolutePath();
		    }
		    
		    /**
		     * pass enter Key appertain in to Browser
		     * @param driver
		     */
		   public void passEnterKey(WebDriver driver) {
			   Actions act = new Actions(driver);
			   act.sendKeys(Keys.ENTER).perform();
		   } 
		   /**
		    * this method use to select the value from dropdown based on index
		    * @param element
		    * @param index
		    */
		   	public void selectWebelement(WebElement element, int index) {
		   		
		   		Select select= new Select(element);
		   		select.selectByIndex(index);
		   		
		   	}
		   	/**
			    * this method use to select the value from dropdown based on value
			    * @param element
			    * @param String
			    */
	public void selectWebelementByvalue(WebElement element, String value) {
		   		
		   		Select select= new Select(element);
		   		select.selectByValue(value);
		   		
		   	}
	/**
	    * this method use to select the value from dropdown based on text
	    * @param element
	    * @param text
	    */
	public void selectWebelementByvisibletext(WebElement element, String text) {
   		
   		Select select= new Select(element);
   		select.selectByVisibleText(text);;
   		
   	}/**
	    * this method use to accept the alert popup
	    * @param driver
	    */
		public void HandleAlertpopupsAccept(WebDriver driver) {
			
			driver.switchTo().alert().accept();
		}
		/**
		    * this method use to deselect the alert popup
		    * @param driver
		    */

		public void HandleAlertpopupsDismiss(WebDriver driver) {
			
			driver.switchTo().alert().dismiss();
		}

		/**
		    * this method use to accept the alert popup
		    * @param driver
		    */
			public WebElement element(WebDriver driver, By by) {
				WebElement ele = driver.findElement(by);
				return ele;
			}
}
