package com.song.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.song.dbconnect.DBConnect;

public class MemberDAO {

	public int delete(MemberDTO memberDTO)throws Exception{
		
		Connection con = DBConnect.getConnection();
		PreparedStatement st = null;
		int result=0;
		
		String sql = "delete member where memberId=?";
		
		st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getMemberID());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	//Insert
	public int insert(MemberDTO memberDTO)throws Exception{

		Connection con = null;
		PreparedStatement st = null;
		int result=0;
		
		con = DBConnect.getConnection();

		String sql="insert into member values (?,?,?,?,?)";
		
		st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getMemberID());
		st.setString(2, memberDTO.getMemberPW());
		st.setString(3, memberDTO.getMemberName());
		st.setString(4, memberDTO.getMemberPhone());
		st.setString(5, memberDTO.getMemberEmail());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		
		Connection con = DBConnect.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String sql = "select * from member where memberid = ? and memberpw = ?";
		
		st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getMemberID());
		st.setString(2, memberDTO.getMemberPW());
		
		rs = st.executeQuery();
		
		// 로그인 성공
		if(rs.next()) {
			// id 는 이미 같음 memberDTO.setMemberID(rs.getString("memberid"));
			// pw 도 이미 같음 memberDTO.setMemberPW(rs.getString("memberpw"));
			memberDTO.setMemberName(rs.getString("membername"));
			memberDTO.setMemberPhone(rs.getString("memberphone"));
			memberDTO.setMemberPhone(rs.getString("memberemail"));
		} else {
			memberDTO = null;
		}
		
		rs.close();
		st.close();
		con.close();
		
		return memberDTO;
	}
	
	//List
	public ArrayList<MemberDTO> selectList() throws Exception{
		
		Connection con = DBConnect.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
		
		String sql = "select * from member";
		
		st = con.prepareStatement(sql);
		
		rs = st.executeQuery();
		
		while(rs.next()) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setMemberID(rs.getString("memberID"));
			memberDTO.setMemberPW(rs.getString("memberPW"));
			memberDTO.setMemberName(rs.getString("memberName"));
			memberDTO.setMemberPhone(rs.getString("memberPhone"));
			memberDTO.setMemberEmail(rs.getString("memberEmail"));
			ar.add(memberDTO);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}

}
