package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class CheckoutProduct {
	public static void main(String[] args)throws InterruptedException{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		 driver.findElement(By.xpath("//input[@id='first-name' and @name='firstName']")).sendKeys("keerthana");
		    driver.findElement(By.xpath("//input[@id='last-name' and @name='lastName']")).sendKeys("s");
	        driver.findElement(By.xpath("//input[@id='postal-code' and @name='postalCode']")).sendKeys("560066");
	        driver.findElement(By.xpath("//input[@type='submit' and @name='continue']")).click();
		
}}
