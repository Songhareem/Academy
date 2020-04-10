package com.song.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.song.point.PointDTO;
import com.song.util.DBConnect;

public class NoticeDAO {
	
	// insert
	public int noticeAdd(NoticeDTO noticeDTO) throws Exception {
		
		Connection conn = DBConnect.getConnect();
		
		String sql = "INSERT INTO notice VALUES (NOTICE_ID.nextval,?,?,?,?,?)";
		
		PreparedStatement pst = conn.prepareStatement(sql);
	
		pst.setString(1, noticeDTO.getSubtitle());
		pst.setString(2, noticeDTO.getName());
		pst.setDate(3, noticeDTO.getDate());
		pst.setInt(4, noticeDTO.getViews());
		pst.setString(5, noticeDTO.getContent());
		
		int result = pst.executeUpdate();
		
		pst.close();
		conn.close();
		
		return result;
	}
	
	// selectAll
	public ArrayList<NoticeDTO> noticeList() throws Exception {
	
		Connection conn = DBConnect.getConnect();
		
		String sql = "SELECT * FROM notice ORDER BY createAt DESC, id DESC";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		
		ResultSet rs = pst.executeQuery();
		
		ArrayList<NoticeDTO> ndtoList = new ArrayList<NoticeDTO>();
		while(rs.next()) {
			
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setId(rs.getInt("id"));
			noticeDTO.setSubtitle(rs.getString("subtitle"));
			noticeDTO.setName(rs.getString("name"));
			noticeDTO.setDate(rs.getDate("createAt"));
			noticeDTO.setViews(rs.getInt("views"));
			noticeDTO.setContent(rs.getString("content"));
			
			ndtoList.add(noticeDTO);
		}
		
		rs.close();
		pst.close();
		conn.close();
		
		return ndtoList;
	}
	
	// selectOne
	public NoticeDTO noticeSelect(NoticeDTO noticeDTO) throws Exception {
		
		Connection conn = DBConnect.getConnect();
		
		String sql = "SELECT * FROM notice WHERE id=?";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		
		pst.setInt(1, noticeDTO.getId());
		
		ResultSet rs = pst.executeQuery();
		
		NoticeDTO ndto = null;
		if(rs.next()) {
			
			ndto = new NoticeDTO();
			ndto.setId(rs.getInt("id"));
			ndto.setSubtitle(rs.getString("subtitle"));
			ndto.setName(rs.getString("name"));
			ndto.setDate(rs.getDate("createAt"));
			ndto.setViews(rs.getInt("views"));
			ndto.setContent(rs.getString("content"));
		}
		
		rs.close();
		pst.close();
		conn.close();
		
		return ndto;
	}

	// update
	public int noticeMod(NoticeDTO noticeDTO) throws Exception {
		
		Connection conn = DBConnect.getConnect();
		
		String sql = "UPDATE notice SET subtitle=?, name=?, views=?, content=? WHERE id=?";
				
		PreparedStatement pst = conn.prepareStatement(sql);
		
		pst.setString(1, noticeDTO.getSubtitle());
		pst.setString(2, noticeDTO.getName());
		pst.setInt(3, noticeDTO.getViews());
		pst.setString(4, noticeDTO.getContent());
		pst.setInt(5, noticeDTO.getId());
		
		int result = pst.executeUpdate();
		
		pst.close();
		conn.close();
		
		return result;
	}
	
	// delete
	public int noticeDel(NoticeDTO noticeDTO) throws Exception {
		
		Connection conn = DBConnect.getConnect();
		
		String sql = "DELETE FROM notice WHERE id = ?";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		
		pst.setInt(1, noticeDTO.getId());
		
		int result = pst.executeUpdate();
		
		pst.close();
		conn.close();
		
		return result;
	}
}
