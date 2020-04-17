package com.song.Spring_legacy2.qna;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.song.Spring_legacy2.AbstractTestCase;
import com.song.Spring_legacy2.board.BoardVO;

public class QnaDAOTest extends AbstractTestCase{

	@Autowired
	private QnaDAO qnaDAO;
	
//	@Test
//	public void boardWriteTest() throws Exception{
//		
//		String writer="";
//		String title="";
//		String contents="";
//		for(int i=0; i<150; i++) {
//			QnaVO qnaVO = new QnaVO();
//			if(i%3 == 0) {
//				writer = "choi";
//				title = "Fx";
//				contents = "Effecter";
//			} else if(i%3 == 1) {
//				writer = "Reem";
//				title = "Computer";
//				contents = "Programmer";
//			} else {
//				writer = "Min";
//				title = "Besiness";
//				contents = "Markecter";
//			}
//			qnaVO.setTitle(title+" "+i);
//			qnaVO.setWriter(writer);
//			qnaVO.setContents(contents+" "+i);
//
//			int result = qnaDAO.boardWrite(qnaVO);
//			if(i == 50 || i == 100) {
//				Thread.sleep(2000);
//			}
//		}
//		//assertEquals(1, result);
//	}

//	@Test
//	public void boardDeleteTest() throws Exception {
//		
//		long num = 131;
//		int result = qnaDAO.boardDelete(num);
//		assertEquals(1, result);
//	}
	
//	@Test
//	public void boardCountTest() throws Exception {
//		
//		long result = qnaDAO.boardCount();
//		assertEquals(1, result);
//	}
	
//	public List<BoardVO> boardListTest() throws Exception {
//	
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		map.put("startRow", 1);
//		map.put("lastRow", 10);
//		return qnaDAO.boardList(map);
//	}
//
//	@Test
//	public void boardList() throws Exception {
//	
//		List<BoardVO> ar = this.boardListTest();
//		System.out.println(ar.size());
//		assertNotEquals(0, ar.size());
//	}
	
//	@Test
//	public void boardSelectTest() throws Exception {
//		
//		BoardVO boardVO = qnaDAO.boardSelect(380);
//		assertNotNull(boardVO);
//	}
	
//	@Test
//	public void boardUpdateTest() throws Exception {
//		
//		QnaVO qnaVO = new QnaVO();
//		qnaVO.setNum(370);
//		qnaVO.setTitle("test title2");
//		qnaVO.setWriter("test writer2");
//		qnaVO.setContents("test contents2");
//		qnaVO.setHit(1);
//		
//		int result = qnaDAO.boardUpdate(qnaVO);
//		assertEquals(1, result);
//	}
	
//	@Test
//	public void hitUpdateTest() throws Exception {
//		
//		QnaVO qnaVO = new QnaVO();
//		qnaVO.setNum(370);
//	
//		int result = qnaDAO.hitUpdate(qnaVO);
//		assertEquals(1, result);
//	}
}
