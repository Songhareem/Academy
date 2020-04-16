package com.song.Spring_legacy2.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.song.Spring_legacy2.AbstractTestCase;

public class NoticeDAOTest extends AbstractTestCase{

	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
//	public void daoIsNull() throws Exception{
//		assertNotNull(noticeDAO);
//	}
//	
//	@Test
//	public void boardWriteTest() throws Exception{
//	
//		NoticeVO noticeVO = new NoticeVO();
//		noticeVO.setTitle("test title");
//		noticeVO.setWriter("test writer");
//		noticeVO.setContents("test contents");
//		
//		int result = noticeDAO.boardWrite(noticeVO);
//		assertEquals(1, result);
//	}
//	
//	@Test
//	public void boardDeleteTest() throws Exception {
//		
//		int result = noticeDAO.boardDelete(5);
//		assertEquals(1, result);
//	}
	
//	@Test
//	public void boardUpdateTest() throws Exception {
//		
//		NoticeVO noticeVO = new NoticeVO();
//		noticeVO.setNum(6);
//		noticeVO.setTitle("test title2");
//		noticeVO.setWriter("test writer2");
//		noticeVO.setContents("test contents2");
//		noticeVO.setHit(1);
//		
//		int result = noticeDAO.boardUpdate(noticeVO);
//		assertEquals(1, result);
//	}
	
	@Test
	public void hitUpdateTest() throws Exception {
		
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNum(6);
		
		int result = noticeDAO.hitUpdate(noticeVO);
		assertEquals(1, result);
	}
}
