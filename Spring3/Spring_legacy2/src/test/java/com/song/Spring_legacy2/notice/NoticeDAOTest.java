package com.song.Spring_legacy2.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.song.Spring_legacy2.AbstractTestCase;
import com.song.Spring_legacy2.board.BoardVO;

public class NoticeDAOTest extends AbstractTestCase{

	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
//	public void daoIsNull() throws Exception{
//		assertNotNull(noticeDAO);
//	}
//	
	@Test
	public void boardWriteTest() throws Exception{

		String writer="";
		String title="";
		String contents="";
		for(int i=0; i<150; i++) {
			NoticeVO noticeVO = new NoticeVO();
			if(i%3 == 0) {
				writer = "iu";
				title = "Alert";
				contents = "Samsung";
			} else if(i%3 == 1) {
				writer = "choa";
				title = "Computer";
				contents = "Apple";
			} else {
				writer = "suji";
				title = "OS";
				contents = "Linux";
			}
			noticeVO.setTitle(title+i);
			noticeVO.setWriter(writer);
			noticeVO.setContents(contents+i);

			int result = noticeDAO.boardWrite(noticeVO);
			if(i == 50 || i == 100) {
				Thread.sleep(1000);
			}
		}
		//assertEquals(1, result);
	}
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
	
//	@Test
//	public void hitUpdateTest() throws Exception {
//		
//		NoticeVO noticeVO = new NoticeVO();
//		noticeVO.setNum(6);
//		
//		int result = noticeDAO.hitUpdate(noticeVO);
//		assertEquals(1, result);
//	}
	
//	@Test
//	public void boardSelectTest() throws Exception {
//		
//		BoardVO boardVO = noticeDAO.boardSelect(1);
//		assertNotNull(boardVO);
//	}

//	public List<BoardVO> boardListTest() throws Exception {
//		
//		return noticeDAO.boardList();
//	}
//	
//	@Test
//	public void boardList() throws Exception {
//		
//		List<BoardVO> ar = this.boardListTest();
//		assertNotEquals(0, ar.size());
//	}
}
