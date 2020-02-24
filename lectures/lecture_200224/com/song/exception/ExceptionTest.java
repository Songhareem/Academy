package com.song.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("숫자 입력");
			int num = sc.nextInt();
			System.out.println("글자입력");
			String data = sc.next();
			//throw new InputMismatchException();
			
			int result = Integer.parseInt(data);
			System.out.println(result);
			
		} catch(NumberFormatException e) {
			if(e instanceof NumberFormatException)
				System.out.println("NumberFormatException");
			
			//e.printStackTrace();
		} catch(InputMismatchException e ) {
			System.out.println("InputMismatchException");
		} finally {
			
			System.out.println("정상종료");
		}
	}

}
