package com.song.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("숫자 입력");
			int num = sc.nextInt();
			
			int result = 15/num; 
			System.out.println(result);
			
		} catch(Exception e) {
			if(e instanceof InputMismatchException) {
				System.out.println("InputMismatchException");
			} else if(e instanceof ArithmeticException) {
				System.out.println("ArithmeticException");
			} else {
				System.out.println("다른 에러인가베");
			}
			
			// 제품 납품 직전까지 놔두셍!
			System.out.println(e.getMessage());
		}
	}

}
