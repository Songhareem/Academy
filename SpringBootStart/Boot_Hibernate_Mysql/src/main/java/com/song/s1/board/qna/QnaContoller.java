package com.song.s1.board.qna;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/qna/**/")
public class QnaContoller {

	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		
		return "qna";
	}
	
	// pageable 이용
//	@GetMapping("qnaList")
//	public ModelAndView boardList(
//			@PageableDefault(size = 10, page = 0, direction = Direction.DESC, sort = {"num"}) Pageable pageable,
//			@RequestParam(defaultValue = "") String search,
//			@RequestParam(defaultValue = "title") String kind) throws Exception {
//		
//		ModelAndView mv = new ModelAndView();
//		
//		Page<QnaVO> pages = qnaService.boardList(pageable, search, kind);
//		
//		System.out.println(pages.getContent().size());
//		System.out.println(pages.getSize());
//		System.out.println(pages.getTotalPages());
//		System.out.println(pages.getTotalElements());
//		System.out.println(pages.hasNext());
//		System.out.println(pages.hasPrevious());
//		System.out.println(pages.getNumber());
//		System.out.println(pages.hasContent());
//		System.out.println(pages.isFirst());
//		System.out.println(pages.isLast());
//		
//		mv.addObject("page", pages);
//		mv.setViewName("board/boardList");
//		return mv;
//	}
	
	// Pager 이용
	@GetMapping("qnaList")
	public ModelAndView boardList(Pager pager) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		Page<QnaVO> pages = qnaService.qnaList(pager);
		
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
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@GetMapping("qnaSelect")
	public ModelAndView getSelectOne(QnaVO qnaVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		qnaVO = qnaService.qnaSelectOne(qnaVO);
		
		mv.addObject("boardVO", qnaVO);
		mv.setViewName("board/boardSelect");
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
		return "redirect:./qnaList";
	}
	
	// boardReply addObj path
		@GetMapping("qnaReply")
		public ModelAndView qnaReply(long num) throws Exception {
		
			ModelAndView mv = new ModelAndView();
			
			BoardVO boardVO = new BoardVO();
			boardVO.setNum(num);
			System.out.println("Get num : "+num);
			mv.addObject("vo", boardVO);
			mv.addObject("path","Reply");
			mv.setViewName("board/boardReply");

			return mv;
		}
		
		@PostMapping("qnaReply")
		public ModelAndView qnaReply(QnaVO qnaVO) throws Exception {
			
			ModelAndView mv = new ModelAndView();
			System.out.println("num = "+qnaVO.getNum());
			qnaVO = qnaService.qnaReply(qnaVO);
			if(qnaVO != null) {
				mv.setViewName("redirect:./qnaList");
			} else {
				mv.addObject("result", "삭제 실패");
				mv.addObject("url", "./qnaList");
				mv.setViewName("common/result");
			}
			return mv;
		}
		
		@GetMapping("qnaDelete")
		public ModelAndView qnaDelete(QnaVO qnaVO) throws Exception {
			
			ModelAndView mv = new ModelAndView();
			
			boolean result = qnaService.qnaDelete(qnaVO);
			if(result) {
				// 성공시
			}
			mv.setViewName("redirect:./qnaList");
			return mv;
		}
		
		@GetMapping("qnaUpdate")
		public ModelAndView setUpdate(QnaVO qnaVO, ModelAndView mv) throws Exception {
			
			qnaVO = qnaService.qnaSelectOne(qnaVO);
			
			mv.addObject("boardVO", qnaVO);
			mv.addObject("path", "Update");
			mv.setViewName("board/boardWrite");
			return mv;
		}
		
		@PostMapping("qnaUpdate")
		public ModelAndView setUpdate(QnaVO qnaVO) throws Exception {
			
			ModelAndView mv = new ModelAndView();
						
			//qnaVO = qnaService.qnaUpdate(qnaVO);
//			String msg = "업데이트 실패";
//			if(qnaVO != null) {
//				msg = "업데이트 성공";
//			}
//			mv.addObject("result", msg);
//			mv.addObject("url", "./qnaList");
//			mv.setViewName("common/result");
			
			qnaService.qnaUpdate(qnaVO);
			mv.setViewName("redirect:../");
			return mv;
		}
}
