package com.song.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.song.jdbc.DBConnect;
import com.song.member.MemberDTO;

public class MemberDAO {

		// Update 
		public int updateMemGetSns (MemberDTO MemberDTO) throws Exception {
			
			Connection conn = null;
			PreparedStatement pst = null;
			
			int result = 0;
			
			conn = DBConnect.getConnection();
			
			String sql = "UPDATE Member SET PROSALE = ? WHERE PRONUM = ?";
			
			pst = conn.prepareStatement(sql);
			
			pst.setBoolean(1, MemberDTO.getMemGetSns());
			pst.setLong(2, MemberDTO.getMemNum());
			result = pst.executeUpdate();
			System.out.println(result);
			
			pst.close();
			conn.close();
			
			return result;
		}
		
		// Delete
		public int delete (MemberDTO MemberDTO) throws Exception {
			
			Connection conn = null;
			PreparedStatement pst = null;
			
			int result = 0;
			
			conn = DBConnect.getConnection();
						
			String sql = "DELETE FROM Member WHERE PRONUM = ?";
			
			pst = conn.prepareStatement(sql);
			
			pst.setLong(1, MemberDTO.getMemNum());
			result = pst.executeUpdate();
			System.out.println(result);
			
			pst.close();
			conn.close();
			
			return result;
		}
		
		// Create
		public int insert (MemberDTO MemberDTO) throws Exception {
			
			Connection conn = null;
			PreparedStatement pst = null;
			
			int result = 0;
			
			conn = DBConnect.getConnection();
			
			String sql = "INSERT INTO MEMBER VALUES (?,?,?,?,?,?,?,?,?)";
			
			pst = conn.prepareStatement(sql);
			
			pst.setLong(1, MemberDTO.getMemNum());
			pst.setString(2, MemberDTO.getMemId());
			pst.setString(3, MemberDTO.getMemPw());
			pst.setString(4, MemberDTO.getMemName());
			pst.setString(5, MemberDTO.getMemAddress());
			pst.setString(6, MemberDTO.getMemPhone());
			pst.setString(7, MemberDTO.getMemEmail());
			pst.setBoolean(8, MemberDTO.getMemGetSns());
			pst.setBoolean(9, MemberDTO.getMemGetEmail());
			
			result = pst.executeUpdate();
			
			pst.close();
			conn.close();
			
			return result;
		}
		
		// Read
		public ArrayList<MemberDTO> selectList() throws Exception {
			
			
			Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			
			ArrayList<MemberDTO> mdtoList = new ArrayList<MemberDTO>();
			
			conn = DBConnect.getConnection();
			
			String sql = "SELECT * FROM MEMBER ORDER BY PRONUM ASC";
			
			pst = conn.prepareStatement(sql);
			
			rs = pst.executeQuery();
				
			// rs.next -> 한 row씩 읽어옴 
			// 데이터 있으면 true, 없으면 false return
			// 데이터 있으면 rs에 저장
			while(rs.next()) {
					
				MemberDTO mdto = new MemberDTO();
				mdto.setMemNum(rs.getLong("MEMNUM")); 
				mdto.setMemId(rs.getString("MEMID"));
				mdto.setMemPw(rs.getString("MEMPW"));
				mdto.setMemAddress(rs.getString("MEMADDRESS"));
				mdto.setMemPhone(rs.getString("MEMPHONE"));
				mdto.setMemEmail(rs.getString("MEMEMAIL"));
				mdto.setMemGetSns(rs.getBoolean("MEMGETSNS"));
				mdto.setMemGetEmail(rs.getBoolean("MEMGETEMAIL"));
				
				mdtoList.add(mdto);
			}
			
			rs.close();
			pst.close();
			conn.close();
			
			return mdtoList;
		}
}
