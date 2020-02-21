package com.song.StringBufferTest;

public class StringBufferTest {

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer("samsung");
		// 참조변수 출력시, 내부에서 toString() 호출
		System.out.println(sb);
		
		//delete
		StringBuffer sb2 = sb.delete(1,3);
		System.out.println(sb2);
		System.out.println(sb2.deleteCharAt(2));
		
		// insert
		sb = sb.insert(1,"google");
		System.out.println(sb);
	}
}
