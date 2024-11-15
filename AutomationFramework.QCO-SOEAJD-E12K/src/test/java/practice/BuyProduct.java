package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class BuyProduct {
	public static void main(String[] args)throws InterruptedException{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		  driver.findElement(By.xpath("//button[@id='finish' and @name='finish']")).click();
		
		
		
}
}