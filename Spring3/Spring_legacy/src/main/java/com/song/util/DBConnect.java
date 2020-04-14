package com.song.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	public static Connection getConnect() throws Exception {
		
		Connection conn = null;
		String user = "user02";
		String password = "user02";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		conn = DriverManager.getConnection(url, user, password);
		if(conn != null)
			System.out.println("Connection Success!");
		
		return conn;
	}
}
