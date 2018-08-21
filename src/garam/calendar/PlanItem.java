package garam.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {
	public Date planDate;
	public String detail;
	public String peoples = "";

	public PlanItem(String date, String detail) {
		this.planDate = getDatefromString(date);
		this.detail = detail;
	}

	public void addPeople(String name) {
		peoples += name + ", ";
	}

	public Date getDate() {
		return planDate;
	}

	public static Date getDatefromString(String strDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-mm-dd").parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
