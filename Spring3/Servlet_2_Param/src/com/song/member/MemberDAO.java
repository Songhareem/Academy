package com.song.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.song.util.DBConnect;

public class MemberDAO {
	
	// insert
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		
		Connection conn = null;
		PreparedStatement pst = null;
		String sql = null;
		int result=0;
		
		conn = DBConnect.getConnection();
		
		sql="insert into member values (?,?,?,?,?,?)";
		
		pst = conn.prepareStatement(sql);
		
		pst.setString(1, memberDTO.getId());
		pst.setString(2, memberDTO.getPw());
		pst.setString(3, memberDTO.getName());
		pst.setInt(4, memberDTO.getAge());
		pst.setString(5, memberDTO.getEmail());
		pst.setString(6, memberDTO.getPhone());
		
		result = pst.executeUpdate();
		
		pst.close();
		conn.close();
		
		//return 0;
		return result;
	}
}
