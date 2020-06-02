package com.song.mysql.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.song.mysql.board.BoardVO;

@Controller
@RequestMapping("/notice/**/")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		
		return "notice";
	}
	
	@GetMapping("noticeWrite")
	public ModelAndView setInsert() throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("path","Write");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@PostMapping("noticeWrite")
	public String setInsert(NoticeVO noticeVO, RedirectAttributes rd, MultipartFile[] files) throws Exception {
		
		int result = noticeService.setInsert(noticeVO, files);
		rd.addFlashAttribute("result", result);
		return "redirect:./noticeList";
	}
	
	@GetMapping("noticeList")
	public ModelAndView getSelectList() throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		List<BoardVO> list = noticeService.getSelectList();	
		
		mv.addObject("list", list);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView getSelectOne(BoardVO boardVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		boardVO = noticeService.getSelectOne(boardVO);
		
		mv.addObject("vo", boardVO);
		mv.setViewName("board/boardSelect");
		return mv;
	}

	@GetMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardVO boardVO, ModelAndView mv) throws Exception {
		
		boardVO = noticeService.getSelectOne(boardVO);
		
		mv.addObject("vo", boardVO);
		mv.addObject("path", "Update");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@PostMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardVO boardVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setUpdate(boardVO);
		
		System.out.println("result : "+result);
		String msg = "업데이트 실패";
		if(result > 0) {
			msg = "업데이트 성공";
		}
		mv.addObject("result", msg);
		mv.addObject("url", "./noticeList");
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("noticeDelete")
	public ModelAndView setDelete(BoardVO boardVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setDelete(boardVO);
		
		System.out.println("result : "+result);
		String msg = "삭제 실패";
		if(result > 0) {
			msg = "삭제 성공";
		}
		mv.addObject("result", msg);
		mv.addObject("url", "./noticeList");
		mv.setViewName("common/result");
		return mv;
	}
}
