package com.song.thread;

public class MyRunnable2 implements Runnable {

	@Override
	public void run() {
		
		while(true) {
			world();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void world() {
		
		System.out.println("world");
	}
}
