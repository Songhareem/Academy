package com.song.random;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random rand = new Random();
		int num = rand.nextInt();
		System.out.println(num);
		
		// 0 <= num < input num
		num = rand.nextInt(5);
		System.out.println(num);
	}

}
