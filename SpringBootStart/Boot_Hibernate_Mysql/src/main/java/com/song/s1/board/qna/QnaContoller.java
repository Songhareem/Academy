package com.song.s1.board.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.song.s1.board.BoardVO;

@Controller
@RequestMapping("/qna/**/")
public class QnaContoller {

	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		
		return "qna";
	}
	
	@GetMapping("qnaList")
	public ModelAndView boardList(
			@PageableDefault(size = 10, page = 0, direction = Direction.DESC, sort = {"num"}) Pageable pageable) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		Page<QnaVO> pages = qnaService.boardList(pageable);
		
		System.out.println(pages.getContent().size());
		System.out.println(pages.getSize());
		System.out.println(pages.getTotalPages());
		System.out.println(pages.getTotalElements());
		System.out.println(pages.hasNext());
		System.out.println(pages.hasPrevious());
		System.out.println(pages.getNumber());
		System.out.println(pages.hasContent());
		System.out.println(pages.isFirst());
		System.out.println(pages.isLast());
		
		mv.addObject("page", pages);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@GetMapping("qnaWrite")
	public ModelAndView qnaWrite() throws Exception {
		
		ModelAndView mv= new ModelAndView();
	
		mv.addObject("boardVO", new BoardVO());
		mv.addObject("path","Write");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@PostMapping("qnaWrite")
	public String qnaWrite(QnaVO qnaVO, RedirectAttributes rd, MultipartFile[] files) throws Exception {
		
		int result = 0;
		QnaVO resultVO = qnaService.setInsert(qnaVO, files);
		if(resultVO != null)
			result = 1;
		rd.addFlashAttribute("result", result);
		return "redirect:../";
	}
}
