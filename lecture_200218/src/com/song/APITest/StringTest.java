package com.song.APITest;

import java.util.Scanner;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		String result = "여성입니다";
		
		String name = "920208-1000000";
		
		//System.out.print("'-'을 포함하여 주민번호를 입력하세요 ");
		//name = sc.next();
		//if('1' == name.charAt(7))
		//	result = "남성입니다";
		
		//System.out.println(name.substring(7,8));
		if((name.substring(7,8)).equals("1"))
			result = "남성입니다";
		System.out.println(result);
		
		// fileName, 이미지파일인지 판별
		// jpg, gif, png
		String fileName = "image.jpg";
		String isImage = "이미지가 아님"; 
		int isJpg = fileName.lastIndexOf(".jpg");
		int isGif = fileName.lastIndexOf(".gif");
		int isPng = fileName.lastIndexOf(".png");
		
		if(isJpg != -1 || isGif != -1 || isPng != -1) {
			isImage = "이미지가 맞음";
		}
		
		System.out.println(isImage);
	}

}
