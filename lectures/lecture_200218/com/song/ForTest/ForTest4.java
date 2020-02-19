package com.song.ForTest;

import java.util.Scanner;

public class ForTest4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 연산자만 사용
		// 계산식을 만들기

		for (int i = 0; i < 13; i++) {
			// System.out.print("수식만들기 입력 :");
			// int n = sc.nextInt();

			int n = i;
			// 방법1
			// System.out.printf("%2d %2d\n",n,n/4*10 + n%4);
			System.out.println(n + (n / 4 * 6));
			// if(n == 0)
			// break;
		}

		sc.close();

	}

}
