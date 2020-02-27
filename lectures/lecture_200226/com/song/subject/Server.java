package com.song.subject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {

		// 클라이언트 접속 후,
		// 1. 점심 메뉴 중 하나 랜덤으로 뽑아서 클라이언트 전송
		// 2. 저녁 메뉴 중 하나를 뽑아서 클라이언트 전송
		// 3. 클라 접속 종료 후, 서버 접속 종료
		
		// 지역변수
		final int PORT = 8282;
		final String IP = "211.238.142.147";
		final String TEST_IP = "211.238.142.213";			
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		// 로직
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server listening | port : 8282 ");
			
			boolean runFlag = true;
			while(runFlag) {
				
				// 클라 받기
				if(socket == null) {
					socket = serverSocket.accept();
					System.out.println("클라이언트 접속");
				}
				
				// 데이터 받기
				String msg = recvData(socket);
				
				switch(msg) {
					case "1": 
					case "2":
						// 점심 메뉴 중 고르기
						// 저녁 메뉴 고르기
						msg = logic(msg);
						break;
					case "3":
						socket = null;
						System.out.println("클라이언트 접속 종료");
						//runFlag = false;
						continue;
					default:
						System.out.println("Err Data!!!");
						continue;
				}
			
				// 데이터 전송
				//System.out.print("is Closed?");
				//System.out.println(socket.isClosed());
				sendData(msg, socket);
			}
			
			socket.close();
			System.out.println("서버를 종료합니다");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
                }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String logic(String msg) {
		
		String result = null;
		String[] lunch = {"Buger-5000", "cake-4000", "bread-3000"};
		String[] dinner = {"stake-10000", "pasta-9000", "soup-7000" };
		int index = new Random().nextInt(3);
		
		if(msg.equals("1")) {
			result = lunch[index];
		} else if(msg.equals("2")){
			result = dinner[index];
		}
		
		return result;
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
		
		return msg;	
	}
	
	public static void sendData(String msg, Socket socket) {
		
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		
		try {
			//System.out.println(socket.isClosed());
			os = socket.getOutputStream();		// byte
			ow = new OutputStreamWriter(os); 	// char
			bw = new BufferedWriter(ow); 		// String
			bw.write(msg + "\r\n"); 			// 보내기
			System.out.println(msg);
			bw.flush();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
