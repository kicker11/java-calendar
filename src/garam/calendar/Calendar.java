package garam.calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Calendar {

	public static final int[] maxDayOfMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static final int[] maxDayOfMonthLeap = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public String[] calMon = new String[37];
	public int idxOfDays = 0;
	
	private HashMap <Date, String> planMap ;
	
	public Calendar() {
		planMap = new HashMap<Date, String>();
	}
	

	/**
	 * 
	 * @param date ex: "2018-08-14"
	 * @param plan ex:
	 * @throws ParseException 
	 */
	public void registerPlan(String strDate, String plan) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		System.out.println(date);
		planMap.put(date, plan) ;
	}
	
	public String searchPlan(String strDate) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		String plan = planMap.get(date);
		return plan;
	}
		
	
	public void setSpace(int idx) {

		if (idx != 0) {
			for (int i = 1; i < idx; i++) {
				calMon[i] = "   ";
			}
		}
	}

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public int getMaxDaysOfMonth(int year, int mon) {

		if (isLeapYear(year)) {
			return maxDayOfMonthLeap[mon];
		} else {
			return maxDayOfMonth[mon];
		}
		
	}

	public void setInitVal(int year, int month) {

		int maxArrayLength = (getMaxDaysOfMonth(year, month) + idxOfDays);
		for (int j = idxOfDays; j < maxArrayLength; j++) {
			calMon[j] = String.valueOf((j) - idxOfDays);
		}
	}

	public void calPrint(int year, int mon) {
		System.out.println("   일   월   화   수   목   금   토");
		System.out.println("-----------------------");

		for (int currntDay = 1; currntDay < (getMaxDaysOfMonth(year, mon) + idxOfDays); currntDay++) {
			int weekCheck = currntDay % 7;
			// if ( (currntDay % 7 != 0)) {
			if ((currntDay == 0) || (weekCheck != 0)) {
				System.out.printf("%3s", calMon[currntDay]);
			} else if ((currntDay != 0) && (weekCheck == 0)) {
				System.out.printf("%3s \n", calMon[currntDay]);
			}
		}

		System.out.print("\n");
		System.out.print("\n");
	}

	
	private int getWeekDay(int year, int month, int day) {
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4;  // 1970/JAN/1ST = Thursday
		
		int count = 0;
		
		for ( int i=syear; i < year ; i++) {
			int delta = isLeapYear(i) ? 366 : 365 ;
			count += day -1 ;
		}
		
		for ( int i = 1; i < month ; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta ;
		}
		
		count += day -1 ;
		
		int weekday  = ( count + STANDARD_WEEKDAY ) % 7 ;
		return weekday ;
		
	}
	
	
	// Simple Test Code
	public static void main(String[] args) throws ParseException {
		Calendar cal = new Calendar();
		System.out.println(cal.getWeekDay(1970, 1, 1) == 4);
		System.out.println(cal.getWeekDay(1971, 1, 1) == 5);
		System.out.println(cal.getWeekDay(1972, 1, 1) == 6);
		System.out.println(cal.getWeekDay(1973, 1, 1) == 1);
		System.out.println(cal.getWeekDay(1974, 1, 1) == 2);
		
		cal.registerPlan("2018-08-14", "1st 일정 등록");
		System.out.println(cal.searchPlan("2018-08-14").equals("1st 일정 등록"));
	}
	
	
}
