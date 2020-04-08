package com.song.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.song.util.DBConnect;

public class PointDAO {
	
	// 1. List
	public ArrayList<PointDTO> pointList() throws Exception {
		
		Connection conn = DBConnect.getConnect();
		
		String sql = "SELECT * FROM point ORDER BY NUM ASC";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		
		ResultSet rs = pst.executeQuery();

		ArrayList<PointDTO> pdtoList = new ArrayList<PointDTO>();
		while(rs.next() == true) {
			PointDTO pointDTO = new PointDTO();
			
			pointDTO.setName(rs.getString("name"));
			pointDTO.setNum(rs.getInt("num"));
			pointDTO.setKor(rs.getInt("kor"));
			pointDTO.setEng(rs.getInt("eng"));
			pointDTO.setMath(rs.getInt("math"));
			pointDTO.setTotal(rs.getInt("total"));
			pointDTO.setAvg(rs.getDouble("average"));
			
			pdtoList.add(pointDTO);
		}
		
		rs.close();
		pst.close();
		conn.close();
		
		return pdtoList;
	}
	
	// 2. SelectOne
	public PointDTO pointSelect(PointDTO pointDTO) throws Exception {
		
		Connection conn = DBConnect.getConnect();
		
		String sql = "SELECT * FROM point WHERE num = ?";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		
		pst.setInt(1, pointDTO.getNum());
		
		ResultSet rs = pst.executeQuery();
		
		PointDTO pdto = null;
		if(rs.next() == false) {
			System.out.println("pointSelect result : NULL");
			return pdto;
		}
		
		pdto = new PointDTO();
		
		pdto.setName(rs.getString("name"));
		pdto.setNum(rs.getInt("num"));
		pdto.setKor(rs.getInt("kor"));
		pdto.setEng(rs.getInt("eng"));
		pdto.setMath(rs.getInt("math"));
		pdto.setTotal(rs.getInt("total"));
		pdto.setAvg(rs.getDouble("average"));
		
		rs.close();
		pst.close();
		conn.close();
		
		return pdto;
	}
	
	// 3. Insert
	
	// 4. Update
	
	// 5. Delete
	public int pointDel(PointDTO pointDTO) throws Exception {
		
		Connection conn = DBConnect.getConnect();
		
		String sql = "DELETE FROM point WHERE num = ?";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		
		pst.setInt(1, pointDTO.getNum());
		
		int result = pst.executeUpdate();
		
		pst.close();
		conn.close();
		
		return result;
	}
}
