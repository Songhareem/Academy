package com.song.math;

public class MathTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Math.random (0.000000 ~ 1.0000000)
		double d = Math.random()*99.9;
		System.out.printf("%.1f",d);
		
		//Math.floor, Math.ceil, Math.round
		System.out.println(Math.floor(10.7));
		System.out.println(Math.ceil(10.7));
		System.out.println(Math.round(10.7));
	}

}
