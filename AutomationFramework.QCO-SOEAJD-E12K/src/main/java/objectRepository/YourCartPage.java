package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {

	//Declaration
	
	@FindBy(className = "inventory_item_name" )
	private WebElement productNameLnk;
	
	@FindBy(linkText="Remove" )
	private WebElement removeBtn;
	
	@FindBy(linkText="Checkout" )
	private WebElement checkoutBtn;
	
	//	Initialization
	public YourCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

    //Utilization
	
	public WebElement getProductNameLnk() {
		return productNameLnk;
	}
	public WebElement getRemoveBtn() {
		return removeBtn;
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}
	//Business library
	/**
	 * This method will capture the product title in cart and return to caller
	 * @return
	 */
	public String getProductTitle()
	{
		return productNameLnk.getText();
	}
	/**
	 * This method will click on remove button
	 */
	public void clickOnRemoveButton()
	{
	removeBtn.click();	
	}
	/**
	 * This method will click on checkout button
	 */
	public void clickOncheckoutButton()
	{
		checkoutBtn.click();
	}
	
}
