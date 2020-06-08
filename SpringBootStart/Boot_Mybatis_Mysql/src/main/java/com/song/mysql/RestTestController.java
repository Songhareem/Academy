package com.song.mysql;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.song.mysql.util.Pager;

@Controller
public class RestTestController {

	// Rest는 자원의 역할을 하는 인자에 의해, 동적 url로 변함
//	@GetMapping("/test/select/{num}")
//	public void test(@PathVariable(value="num", required = true) int num) {
//		System.out.println("num : "+num);
//	}
	@GetMapping("/test/select/{num}/{name}")
	public void test(@PathVariable(value="num", required = true) int num, String namefw1fw) {
		System.out.println("num : "+num);
	}
	
//	@GetMapping("/test/list/{curPage}/{kind}/{search}")
//	public void listTest(
//			@PathVariable int curPage, 
//			@PathVariable String kind,
//			@PathVariable String search) {
//		System.out.println("curPage : "+curPage);
//		System.out.println("kind : "+kind);
//		System.out.println("search : "+search);
//	}
	
	@GetMapping("/test/list/{curPage}/{kind}/{search}")
	public void listTest(Pager pager) {
		System.out.println("curPage : "+pager.getCurPage());
		System.out.println("kind : "+pager.getKind());
		System.out.println("search : "+pager.getSearch());
	}
}
