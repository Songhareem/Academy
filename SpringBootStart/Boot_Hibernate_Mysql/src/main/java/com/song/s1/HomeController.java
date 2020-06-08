package com.song.s1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	//@Autowired
	//private FilePathMaker pathMaker;
	
	@GetMapping("/")
	public String home(Model model) throws Exception {
		
		//pathMaker.getUserResourceLoader("upload");
		
		//model.addAttribute("name", "front");
		//model.addAttribute("phone", "back");
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
