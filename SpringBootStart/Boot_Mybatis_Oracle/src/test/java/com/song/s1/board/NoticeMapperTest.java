package com.song.s1.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.song.s1.board.notice.NoticeMapper;
import com.song.s1.board.notice.NoticeVO;

@SpringBootTest
class NoticeMapperTest {

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Test
	public void setInsertTest() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("test1");
		noticeVO.setWriter("writer1");
		noticeVO.setContents("contents1");
		
		noticeMapper.setInsert(noticeVO);
	}
	
	@Test
	public void setDeleteTest() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNum(3);
		noticeMapper.setDelete(noticeVO);
	}
	
	@Test
	public void setSelectTest() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNum(4);
		noticeVO = (NoticeVO)noticeMapper.setSelect(noticeVO);
		
		System.out.println(noticeVO.getNum());
		System.out.println(noticeVO.getRegDate());
	}
}
