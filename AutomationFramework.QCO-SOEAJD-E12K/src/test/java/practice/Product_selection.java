package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Product_selection {
	public static void main(String[] args)throws InterruptedException{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("Sauce Labs Backpack")).click();
}
}