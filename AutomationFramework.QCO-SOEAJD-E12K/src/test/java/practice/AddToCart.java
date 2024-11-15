package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class AddToCart {
	public static void main(String[] args)throws InterruptedException{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='add-to-cart' and @name='add-to-cart']")).click();
}}
