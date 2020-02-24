package com.song.calendar;

import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CalenderTest2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// 예제 1
		System.out.println("생년월일을 입력해주세요(ex : 920208) : ");
		String birth = sc.next();
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, Integer.parseInt(birth.substring(0, 2))+1900);
		cal.set(Calendar.MONTH, Integer.parseInt(birth.substring(2, 4))-1);
		cal.set(Calendar.DATE, Integer.parseInt(birth.substring(4, 6)));
		
		System.out.println(cal.getTime());

		// 예제 2
		System.out.println("생년월일을 입력해주세요(ex : 1992-02-08) : ");
		String[] birthInfo = sc.next().split("-");
		
		cal.set(Calendar.YEAR, Integer.parseInt(birthInfo[0]));
		cal.set(Calendar.MONTH, Integer.parseInt(birthInfo[1])-1);
		cal.set(Calendar.DATE, Integer.parseInt(birthInfo[2]));

		System.out.println(cal.getTime());

		// 예제 3
		System.out.println("생년월일을 입력해주세요(ex : 1992-02-08) : ");
		String birthStr = sc.next();
		StringTokenizer st = new StringTokenizer(birthStr,"-");
		
		cal.set(Calendar.YEAR, Integer.parseInt(st.nextToken()));
		cal.set(Calendar.MONTH, Integer.parseInt(st.nextToken())-1);
		cal.set(Calendar.DATE, Integer.parseInt(st.nextToken()));

		System.out.println(cal.getTime());
		
		
		sc.close();
	}

}
