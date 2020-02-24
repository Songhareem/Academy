package com.song.exception;

public class ExceptionTest3 {

	public static void main(String[] args) {

		ExceptionData ed = new ExceptionData();
		
		try {
			ed.test2();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
