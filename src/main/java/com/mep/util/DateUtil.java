package com.mep.util;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date getCurrentTime() {

		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();
		return now;
	}

	public static String changeDateFormat(Date date, String format) {

		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}
	
	public static String convertMonthNumberToMonthName(int month) {
		
		if (month > 0) {
			return new DateFormatSymbols().getMonths()[month-1];
		}
		return new DateFormatSymbols().getMonths()[month];
	}
}
