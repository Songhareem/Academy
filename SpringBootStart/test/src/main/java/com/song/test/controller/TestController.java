package com.song.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller + @ResponseBody
@RestController
public class TestController {
	
	@GetMapping(value="/test")
	public String getTest() throws Exception {
		return "Hello BootStrap";
	}
}
