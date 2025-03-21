package testPackage;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseTest;
import pomPackage.ElectronicsPage;
import pomPackage.ShoppingCartPage;
import pomPackage.WelcomePage;
@Listeners(genericLibrary.MyListener.class)
public class TC_AddToCart_001_Test extends BaseTest{
  @Test
  public void TC_addToCart_001_Test() throws IOException {
		
		
		WelcomePage wp = new WelcomePage(driver);
		wp.getElectronicslink().click();
		
		ElectronicsPage ep = new ElectronicsPage(driver);
		ep.getCellPhoneLink().click();
		
		ep.getSmartphoneAddToCart().click();
		
		wp.getShoppingcartlink().click();
		
		ShoppingCartPage sp=new ShoppingCartPage(driver);
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(sp.getSmartPhoneCartProduct().isDisplayed(), true, "Product is not added to cart");
	
		
	}
}
