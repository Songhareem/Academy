package com.song.mysql.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**/")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("memberJoin")
	public ModelAndView memberJoin() throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("memberVO", new MemberVO());
		mv.setViewName("member/memberJoin");
		return mv;
	}
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(@Valid MemberVO memberVO, BindingResult bindingResult) throws Exception {
		
		ModelAndView mv = new ModelAndView();

		// 데이터 검증
		if(memberService.memberError(memberVO, bindingResult)) {
			mv.setViewName("member/memberJoin");
			return mv;
		}

		int result = 1;//memberService.memberJoin(memberVO);
		if(result>0) {
			mv.setViewName("redirect:../");
		} else {
			mv.setViewName("member/memberJoin");
		}
		return mv;
	}
	
	@GetMapping("memberLogin")
	public ModelAndView memberLogin() throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/memberLogin");
		return mv;
	}
	
	@PostMapping("memberLogin")
	public ModelAndView memberLogin(MemberVO memberVO, String remember, HttpServletResponse response, HttpSession session) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		// 쿠키 발행
		Cookie cookie = new Cookie("uid", "");
		if(remember != null) {
			cookie.setValue(memberVO.getId());
			cookie.setMaxAge(1000 * 60 * 30);
		} else {
			cookie.setMaxAge(0);			
		}
				
		response.addCookie(cookie);
		
		memberVO = memberService.memberLogin(memberVO);
		if(memberVO != null) {
			System.out.println("로그인 성공");
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:../");
		} else {
			mv.addObject("result", "로그인 실패");
			mv.addObject("url", "./memberLogin");
			mv.setViewName("common/result");
		}
				
		return mv;
	}
	
	@GetMapping("memberLogout")
	public ModelAndView memberLogout(HttpSession session) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		session.invalidate();
		
		mv.setViewName("redirect:../");
		return mv;
	}
	
	// error 처리
	@ExceptionHandler(Exception.class)
	public ModelAndView nullPtrException() throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("error/exception");
		
		return mv;
	}
}
