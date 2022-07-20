import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class checkoutPage {
	
	private final WebDriver driver;
	
	public checkoutPage(final WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	public void clickCheckout(Actions act) throws InterruptedException
	{
		String cartCountBefore = driver.findElement(By.xpath("//span[@class=\"item-count\"]")).getText();
		WebElement addtoCart  = driver.findElement(By.xpath("(//button[contains(text(),\"Add to Cart\")])["+2+"]"));
		WebElement parentImg = driver.findElement(By.xpath("(//button[contains(text(),\"Add to Cart\")])["+2+"]//parent::div"));
		act.moveToElement(parentImg);
	    act.moveToElement(addtoCart);
	    act.click().build().perform();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div")).click();
		driver.findElement(By.xpath("//button[@class=\"  custom-button\"]")).click();
	}
	public void checkQuantityPrice(Actions act) 
	{
		String quantity = driver.findElement(By.xpath("//span[@class=\"quantity\"]/span")).getText();
		String price = driver.findElement(By.xpath("//span[@class=\"price\"]")).getText();
		int quantityNum = Integer.parseInt(quantity);
		int priceNum = Integer.parseInt(price);
		// price*quantity = total
		int totalExpected = quantityNum * priceNum;
		String ActualTotal = driver.findElement(By.xpath("//div[@class=\"total\"]/span")).getText();
		int index = ActualTotal.indexOf("$");
		String subActualTotal = ActualTotal.substring(index+1);
		int ActualTotalNum = Integer.parseInt(subActualTotal);
		Assert.assertEquals(totalExpected, ActualTotalNum);
		//payment Amount
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		
		driver.findElement(By.xpath("//span[@style]")).click();
		
		act.sendKeys(Keys.ESCAPE).build().perform();
		act.sendKeys(Keys.ESCAPE).build().perform();
		
		
		
		driver.findElement(By.xpath("//span[@style]")).click();
		
		
	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"title\"]/h2")));
		String finalPaymentAmount  = driver.findElement(By.xpath("//div[@class=\"title\"]/h2")).getText();
		int index1 = finalPaymentAmount.indexOf("$");
		String finalPaymentAmountActual = finalPaymentAmount.substring(index1+1);
		int finalPaymentAmountNum = Integer.parseInt(finalPaymentAmountActual);
		
		
		Assert.assertEquals(totalExpected, finalPaymentAmountNum);
		driver.findElement(By.xpath("//a[@class=\"close right\"]")).click();
		
		
		
	}
	public void increaseQuantity(int num)
	{
		for (int i =0 ; i<=num ; i++)
		{
		driver.findElement(By.xpath("(//span[@class=\"quantity\"]/div[@class=\"arrow\"])[2]")).click();
		}
	}
	public void decreaseQuantity(int num)
	{
		for (int i =0 ; i<=num ; i++)
		{
		driver.findElement(By.xpath("(//span[@class=\"quantity\"]/div[@class=\"arrow\"])[1]")).click();
		}
	}
	
	

}
