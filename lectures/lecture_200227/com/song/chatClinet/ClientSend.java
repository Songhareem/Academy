package com.song.chatClinet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSend implements Runnable {

	private Socket serverSock = null;
	
	OutputStream os = null;
	OutputStreamWriter ow = null;
	BufferedWriter bw = null;
	
	public ClientSend(Socket serverSock) {
		this.serverSock = serverSock;
	}
	
	// 입력 후, Send
	public void run() {
		
		while(true) {
		
			if(sendData())
				break;
		}
		// 종료처리
		bw = null;
		ow = null;
		os = null;
		serverSock = null;
	}

	private boolean sendData() {
		
		try {
			System.out.print(">> ");
			Scanner sc = new Scanner(System.in);
			String msg = sc.nextLine();
			
			if(msg.equals("0"))
				return true;
			
			os = this.serverSock.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			bw.write(msg);
			bw.flush();
					
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
