package com.song.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWrite {

	public void write() {
		
		FileWriter fw = null;
		String str = null;
		
		try {
			str = "sql World\r\n";
			
			// true : 이어 붙이기, false : 덮어쓰기
			fw = new FileWriter("C:\\test\\test2.txt", true);
			fw.write(str);
			
			// 버퍼 비우기
			fw.flush();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void read() {
		
		// 파일의 내용 자바로 출력
		// 1. 파일 정보 읽는 객체 생성
		File file = new File("C:\\test\\test.txt");
		//if(file.exists())
		//	System.out.println("true");
		
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file); 		// byte -> char
			br = new BufferedReader(fr);
			
			String str;
			while((str = br.readLine()) != null) {
				System.out.println(str);
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
}
