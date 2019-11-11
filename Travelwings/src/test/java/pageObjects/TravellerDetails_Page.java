package pageObjects;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import actions.Search_Inputs;
import framework.ExcelUtils;
import utils.Constants;

public class TravellerDetails_Page {
	
	private static WebElement element;
	
	public static void add_pax(WebDriver driver) throws IOException {
		
	//List<WebElement> adults = driver.findElements(By.xpath("//h6[contains(text(),'Adult')]"));
	
	List<WebElement> adults = driver.findElements(By.xpath("//h6[contains(text(),'Adult')]"));
	
	List<WebElement> childs = driver.findElements(By.xpath("//h6[contains(text(),'Child')]"));
	
	List<WebElement> infants = driver.findElements(By.xpath("//h6[contains(text(),'Infant')]"));
	
	List<WebElement> titles= driver.findElements(By.xpath("//select[@name='Title']"));
	
	List<WebElement> firstname = driver.findElements(By.xpath("//div[text()='First Name']/../div[2]/input"));
			
	List<WebElement> lastname = driver.findElements(By.xpath("//div[text()='Last Name']/../div[2]/input"));

	List<WebElement> dob = driver.findElements(By.xpath("//input[@data-ng-model='booking.dob[$index]']"));
	
	List<WebElement> phone = driver.findElements(By.xpath("//div[@class='col-sm-8 type ng-scope']/input[2]"));
	
	List<WebElement> passport = driver.findElements(By.xpath("//div[text()='Passport Number']/../div/input"));
	
	List<WebElement> exp_date = driver.findElements(By.xpath("//input[@data-ng-model='booking.passportExpireDate[$index]']"));
	
	List <WebElement> nationality = driver.findElements(By.xpath("//select[@id='countryId']"));
	
	
	
		
	int adult_size = adults.size();
	int child_size = childs.size();
	int infant_size = infants.size();
	
	
	for(int i=0;i<adult_size;i++) {
		
		if(i>=1) {
		adults.get(i).click();
		}
		
		
		Select sl = new Select(titles.get(i));
		String title = ExcelUtils.getStringValue(69+i, 0);
		sl.selectByVisibleText(title);
		String first_name = ExcelUtils.getStringValue(69+i, 1);
		firstname.get(i).sendKeys(first_name);
		String last_name = ExcelUtils.getStringValue(69+i, 2);
		lastname.get(i).sendKeys(last_name);

		String date = ExcelUtils.getStringValue(69+i, 3);
		String d_day=Search_Inputs.date(date);
		String d_month = Search_Inputs.month(date);
		String d_year = Search_Inputs.year(date);
		
		dob.get(i).click();
		Select d_year0=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));
		d_year0.selectByVisibleText(d_year);

		Select d_month0=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));
		
		d_month0.selectByVisibleText(d_month);

		driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='"+d_day+"']")).click();
				
		String phone_number = ExcelUtils.getStringValue(69+i, 5);
		phone.get(i).sendKeys(phone_number);

		String passport_exp = ExcelUtils.getStringValue(69+i, 6);
		passport.get(i).sendKeys(passport_exp);
		exp_date.get(i).click();
		
		String expiry_date = ExcelUtils.getStringValue(69+i, 7);
		String exp_day=Search_Inputs.date(expiry_date);
		String exp_month = Search_Inputs.month(expiry_date);
		String exp_year = Search_Inputs.year(expiry_date);
		
		Select sly1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));
		sly1.selectByVisibleText(exp_year);

		Select slm1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));

		slm1.selectByVisibleText(exp_month);
		
		driver.findElement(By.xpath("//a[text()='"+exp_day+"']")).click();

		Select nation = new Select(nationality.get(i));

		String country = ExcelUtils.getStringValue(69+i, 8);

		nation.selectByVisibleText(country);
		
	}
	
	int m =adult_size;
	for(int j=0;j<child_size;j++) {
		
		childs.get(j).click();
		
		Select sl = new Select(titles.get(j+m));
		String title = ExcelUtils.getStringValue(78+j, 0);
		sl.selectByVisibleText(title);
		
		String first_name = ExcelUtils.getStringValue(78+j, 1);
		firstname.get(j+m).sendKeys(first_name);
		
		String last_name = ExcelUtils.getStringValue(78+j, 2);
		lastname.get(j+m).sendKeys(last_name);
		
		dob.get(j+m).click();
		
		String date = ExcelUtils.getStringValue(78+j, 3);
		String d_day=Search_Inputs.date(date);
		String d_month = Search_Inputs.month(date);
		String d_year = Search_Inputs.year(date);
		
		Select d_year0=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));
		d_year0.selectByVisibleText(d_year);
	
		Select d_month0=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));

		d_month0.selectByVisibleText(d_month);
		driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='"+d_day+"']")).click();

		String phone_number = ExcelUtils.getStringValue(78+j, 5);
		phone.get(j+m).sendKeys(phone_number);

		String passport_exp = ExcelUtils.getStringValue(78+j, 6);
		passport.get(j+m).sendKeys(passport_exp);

		exp_date.get(j+m).click();

		String expiry_date = ExcelUtils.getStringValue(78+j, 7);
		String exp_day=Search_Inputs.date(expiry_date);
		String exp_month = Search_Inputs.month(expiry_date);
		String exp_year = Search_Inputs.year(expiry_date);
		
		Select sly1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));

		sly1.selectByVisibleText(exp_year);

		Select slm1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));

		slm1.selectByVisibleText(exp_month);

		driver.findElement(By.xpath("//a[text()='"+exp_day+"']")).click();

		Select nation = new Select(nationality.get(j+m));

		String country = ExcelUtils.getStringValue(78+j, 8);

		nation.selectByVisibleText(country);
		
	}
	
	
	int l =adult_size+child_size;
	for(int k=0;k<infant_size;k++) {
		
		infants.get(k).click();
		
		Select sl = new Select(titles.get(k+l));
		String title = ExcelUtils.getStringValue(90+k, 0);
		sl.selectByVisibleText(title);
		
		String first_name = ExcelUtils.getStringValue(90+k, 1);
		firstname.get(k+l).sendKeys(first_name);
		String last_name = ExcelUtils.getStringValue(90+k, 2);
		lastname.get(k+l).sendKeys(last_name);
		
		dob.get(k+l).click();
		
		String date = ExcelUtils.getStringValue(90+k, 3);
		String d_day=Search_Inputs.date(date);
		String d_month = Search_Inputs.month(date);
		String d_year = Search_Inputs.year(date);

		
		Select d_year0=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));
		d_year0.selectByVisibleText(d_year);
		
		Select d_month0=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));

		d_month0.selectByVisibleText(d_month);
		driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='"+d_day+"']")).click();
		
//		String phone_number = ExcelUtils.getStringValue(90+k, 5);
//		phone.get(k+l).sendKeys(phone_number);

		String passport_exp = ExcelUtils.getStringValue(90+k, 6);
		passport.get(k+l).sendKeys(passport_exp);

		exp_date.get(k+l).click();

		String expiry_date = ExcelUtils.getStringValue(90+k, 7);
		String exp_day=Search_Inputs.date(expiry_date);
		String exp_month = Search_Inputs.month(expiry_date);
		String exp_year = Search_Inputs.year(expiry_date);
		
		
		Select sly1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));
		
		sly1.selectByVisibleText(exp_year);

		Select slm1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));

		slm1.selectByVisibleText(exp_month);

		driver.findElement(By.xpath("//a[text()='"+exp_day+"']")).click();

		Select nation = new Select(nationality.get(k+l));

		String country = ExcelUtils.getStringValue(90+k, 8);

		nation.selectByVisibleText(country);
		
	}
}


	public static WebElement onward_seat(WebDriver driver) {
		
		//element = driver.findElements(By.xpath("//button[contains(text(),'Onward Seat')]")).get(0);
		
		element = driver.findElements(By.xpath("//button[contains(@data-ng-click,'booking.openSelectModal')]")).get(0);
		
		return element;
	}
	
	
	public static WebElement return_seat(WebDriver driver) {
		//element = driver.findElements(By.xpath("//button[contains(@data-ng-click,'booking.openSelectModal')]")).get(0);
		
		element = driver.findElements(By.xpath("//button[contains(@data-ng-click,'booking.openSelectModal')]")).get(1);
		
		return element;
	}
	
	
	public static void onward_seatmap(WebDriver driver,int testrow) throws IOException, InterruptedException {
	
		String onwrd_seat = ExcelUtils.getStringValue(testrow, 11);
		
		if(onwrd_seat.equalsIgnoreCase("YES")) {
		
		//TravellerDetails_Page.onward_seat(driver).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].click();",TravellerDetails_Page.onward_seat(driver));
		
		
		int adult = ExcelUtils.getIntValue(testrow, Constants.adult_col);
		
		int child = ExcelUtils.getIntValue(testrow, Constants.child_col);
		
		int pax = adult+child;
		
		List <WebElement> Adult_onward = driver.findElements(By.xpath("//input[contains(@id,'change_')]"));
		
		List <WebElement> seat_select = driver.findElements(By.xpath("//li[contains(@id,'onward_') and @class='available']"));
		
		for(int i=0;i<pax;i++) {
			Thread.sleep(1000);
			Adult_onward.get(i).click();
			seat_select.get(i).click();
		}	
		
		driver.findElements(By.xpath("//a[text()='Confirm & Continue']")).get(0).click();
}
		}
	
	
	public static void return_seatmap(WebDriver driver,int testrow) throws IOException, InterruptedException {

		String rtrn_seat = ExcelUtils.getStringValue(testrow, Constants.return_seat_col);
		
		String date = ExcelUtils.getStringValue(testrow, Constants.returndate_col);
		
		if(rtrn_seat.equalsIgnoreCase("YES") && !"".equals(date)) {
		
		//TravellerDetails_Page.return_seat(driver).click();
		
			JavascriptExecutor js = (JavascriptExecutor) driver;		
			js.executeScript("arguments[0].click();",TravellerDetails_Page.return_seat(driver));
			
			
		List<WebElement> Adult_return = driver.findElements(By.xpath("//input[contains(@id,'changeR_0')]"));
		
		List <WebElement> retun_seat = driver.findElements(By.xpath("//li[contains(@id,'return_') and @class='available']"));
		
		int adult = ExcelUtils.getIntValue(testrow, Constants.adult_col);
		int child = ExcelUtils.getIntValue(testrow, Constants.child_col);
		
		int pax = adult+child;
		
		for(int i=0;i<pax;i++) {
			Thread.sleep(1000);
			Adult_return.get(i).click();
			retun_seat.get(i).click();
		
		}
		
		driver.findElements(By.xpath("//a[text()='Confirm & Continue']")).get(1).click();	
		}		
}

	
	public static void onward_baggage(WebDriver driver,int testrow) {
		
		String owrd_bag = ExcelUtils.getStringValue(testrow, Constants.onward_baggage_col);
		
		if(owrd_bag.equalsIgnoreCase("YES") ) {
		
			List <WebElement> onward_bag = driver.findElements(By.xpath("//select[contains(@id,'bagg_')]"));
		
		for(int i=0;i<onward_bag.size();i++) {
		
		Select sl = new Select(onward_bag.get(i));
		sl.selectByIndex(1);
		
		}
	}
}

	
	public static void return_baggage(WebDriver driver,int testrow) {
		
		String rtn_bag = ExcelUtils.getStringValue(testrow, Constants.return_baggage_col);

		String date = ExcelUtils.getStringValue(testrow, Constants.returndate_col);
		
		if(rtn_bag.equalsIgnoreCase("YES") && !"".equals(date)) {
			
		List <WebElement> return_bag = driver.findElements(By.xpath("//select[contains(@id,'baggr_')]"));	
			
		for(int i=0;i<return_bag.size();i++) {
		Select sl = new Select(return_bag.get(i));
		sl.selectByIndex(2);	
		}
		}
	}
	
	
	public static void onward_meal(WebDriver driver,int testrow) {
		
		String owrd_meal = ExcelUtils.getStringValue(testrow, Constants.onward_meal_col);
		
		if(owrd_meal.equalsIgnoreCase("YES") ) {
			
			//List <WebElement> onward_meal = driver.findElements(By.xpath("//select[contains(@name,'onwardSpecialServiceMeal')]"));
			List <WebElement> onward_meal = driver.findElements(By.xpath("//select[contains(@name,'onwardSpecialServiceMeal')]"));
			for(int i=0;i<onward_meal.size();i++) {
			Select sl = new Select(onward_meal.get(i));
			sl.selectByIndex(1);
				
			}
			
		}
	}
	
	
	public static void return_meal(WebDriver driver,int testrow) {
		
		String rtn_meal = ExcelUtils.getStringValue(testrow, Constants.return_meal_col);
		
		String date = ExcelUtils.getStringValue(testrow, Constants.returndate_col);
		
		if(rtn_meal.equalsIgnoreCase("YES") && !"".equals(date)) {
			
			List <WebElement> return_meal = driver.findElements(By.xpath("//select[contains(@name,'returnSpecialServiceMeal')]"));
			
			for(int i=0;i<return_meal.size();i++) {
			Select sl = new Select(return_meal.get(i));
			sl.selectByIndex(2);
			}
		}
	}
	
	
	public static WebElement cont_button(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[text()='CONTINUE' and @class='bttn-yellow']"));
		return element;
	}


	
	
	
	
	
	
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

}
