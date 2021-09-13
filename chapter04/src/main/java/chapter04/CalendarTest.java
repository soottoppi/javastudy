package chapter04;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, 2021);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DATE, 25);
		printDate(cal);
		
		cal.set(2021, 8, 13);
		cal.add(Calendar.DATE, 1000);
		printDate(cal);
	}
	
	public static void printDate(Calendar cal) {
		final String[] DAYS = {"일", "월", "화", "수", "목", "금", "토"};
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);	 // 0~11 + 1
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK); // 1(일)~7(토)
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println(
				year + "년 " +
				(month+1) + "월 " +
				date + "일 " +
				DAYS[day-1] + "요일 " +
				hour + "시 " +
				minute + "분 " +
				second + "초"
		);
	}
}
