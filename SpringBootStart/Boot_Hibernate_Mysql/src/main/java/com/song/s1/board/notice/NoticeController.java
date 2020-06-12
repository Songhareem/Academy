package com.song.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.song.s1.board.BoardVO;
import com.song.s1.util.Pager;

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
		
		mv.addObject("boardVO", new BoardVO());
		mv.addObject("path","Write");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@PostMapping("noticeWrite")
	public String setInsert(NoticeVO noticeVO, RedirectAttributes rd, MultipartFile[] files) throws Exception {
		
		int result = 0;
		NoticeVO resultVO = noticeService.setInsert(noticeVO, files);
		if(resultVO != null)
			result = 1;
		rd.addFlashAttribute("result", result);
		return "redirect:./noticeList";
	}
	
//	@GetMapping("noticeList")
//	// (@PageableDefault(page = 0, size = 10) 괄호 안의 값들은 값이 안왔을때의 defalut 값
//	public ModelAndView getSelectList(
//			@PageableDefault(page = 0, size = 10, sort = {"num"}, direction = Direction.DESC) Pageable pageable, 
//			@RequestParam(defaultValue = "") String search,
//			@RequestParam(defaultValue = "title") String kind) throws Exception {
//		
//		ModelAndView mv = new ModelAndView();
//
//		List<NoticeVO> list = noticeService.noticeList(pageable, search, kind);
//		if(list == null)
//			System.out.println("list is null");
//		
//		mv.addObject("list", list);
//		mv.setViewName("board/boardList");
//		return mv;
//	}
	
	@GetMapping("noticeList")
	public ModelAndView getSelectList(Pager pager) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		Page<NoticeVO> page = noticeService.noticeList(pager);	
		
		mv.addObject("page", page);
		mv.addObject("Pager", pager);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView getSelectOne(BoardVO boardVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		boardVO = noticeService.noticeSelectOne(boardVO);
		
		mv.addObject("boardVO", boardVO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
}
