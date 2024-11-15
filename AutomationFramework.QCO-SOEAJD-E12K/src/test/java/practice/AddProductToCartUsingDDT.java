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
public class AddProductToCartUsingDDT {
	public static void main(String[] args) throws InterruptedException, IOException{
		
		//read common data from the property file
		FileInputStream fisp= new FileInputStream("/Users/jesus/Desktop/eclipse-workspace/AutomationFramework.QCO-SOEAJD-E12K/src/test/resources/CommonData.properties");
		Properties p=new Properties();
		p.load(fisp);
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		
		//read testdata from excel file
		FileInputStream fise= new FileInputStream("/Users/jesus/Desktop/eclipse-workspace/AutomationFramework.QCO-SOEAJD-E12K/src/test/resources/Testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fise);
		Sheet sh=wb.getSheet("Products");
		Row rw=sh.getRow(1);
		Cell cl=rw.getCell(2);
		String PRODUCTNAME=cl.getStringCellValue();
		
		//step 1: launch the browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step 2: load the url
		driver.get(URL);
		
		//step 3: login to application
		driver.findElement(By.xpath("//input[@type='text' and @name='user-name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@type='password' and @name='password']")).sendKeys(PASSWORD);
	    driver.findElement(By.xpath("//input[@type='submit' and @name='login-button']")).click();
	     
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