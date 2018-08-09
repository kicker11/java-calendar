package garam.calendar;

public class Calendar {

	public static final int[] maxDayOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static final int[] maxDayOfMonthLeap = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public String[] calMon = new String[37];
	public int idxOfDays = 0;

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
			return maxDayOfMonthLeap[mon - 1];
		} else {
			return maxDayOfMonth[mon - 1];
		}
	}

	public void setInitVal(int year, int month, String day) {

		switch (day) {
		case "MO":
			setSpace(2);
			idxOfDays = 2;
			break;
		case "TU":
			setSpace(3);
			idxOfDays = 3;
			break;
		case "WE":
			setSpace(4);
			idxOfDays = 4;
			break;
		case "TH":
			setSpace(5);
			idxOfDays = 5;
			break;
		case "FR":
			setSpace(6);
			idxOfDays = 6;
			break;
		case "ST":
			setSpace(7);
			idxOfDays = 7;
			break;
		default:
			setSpace(1);
			idxOfDays = 1;
			break;
		}

		int maxArrayLength = (getMaxDaysOfMonth(year, month) + idxOfDays);
		for (int j = idxOfDays; j < maxArrayLength; j++) {
			calMon[j] = String.valueOf((j + 1) - idxOfDays);
		}
	}

	public void calPrint(int year, int mon, String inValDay) {
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

}
