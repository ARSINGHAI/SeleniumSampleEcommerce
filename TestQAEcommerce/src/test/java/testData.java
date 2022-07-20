import org.testng.annotations.DataProvider;

public class testData {

	
	@DataProvider(name="TS1" , parallel=true)
	Object[][] data()
	{
		String pdtClass = "HATS";
		String pdtName = "Brown Brim";
		String pdtName1 = "Blue Beanie";
		String pdtName2 = "Brown Cowboy";
		String pdtName3 ="Grey Brim";
		String Cartindex = "2";
		return new Object[][] {{pdtClass,pdtName,pdtName1,pdtName2,pdtName,Cartindex}};
	}
	@DataProvider(name="TS2" , parallel = true)
	Object[][] data_2()
	{
		return new Object[][] {};
		
	}
}
