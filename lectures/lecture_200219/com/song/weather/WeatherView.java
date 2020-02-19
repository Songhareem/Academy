package com.song.weather;

public class WeatherView {

	public void view(WeatherVO[] weathers) {
		
		// 기능 출력
		System.out.println("==== 날씨정보 출력 ====");
		
		for(int i=0; i<weathers.length; i++) {
			System.out.printf("%s %s %s %s\n",
					weathers[i].getLocalName(),weathers[i].getDegree(),
					weathers[i].getClimate(),weathers[i].getHumidity());
		}
	}
	
	public void view(WeatherVO tmpVO) {
		
		System.out.printf("검색 결과 : %s %s %s %s\n",
				tmpVO.getLocalName(), tmpVO.getDegree(),
				tmpVO.getClimate(), tmpVO.getHumidity());
	}
}
