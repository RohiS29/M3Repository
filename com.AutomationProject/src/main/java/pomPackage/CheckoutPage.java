package pomPackage;



import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import genericLibrary.BaseTest;
import genericLibrary.Flib;
import genericLibrary.SelectUtility;


public class CheckoutPage extends BaseTest{
	
	
	@FindBy(id = "BillingNewAddress_CountryId") private WebElement BCountry;
	@FindBy(id = "BillingNewAddress_City") private WebElement BCity;
	@FindBy(id = "BillingNewAddress_Address1") private WebElement BAddress1;	
	@FindBy(id = "BillingNewAddress_ZipPostalCode") private WebElement BZipCode;
	@FindBy(id = "BillingNewAddress_PhoneNumber") private WebElement BPhoneNumber;
	@FindBy(id = "billing-address-select") private WebElement BOldAddressDropDown;
	


	@FindBy(xpath = "//input[@onclick='Billing.save()']")
	private WebElement BcontinueButton;	
	
	@FindBy(xpath = "//input[@onclick='Shipping.save()']") 
	private WebElement ShipAddrContinueButton;
	
	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']") 
	private WebElement ShipMethodContinueButton;
	
	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")
	private WebElement PaymentContinueButton;
	
	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")
	private WebElement PaymentInfoContinueButton;
	
	@FindBy(xpath="//input[@onclick='ConfirmOrder.save()']")
	private WebElement ConfirmOrderButtion;
	
	@FindBy(xpath = "//strong[text()='Your order has been successfully processed!']")
	private WebElement OrderProcessText;
	
	
	
	
	
	//Initialization
	public CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Utilization


	public WebElement getBCountry() {
		return BCountry;
	}

	public WebElement getBCity() {
		return BCity;
	}

	public WebElement getBAddress1() {
		return BAddress1;
	}

	public WebElement getBZipCode() {
		return BZipCode;
	}
	public WebElement getBPhoneNumber() {
		return BPhoneNumber;
	}

	public WebElement getBcontinueButton() {
		return BcontinueButton;
	}

	public WebElement getShipAddrContinueButton() {
		return ShipAddrContinueButton;
	}

	public WebElement getShipMethodContinueButton() {
		return ShipMethodContinueButton;
	}

	public WebElement getPaymentContinueButton() {
		return PaymentContinueButton;
	}

	public WebElement getPaymentInfoContinueButton() {
		return PaymentInfoContinueButton;
	}

	public WebElement getConfirmOrderButtion() {
		return ConfirmOrderButtion;
	}

	public WebElement getOrderProcessText() {
		return OrderProcessText;
	}

	public WebElement getBOldAddressDropDown() {
		return BOldAddressDropDown;
	}

	//OperationalMethod OR Business Logic
	
	public void buyProduct() throws EncryptedDocumentException, IOException
	{
		SelectUtility su = new SelectUtility();
		try
		{
			if(BOldAddressDropDown.isDisplayed()==true)
			{
				su.selectByVisisbleTextMethod(BOldAddressDropDown, "New Address");
			}
		}
		catch(Exception e)
		{
			su.selectByVisisbleTextMethod(BCountry, "India");
		}
		su.selectByVisisbleTextMethod(BCountry, "India");
		
		Flib flib = new Flib();
		int rn = flib.randomNumber();						
		String city = flib.readExcelData(EXCEL_PATH_MAIN, BUYPRODUCTDETAILS, 1, 0);
		String address1 = flib.readExcelData(EXCEL_PATH_MAIN, BUYPRODUCTDETAILS, 1, 1);
		long pin = flib.readExcelData1(EXCEL_PATH_MAIN, BUYPRODUCTDETAILS, 1, 2);
		long phone = flib.readExcelData1(EXCEL_PATH_MAIN, BUYPRODUCTDETAILS, 1, 3);
	
		String phoneno = phone+""+rn;
		
		BCity.sendKeys(city);
		BAddress1.sendKeys(address1);
		BZipCode.sendKeys(String.valueOf(pin));
		BPhoneNumber.sendKeys(String.valueOf(phoneno));
		
		BcontinueButton.click();		
		ShipAddrContinueButton.click();		
		ShipMethodContinueButton.click();		
		PaymentContinueButton.click();		
		PaymentInfoContinueButton.click();
		ConfirmOrderButtion.click();
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(OrderProcessText.isDisplayed(), true,"Order is not placed!!!");
		sa.assertAll();
		
	}
	
	
	

}

