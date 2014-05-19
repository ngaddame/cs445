package edu.iit.cs445.cm.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	public static final String DATE_FORMAT = "MM/dd/yyyy";
	public static boolean hasBirthdayInNextSevenDays(Date dob) {
		if(dob==null) {
			return false;
		}
		Calendar todayC=Calendar.getInstance();
		todayC.set(Calendar.MILLISECOND, 00);
		todayC.set(Calendar.SECOND, 01);
		todayC.set(Calendar.MINUTE, 0);
		todayC.set(Calendar.HOUR_OF_DAY, 0);
		
		Calendar dobC=Calendar.getInstance();
		dobC.setTime(dob);
		dobC.set(Calendar.YEAR, todayC.get(Calendar.YEAR));
		dobC.set(Calendar.MILLISECOND, 00);
		dobC.set(Calendar.SECOND, 01);
		dobC.set(Calendar.MINUTE, 00);
		dobC.set(Calendar.HOUR_OF_DAY, 00);
		
		Calendar sevenDaysC=Calendar.getInstance();
		sevenDaysC.set(Calendar.MILLISECOND, 999);
		sevenDaysC.set(Calendar.SECOND, 59);
		sevenDaysC.set(Calendar.MINUTE, 59);
		sevenDaysC.set(Calendar.HOUR_OF_DAY, 23);
		sevenDaysC.add(Calendar.DATE,7);
		
		boolean dobMatch=dobC.getTime().getTime() >= todayC.getTime().getTime() && dobC.getTime().getTime() <= sevenDaysC.getTime().getTime();
		return dobMatch;
	}
	public static Date convertToDate(String dateString) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.US);
			return sdf.parse(dateString);
		} catch (Exception e) {
			return null;
		}
	}

	public static String convertToString(Date date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.US);
			return sdf.format(date);
		} catch (Exception e) {
			return null;
		}
	}
}
