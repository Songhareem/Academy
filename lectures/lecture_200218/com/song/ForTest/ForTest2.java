package com.song.ForTest;

import java.util.Scanner;

public class ForTest2 {

	public static void main(String[] args) {

		// 분 초 입력
		// 0분 0초 ~ 59분 59초 출력
		// 입력한 분과 초가 맞으면 그 즉시 종료

		Scanner sc = new Scanner(System.in);

		System.out.println("==== 분 초 출력 ====");

		while (true) {
			System.out.println("분을 입력하세요 [0~59초 사이의 숫자]");
			int userMin = sc.nextInt();
			if (!(0 <= userMin && userMin <= 59))
				continue;

			System.out.println("초를 입력하세요 [0~59초 사이의 숫자]");
			int userSec = sc.nextInt();
			if (!(0 <= userSec && userSec <= 59))
				continue;

			for (int i = 0; i <= userMin * 60 + userSec; i++) {

				int min = i / 60;
				int sec = i % 60;

				System.out.printf("%2d분 %2d초\n", min, sec);
			}

			break;
		}
		System.out.println("출력끝!");
		sc.close();
	}

}
