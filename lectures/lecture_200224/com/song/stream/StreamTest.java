package com.song.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamTest {

	public void keyInput() throws Exception {
		// 키보드 연결 (1byte read)
		InputStream is = System.in;
		System.out.print("입력 : ");
		// 문자 to 정수
		int i = is.read();
		// 정수 to 문자
		char c = (char)i;
		System.out.println(c);
		
		// 키보드 자원 반납
		is.close();
	}
	
	public void keyInput2() throws IOException {
		System.out.print("입력 : ");
		InputStream is = System.in;
		InputStreamReader ir = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(ir);
		
		String str = br.readLine();
		
		System.out.println(str); 
		
		br.close();
		ir.close();
		is.close();
	}
}
