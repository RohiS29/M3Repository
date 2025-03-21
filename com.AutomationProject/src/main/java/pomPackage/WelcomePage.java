package pomPackage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	@FindBy(linkText = "Register") private WebElement registerLink;
	@FindBy(linkText = "Log in") private WebElement loginButton;
	@FindBy(xpath = "//span[text()='Shopping cart']") private WebElement shoppingcartlink;
	@FindBy(xpath = "//span[text()='Wishlist']") private WebElement wishlistlink;
	@FindBy(partialLinkText = "BOOKS") private WebElement bookslink;
	@FindBy(partialLinkText = "COMPUTERS") private WebElement computerslink;
	@FindBy(partialLinkText = "ELECTRONICS") private WebElement electronicslink;
	@FindBy(linkText = "Log out") private WebElement logOutLink;
	
	public WelcomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getShoppingcartlink() {
		return shoppingcartlink;
	}

	public WebElement getWishlistlink() {
		return wishlistlink;
	}

	public WebElement getBookslink() {
		return bookslink;
	}

	public WebElement getComputerslink() {
		return computerslink;
	}

	public WebElement getElectronicslink() {
		return electronicslink;
	}

	public WebElement getLogOutLink() {
		return logOutLink;
	}
//operational Method
	public void logout()
	{
		logOutLink.click();
	}
}

