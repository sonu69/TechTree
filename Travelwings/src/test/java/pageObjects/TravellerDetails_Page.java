package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TravellerDetails_Page {
	
	private static WebElement element;
	
	public static void add_adult(WebDriver driver) {
		List<WebElement> titles= driver.findElements(By.xpath("//select[@name='Title']"));
		
		List<WebElement> firstname = driver.findElements(By.xpath("//div[text()='First Name']/../div[2]/input"));
				
		List<WebElement> lastname = driver.findElements(By.xpath("//div[text()='Last Name']/../div[2]/input"));
		
		List<WebElement> dob = driver.findElements(By.xpath("//input[@data-ng-model='booking.dob[$index]']"));
		
		List<WebElement> phone = driver.findElements(By.xpath("//div[@class='col-sm-8 type ng-scope']/input[2]"));
		
		List<WebElement> passport = driver.findElements(By.xpath("//div[text()='Passport Number']/../div/input"));
		
		List<WebElement> exp_date = driver.findElements(By.xpath("//input[@data-ng-model='booking.passportExpireDate[$index]']"));
		
		List<WebElement> adults = driver.findElements(By.xpath("//h6[contains(text(),'Adult')]"));
		
		int size = adults.size();
		
		for(int i=0;i<size;i++) {
			
			Select sl = new Select(titles.get(i));
			sl.selectByVisibleText("Mr.");
			
			firstname.get(i).sendKeys("sonu");
			
			lastname.get(i).sendKeys("kumar");
			
			dob.get(i).click();
			Select sly=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));
			sly.selectByVisibleText("1992");
			Select slm=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));
			slm.selectByVisibleText("Jul");
			
			driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='3']")).click();
			
			phone.get(i).sendKeys("9905040207");
			
			passport.get(i).sendKeys("J8965230");
			
			exp_date.get(i).click();
			Select sly1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));
			sly1.selectByVisibleText("2020");
			
			Select slm1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));
			slm1.selectByVisibleText("Jul");
			
			driver.findElement(By.xpath("//a[text()='7']")).click();
			
		}		
	}
		
	
	public static void add_child(WebDriver driver) {
		List<WebElement> titles= driver.findElements(By.xpath("//select[@name='Title']"));
		
		List<WebElement> firstname = driver.findElements(By.xpath("//div[text()='First Name']/../div[2]/input"));
				
		List<WebElement> lastname = driver.findElements(By.xpath("//div[text()='Last Name']/../div[2]/input"));
		
		List<WebElement> dob = driver.findElements(By.xpath("//input[@data-ng-model='booking.dob[$index]']"));
		
		List<WebElement> phone = driver.findElements(By.xpath("//div[@class='col-sm-8 type ng-scope']/input[2]"));
		
		List<WebElement> passport = driver.findElements(By.xpath("//div[text()='Passport Number']/../div/input"));
		
		List<WebElement> exp_date = driver.findElements(By.xpath("//input[@data-ng-model='booking.passportExpireDate[$index]']"));
		
		List<WebElement> childs = driver.findElements(By.xpath("//h6[contains(text(),'Child')]"));
		
		List<WebElement> adults = driver.findElements(By.xpath("//h6[contains(text(),'Adult')]"));
		
		int adult_size = adults.size();
		
		int size = childs.size();
		
		for(int i=0;i<size;i++) {
			
			Select sl = new Select(titles.get(i+adult_size));
			sl.selectByVisibleText("Miss");
			
			firstname.get(i+adult_size).sendKeys("Lata");
			
			lastname.get(i+adult_size).sendKeys("Dev");
			
			dob.get(i+adult_size).click();
			Select sly=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));
			sly.selectByVisibleText("2009");
			Select slm=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));
			slm.selectByVisibleText("Jul");
			
			driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='3']")).click();
			
			phone.get(i+adult_size).sendKeys("9905040207");
			
			passport.get(i+adult_size).sendKeys("J8965230");
			
			exp_date.get(i+adult_size).click();
			Select sly1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));
			sly1.selectByVisibleText("2020");
			
			Select slm1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));
			slm1.selectByVisibleText("Jul");
			
			driver.findElement(By.xpath("//a[text()='7']")).click();
			
		}		
	}
	

	public static void add_infants(WebDriver driver) {
		List<WebElement> titles= driver.findElements(By.xpath("//select[@name='Title']"));
		
		List<WebElement> firstname = driver.findElements(By.xpath("//div[text()='First Name']/../div[2]/input"));
				
		List<WebElement> lastname = driver.findElements(By.xpath("//div[text()='Last Name']/../div[2]/input"));
		
		List<WebElement> dob = driver.findElements(By.xpath("//input[@data-ng-model='booking.dob[$index]']"));
		
		List<WebElement> phone = driver.findElements(By.xpath("//div[@class='col-sm-8 type ng-scope']/input[2]"));
		
		List<WebElement> passport = driver.findElements(By.xpath("//div[text()='Passport Number']/../div/input"));
		
		List<WebElement> exp_date = driver.findElements(By.xpath("//input[@data-ng-model='booking.passportExpireDate[$index]']"));
		
		List<WebElement> infants = driver.findElements(By.xpath("//h6[contains(text(),'Infant')]"));
		
		List<WebElement> childs = driver.findElements(By.xpath("//h6[contains(text(),'Child')]"));
		
		List<WebElement> adults = driver.findElements(By.xpath("//h6[contains(text(),'Adult')]"));
		
		int ad_size = adults.size();
		int ch_size = childs.size();
		
		int size = infants.size();
		
		for(int i=0;i<size;i++) {
			
			Select sl = new Select(titles.get(i+ad_size+ch_size));
			sl.selectByVisibleText("Miss");
			
			firstname.get(i+ad_size+ch_size).sendKeys("shameek");
			
			lastname.get(i+ad_size+ch_size).sendKeys("kumar");
			
			dob.get(i+ad_size+ch_size).click();
			Select sly=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));
			sly.selectByVisibleText("2018");
			Select slm=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));
			slm.selectByVisibleText("Jul");
			
			driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='3']")).click();
			
			phone.get(i+ad_size+ch_size).sendKeys("9905040207");
			
			passport.get(i+ad_size+ch_size).sendKeys("J8965230");
			
			exp_date.get(i+ad_size+ch_size).click();
			Select sly1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));
			sly1.selectByVisibleText("2020");
			
			Select slm1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));
			slm1.selectByVisibleText("Jul");
			
			driver.findElement(By.xpath("//a[text()='3']")).click();
			
		}		
	}
	
	public static void add_passengers(WebDriver driver) {
		TravellerDetails_Page.add_adult(driver);
		TravellerDetails_Page.add_child(driver);
		TravellerDetails_Page.add_infants(driver);
		
	}
	
		
		public static WebElement cont_button(WebDriver driver) {
			element = driver.findElement(By.xpath("//button[text()='CONTINUE' and @class='bttn-yellow']"));
			return element;
		}
		
		
		


}
