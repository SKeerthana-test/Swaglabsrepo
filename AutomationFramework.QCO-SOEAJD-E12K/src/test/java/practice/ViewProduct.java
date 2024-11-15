package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class ViewProduct {
	public static void main(String[] args)throws InterruptedException{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		 driver.findElement(By.className("shopping_cart_link")).click();
		    driver.findElement(By.xpath("//button[@id='checkout' and @name='checkout']")).click();
		
}
}