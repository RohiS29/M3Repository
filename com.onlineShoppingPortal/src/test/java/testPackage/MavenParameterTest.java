package testPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MavenParameterTest {
  @Test
  public void LaunchGoogleUsingMavenParameterization() {
	 WebDriver driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	 
	 String URL = System.getProperty("url");
	 driver.get(URL);
	 
	 String DATA = System.getProperty("data");
	 driver.findElement(By.name("q")).sendKeys(DATA,Keys.ENTER);
  }
}
