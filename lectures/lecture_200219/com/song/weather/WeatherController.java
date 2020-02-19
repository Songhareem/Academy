package com.song.weather;

import java.util.Scanner;

public class WeatherController {

	public void start() {
		
		Scanner sc = new Scanner(System.in);
		
		boolean run = true;
		
		WeatherData wd = new WeatherData();
		WeatherView wv = new WeatherView();
		WeatherVO[] weatherVO = new WeatherVO[4];
		
		while(run) {
			
			System.out.print("1. 날씨정보 초기화\n2. 날씨정보 출력\n");
			System.out.print("3. 날씨정보 검색\n4. 프로그램종료\n선택 : ");
			int in = sc.nextInt();
			
			switch (in) {
			case 1:
				weatherVO = wd.makeInfo();
				break;
			case 2:
				wv.view(weatherVO);
				break;
			case 3:
				WeatherVO tmpVO = WeatherService.search(weatherVO);
				if(tmpVO != null) wv.view(tmpVO);
				break;
			case 4:
				System.out.println("==== 프로그램 종료 ====");
				run = false;
				break;
			default:
				System.out.println("==== 잘못 선택했습니다 ====");
				break;
			}
			
		}
		sc.close();
	}
}
