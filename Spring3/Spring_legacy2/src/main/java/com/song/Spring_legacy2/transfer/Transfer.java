package com.song.Spring_legacy2.transfer;

public class Transfer {
	
	public void bus(int money) {
		System.out.println("================");
		System.out.println("버스 타기");
		System.out.println("핸드폰 보기");
		System.out.println("================");
	}
	
	public void subway(int money, String line) {
		System.out.println("================");
		System.out.println("지하철 타기");
		System.out.println("신문 보기");
		System.out.println("================");
	}
	
	public void texi() {
		System.out.println("택시 타기");
	}
}
