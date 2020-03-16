package com.song.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	static String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
	static String user = "USER01";
	static String password = "USER01";
	
	static String driver = "oracle.jdbc.driver.OracleDriver";
	
	static public Connection getConnection() throws Exception {
		
		Connection conn = null;
		
		Class.forName(driver);
		
		conn = DriverManager.getConnection(url, user, password);
		if(conn == null)
			System.out.println("Connection Fail");
		
		return conn;
	}
}
