package com.song.exception;

import java.util.Scanner;

public class ExceptionData {

	Scanner sc = new Scanner(System.in);

	public void test(int[] arr) throws ArrayIndexOutOfBoundsException {
		System.out.println(arr[1]);
	}

	public void test2() throws Exception { 
		System.out.println("숫자를 입력");
		int num = sc.nextInt();
		
		int num2 = 10;
		int result = num2 - num;
		
		if(result < 0) {
			throw new MyException("음수는 안돼요");
		}
	}
}
