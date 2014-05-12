package edu.iit.cs445.cm.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	public static final String DATE_FORMAT = "MM/dd/yyyy";

	public static int daysFromToday(String dateString) {
		if (dateString != null) {
			Date date = convertToDate(dateString);
			if (date != null)
				return daysBetween(new Date(), date);
		}
		return -999;
	}

	public static int daysBetween(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}
	
	public static boolean birthdayInSevenDays(Date dob) {
		//TODO return true if dob is in seven days
		return false;
	}

	public static Date convertToDate(String dateString, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
			return sdf.parse(dateString);
		} catch (Exception e) {
			System.out.println("Invalid date: " + dateString);
			return null;
		}
	}

	public static String convertToString(Date date, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
			return sdf.format(date);
		} catch (Exception e) {
			System.out.println("Invalid date: " + date);
			return null;
		}
	}

	public static Date convertToDate(String dateString) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.US);
			return sdf.parse(dateString);
		} catch (Exception e) {
			System.out.println("Invalid date: " + dateString);
			return null;
		}
	}

	public static String convertToString(Date date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.US);
			return sdf.format(date);
		} catch (Exception e) {
			System.out.println("Invalid date: " + date);
			return null;
		}
	}

	public static String today() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.US);
			return sdf.format(new Date());
		} catch (Exception e) {
			return null;
		}
	}
}
