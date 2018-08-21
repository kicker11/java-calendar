package garam.calendar;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

public class Calendar {

	public static final int[] maxDayOfMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static final int[] maxDayOfMonthLeap = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public String[] calMon = new String[37];
	public int idxOfDays = 0;

	private HashMap<Date, PlanItem> planMap;

	public Calendar() {
		planMap = new HashMap<Date, PlanItem>();
	}

	/**
	 * 
	 * @param date ex: "2018-08-14"
	 * @param plan ex:
	 * @throws ParseException
	 */
	public void registerPlan(String strDate, String plan) throws ParseException {
		// Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);

		PlanItem p = new PlanItem(strDate, plan);
		planMap.put(p.getDate(), p);
	}

	public PlanItem searchPlan(String strDate) {
		Date date = PlanItem.getDatefromString(strDate);
		return planMap.get(date);
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

		// get weekday automatically
		int weekday = getWeekDay(year, mon, 1);

		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}

		int maxDay = getMaxDaysOfMonth(year, mon);
		int count = 7 - weekday;
		int delim = (count < 7) ? count : 0;

		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();

		count++;
		for (int i = count; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == delim) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
	}

	private int getWeekDay(int year, int month, int day) {
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4; // 1970/JAN/1ST = Thursday

		int count = 0;

		for (int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}

		for (int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}

		count += day - 1;

		int weekday = (count + STANDARD_WEEKDAY) % 7;
		return weekday;

	}

}
