package framework;

import java.io.IOException;

public class Test3 {

	public static void main(String[] args) throws IOException {

		String number = ExcelUtils.getStringValue(17, 3);
		System.out.println(number);

	}

}
