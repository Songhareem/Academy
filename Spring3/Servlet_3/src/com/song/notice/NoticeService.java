package com.song.notice;

import java.sql.Date;
import java.util.ArrayList;

public class NoticeService {

	private NoticeDAO noticeDAO;
	
	public NoticeService() {
		
		noticeDAO = new NoticeDAO();
	}
	
	// SelectAll
	public ArrayList<NoticeDTO> noticeList() throws Exception {
		
		return noticeDAO.noticeList();
	}
	
	// insert
	public int noticeAdd(NoticeDTO noticeDTO) throws Exception {
		
		noticeDTO.setName("관리자");
		noticeDTO.setDate(new Date(System.currentTimeMillis()));
		noticeDTO.setViews(0);
		
		return noticeDAO.noticeAdd(noticeDTO); 
	}
	
	// selectOne
	public NoticeDTO noticeSelect(NoticeDTO noticeDTO) throws Exception {
	
		return noticeDAO.noticeSelect(noticeDTO);
	}
	
	// update
	public int noticeMod(NoticeDTO noticeDTO) throws Exception {
		
		return noticeDAO.noticeMod(noticeDTO);
	}
	
	// delete
	public int noticeDel(NoticeDTO noticeDTO) throws Exception {
		
		return noticeDAO.noticeDel(noticeDTO);
	}
}
