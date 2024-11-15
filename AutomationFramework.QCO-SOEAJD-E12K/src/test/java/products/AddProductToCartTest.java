package products;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.AllProductsPage;
import objectRepository.LoginPage;
import objectRepository.ProductPage;
import objectRepository.YourCartPage;
/* have to give listener for every class*/
@Listeners(genericUtilities.ListenersImplementation.class)
/*Test Class*/
public class AddProductToCartTest extends BaseClass {
@Test(groups ="Smoke")/*Test Method/Test Script*/
public void tc_001_AddSingleProductToCartTest() throws IOException,InterruptedException
	

 {
	    
				//read testdata from excel file
				
				String PRODUCTNAME=eUtil.readDataFromExcelFile("Products",1,2);
				System.out.println(PRODUCTNAME);
				
				
			    //step 4: click on a product
			    Thread.sleep(1000);
			     AllProductsPage app=new  AllProductsPage(driver);
			     String productTitle=app.clickOnProductName(driver,PRODUCTNAME);
			   
			   //step 5: add product to cart
			    ProductPage pp=new ProductPage(driver);
			    pp.clickOnAddToCartButton();
			    //to fail volunterly
			   // Assert.fail();
			    
			    //step 6:navigate to cart
			    pp.clickOnCartButton();
			  
			 
			    //Step 7:capture product details in cart
			    YourCartPage cp=new YourCartPage(driver);
			    String ProductTitleInCart=cp.getProductTitle();
			  
			    
			    //Step 8:validate for product name
			    AssertJUnit.assertEquals(ProductTitleInCart, productTitle);
			    
			 
		
		
		
		
		
		
		
		
	}
}
