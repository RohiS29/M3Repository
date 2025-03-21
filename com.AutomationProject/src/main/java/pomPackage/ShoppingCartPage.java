package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	//Declaration
	@FindBy(xpath="//h1[text()='Shopping cart']/../..//img[@title='Show details for Smartphone']") 
	private WebElement smartPhoneCartProduct;
	
	@FindBy(xpath="//h1[text()='Shopping cart']/../..//img[@title='Show details for Smartphone']/../..//input[@name='removefromcart']")
	private WebElement smartPhoneCheckBox;
	
	@FindBy(name="updatecart")
	private WebElement updateShoppingCartBtton;
	
	@FindBy(name="continueshopping") 
	private WebElement continueShoppingCartButton;
	
	@FindBy(id="termsofservice") 
	private WebElement termOfServiceCheckbox;
	
	@FindBy(id="checkout")
	private WebElement checkboxButton;
	
	//Initialization	
	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	public WebElement getSmartPhoneCartProduct() {
		return smartPhoneCartProduct;
	}

	public WebElement getSmartPhoneCheckBox() {
		return smartPhoneCheckBox;
	}

	public WebElement getUpdateShoppingCartBtton() {
		return updateShoppingCartBtton;
	}

	public WebElement getContinueShoppingCartButton() {
		return continueShoppingCartButton;
	}

	public WebElement getTermOfServiceCheckbox() {
		return termOfServiceCheckbox;
	}

	public WebElement getCheckboxButton() {
		return checkboxButton;
	}

	
	
	
	
}
