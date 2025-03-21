package genericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPackage.LoginPage;
import pomPackage.WelcomePage;

public class BaseTest implements IAutoConstant {
	protected static WebDriver driver;
	@BeforeClass
	public void browserSetup() throws IOException
	{
		
		Flib flib=new Flib();
		String browserValue=flib.readPropertyData(PROP_PATH_MAIN, "chrome");
		String url=flib.readPropertyData(PROP_PATH_MAIN, URL);
		
		if(browserValue.equalsIgnoreCase("chrome")) {
			driver=new EdgeDriver();
		}
		
		else if(browserValue.equalsIgnoreCase("firefox")) {
			
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Enter valid Browser !!!");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	}
	@BeforeMethod
	public void validLogin() throws EncryptedDocumentException, IOException {
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginButton().click();
		LoginPage lp = new LoginPage(driver);
		Flib flib = new Flib();
		String email = flib.readExcelData(EXCEL_PATH_MAIN, VALIDLOGINCREDS, 1, 0);
		String password = flib.readExcelData(EXCEL_PATH_MAIN, VALIDLOGINCREDS, 1, 1);
		lp.validLoginMethod(email,password);
		
		
	}
	@AfterMethod
	public void logout() {
		
		WelcomePage wp = new WelcomePage(driver);
		wp.logout();
	}
	@AfterClass
	public void browserTearDown() {
		driver.quit();
	}
}
