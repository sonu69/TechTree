package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import framework.ExcelUtils;

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
		
		List<WebElement> dob_year = driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']"));
		
		List<WebElement> dob_month = driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']"));
		
		List<WebElement> exp_year = driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']"));
		
		List<WebElement> exp_month = driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']"));
		
		List <WebElement> nationality = driver.findElements(By.xpath("//select[@id='countryId']"));
		
		
//		int size = adults.size();
//		System.out.println(size);
		
		//for(int i=0;i<size;i++) {
			
			Select sl0 = new Select(titles.get(0));
			
			sl0.selectByVisibleText("Mr.");
			
			firstname.get(0).sendKeys("sonu");
			
			lastname.get(0).sendKeys("kumar");
			
			dob.get(0).click();
			//Select sly=new Select(dob_year.get(0));
			Select d_year0=new Select(driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")).get(0));
			d_year0.selectByVisibleText("1992");
			
			//Select slm=new Select(dob_month.get(0));
			Select d_month0=new Select(driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")).get(0));
			d_month0.selectByVisibleText("Jul");
			
			driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='3']")).click();
			
			phone.get(0).sendKeys("9905040207");
			
			passport.get(0).sendKeys("J8965230");
			
			exp_date.get(0).click();
			//Select sly1=new Select(exp_year.get(0));
			Select e_year0=new Select(driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")).get(0));
			e_year0.selectByVisibleText("2020");
			
			//Select slm1=new Select(exp_month.get(0));
			Select e_month0=new Select(driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")).get(0));
			e_month0.selectByVisibleText("Jul");
			
			driver.findElement(By.xpath("//a[text()='7']")).click();
			
			Select national0 = new Select(driver.findElements(By.xpath("//select[@id='countryId']")).get(0));
			national0.selectByVisibleText("India");
			
			
			
			//2nd Adult
			
			Select sl1 = new Select(titles.get(1));
			
			sl1.selectByVisibleText("Mr.");
			
			firstname.get(1).sendKeys("Ashish");
			
			lastname.get(1).sendKeys("kumar");
			
			dob.get(1).click();
			//Select sly=new Select(dob_year.get(0));
			//Select d_year1=new Select(driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")).get(1));
			Select d_year1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));
			d_year1.selectByVisibleText("1994");
			
			//Select slm=new Select(dob_month.get(0));
			//Select d_month1=new Select(driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")).get(1));
			Select d_month1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));
			d_month1.selectByVisibleText("Nov");
			
			driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='17']")).click();
			
			phone.get(1).sendKeys("9874563210");
			
			passport.get(1).sendKeys("H8965230");
			
			exp_date.get(1).click();
			//Select sly1=new Select(exp_year.get(0));
			Select e_year1=new Select(driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")).get(0));
			e_year1.selectByVisibleText("2021");
			
			//Select slm1=new Select(exp_month.get(0));
			Select e_month1=new Select(driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")).get(0));
			e_month1.selectByVisibleText("Jul");
			
			driver.findElement(By.xpath("//a[text()='8']")).click();
			
			Select national1 = new Select(driver.findElements(By.xpath("//select[@id='countryId']")).get(1));
			national1.selectByVisibleText("India");
			
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
