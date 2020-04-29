package com.song.Spring_legacy2.board.file;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/boardFile/**")
public class BoardFileController {

	@Autowired
	private BoardFileService boardFileService;
	
	@PostMapping("fileInsert")
	public ModelAndView fileInsert(MultipartFile files, HttpSession session) throws Exception {

		ModelAndView mv = new ModelAndView();
		String fileName = boardFileService.boardFileInsert(files, session);
		mv.addObject("result", fileName);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	@PostMapping("summerDelete")
	public ModelAndView fileDelete(String fileName, HttpSession session) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		int result = boardFileService.boardFileDelete(fileName, session);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	@PostMapping("fileDelete")
	public ModelAndView fileDelete(BoardFileVO boardFileVO, HttpSession session) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		int result = boardFileService.boardFileDelete(boardFileVO, session);
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
