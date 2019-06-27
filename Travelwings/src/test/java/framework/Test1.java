package framework;


public class Test1 {

	
	public static void main (String[] args) throws Exception {
		String return_date= ExcelUtils.getStringValue(62, 2);
		
		String onward_Seat = ExcelUtils.getStringValue(61, 3);
		
		String return_Seat = ExcelUtils.getStringValue(61, 4);
		
		if((return_date != null && !"".equals(return_date)) && (onward_Seat.equalsIgnoreCase("yes") || (onward_Seat != null && !"".equals(onward_Seat))))
		{
			System.out.println("sonu");
		}
		
		System.out.println("shameek");
	}
}