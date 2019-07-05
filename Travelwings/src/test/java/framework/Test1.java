package framework;

import org.openqa.selenium.WebDriver;
import actions.Search_Inputs;
import pageObjects.SearchFlight_Page;
import utils.Constants;

public class Test1 {
	
	public static void main (String[] args) throws Exception {
		
		int TestCase_Row=ExcelUtils.getRowContains(Constants.testcase_name);
		
		WebDriver driver = BrowserFactory.openBrowser(TestCase_Row);

		Search_Inputs.add_origin(driver,TestCase_Row);
		
		Search_Inputs.add_destination(driver,TestCase_Row);

		Search_Inputs.journeydate(driver,TestCase_Row);
				
		Search_Inputs.returndate(driver,TestCase_Row);
				
		Search_Inputs.pax_list(driver,TestCase_Row);
		
		Thread.sleep(2000);
		
		SearchFlight_Page.search_flight(driver).click();
		
		Thread.sleep(10000);
			
	}
}