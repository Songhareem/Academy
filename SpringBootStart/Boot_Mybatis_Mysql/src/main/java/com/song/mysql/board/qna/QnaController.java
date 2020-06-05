package com.song.mysql.board.qna;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.song.mysql.board.BoardVO;
import com.song.mysql.board.qna.qnaFile.QnaFileVO;
import com.song.mysql.util.Pager;

@Controller
@RequestMapping("/qna/**/")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		
		return "qna";
	}
	
	@GetMapping("qnaWrite")
	public ModelAndView setInsert() throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("path","Write");
		mv.addObject("boardVO", new BoardVO());
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	// boardForm
//	@PostMapping("qnaWrite")
//	public String setInsert(QnaVO qnaVO, RedirectAttributes rd, MultipartFile[] files) throws Exception {
//		
//		int result = qnaService.setInsert(qnaVO, files);
//		rd.addFlashAttribute("result", result);
//		return "redirect:./qnaList";
//	}

	// springForm
	@PostMapping("qnaWrite")
	public ModelAndView setInsert(@Valid BoardVO boardVO, BindingResult bindingResult, RedirectAttributes rd, MultipartFile[] files) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		// 데이터 검증
		if(bindingResult.hasErrors()) {
			mv.setViewName("board/boardWrite");
			mv.addObject("path","Write");
		} else {
		
			int result = qnaService.setInsert(boardVO, files);
			rd.addFlashAttribute("result", result);
			mv.setViewName("redirect:./qnaList");
		}
		
		return mv;
	}
	
	@GetMapping("qnaList")
	public ModelAndView getSelectList(Pager pager) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		List<BoardVO> list = qnaService.getSelectList(pager);	
		
		mv.addObject("list", list);
		mv.addObject("Pager", pager);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@GetMapping("qnaSelect")
	public ModelAndView getSelectOne(BoardVO boardVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		boardVO = qnaService.getSelectOne(boardVO);
		
		mv.addObject("boardVO", boardVO);
		mv.setViewName("board/boardSelect");
		return mv;
	}

	@GetMapping("qnaUpdate")
	public ModelAndView setUpdate(BoardVO boardVO, ModelAndView mv) throws Exception {
		
		boardVO = qnaService.getSelectOne(boardVO);
		
		mv.addObject("boardVO", boardVO);
		mv.addObject("path", "Update");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@PostMapping("qnaUpdate")
	public ModelAndView setUpdate(@Valid BoardVO boardVO, BindingResult bindingResult) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		// 데이터 검증
		if(bindingResult.hasErrors()) {
			mv.setViewName("board/boardUpdate");
			mv.addObject("path","Update");
			return mv;
		}
		
		int result = qnaService.setUpdate(boardVO);
		
		System.out.println("result : "+result);
		String msg = "업데이트 실패";
		if(result > 0) {
			msg = "업데이트 성공";
		}
		mv.addObject("result", msg);
		mv.addObject("url", "./qnaList");
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("qnaDelete")
	public ModelAndView setDelete(BoardVO boardVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setDelete(boardVO);
		
		System.out.println("result : "+result);
		String msg = "삭제 실패";
		if(result > 0) {
			msg = "삭제 성공";
		}
		mv.addObject("result", msg);
		mv.addObject("url", "./qnaList");
		mv.setViewName("common/result");
		return mv;
	}
	
	// param : fileNum
	@GetMapping("fileDown")
	public ModelAndView fileDown(QnaFileVO qnaFileVO) throws Exception {
	
		ModelAndView mv = new ModelAndView();
		
		qnaFileVO = qnaService.fileDown(qnaFileVO);
		mv.addObject("fileVO", qnaFileVO);
		mv.addObject("path", "upload/qna/");
		// fileDown 객체 찾아보고 없으면 .jsp 찾아봄
		mv.setViewName("fileDown");
		return mv;
	}
	
	// boardReply addObj path
	@GetMapping("qnaReply")
	public ModelAndView qnaReply(long num) throws Exception {
	
		ModelAndView mv = new ModelAndView();
		
		BoardVO boardVO = new BoardVO();
		boardVO.setNum((int)num);
		mv.addObject("boardVO", boardVO);
		mv.addObject("path","Reply");
		mv.setViewName("board/boardReply");

		return mv;
	}
	
	@PostMapping("qnaReply")
	public ModelAndView qnaReply(BoardVO boardVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		System.out.println("num = "+boardVO.getNum());
		int result = qnaService.setInsertReply(boardVO);
		if(result > 0) {
			mv.setViewName("redirect:./qnaList");
		} else {
			mv.addObject("result", "삭제 실패");
			mv.addObject("url", "./qnaList");
			mv.setViewName("common/result");
		}
		return mv;
	}
}
