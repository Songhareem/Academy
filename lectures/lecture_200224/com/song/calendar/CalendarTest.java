package com.song.calendar;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		System.out.println(cal);

		System.out.print(cal.get(cal.YEAR)+"-");
		System.out.print(cal.get(cal.MONTH) + 1);
		System.out.println("-" + cal.get(cal.DATE));
		
		System.out.print(cal.get(cal.HOUR)+":");
		System.out.print(cal.get(cal.MINUTE)+":");
		System.out.print(cal.get(cal.SECOND)+":");
		System.out.println(cal.get(cal.MILLISECOND));
	
		System.out.println(cal.get(cal.DAY_OF_WEEK));
		
		System.out.println(cal.getTime());
		
		cal.set(Calendar.YEAR, 2060);
		cal.set(Calendar.MONTH, 2);
		cal.set(Calendar.DATE, 23);
		System.out.println(cal.getTime());
		
		// 현시간을 밀리세컨드로 변환(기준날(1970-01-01)로부터 현재 날짜까지)
		System.out.println(cal.getTimeInMillis());
		System.out.println(cal.get(Calendar.DATE));
		
		// millis to calendar
		cal.setTimeInMillis(cal.getTimeInMillis());
		System.out.println(cal.getTime());
		
		// roll
		cal.roll(Calendar.MINUTE, 30);
		System.out.println(cal.getTime());
		
		// add
		cal.add(Calendar.MINUTE, 30);
		System.out.println(cal.getTime());
		
	}
}
