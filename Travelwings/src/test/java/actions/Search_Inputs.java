package actions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.ExcelUtils;
import framework.Helper;
import pageObjects.SearchFlight_Page;
import utils.Constants;

public class Search_Inputs {
		
	public static void add_origin(WebDriver driver,int testrow) throws IOException {
		
		
		String origin = ExcelUtils.getStringValue(testrow, Constants.origin_col);
		SearchFlight_Page.origin(driver).sendKeys(origin);
		
		SearchFlight_Page.elementlocator(driver, origin);
		
//		Actions act = new Actions(driver);
//		WebElement origin_add=driver.findElement(By.xpath("//div[@class='ctyname' and text()='New Delhi (DEL)']"));
//		act.moveToElement(origin_add).build().perform();
//		origin_add.click();

		
	}

	public static void add_destination(WebDriver driver,int testrow) throws IOException {

		String destination = ExcelUtils.getStringValue(testrow, Constants.destination_col);
		SearchFlight_Page.destination(driver).sendKeys(destination);
		
		SearchFlight_Page.elementlocator(driver, destination);
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

	
	public static void journeydate(WebDriver driver,int testrow) throws InterruptedException, IOException {
		
		List <WebElement> journeydate = driver.findElements(By.xpath("//input[contains(@id,'journeyDate_')]"));
		
		for(int m=0;m<journeydate.size();m++) {
			
			journeydate.get(m).click();
			
			String journeydat = ExcelUtils.getStringValue(testrow+m, Constants.journeydate_col);
			String departing_day = date(journeydat);
			String departing_month = month(journeydat);
			WebDriverWait wait = new WebDriverWait(driver,10);
			
			String month=driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).get(0).getText();
			
			if(month.equalsIgnoreCase(departing_month)) {
					
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
	}
	
	
	public static void journey1(WebDriver driver,int testrow) throws IOException {
		
		SearchFlight_Page.journey_date(driver).click();
		
		String date = ExcelUtils.getStringValue(testrow, Constants.returndate_col);
		String departing_day = date(date);
		String departing_month = month(date);
		//String departing_year = year(date);
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		String month=driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).get(0).getText();
		
		if(month.equalsIgnoreCase(departing_month)) {
			
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
	
	public static void returndate(WebDriver driver,int testrow) throws IOException {

		String date = ExcelUtils.getStringValue(testrow, Constants.returndate_col);
		
		if(date != null && !"".equals(date)) {
		
		String return_day = date(date);
		
		String return_month = month(date);
		
		SearchFlight_Page.return_date(driver).click();
		

		//String departing_year = year(date);
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		String month=driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).get(0).getText();
		
		if(month.equalsIgnoreCase(return_month)) {
			
		}else {
			for(int i=1;i<12;i++) {
				WebElement next_month=driver.findElement(By.xpath("//body[@class='ng-scope']/div[3]/div[2]/div/a[@title='Next']"));
				wait.until(ExpectedConditions.elementToBeClickable(next_month));
				next_month.click();
				month=driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).get(0).getText();
				if(month.equalsIgnoreCase(return_month)){
					break;
					}
				}
			}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr/td")));
		List<WebElement> enable_days = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr/td"));
		for(int j=0;j<enable_days.size();j++)
			{
			if(enable_days.get(j).getText().equalsIgnoreCase(return_day))
				{
				enable_days.get(j).click();
				}
			}
		}
	}
	
	
	public static void pax_list(WebDriver driver,int testrow) throws IOException {
		
		SearchFlight_Page.pax(driver).click();
		
		//String adult = ExcelUtils.getStringValue(1, 7);
		int adult = ExcelUtils.getIntValue(testrow, Constants.adult_col);
		int child = ExcelUtils.getIntValue(testrow, Constants.child_col);
		int infants = ExcelUtils.getIntValue(testrow, Constants.infants_col);

		
		for(int n=1;n<adult;n++){
			WebElement adult_count=driver.findElement(By.xpath("//button[@data-ng-click='flight.addAdult()']"));
			adult_count.click();
		}
		

		if(child !=0 && !"".equals(child)) {
		for(int o=1;o<=child;o++){
			WebElement child_count=driver.findElement(By.xpath("//button[@data-ng-click='flight.addChild()']"));
			child_count.click();
		}
		}
		
		if(infants !=0 && !"".equals(infants)) {
		if(infants<=adult) {
		for(int p=1;p<=infants;p++){
			WebElement infant_count=driver.findElement(By.xpath("//button[@data-ng-click='flight.addInfant()']"));
			infant_count.click();
		}
		}else {System.out.println("infant number should not be more than adult number");
		System.exit(0);
		}
		}
		
		WebElement cancel_traveller=driver.findElement(By.xpath("//div[@class='cancel']/div"));
		
		Helper.Webelement(driver, cancel_traveller);
		
//		cancel_traveller.click();
	
	}
	
	public static void elementlocator(WebDriver driver,String airportname) {
		WebElement element = driver.findElement(By.xpath("//div[@class='ctyname' and contains(text(),'"+airportname+"')]"));
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		element.click();
	}
	
	
	public static void flight_name(WebDriver driver,int testrow) throws IOException {
		
		String flightname = ExcelUtils.getStringValue(testrow, Constants.flightname_col);
		
		String status = ExcelUtils.getStringValue(testrow, Constants.preferred_airline);
		
		if(status.equalsIgnoreCase("yes")) {
		SearchFlight_Page.advance_search(driver).click();
		driver.findElement(By.xpath("//input[@ng-model='inputValue']")).sendKeys(flightname);
		WebElement element = driver.findElement(By.xpath("//div[@id='mCSB_2_container']/li[contains(text(),'"+flightname+"')]"));
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		element.click();
		}
		else {}
	}
	
	

}
