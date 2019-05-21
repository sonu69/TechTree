package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.SearchFlight_Page;

public class Search_Inputs {
	
	public static void add_origin(WebDriver driver,String origin) {
		SearchFlight_Page.origin(driver).sendKeys(origin);
		Actions act = new Actions(driver);
		WebElement origin_add=driver.findElement(By.xpath("//div[@class='ctyname' and text()='New Delhi (DEL)']"));
		act.moveToElement(origin_add).build().perform();
		origin_add.click();
	}
	
	
	public static void add_destination(WebDriver driver,String destination) {
		SearchFlight_Page.origin(driver).sendKeys(destination);
		Actions act = new Actions(driver);
		WebElement dest_add=driver.findElement(By.xpath("//div[@class='ctyname' and text()='Dubai (DXB)']"));
		act.moveToElement(dest_add).build().perform();
		dest_add.click();
	}
	
	public static void journeydate(WebDriver driver,String departing_month,String departing_day) {
		SearchFlight_Page.journey_date(driver).click();
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
	
	public static void returndate(WebDriver driver,String return_month,String return_day) {
		
		SearchFlight_Page.return_date(driver).click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		String month=driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).get(0).getText();
		
		if(month.equalsIgnoreCase(return_month)) {
			System.out.println("month selected");	
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
	
	
	public static void pax_list(WebDriver driver,int adult,int child, int infants) {
		
		SearchFlight_Page.pax(driver).click();
		
		for(int n=1;n<adult;n++){
			WebElement adult_count=driver.findElement(By.xpath("//button[@data-ng-click='flight.addAdult()']"));
			adult_count.click();
		}

		for(int o=1;o<=child;o++){
			WebElement child_count=driver.findElement(By.xpath("//button[@data-ng-click='flight.addChild()']"));
			child_count.click();
		}
		
		if(infants>=adult) {
		for(int p=1;p<=adult;p++){
			WebElement infant_count=driver.findElement(By.xpath("//button[@data-ng-click='flight.addInfant()']"));
			infant_count.click();
			}
		}
		else {
			for(int p=1;p<adult;p++){
				WebElement infant_count=driver.findElement(By.xpath("//button[@data-ng-click='flight.addInfant()']"));
				infant_count.click();	
			}
		}
		
		WebElement cancel_traveller=driver.findElement(By.xpath("//div[@class='cancel']/div"));
		cancel_traveller.click();
	
	}
	
	
	
	

}
