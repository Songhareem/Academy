package com.song.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
