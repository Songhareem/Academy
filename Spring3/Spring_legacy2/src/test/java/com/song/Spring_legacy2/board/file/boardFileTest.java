package com.song.Spring_legacy2.board.file;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.song.Spring_legacy2.AbstractTestCase;

public class boardFileTest extends AbstractTestCase {

	@Autowired
	private BoardFileDAO boardFileDAO;
	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void boardFileInsertTest() throws Exception {
//		
//		BoardFileVO boardFileVO = new BoardFileVO();
//		boardFileVO.setNum(1);
//		boardFileVO.setFileName("test123456.png");
//		boardFileVO.setOriginName("test.png");
//		boardFileVO.setBoard(1);
//		
//		int result = boardFileDAO.boardFileInsert(boardFileVO);
//		assertEquals(1, result);
//	}
	
	
	
//	@Test
//	public void boardFileDeleteTest() throws Exception {
//		
//		BoardFileVO boardFileVO = new BoardFileVO();
//		boardFileVO.setFileNum(2);
//		int result = boardFileDAO.boardFileDelete(boardFileVO);
//		assertEquals(1, result);
//	}
}
