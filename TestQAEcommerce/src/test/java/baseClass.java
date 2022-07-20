import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class baseClass {

	
protected WebDriver driver;
	
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.get("https://crwn-clothing-live-ks.herokuapp.com/shop");
		  driver.manage().window().maximize();
		  
	  }

	  @AfterMethod
	  public void afterMethod() {
		 //driver.quit();

	  }

	  @BeforeClass
	  public void beforeClass() {
		  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		  
	  }
	  @AfterClass
	  public void afterClass() {
		  System.clearProperty("webdriver.chrome.drive");
	  }

	}

