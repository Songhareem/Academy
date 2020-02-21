package com.song.StringAPI;

public class Card {

	public static int width = -1;
	public static int height = -1;
	
	private String kind = "";
	private String color = "";
	private int num = 0;
	
	public static void sizeInit() {
		
		if(width != -1 && height != -1)
			return;
		
		width = 62;
		height = 88;
	}
	
	public Card(String kind, String color, int num) {
		
		this.kind = kind;
		this.color = color;
		this.num = num;
	}
	
	public void InstanceMethod() {
		System.out.println(kind);
		System.out.println(Card.width);
		Card.classMethod();
	}
	
	public static void classMethod() {
		
	}
}
