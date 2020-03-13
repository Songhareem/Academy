package com.song.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.song.dept.DeptDTO;

public class ProductDAO {

	// ===================
	// CRUD
	// ===================
	
	// Update 
	public int updateProSale (ProductDTO productDTO) throws Exception {
		
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String user = "USER01";
		String password = "USER01";
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		int result = 0;
		
		Class.forName(driver);
		
		conn = DriverManager.getConnection(url, user, password);
		if(conn == null) {
			System.out.println("connect fail");
			return -1;
		}
		
		String sql = "UPDATE PRODUCT SET PROSALE = ? WHERE PRONUM = ?";
		
		pst = conn.prepareStatement(sql);
		
		pst.setInt(1, productDTO.getProSale());
		pst.setString(2, productDTO.getProNum());
		result = pst.executeUpdate();
		System.out.println(result);
		
		pst.close();
		conn.close();
		
		return result;
	}
	
	// Delete
	public int delete (ProductDTO productDTO) throws Exception {
		
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String user = "USER01";
		String password = "USER01";
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		int result = 0;
		
		Class.forName(driver);
		
		conn = DriverManager.getConnection(url, user, password);
		if(conn == null) {
			System.out.println("connect fail");
			return -1;
		}
		
		String sql = "DELETE FROM PRODUCT WHERE PRONUM = ?";
		
		pst = conn.prepareStatement(sql);
		
		pst.setString(1, productDTO.getProNum());
		result = pst.executeUpdate();
		System.out.println(result);
		
		pst.close();
		conn.close();
		
		return result;
	}
	
	// Create
	public int insert (ProductDTO productDTO) throws Exception {
		
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String user = "USER01";
		String password = "USER01";
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		int result = 0;
		
		Class.forName(driver);
		
		conn = DriverManager.getConnection(url, user, password);
		if(conn == null) {
			System.out.println("connect fail");
			return -1;
		}
		
		String sql = "INSERT INTO PRODUCT VALUES (?,?,?,?,?)";
		
		pst = conn.prepareStatement(sql);
		
		pst.setString(1, productDTO.getProNum());
		pst.setString(2, productDTO.getProName());
		pst.setString(3, productDTO.getProComment());
		pst.setDouble(4, productDTO.getProRate());
		pst.setInt(5, productDTO.getProSale());
		
		result = pst.executeUpdate();
		
		pst.close();
		conn.close();
		
		return result;
	}
	
	// Read
	public ArrayList<ProductDTO> selectList() throws Exception {
		
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String user = "USER01";
		String password = "USER01";
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		ArrayList<ProductDTO> pdtoList = new ArrayList<ProductDTO>();
		
		
		Class.forName(driver);
		
		conn = DriverManager.getConnection(url, user, password);
		if(conn == null) {
			System.out.println("connect fail");
			return null;
		}	
		
		String sql = "SELECT * FROM PRODUCT ORDER BY PRONUM ASC";
		
		pst = conn.prepareStatement(sql);
		
		rs = pst.executeQuery();
			
		// rs.next -> 한 row씩 읽어옴 
		// 데이터 있으면 true, 없으면 false return
		// 데이터 있으면 rs에 저장
		while(rs.next()) {
				
			ProductDTO pdto = new ProductDTO();
			pdto.setProNum(rs.getString("PRONUM")); 
			pdto.setProName(rs.getString("PRONAME"));
			pdto.setProComment(rs.getString("PROCOMMENT"));
			pdto.setProRate(rs.getDouble("PRORATE"));
			pdto.setProSale(rs.getInt("PROSALE"));
			
			pdtoList.add(pdto);
		}
		
		rs.close();
		pst.close();
		conn.close();
		
		return pdtoList;
	}
}
