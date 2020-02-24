package com.song.subject;

import java.util.ArrayList;
import java.util.HashSet;

public class gacha {

	public static void main(String[] args) {

		// UR	5%
		// SSR	10%
		// SR	15%
		// R	20%
		// N	50%
		final int[] PERCENT = {5, 10, 15, 20, 50};
		
		ArrayList<Integer> intList = new ArrayList<Integer>();
		HashSet<Integer> intSet = new HashSet<Integer>();
		
		// 값넣기
		// 1 5개
		// 2 10개
		// 3 15개
		// 4 20개
		// 5 50개
		for(int index = 0; index<PERCENT.length; index++) {
			for (int i = 0; i < PERCENT[index]; i++) {
				intList.add(index + 1);
			}
		}
		
		// 랜덤값 생성
		while(true) {
		
			// 랜덤값 받기
			int rand = (int)(Math.random()*100);
			
			// 랜덤 순서값 저장
			int setSize = intSet.size();
			intSet.add(rand);
			
			if(setSize != intSet.size()) {
				
				int result = intList.get(rand);
				
				switch(result) {
				case 1:
					System.out.println("UR");
					break;
				case 2:
					System.out.println("SSR");
					break;
				case 3:
					System.out.println("SR");
					break;
				case 4:
					System.out.println("R");
					break;
				case 5:
					System.out.println("N");
					break;
				}
			}
				
			if(intSet.size()>=100)
				break;
		}
	}
}
