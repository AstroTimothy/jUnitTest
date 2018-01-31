package common;

import exception.DateLengthException;

public class Util {
	public static String emptyBlank(Object str) {	
		return str == null ? "": str.toString();
	}
	public static String emptyBlank(int num) {	
		return num == 0 ? "": String.valueOf(num);
	}
	public String split(String regex) {
		String str = new String();		
		return str;
	}
	
	public static String dateFormat(String creDate) throws DateLengthException {
		
		String viewDate = ""; 
		
		if(creDate == null) {
			viewDate = "";
		} else {
			
			if (creDate.length() > 8) {
				throw new DateLengthException("8자리가 아닙니다.");
			}
			
	//		1. 문자열을 4, 2, 2로 자른 후 '-'삽입
			String yyyy = creDate.substring(0, 4);
			String mm = creDate.substring(4, 6);
			String dd = creDate.substring(6, 8);
			
			viewDate = yyyy + "-" + mm + "-" + dd;
		}
		
		return viewDate;
	}
	
}
