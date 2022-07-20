import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TechQflowPractice {
	public static void main(String[] args)
	{
		 WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		
		//Dropdowns
//		driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
//		driver.manage().window().maximize();
//		Select sl = new Select(driver.findElement(By.name("continents")));
//		sl.selectByIndex(2);
//		sl.selectByVisibleText("Australia");
		
		// Alert / pop up 

//		driver.get("https://demo.guru99.com/test/delete_customer.php");
//		driver.manage().window().maximize();
//		WebElement ele = driver.findElement(By.name("submit"));
//		ele.click();
//		driver.switchTo().alert().accept();
//				
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		String parentWin = driver.getWindowHandle();
		driver.findElement(By.id("windowButton")).click();
		Set<String> windowSet = driver.getWindowHandles();
		
		for(String win:windowSet) {
			if(!win.equalsIgnoreCase(parentWin)) {
				driver.switchTo().window(win);
				driver.manage().window().maximize();
				String txt = driver.findElement(By.id("sampleHeading")).getText();
				System.out.println(txt);
			}
			
			driver.switchTo().window(parentWin);
		}
		
		
		
		
	
	}
	
	

}
