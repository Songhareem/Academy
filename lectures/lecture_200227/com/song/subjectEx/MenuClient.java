package com.song.subjectEx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuClient {

	public static void main(String[] args) {

		// client
		
		String ip = "211.238.142.213";
		int port = 8282;
		Scanner scan = new Scanner(System.in);
		Socket socket = null;
		
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		
		MenuClientUtil mcu = new MenuClientUtil();
		MenuClientView mcv = new MenuClientView();
		ArrayList<MenuVO> mvoList = new ArrayList<MenuVO>();
		
		try {
			socket = new Socket(ip, port);
			System.out.println("==== 서버 접속 성공 ====");
			
			boolean runFlag = true;
			while(runFlag) { 
				System.out.println("1. 점심");
				System.out.println("2. 저녁");
				System.out.println("3. 종료");
				
				String select = scan.next();
				
				os = socket.getOutputStream();		// byte
				ow = new OutputStreamWriter(os); 	// char
				bw = new BufferedWriter(ow); 		// String
				bw.write(select + "\r\n"); 			// 보내기
				bw.flush();
				
				if(select.equals("3")) {
					runFlag = false;
					System.out.println("클라 종료");
					socket.close();
					continue;
				}
				
				is = socket.getInputStream();	// byte
				ir = new InputStreamReader(is); // char
				br = new BufferedReader(ir);    // String
				String str = br.readLine();
				System.out.println(str);
				
				mvoList.add(mcu.makeMenu(str));
			}
			
			mcv.view(mvoList);
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
