package main;

import common.Util;
import exception.DateLengthException;

public class Main {
	
	public static void main(String[] args) throws DateLengthException {
		String result = Util.emptyBlank("Test String");
		System.out.println(result);
		
		result = Util.emptyBlank(null);
		System.out.println(result);
		
		String date = "19861206";
		String dateForm = Util.dateFormat(date);
		
		System.out.println(dateForm);
	}
	
}
