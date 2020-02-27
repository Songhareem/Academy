package com.song.chatClinet;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {

		String ip = "211.238.142.213";
		int port = 8282;
		Socket serverSock = null;
		
		// main 로직 
		Scanner sc = new Scanner(System.in);
		System.out.println("채팅 준비!");
		System.out.print("사용자 닉네임을 적어주세요 : ");
		String name = sc.next();

		try {
			serverSock = new Socket(ip, port);
			System.out.println("========== 채팅 접속 완료 ==========");
			System.out.println("채팅을 끝내고 싶다면 '0'을 입력해주세요!");
			
			// 각 쓰레드 Run()
			Thread[] thread = { new Thread(new ClientRecv(serverSock)),
								new Thread(new ClientSend(serverSock)) };
			
			while(true) {
				Thread.sleep(500);
				if(!thread[0].isAlive() && !thread[1].isAlive())
					break;
			}
			
			System.out.println("========== 채팅 종료 ==========");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Socket close
				if(serverSock != null || !serverSock.isClosed()) {
					serverSock.close();
				}
				// Scanner close
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
