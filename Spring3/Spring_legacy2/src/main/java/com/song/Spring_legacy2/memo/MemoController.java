package com.song.Spring_legacy2.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.song.Spring_legacy2.util.Pager;

@Controller
@RequestMapping("/memo/**")
public class MemoController {
	
	@Autowired
	private MemoService memoService;
	
	@GetMapping
	public void getList(Pager pager, Model model) throws Exception {
		
		System.out.println("Pager : " + pager.getCurPage());
		List<MemoVO> list = memoService.memoList(pager);
		model.addAttribute("list", list);
	}
	
	@PostMapping("memoInsert")
	public ModelAndView memoInsert(MemoVO memoVO, ModelAndView mv) throws Exception{
		
		int result = memoService.memoInsert(memoVO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	} 
	
	@GetMapping("memoList")
	public void memoList(Pager pager) throws Exception {
			
	}
}
