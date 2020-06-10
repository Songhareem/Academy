package com.song.s1.board.notice;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NoticeRepositoryTest {

	@Autowired
	private NoticeRepository noticeRepository;
	
	private NoticeVO noticeVO;
	private List<NoticeFileVO> noticeFileVOs;
	
	//@BeforeEach
	public void beforeEach() {
		noticeVO = new NoticeVO();
		noticeVO.setTitle("title");
		noticeVO.setWriter("writer");
		noticeVO.setContents("contents");
		List<NoticeFileVO> noticeFileVOs = new ArrayList<NoticeFileVO>();
		
		NoticeFileVO vo1 = new NoticeFileVO();
		vo1.setFileName("fileName1");
		vo1.setOriName("oriName1");
		vo1.setNoticeVO(noticeVO);
		noticeFileVOs.add(vo1);
		
		
		NoticeFileVO vo2 = new NoticeFileVO();
		vo2.setFileName("fileName2");
		vo2.setOriName("oriName2");
		vo2.setNoticeVO(noticeVO);
		noticeFileVOs.add(vo2);
		
		noticeVO.setNoticeFileVOs(noticeFileVOs);
	}
	
	//insert
	//@Test
	public void insertTest()throws Exception{
		
//		for(int i=0; i<112; i++) {
//			noticeVO.setNum(0L);
//			noticeVO.setTitle("title_"+i);
//			noticeVO.setWriter("writer_"+i);
//			noticeVO.setContents("contents_"+i);
//			noticeVO.setHit(0L);
//			noticeRepository.save(noticeVO);
//		}
		//assertNotNull(noticeVO);
		
		noticeVO = noticeRepository.save(noticeVO);
		assertNotNull(noticeVO);
	}
	
	//update
	//@Test
	public void updateTest()throws Exception{
		noticeVO.setNum(5L);
		noticeVO.setTitle("update Title");
		noticeVO = noticeRepository.save(noticeVO);
		assertNotNull(noticeVO);
	}
	
	//delete
	//@Test
	public void deleteTest()throws Exception{
		noticeRepository.deleteById(1L);
	}
	
	@Test
	public  void selectListTest() throws Exception {
		//List<NoticeVO> list = noticeRepository.findAll();
		//List<NoticeVO> list = noticeRepository.findByNumBetweenOrderByNumDesc(5, 15);
		List<NoticeVO> list = noticeRepository.findByTitleContainingOrderByNumDesc("_10");
		for (NoticeVO noticeVO : list) {
			System.out.println(noticeVO.getTitle());
		}
		assertNotEquals(0, list);
	}
	
	//@Test
	public void selectOneTest() throws Exception {
		Optional<NoticeVO> opt = noticeRepository.findById(113L);
		// 데이터가 있다면
		if(opt.isPresent()) {
			
		}
		noticeVO = opt.get();
		System.out.println(noticeVO.toString());
//		noticeFileVOs = noticeVO.getNoticeFileVOs();
//		for (NoticeFileVO noticeFileVO : noticeFileVOs) {
//			noticeFileVO.toString();
//		}
		assertNotNull(noticeVO);
	}
}

