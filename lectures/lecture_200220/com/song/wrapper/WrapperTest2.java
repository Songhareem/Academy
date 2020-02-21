package com.song.wrapper;

import java.time.LocalDate;

public class WrapperTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//주민번호입력
		//1. 나이를 출력
		//2. 태어난 계절 (3~5 / 6~8 / 9 ~ 11 / 12 ~ 2)
		
		String index = "000208-3111111";
		String userYear = index.substring(0,2);
		String userMon = index.substring(2,4);
		char userGender = index.charAt(7);
		
		// 컴퓨터의 현재 날짜 정보 ex)2018-07-26
		LocalDate currentDate = LocalDate.now();
		
		// 나이 구하기
		int age = currentDate.getYear() - Integer.parseInt(19+userYear) + 1;
		if(userGender == '3' || userGender == '4')
			age -= 100; 
		
		// 태어난 달 구하기
		int birth = Integer.parseInt(userMon);
		String season = null;
		if(3<=birth && birth<=5) {
			season = "봄";
		} else if(6<=birth && birth<=8) {
			season = "여름";
		} else if(9<=birth && birth<=11) {
			season = "가을";
		} else {
			season = "겨울";
		}

		// 출력
		System.out.printf("나이는 : %d세\n", age);
		System.out.printf("태어난 계절은 : %s\n", season);
	}
}
