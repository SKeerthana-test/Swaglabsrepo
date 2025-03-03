package genericUtilities;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of generic methods related to selenium
 * @author Keerthana S
 */
public class SeleniumUtility {

	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method will add implicitly wait of 10 Seconds
	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver)
	{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will wait for particular element to be visible
	 *@param driver
	 *@param element
	 */
	public void WaitForElementToBeVisible(WebDriver driver,WebElement element)
	
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
	
	}
	/**
	 * This method will wait for particular element to be clickable
	 *@param driver
	 *@param element
	 */
	public void WaitForElementToBeClickable(WebDriver driver,WebElement element)
	
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	
	}
	/**
	 * This method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element,int index)
	{
		
		Select sel=new Select(element);
		sel.selectByIndex(index);
		
	}
	/**
	 *  This method will handle dropdown by value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element,String value)
	{
		
		Select sel=new Select(element);
		sel.selectByValue(value);
		
	}
	/**
	 *  This method will handle dropdown by visibleText
	 * @param visibleText
	 * @param element
	 */
	public void handleDropdown(String visibleText,WebElement element)
	{
		
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method will perform click action
	 * @param driver
	 * @param element
	 */
	public void clickAction(WebDriver driver,WebElement element)
	{
		
		Actions act=new Actions(driver);
		act.click(element).perform();
		
	}
	/**
	 * This method will perform double click action
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
		
	}
	/**
	 * This method will perform mouse overing action
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver,WebElement element)
	{
		
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param source
	 * @param destiny
	 */
	public void dragAndDrop(WebDriver driver,WebElement source,WebElement destiny)
	{
		
		Actions act=new Actions(driver);
		act.dragAndDrop(source, destiny).perform();
	}
	/**
	 * This method will perform right click action
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
		
	}
	/**
	 * This method will perform click and hold action
	 * @param driver
	 * @param element
	 */
	public void clickAndHold(WebDriver driver,WebElement element)
	{
		
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
		
	}
	
	/**
	 * This method will perform scroll to particular web element 
	 * @param driver
	 * @param element
	 */
	public void scrollToElementAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
		
	}
	/**
	 * This method will randomly scroll the page up by 500 units
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-500;", "");
	}
	/**
	 * This method will randomly scroll the page down by 500 units
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500;", "");
	}
	
	/**
	 * This method will scroll to element using javascript executor
	 * @param driver
	 * @param element
	 */
	public void scrollToElementJavaScript(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
		
	}
	/**
	 * This method will handle frame by idOrName
	 * @param driver
	 * @param idOrName
	 */
	public void handleFrame(WebDriver driver,String idOrName)
	{
		driver.switchTo().frame(idOrName);
		
	}
	/**
	 * This method will handle frame by element
	 * @param driver
	 * @param element
	 */
	
	public void handleFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
		
	}
	/**
	 * This method will navigate to immediate parent
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		
		driver.switchTo().parentFrame();
	}
	/**
	 * This method will navigate to immediate main page
	 * @param driver
	 */
	public void switchToMainPage(WebDriver driver)
	{
		
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will take screenshot and return the path
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver,String screenshotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("/Users/jesus/Desktop/eclipse-workspace/AutomationFramework.QCO-SOEAJD-E12K/Screenshots"+ screenshotName +".png");
        Files.copy(src, dst);
        
        return dst.getAbsolutePath();//Extent reports
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
