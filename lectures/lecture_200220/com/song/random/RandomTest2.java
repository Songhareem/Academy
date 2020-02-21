package com.song.random;

import java.util.Arrays;
import java.util.Random;

public class RandomTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// lotto 번호 랜덤 뽑기
		Random rand = new Random();
		int lottoNum[] = new int[] {0, 0, 0, 0, 0, 0, 0};

		while(true) {
		
			if(lottoNum[lottoNum.length-1] != 0) {
				//System.out.println("break;");
				break;				
			}
			
			// 새 로또 값
			int tmp = rand.nextInt(45)+1;
			
			for(int i=0; i<lottoNum.length; i++) {

				// 들어간 값과 새 값이 같다면
				if(lottoNum[i] == tmp) {
					//System.out.println("inner break;");
					break;
				}
				
				// 로또 값
				if(lottoNum[i] == 0) {
					lottoNum[i] = tmp;
					break;
				}
			}
		}
		
		Arrays.sort(lottoNum, 0, lottoNum.length-1);
		System.out.print("이번 로또 번호는! : ");
		for(int i=0; i<lottoNum.length; i++)
			System.out.printf("%d ",lottoNum[i]);
		System.out.println();
	}
}
