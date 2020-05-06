package com.song.Spring_legacy2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.song.Spring_legacy2.board.BoardVO;
import com.song.Spring_legacy2.notice.NoticeService;
import com.song.Spring_legacy2.util.Pager;

@RestController
@RequestMapping("/json/**")
public class JsonController {

	@Autowired
	private NoticeService noticeService;
	
	
	@GetMapping("json1")
	@ResponseBody			// ajax요청시에만 사용가능
	public List<BoardVO> json1() throws Exception {
		
		Pager pager = new Pager();
		pager.setCurPage(1L);
		List<BoardVO> list = noticeService.boardList(pager);

		return list;
	}
	
}
