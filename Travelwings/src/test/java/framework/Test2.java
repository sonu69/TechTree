package framework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class Test2 {
	
    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

	public static void main(String[] args) {
			
		DateFormat customer_format = new SimpleDateFormat("dd_MM_yyyy");
		Date current_date = new Date();
		
		
		String date1 = customer_format.format(current_date);
		//System.out.println(date1);
		
		Random random = new Random();
		int minDay = (int) LocalDate.of(2019, 5, 5).toEpochDay();
		int maxDay = (int) LocalDate.of(2019, 12, 12).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);

		LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);

		System.out.println(randomBirthDate);

    }



	}

