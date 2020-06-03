package com.song.mysql.board.notice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.song.mysql.board.BoardVO;

@SpringBootTest
class NoticeRepositoryTest {

	@Autowired
	private NoticeRepository noticeRepository;
	
//	@Test
//	void setInsertTest() throws Exception {
//		for(int i=0; i<100; i++) {
//			NoticeVO noticeVO = new NoticeVO();
//			noticeVO.setTitle("title"+i);
//			noticeVO.setWriter("writer"+i);
//			noticeVO.setContents("contents"+i);
//			
//			int result = noticeRepository.setInsert(noticeVO);
//		}
//		//assertEquals(1, result);
//	}
//	
//	@Test
//	void setUpdateTest() throws Exception {
//		NoticeVO noticeVO = new NoticeVO();
//		noticeVO.setNum(1);
//		noticeVO.setTitle("title2");
//		noticeVO.setContents("contents2");
//		
//		int result = noticeRepository.setInsert(noticeVO);
//		assertEquals(1, result);
//	}
	
//	@Test
//	void setDeleteTest() throws Exception {
//		NoticeVO noticeVO = new NoticeVO();
//		noticeVO.setNum(3);
//		
//		int result = noticeRepository.setInsert(noticeVO);
//		assertEquals(1, result);
//	}
	
//	@Test
//	void getSelectOneTest() throws Exception {
//		NoticeVO noticeVO = new NoticeVO();
//		noticeVO.setNum(1);
//		
//		noticeVO = (NoticeVO)noticeRepository.getSelectOne(noticeVO);
//		System.out.println(noticeVO.getTitle());
//		System.out.println(noticeVO.getWriter());
//		System.out.println(noticeVO.getContents());
//		assertNotNull(noticeVO);
//	}
//	
//	@Test
//	void getSelectListTest() throws Exception {
//		List<BoardVO> list = noticeRepository.getSelectList();
//		for (BoardVO vo : list) {
//			NoticeVO noticeVO = (NoticeVO)vo;
//			
//			System.out.println(noticeVO.getTitle());
//			System.out.println(noticeVO.getWriter());
//			System.out.println(noticeVO.getContents());
//		}
//		
//		assertNotNull(list);
//	}
}
