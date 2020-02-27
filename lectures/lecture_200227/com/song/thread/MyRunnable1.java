package com.song.thread;

import java.util.Scanner;

public class MyRunnable1 implements Runnable{

	Scanner sc = new Scanner(System.in);
	
	@Override
	public void run() {
	
		
		while(true) {
			hello();

			try {
				Thread.sleep(1000);
				return;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void hello() {
		System.out.println("hello");
	}
}
