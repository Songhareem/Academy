package com.song.tokenizer;

import java.util.StringTokenizer;

import com.song.weather.WeatherVO;

public class StringTokenizerTest {

	public static void main(String[] args) {

		// 문자열 파서 클래스
		/*
		 * StringTokenizer st = new StringTokenizer("this is tokenizer");
		 * while(st.hasMoreTokens()) { System.out.println(st.nextToken()); }
		 */
	
		StringBuffer sb = new StringBuffer();
		
		sb.append("seoul,28도,눈,60%,");
		sb.append("jeju,35도,비,90%,");
		sb.append("busan,-52도,흐림,30%,");
		sb.append("incheon,40도,맑음,10%,");
		
		StringTokenizer st = new StringTokenizer(sb.toString(), ",");
		while(st.hasMoreTokens()) {
			WeatherVO wv = new WeatherVO();
			wv.setLocalName(st.nextToken());
			wv.setDegree(st.nextToken());
			wv.setClimate(st.nextToken());
			wv.setHumidity(st.nextToken());
		}
	}

}
