package com.song.thread;

public class threadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Thread[] thread = { new Thread(new MyRunnable1()), 
							new Thread(new MyRunnable2()) };
		
		thread[0].start();
		thread[1].start();
	}
}
