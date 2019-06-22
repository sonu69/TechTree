package framework;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.Addpax_Actions;
import actions.BookingDetail_Page;
import actions.FlightSelect_Page;
import actions.Payment_Actions;
import actions.Search_Inputs;
import pageObjects.Itinerary_Page;
import pageObjects.SearchFlight_Page;
import pageObjects.YourEmailId_Page;


public class Multicity {

	public static void main(String[] args) throws IOException, InterruptedException {
		 
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.get("https://test.techtreeit.in/");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("//span[text()='Multi-city route']")).click();
				
				driver.findElement(By.xpath("//button[text()='Add City']")).click();
				
				List <WebElement> origins = driver.findElements(By.xpath("//input[contains(@id,'origin_')]"));
				List <WebElement> destinations = driver.findElements(By.xpath("//input[contains(@id,'destination_')]"));
				List <WebElement> journeydate = driver.findElements(By.xpath("//input[contains(@id,'journeyDate_')]"));
				
				String origin1 = ExcelUtils.getStringValue(49, 1);
				origins.get(0).sendKeys(origin1);
				SearchFlight_Page.elementlocator(driver, origin1);
				
				
				
				for(int i=0;i<destinations.size();i++) {
				String destination = ExcelUtils.getStringValue(49+i, 2);
				destinations.get(i).clear();
				destinations.get(i).sendKeys(destination);
				SearchFlight_Page.elementlocator(driver, destination);
				
				}
				
//				for(int i=0;i<origins.size();i++) {
//				String origin = ExcelUtils.getStringValue(49+i, 1);
//				origins.get(i).clear();
//				origins.get(i).sendKeys(origin);
//				
//				List <WebElement> element = driver.findElements(By.xpath("//div[@class='ctyname' and contains(text(),'"+origin+"')]"));
//				Actions act = new Actions(driver);
//				act.moveToElement(element.get(0)).build().perform();
//				element.get(0).click();
//				
//				//SearchFlight_Page.elementlocator(driver, origin);
//				
//				}				

				
				

				
//				String origin = ExcelUtils.getStringValue(49, 1);
//				origins.get(0).sendKeys(origin);
//				SearchFlight_Page.elementlocator(driver, origin);
				
				
				for(int m=0;m<journeydate.size();m++) {
					Thread.sleep(2000);
					journeydate.get(m).click();
					String journeydat = ExcelUtils.getStringValue(49+m, 3);
					String departing_day = date(journeydat);
					String departing_month = month(journeydat);
					WebDriverWait wait = new WebDriverWait(driver,10);
					String month=driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).get(0).getText();
					
					if(month.equalsIgnoreCase(departing_month)) {
						System.out.println("month selected");	
					}else {
						for(int i=1;i<12;i++) {
							WebElement next_month=driver.findElement(By.xpath("//body[@class='ng-scope']/div[3]/div[2]/div/a[@title='Next']"));
							wait.until(ExpectedConditions.elementToBeClickable(next_month));
							next_month.click();
							month=driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).get(0).getText();
							if(month.equalsIgnoreCase(departing_month)){
								break;
								}
							}
						}	
					
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr/td")));
					List<WebElement> enable_days = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr/td"));
					for(int j=0;j<enable_days.size();j++)
						{
						if(enable_days.get(j).getText().equalsIgnoreCase(departing_day))
							{
							enable_days.get(j).click();
							}
						}

				}
				
				Search_Inputs.pax_list(driver);
				
				Thread.sleep(2000);
				
				SearchFlight_Page.search_flight(driver).click();
				
				Thread.sleep(10000);
				
				FlightSelect_Page.select_flight(driver);
				
				Itinerary_Page.continue_itinerary(driver).click();
				
				YourEmailId_Page.account_login(driver);
				
				Addpax_Actions.execute(driver);
				
				Payment_Actions.payment_action(driver);

				BookingDetail_Page.booking_status(driver);
				
				BookingDetail_Page.booking_detail(driver);
				
				
				

		
	}
	
	
	public static void journeydate(WebDriver driver) throws IOException {
		
		SearchFlight_Page.journey_date(driver).click();
		
		String date = ExcelUtils.getStringValue(1, 3);
		String departing_day = date(date);
		String departing_month = month(date);
		//String departing_year = year(date);
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		String month=driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).get(0).getText();
		
		if(month.equalsIgnoreCase(departing_month)) {
			System.out.println("month selected");	
		}else {
			for(int i=1;i<12;i++) {
				WebElement next_month=driver.findElement(By.xpath("//body[@class='ng-scope']/div[3]/div[2]/div/a[@title='Next']"));
				wait.until(ExpectedConditions.elementToBeClickable(next_month));
				next_month.click();
				month=driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).get(0).getText();
				if(month.equalsIgnoreCase(departing_month)){
					break;
					}
				}
			}	
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr/td")));
		List<WebElement> enable_days = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr/td"));
		for(int j=0;j<enable_days.size();j++)
			{
			if(enable_days.get(j).getText().equalsIgnoreCase(departing_day))
				{
				enable_days.get(j).click();
				}
			}
	}
	
	
	public static String date(String date) {
		String splitter[] = date.split("-");
		String day=splitter[0];
		return day;
	}
	
	public static String month(String date) {
		String splitter[] = date.split("-");
		String month=splitter[1];
		return month;
	}
	
	public static String year(String date) {
		String splitter[] = date.split("-");
		String year = splitter[2];
		return year;
	}
	
	
	
	
	
	
	

}
