package com.song.weather;

import java.util.Scanner;

public class WeatherService {

	public static WeatherVO search(WeatherVO[] wv) {
		
		WeatherVO tmpWv = null;
		
		System.out.println("==== 날씨정보 검색 ====");
		System.out.print("검색할 도시 :");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		for(int i=0; i<wv.length; i++) {
			
			if(wv[i] == null) {
				System.out.println("초기화를 먼저 해주세요!");
				return null;
			}
				
			if(wv[i].getLocalName().equals(str)) {
				tmpWv = wv[i];
				break;
			}
		}
		
		return tmpWv;
	}
}
