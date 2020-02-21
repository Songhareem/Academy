package com.song.thead;

public class threadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable[] r = new Runnable[2];
		r[0] = new Thread1();
		r[1] = new Thread2();
		
		Thread t1 = new Thread(r[0]);
		Thread t2 = new Thread(r[1]);
		
		t1.start();
		t2.start();
	}
}

class Thread1 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0; i<5; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}

class Thread2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0; i<5; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}