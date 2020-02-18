package com.song.t1.ForTest1;

import java.util.Date;
import java.util.Scanner;

public class ForTest1 {

	public static void main(String[] args) {

		// 초입력 :
		// 0 ~ 59초 입력하세요 출력
		// 입력
		// 입력한 숫자와 현재 초가 일치하면 즉시 종료
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==== 초 맞추기 게임 ====");

		while(true) {
			System.out.println("0~59 사이의 숫자를 입력하세요");
			int userSec = sc.nextInt();
			
			if(!(0<=userSec && userSec<=59))
				continue;
			
			int nowSec = new Date().getSeconds();
			
			if(nowSec == userSec) {
				System.out.println("초를 맞췄습니다!");
				break;
			}
			
			System.out.printf("이런! 틀렸네요! 다시 도전~!(현재 초 : %d)\n",nowSec);
		}
		System.out.println("게임이 끝났습니다!");
		sc.close();
	}

}
