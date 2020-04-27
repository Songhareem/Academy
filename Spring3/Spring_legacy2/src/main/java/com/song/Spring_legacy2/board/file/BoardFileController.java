package com.song.Spring_legacy2.board.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/boardFile/**")
public class BoardFileController {

	@Autowired
	private BoardFileService boardFileService;
	
	@PostMapping("fileDelete")
	public ModelAndView fileDelete(BoardFileVO boardFileVO) throws Exception {
		
		System.out.println(boardFileVO.getFileNum());
		ModelAndView mv = new ModelAndView();
		int result = boardFileService.boardFileDelete(boardFileVO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@GetMapping("fileDown")
	public ModelAndView fileDownload(BoardFileVO boardFileVO) throws Exception {
		
		ModelAndView mv = new ModelAndView(); 
		boardFileVO = boardFileService.boardFileSelect(boardFileVO);
		mv.addObject("file", boardFileVO);
		mv.setViewName("fileDown");
		
		return mv;
	}
}
