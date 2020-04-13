package com.song.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.song.util.DBConnect;

public class MemberDAO {

	// memberJoin (Insert)
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		
		Connection conn = DBConnect.getConnect();
		
		String sql = "INSERT INTO member VALUES (?,?,?,?,?,?)";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		
		pst.setString(1, memberDTO.getId());
		pst.setString(2, memberDTO.getPw());
		pst.setString(3, memberDTO.getName());
		pst.setInt(4, memberDTO.getAge());
		pst.setString(5, memberDTO.getEmail());
		pst.setString(6, memberDTO.getPhone());
	
		System.out.println("join before");
		int result = pst.executeUpdate();
		System.out.println("join after");
	
		pst.close();
		conn.close();
		
		return result;
	}
	
	// memberLogin (Select One)
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		
		Connection conn = DBConnect.getConnect();
		
		String sql = "SELECT * FROM member WHERE id = ?  AND pw=?";
		
		PreparedStatement pst = conn.prepareStatement(sql);
	
		pst.setString(1, memberDTO.getId());
		pst.setString(2, memberDTO.getPw());
		
		ResultSet rs = pst.executeQuery();
		
		if(rs.next() == false) {
			System.out.println("memberLogin result : NULL");
			return null;
		}
		
		memberDTO.setName(rs.getString("name"));
		memberDTO.setAge(rs.getInt("age"));
		memberDTO.setEmail(rs.getString("email"));
		memberDTO.setPhone(rs.getString("phone"));
		
		rs.close();
		pst.close();
		conn.close();
		
		return memberDTO;
	}
	
	// memberUpdate (Update)
	public int memberUpdate(MemberDTO memberDTO) throws Exception {
		
		Connection conn = DBConnect.getConnect();
		
		String sql = "UPDATE member SET pw=?, name=?, age=?, email=?, phone=? WHERE id=?";
	
		PreparedStatement pst = conn.prepareStatement(sql);
		
		pst.setString(1, memberDTO.getPw());
		pst.setString(2, memberDTO.getName());
		pst.setInt(3, memberDTO.getAge());
		pst.setString(4, memberDTO.getEmail());
		pst.setString(5, memberDTO.getPhone());
		pst.setString(6, memberDTO.getId());
		
		int result = pst.executeUpdate();
		
		pst.close();
		conn.close();
		
		return result;
	}
	
	// memberDelete (Delete)
	public int memberDelete(MemberDTO memberDTO) throws Exception {
		
		Connection conn = DBConnect.getConnect();
		
		String sql = "DELETE FROM member WHERE id = ?";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		
		pst.setString(1, memberDTO.getId());
		
		int result = pst.executeUpdate();
		
		pst.close();
		conn.close();
		
		return result;
	}
}
