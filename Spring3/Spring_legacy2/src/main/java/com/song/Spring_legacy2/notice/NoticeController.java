package com.song.Spring_legacy2.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.song.Spring_legacy2.board.BoardVO;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	private int perPage = 10;
	
	// 모든 요청에 다 추가
	@ModelAttribute("board")
	public String getBoard() throws Exception {
		return "notice";
	}
	
	@RequestMapping(value = "noticeList")
	public ModelAndView getBoardList(@RequestParam(defaultValue = "1") int curPage, ModelAndView mv) throws Exception {
		
		List<BoardVO> ndtoList = noticeService.boardList(curPage, perPage);
		mv.addObject("list", ndtoList);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@RequestMapping(value = "noticeSelect")
	public ModelAndView getBoardSelect(long num) throws Exception {
		
		BoardVO boardVO = noticeService.boardSelect(num);
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", boardVO);
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite")
	public ModelAndView getBoardWrite() throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView postBoardWrite(NoticeVO noticeVO, ModelAndView mv) throws Exception {
		
		String view = "common/result";
		noticeVO.setWriter("admin");
		int result = noticeService.boardWrite(noticeVO);
		if(result > 0) {
			view = "redirect: ./noticeWrite";
		} else {
			mv.addObject("result", "글쓰기 성공");
			mv.addObject("url", "./noticeList");	
		}		
		
		mv.setViewName(view);
		
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate")
	public ModelAndView getBoardUpdate(NoticeVO noticeVO, ModelAndView mv) throws Exception {
		
		mv.addObject("vo",noticeVO);
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public ModelAndView postBoardUpdate(NoticeVO noticeVO, ModelAndView mv) throws Exception {
		
		int result = noticeService.boardUpdate(noticeVO);
		if(result > 0) {
			mv.setViewName("redirect: ./noticeSelect?num="+noticeVO.getNum());
		} else {
			mv.addObject("result", "공지 수정 실패");
			mv.addObject("url", "./noticeSelect?num="+noticeVO.getNum());
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "noticeDelete")
	public ModelAndView getBoardDelete(long num, ModelAndView mv) throws Exception {
		
		String view = "common/result";
		int result = noticeService.boardDelete(num);
		if(result > 0) {
			view = "redirect: ./noticeList";
		} else {
			mv.addObject("result", "삭제 실패");
			mv.addObject("url", "./noticeSelect?num="+num);
		}
		
		mv.setViewName(view);
		
		return mv;
		
	}
}
