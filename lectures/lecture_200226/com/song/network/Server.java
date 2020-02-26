package com.song.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	
	// 클라에서 문자열 받아서 출력하고 종료
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		Scanner scan = new Scanner(System.in);
		
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		
		try {
			serverSocket = new ServerSocket(8282);
			System.out.println("Server listening | port : 8282 ");
			clientSocket = serverSocket.accept();
			System.out.println("클라이언트 연결 성공");
			
			boolean runFlag = true;
			while(runFlag) {
				
				is = clientSocket.getInputStream();		// byte
				ir = new InputStreamReader(is);			// char
				br = new BufferedReader(ir);			// String
				
				String msg = br.readLine();
				
				if(msg.equals("0")) {
					clientSocket.close();
					System.out.println("클라이언트가 종료했습니다!");
					runFlag = false;
					continue;
				}
				
				System.out.println("<< " + msg);
				
				System.out.print("답장할 메시지 입력\n>> ");
				
				msg = scan.nextLine();
				
				os = clientSocket.getOutputStream();// byte
				ow = new OutputStreamWriter(os);	// char
				bw = new BufferedWriter(ow);		// String
				bw.write(msg+"\r\n");				// 보내기
				bw.flush();
				
				System.out.println("답장을 보냈습니다");
			}
			
			System.out.println("서버를 종료합니다");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				ir.close();
				br.close();
				clientSocket.close();
				if(serverSocket != null && !serverSocket.isClosed())
					serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
