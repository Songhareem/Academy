package com.song.weather;

public class WeatherData {

	private String data;
	WeatherVO[] weather;	
	int factor;
	public WeatherData() {
	
		factor = 4;	// 데이터 한 덩어리에 들어가있는 각 갯수
		data="seoul    ,28도,눈,60%,"
				+ "   jeju,35도,비,90%,"
				+ "busan,-52도,흐림,30%,"
				+ "incheon,40도,맑음,10%,";
	}
	
	public WeatherVO[] makeInfo() {
		
		// 기능 출력
		System.out.println("==== 초기화 ====");
		
		// 데이터 쪼개기
		String[] tmp = data.split(",");
		
		// 각 단어 앞뒤 공백제거
		for(int i=0; i<tmp.length; i++)
			tmp[i] = tmp[i].trim();
		
		// weather 메모리 세팅
		int localNum = tmp.length/factor;
		weather = new WeatherVO[localNum];
		
		for(int i=0; i<factor; i++) {
			weather[i] = new WeatherVO(); 			
		}
		
		// weather에 data input
		for (int i=0; i<tmp.length; i++) {
		
			int assign = i%localNum;
			int VOIndex = i/localNum;
			
			switch(assign) {
				case 0:
					weather[VOIndex].setLocalName(tmp[i]);
					break;
				case 1:
					weather[VOIndex].setDegree(tmp[i]);
					break;
				case 2:
					weather[VOIndex].setClimate(tmp[i]);
					break;
				case 3:
					weather[VOIndex].setHumidity(tmp[i]);
					break;
				default:
					break;
			}
			
		}
		
		// return weather
		return this.weather;
	}
}
