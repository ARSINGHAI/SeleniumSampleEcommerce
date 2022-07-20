import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestScenario1 extends baseClass {
	
	@Test(dataProvider= "TS1" , dataProviderClass = testData.class)
	public void TS1(String pdtClass , String pdtName, String pdtName1, String pdtName2, String pdtName3 , String index) throws InterruptedException
	{
		shopPage ob1 = new shopPage(driver);
		ob1.productNameVerification(pdtClass, pdtName, pdtName1, pdtName2, pdtName3);
		Actions act = new Actions(driver);
		ob1.addToCart(act,index);
	}


}
