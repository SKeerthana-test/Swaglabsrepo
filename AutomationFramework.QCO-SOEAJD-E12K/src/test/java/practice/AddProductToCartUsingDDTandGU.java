package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class AddProductToCartUsingDDTandGU {
public static void main(String[] args)throws InterruptedException, IOException
{
//create object of utility classes	
	ExcelFileUtility eUtil=new 	ExcelFileUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	SeleniumUtility sUtil=new SeleniumUtility();
	 
	//read common data from the property file
			
			String URL=pUtil.readDataFromPropertyFile("url");
			String USERNAME=pUtil.readDataFromPropertyFile("username");
			String PASSWORD=pUtil.readDataFromPropertyFile("password");
			
			//read testdata from excel file
			
			String PRODUCTNAME=eUtil.readDataFromExcelFile("Products",1,2);
			
			//step 1: launch the browser
			ChromeDriver driver=new ChromeDriver();
			sUtil.maximizeWindow(driver);
			sUtil.addImplicitlyWait(driver);
			
			//step 2: load the url
			driver.get(URL);
			
			//step 3: login to application
			//driver.findElement(By.xpath("//input[@type='text' and @name='user-name']")).sendKeys(USERNAME);
			//driver.findElement(By.xpath("//input[@type='password' and @name='password']")).sendKeys(PASSWORD);
		   // driver.findElement(By.xpath("//input[@type='submit' and @name='login-button']")).click();
		    
			LoginPage lp=new LoginPage(driver);
			lp.getUsernameEdt().sendKeys(USERNAME);
			lp.getPasswordEdt().sendKeys(PASSWORD);
			lp.getLoginBtn().click();
			
			
		    //step 4: click on a product
		    Thread.sleep(1000);
		    System.out.println(PRODUCTNAME);
		    driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
		    String producttitle=driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).getText();
		   
		    //step 5: add product to cart
		   driver.findElement(By.xpath("//button[@id='add-to-cart' and @name='add-to-cart']")).click();
		    
		    //step 6:navigate to cart and validate the product
		   driver.findElement(By.className("shopping_cart_link")).click();
		   String Producttitleincart = driver.findElement(By.className("inventory_item_name")).getText();
		   if(Producttitleincart.equalsIgnoreCase(producttitle))
		    {
		    System.out.println("product successfully added in cart")	;
		    System.out.println("pass")	;
		    System.out.println(Producttitleincart)	;
		    }
		    else
		    {
		    	System.out.println("product not added in cart ->fail")	;
		    }
		    
		    //step 7:logout of application
		    driver.findElement(By.id("react-burger-menu-btn")).click();
		    driver.findElement(By.linkText("Logout")).click();
		    System.out.println("logout successful");
	
	
	
	
	
	
	
	
	
}
}
