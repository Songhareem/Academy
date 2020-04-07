package com.song.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	/*
	 * // DBConnection test
	 * public static void main(String[] args) {
	 * 
	 * try { Connection conn = DBConnect.getConnection(); } catch (Exception e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } }
	 */
	
	static public Connection getConnection() throws Exception {

		// 1. 로그인 정보 준비
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String user = "user02";
		String password = "user02";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		
		// 2. 드라이버를 메모리에 로딩
		Class.forName(driver);
		
		// 3. DB 연결 후, Connection 반환
		Connection conn = null;
		conn = DriverManager.getConnection(url, user, password);
		if(conn != null)
			System.out.println("Connection Success!");
		
		return conn;
	}
}
