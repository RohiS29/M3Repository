package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Declaration
	@FindBy(id="Email") private WebElement emailTB;
	@FindBy(id="Password") private WebElement passwordTB;
	@FindBy(xpath="//input[@value='Log in']") private WebElement loginButton;
	@FindBy(id="RememberMe") private WebElement rememberCheckBox;
	@FindBy(linkText = "Forgot password?") private WebElement forgotLink;
	
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getEmailTB() {
		return emailTB;
	}

	public WebElement getPasswordTB() {
		return passwordTB;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getRememberCheckBox() {
		return rememberCheckBox;
	}

	public WebElement getForgotLink() {
		return forgotLink;
	}
	
	public void validLoginMethod(String email, String password)
	{
		emailTB.sendKeys(email);
		passwordTB.sendKeys(password);
		loginButton.click();
	}
	public void invalidLoginMethod(String email, String password)
	{
		emailTB.sendKeys(email);
		passwordTB.sendKeys(password);
		loginButton.click();
		emailTB.clear();
		passwordTB.clear();
		
		
	}
	
	
}
