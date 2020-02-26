package com.song.subject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Client {

	public static void main(String[] args) {

		// 서버접속
		// 1. 점심 메뉴
		// 2. 저녁 메뉴
		// 3. 종 료
		
		// 지역변수
		final int PORT = 8282;
		final String IP = "211.238.142.214";
		final String TEST_IP = "211.238.142.213";			
		Socket socket = null;
	
		HashMap<String, Integer> strMap = new HashMap<String, Integer >();
		Iterator<String> iter = null;
		int total = 0;
		
		// 로직
		try {
			//socket = new Socket(IP, PORT);
			socket = new Socket(TEST_IP, PORT);
			System.out.println("서버 접속 완료");
			
			boolean runFlag = true;
			while(runFlag) {
				
				String msg = selectData();
				
				switch(msg) {
					case "1": 
					case "2":
						sendData(msg, socket);
						break;
					case "3":
						sendData(msg, socket);
						runFlag = false;
						continue;
					default:
						System.out.println("잘못된 선택입니다 다시 선택해주세요");
						continue;
				}
			
				String result = recvData(socket);
				logic(result, strMap);				
			}
			
			System.out.println("클라이언트를 종료합니다");

			iter = strMap.keySet().iterator();
			while(iter.hasNext()) {
				total += strMap.get(iter.next());
			}
			
			System.out.println("합계 : " + total);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void logic(String result, HashMap<String, Integer> strMap) {
		
		StringTokenizer st = new StringTokenizer(result, "-");
		
		while(st.hasMoreTokens()) {
			
			String food = st.nextToken();
			int pay = Integer.parseInt(st.nextToken());
			
			if(!strMap.containsKey(food)) {
				strMap.put(food, pay);
				return;
			}
			
			pay += strMap.get(food);
			strMap.put(food, pay);
		}
	}
	
	public static String recvData(Socket socket) {
		
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		String msg = null;
		try {
			is = socket.getInputStream();	// byte
			ir = new InputStreamReader(is); // char
			br = new BufferedReader(ir);    // String
			
			msg = br.readLine();

		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		// 받은 음식 출력
		System.out.println(msg);
		
		return msg;
	}
	
	public static void sendData(String msg, Socket socket) {
		
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		
		try {
			os = socket.getOutputStream();		// byte
			ow = new OutputStreamWriter(os); 	// char
			bw = new BufferedWriter(ow); 		// String
			bw.write(msg + "\r\n"); 			// 보내기
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		System.out.print("<< ");
	}
	
	public static String selectData() {
		
		String msg = null;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("서비스를 선택해주세요");
		System.out.println("1. 점심 메뉴");
		System.out.println("2. 저녁 메뉴");
		System.out.println("3. 프로그램 종료");
		System.out.print(">> ");
		msg = scan.nextLine();
		
		return msg;
	}
}
