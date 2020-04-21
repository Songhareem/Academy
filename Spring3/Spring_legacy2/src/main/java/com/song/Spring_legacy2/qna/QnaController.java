package com.song.Spring_legacy2.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.song.Spring_legacy2.board.BoardVO;
import com.song.Spring_legacy2.util.Pager;

@Controller
@RequestMapping(value = "/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	// 모든 요청에 다 추가
	@ModelAttribute("board")
	public String getBoard() throws Exception {
		return "qna";
	}
	
	@GetMapping("qnaList")
	public ModelAndView getBoardList(Pager pager, ModelAndView mv) throws Exception {
		
		List<BoardVO> ndtoList = qnaService.boardList(pager);
		mv.addObject("list", ndtoList);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@RequestMapping(value = "qnaSelect")
	public ModelAndView getBoardSelect(long num) throws Exception {
		
		BoardVO boardVO = qnaService.boardSelect(num);
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", boardVO);
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@RequestMapping(value = "qnaWrite")
	public ModelAndView getBoardWrite(ModelAndView mv) throws Exception {
		
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public ModelAndView postBoardWrite(QnaVO qnaVO, ModelAndView mv) throws Exception {
		
		String view = "common/result";
		qnaVO.setWriter("admin");
		int result = qnaService.boardWrite(qnaVO);		
		if(result > 0) {
			System.out.println("글쓰기 성공");
			mv.addObject("result", "글쓰기 성공");
			mv.addObject("url", "./qnaList");	
		} else {
			view = "redirect: ./qnaWrite";
		}		
		
		mv.setViewName(view);
		
		return mv;
	}
	
	@RequestMapping(value = "qnaUpdate")
	public ModelAndView getBoardUpdate(QnaVO qnaVO, ModelAndView mv) throws Exception {
		
		mv.addObject("vo",qnaVO);
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.POST)
	public ModelAndView postBoardUpdate(QnaVO qnaVO, ModelAndView mv) throws Exception {
		
		int result = qnaService.boardUpdate(qnaVO);
		if(result > 0) {
			mv.setViewName("redirect: ./qnaSelect?num="+qnaVO.getNum());
		} else {
			mv.addObject("result", "공지 수정 실패");
			mv.addObject("url", "./qnaSelect?num="+qnaVO.getNum());
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "qnaDelete")
	public ModelAndView getBoardDelete(long num, ModelAndView mv) throws Exception {
		
		String view = "common/result";
		int result = qnaService.boardDelete(num);
		if(result > 0) {
			view = "redirect: ./qnaList";
		} else {
			mv.addObject("result", "삭제 실패");
			mv.addObject("url", "./qnaSelect?num="+num);
		}
		
		mv.setViewName(view);
		
		return mv;
	}
	
	@GetMapping("qnaReply")
	public ModelAndView getBoardReply(long num, ModelAndView mv) throws Exception {
	
		mv.addObject("num", num);
		mv.setViewName("board/boardReply");
		return mv;
	}
	
	@PostMapping("qnaReply")
	public ModelAndView postBoardReply(QnaVO qnaVO, ModelAndView mv) throws Exception {
		
		int result = qnaService.boardReply(qnaVO);
		if(result > 0) {
			mv.setViewName("redirect: ./qnaList");
		} else {
			mv.addObject("result", "삭제 실패");
			mv.addObject("url", "./qnaList");
			mv.setViewName("common/result");
		}
		return mv;
	}
}
