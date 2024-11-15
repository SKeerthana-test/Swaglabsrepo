package practice;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class AddProductToCartAndValidate {
public static void main(String[] args) throws InterruptedException{
	
		//step 1: launch the browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step 2: load the url
		driver.get("https://www.saucedemo.com/");
		
		//step 3: login to application
		driver.findElement(By.xpath("//input[@type='text' and @name='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@type='password' and @name='password']")).sendKeys("secret_sauce");
	    driver.findElement(By.xpath("//input[@type='submit' and @name='login-button']")).click();
	     
	    //step 4: click on a product
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']")).click();
	    String producttitle=driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']")).getText();
	   
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
	    
	 //driver.findElement(By.xpath("//button[@id='checkout' and @name='checkout']")).click();
	    //checkout product
	 //driver.findElement(By.xpath("//input[@id='first-name' and @name='firstName']")).sendKeys("keerthana");
	 //driver.findElement(By.xpath("//input[@id='last-name' and @name='lastName']")).sendKeys("s");
     //driver.findElement(By.xpath("//input[@id='postal-code' and @name='postalCode']")).sendKeys("560066");
     //driver.findElement(By.xpath("//input[@type='submit' and @name='continue']")).click();
       //buy product
     //driver.findElement(By.xpath("//button[@id='finish' and @name='finish']")).click();
        //back to main page
     //driver.findElement(By.xpath("//button[@id='back-to-products' and @name='back-to-products']")).click();
	}
}
