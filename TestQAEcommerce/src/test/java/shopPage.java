

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.awt.List;

import org.junit.Assert;

public class shopPage {
	
	private final WebDriver driver;
	
	public shopPage(final WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	public void productNameVerification(String pdtClass ,String pdtName ,String pdtName1,String pdtName2,String pdtName3)
	{
		String expected = driver.findElement(By.xpath("//h1[contains(text(),'"+pdtClass+"')]//parent::div/div/div/child::div[@class='collection-footer']/span[contains(text(),'"+pdtName+"')]" )).getText();
		Assert.assertEquals(expected, pdtName);
		String expected1 = driver.findElement(By.xpath("//h1[contains(text(),'"+pdtClass+"')]//parent::div/div/div/child::div[@class='collection-footer']/span[contains(text(),'"+pdtName1+"')]" )).getText();
		Assert.assertEquals(expected1, pdtName1);
		String expected2 = driver.findElement(By.xpath("//h1[contains(text(),'"+pdtClass+"')]//parent::div/div/div/child::div[@class='collection-footer']/span[contains(text(),'"+pdtName2+"')]" )).getText();
		Assert.assertEquals(expected2, pdtName2);
		String expected3 = driver.findElement(By.xpath("//h1[contains(text(),'"+pdtClass+"')]//parent::div/div/div/child::div[@class='collection-footer']/span[contains(text(),'"+pdtName3+"')]" )).getText();
		Assert.assertEquals(expected3, pdtName3);
	}
	public void addToCart(Actions act ,String index) throws InterruptedException
	{
		String cartCountBefore = driver.findElement(By.xpath("//span[@class=\"item-count\"]")).getText();
		WebElement addtoCart  = driver.findElement(By.xpath("(//button[contains(text(),\"Add to Cart\")])["+index+"]"));
		WebElement parentImg = driver.findElement(By.xpath("(//button[contains(text(),\"Add to Cart\")])["+index+"]//parent::div"));
		act.moveToElement(parentImg);
	    act.moveToElement(addtoCart);
	    act.click().build().perform();
	    String cartCountCurrent = driver.findElement(By.xpath("//span[@class=\"item-count\"]")).getText();
	    int a = Integer.parseInt(cartCountBefore);
	    int b  =  Integer.parseInt(cartCountCurrent);
	    Assert.assertEquals(a+1,b);
	    String pdtName = driver.findElement(By.xpath("(//button[contains(text(),\"Add to Cart\")])["+index+"]//parent::div/div/span")).getText();
	    driver.findElement(By.xpath("//*[@id=\"Capa_1\"]")).click();
	    String pdtNameCart = driver.findElement(By.xpath("//div[@class=\"cart-details\"]/span")).getText();
	    Assert.assertEquals(pdtName,pdtNameCart);
	   
	}
}


















