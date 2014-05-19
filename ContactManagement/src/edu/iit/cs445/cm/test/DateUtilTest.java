package edu.iit.cs445.cm.test;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;
import edu.iit.cs445.cm.util.DateUtil;

public class DateUtilTest extends TestCase {
	Date today,sevenDays,lessthanToday,overSevenDays=null;
	String dateString=null;
	protected void setUp()  throws Exception {
		dateString="01/01/2014";
		today=new Date();
		
		Calendar sevenDaysC=Calendar.getInstance();
		sevenDaysC.add(Calendar.DATE,7);
		sevenDays=sevenDaysC.getTime();
		
		Calendar afterSevenDaysC=Calendar.getInstance();
		afterSevenDaysC.add(Calendar.DATE,9);
		overSevenDays=afterSevenDaysC.getTime();
		
		Calendar lessthanTodayC=Calendar.getInstance();
		lessthanTodayC.add(Calendar.DATE,-2);
		lessthanToday=lessthanTodayC.getTime();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testHasBirthdayInNextSevenDaysWithToday() {
		assertTrue(DateUtil.hasBirthdayInNextSevenDays(today));
	}

	public void testHasBirthdayInNextSevenDaysWithLessthanToday() {
		assertTrue(!DateUtil.hasBirthdayInNextSevenDays(lessthanToday));
	}
	
	public void testHasBirthdayInNextSevenDaysWithSeventhDay() {
		assertTrue(DateUtil.hasBirthdayInNextSevenDays(sevenDays));
	}
	
	public void testHasBirthdayInNextSevenDaysWithOverSevenDays() {
		assertTrue(!DateUtil.hasBirthdayInNextSevenDays(overSevenDays));
	}
	
	public void testHasBirthdayInNextSevenDaysWithNull() {
		assertTrue(!DateUtil.hasBirthdayInNextSevenDays(null));
	}
	
	public void testConvertToDate() {
		Date date=DateUtil.convertToDate(dateString);
		assertEquals(date,DateUtil.convertToDate(dateString));
	}
	
	public void testConvertToString() {
		Date date=DateUtil.convertToDate(dateString);
		assertEquals(dateString, DateUtil.convertToString(date));
	}

}
