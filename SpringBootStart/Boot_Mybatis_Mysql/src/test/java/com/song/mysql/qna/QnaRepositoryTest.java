package com.song.mysql.qna;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.song.mysql.board.BoardVO;
import com.song.mysql.board.qna.QnaRepository;
import com.song.mysql.board.qna.QnaVO;
import com.song.mysql.util.Pager;

@SpringBootTest
class QnaRepositoryTest {

	@Autowired
	private QnaRepository qnaRepository; 
	
//	@Test
//	void setInsertTest() throws Exception {
//		for(int i=0; i<102; i++) {
//			QnaVO qnaVO = new QnaVO();
//			qnaVO.setTitle("title"+i);
//			qnaVO.setWriter("writer"+i);
//			qnaVO.setContents("contents"+i);
//			
//			int result = qnaRepository.setInsert(qnaVO);
//		}
//		//assertEquals(1, result);
//	}
	
//	@Test
//	void setUpdateTest() throws Exception {
//		QnaVO qnaVO = new QnaVO();
//
//		qnaVO.setNum(2);
//		qnaVO.setTitle("title00");
//		qnaVO.setWriter("writer00");
//		qnaVO.setContents("contents00");
//			
//		int result = qnaRepository.setUpdate(qnaVO);
//		assertEquals(1, result);
//	}
	
//	@Test
//	void setDeleteTest() throws Exception {
//		QnaVO qnaVO = new QnaVO();
//		qnaVO.setNum(2);
//		
//		int result = qnaRepository.setDelete(qnaVO);
//		assertEquals(1, result);
//	}
	
//	@Test
//	void getSelectOneTest() throws Exception {
//		QnaVO qnaVO = new QnaVO();
//		qnaVO.setNum(103);
//		
//		qnaVO = (QnaVO)qnaRepository.getSelectOne(qnaVO);
//		assertNotNull(qnaVO);
//	}


//	@Test
//	void getSelectListTest() throws Exception {
//		Pager pager = new Pager();
//		pager.setStartRow(0);
//		long totalNum = qnaRepository.getSelectCount(pager);
//		pager.setPerPage((int)totalNum);
//		List<BoardVO> list = qnaRepository.getSelectList(pager);
//		assertNotNull(list);
//	}
}
