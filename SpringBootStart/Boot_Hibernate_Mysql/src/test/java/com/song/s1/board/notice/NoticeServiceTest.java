package com.song.s1.board.notice;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class NoticeServiceTest {

	@Autowired
	private NoticeService noticeService;
	
	//@Test
	public void noticeListTest() throws Exception {
		
//		Pageable pageable = PageRequest.of(1, 10, Sort.Direction.DESC, "num");
//		List<NoticeVO> list = noticeService.noticeList(pageable, "", "title");
//		for (NoticeVO noticeVO : list) {
//			System.out.println("num :"+ noticeVO.getNum());
//			System.out.println("title : "+noticeVO.getTitle());
//		}
	}
}
