package com.song.chatClinet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientRecv implements Runnable {

	Socket serverSock = null;
	
	InputStream is = null;
	InputStreamReader ir = null;
	BufferedReader br = null;
	
	public ClientRecv(Socket serverSock) {
		
		this.serverSock = serverSock;
	}
	
	public void run() {
		
		while(true) {
			
			if(recvData())
				break;
		}
		// 종료처리
		br = null;
		ir = null;
		is = null;
	}
	
	private boolean recvData() {
		
		try {
			is = this.serverSock.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			String msg = br.readLine();
			
			if(msg.equals("0"))
				return true;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
