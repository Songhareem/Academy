package com.song.StringAPI;

public class StringTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String data = "Song,20,Han_18,Choi_17";
		
		String replaced = data.replace("_",",");
		
		String[] parsed = replaced.split(",");
		
		for (String string : parsed) {

		System.out.println(string);
	
		}
	}
}
