package com.song.salgrade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalgradeDAO {

	public void delete(int salgrade) {
		
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String user = "scott";
		String pw = "tiger";
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, user, pw);
			if(conn != null)
				System.out.println("connect success");
			
			String query = "DELETE FROM SALGRADE WHERE GRADE = ?";
			
			pst = conn.prepareStatement(query);
			
			pst.setInt(1, salgrade);
			
			int result = pst.executeUpdate();
			if(result > 0) {
				System.out.printf("%d delete success", result);
			} else {
				System.out.println("delete fail");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void insert(SalgradeDTO sdto) {
		
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String user = "scott";
		String pw = "tiger";
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		try {
			Class.forName(driver);
			
			String query = "INSERT INTO SALGRADE VALUES (?,?,?)";
			
			conn = DriverManager.getConnection(url, user, pw);
			if(conn != null)
				System.out.println("connect success");
			
			pst = conn.prepareStatement(query);
			
			pst.setInt(1, sdto.getGrade());
			pst.setInt(2, sdto.getLosal());
			pst.setInt(3, sdto.getHisal());
			
			int result = pst.executeUpdate();
			if(result > 0) {
				System.out.printf("%d insert success", result);
			} else {
				System.out.println("insert fail");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
