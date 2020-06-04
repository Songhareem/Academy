package com.song.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.song.mysql.util.FilePathMaker;

@Controller
public class HomeController {

	@Autowired
	private FilePathMaker pathMaker;
	
	@GetMapping("/")
	public String home() throws Exception {
		
		pathMaker.getUserResourceLoader("upload");
		
		return "index";
	}
	
	@GetMapping("/messageResult")
	public ModelAndView message(String result, String url) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.addObject("url", url);
		mv.setViewName("common/result");
		return mv;
	}
}
