package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.AllProductsPage;
import objectRepository.LoginPage;

/**This class consists of basic configuration annotation of TestNG
 * @author Keerthana S
 */

public class BaseClass {
	
public ExcelFileUtility eUtil= new	ExcelFileUtility();
public PropertyFileUtility pUtil=new PropertyFileUtility();
public SeleniumUtility sUtil=new  SeleniumUtility();
public ChromeDriver driver;	

/*used for listereners*/
public static ChromeDriver sdriver;	
@BeforeSuite(groups ={"Smoke","Regression"})
public void bsConfig()
{
	System.out.println("......Database connection successful..........");
}
//@Parameters("browser")
//@BeforeTest
@BeforeClass(alwaysRun = true)
public void bcConfig(/*String BROWSER*/) throws IOException
{
	/* FOR CROSS BROWSER EXECUTION*/
	//if(BROWSER.equalsIgnoreCase("Chrome"))
	//{
	//	driver=new ChromeDriver();
		
	//}
	//else if(BROWSER.equalsIgnoreCase("Edge"))
	//{
		//driver=new EdgeDriver();
	//}
	//else
	//{
	//	driver=new ChromeDriver();	
	//}
	String URL=pUtil.readDataFromPropertyFile("url");
	driver=new ChromeDriver();
	sUtil.maximizeWindow(driver);
	sUtil.addImplicitlyWait(driver);
	driver.get(URL);
	System.out.println("....BROWSER LAUNCHED SUCCESSFUL....");
	/*used for listereners*/
	sdriver=driver;
}
@BeforeMethod(alwaysRun = true)
public void bmConfig() throws IOException
{
	String USERNAME=pUtil.readDataFromPropertyFile("username");
	String PASSWORD=pUtil.readDataFromPropertyFile("password");
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	System.out.println("........login to application successful.......");
}
@AfterMethod(alwaysRun = true)
public void amConfig()
{
	AllProductsPage app=new AllProductsPage(driver);
	app.logoutOfApp();
	System.out.println("........logout of application successful.......");
}
//@AfterTest
@AfterClass(alwaysRun = true)
public void acConfig()
{
	driver.quit();
	System.out.println("......BROWSER CLOSURE SUCCESSFUL....");
	
}
@AfterSuite(alwaysRun = true)
public void asConfig()
{
	System.out.println("......Database closure successful.....");
}
}
