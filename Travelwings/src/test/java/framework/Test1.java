package framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import actions.FlightSelect_Page;
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
		
//		FlightSelect_Page.select_flight(driver, TestCase_Row);
		
		//List <WebElement> element = driver.findElements(By.xpath("//p[text()='IndiGo Airlines']"));
		
		String flightname = ExcelUtils.getStringValue(TestCase_Row, Constants.flightname_col);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement el = driver.findElements(By.xpath("//p[text()='Emirates']")).get(0);
		
		for(int i=0;el.isDisplayed()==true;i++) {
		
			Thread.sleep(2000);
		
			js.executeScript("window.scrollBy(0, 2500)", "");
		
		}
		
		List<WebElement> flights=driver.findElements(By.xpath("//p[@class='travel-company-name ng-binding']"));
		
		List<WebElement> select_buttons=driver.findElements(By.xpath("//button[@class='bttn-search']"));
		
		for(int j=0;j<flights.size();j++) {

			if(flights.get(j).getText().equalsIgnoreCase(flightname)) {
	
				js.executeScript("arguments[0].click();",select_buttons.get(j));

				//select_buttons.get(j).click();
				break;
			}
			
		}
		
		
		
		//FlightSelect_Page.select_flight(driver, TestCase_Row);
		
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		//js.executeScript("window.scrollTo(0, Math.max(document.documentElement.scrollHeight, document.body.scrollHeight, document.documentElement.clientHeight));");
		
//		for(int i=0;element.isDisplayed()==true;i++) {
//		
//		js.executeScript("window.scrollBy(0, 2500)", "");
//		
//		}
		
//		element.click();
		
		
		
	}
}