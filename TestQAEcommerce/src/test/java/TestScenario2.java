import java.awt.AWTException;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestScenario2 extends baseClass {
	
	
	@Test()
	public void TS2() throws InterruptedException, AWTException
	{
		Actions act  = new Actions(driver);
		checkoutPage ob1 = new checkoutPage(driver);
		ob1.clickCheckout(act);
		ob1.checkQuantityPrice(act);
		ob1.increaseQuantity(3);
		ob1.checkQuantityPrice(act);
		ob1.decreaseQuantity(3);
		ob1.checkQuantityPrice(act);
	}
}
