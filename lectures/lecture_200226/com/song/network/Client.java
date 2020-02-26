package com.song.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	// 서버에 연결해서 HelloWorld 전송하고 끝
	
	public static void main(String[] args) {
		
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;			
		Socket socket = null;
		Scanner scan = new Scanner(System.in);
		
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		
		try {
			socket = new Socket("211.238.142.147", 8282);
			
			System.out.println("서버 접속 완료");
			
			boolean runFlag = true;
			
			while(runFlag) {
				
				System.out.printf("메시지 입력[0 입력시, 프로그램이 종료됩니다]\n>>");
				String msg = scan.nextLine();
				
				if(msg.contentEquals("0"))
					System.out.println("종료 요청!");
				
				os = socket.getOutputStream(); // byte
				ow = new OutputStreamWriter(os); // char
				bw = new BufferedWriter(ow); // String
				bw.write(msg + "\r\n"); // 보내기
				bw.flush();

				if(!(msg.contentEquals("0"))) {
					System.out.println("데이터 전송 종료");
				} else {
					runFlag = false;
					continue;
				}
				
				is = socket.getInputStream(); // byte
				ir = new InputStreamReader(is); // char
				br = new BufferedReader(ir); // String

				msg = br.readLine();
					
				System.out.println("답장을 기다립니다~");
				System.out.println("<< " + msg);
				
			}
			
			System.out.println("클라이언트를 종료합니다");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				bw.close();
				ow.close();
				os.close();
				if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
