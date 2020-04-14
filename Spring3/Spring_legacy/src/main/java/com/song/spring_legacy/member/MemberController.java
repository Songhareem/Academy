package com.song.spring_legacy.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="memberJoin")
	public void getMemberJoin() {
		
	}
	
	@RequestMapping(value="memberJoin", method=RequestMethod.POST)
	public String postMemberJoin(MemberVO memberVO, Model model) throws Exception {
		
		String msg = "";
		String url = "common/result";
		int result = memberService.memberJoin(memberVO);
		if(result > 0) {
			msg = "회원가입 성공";
			model.addAttribute("url", "../");
		} else {
			msg = "회원가입 실패";
			model.addAttribute("url", "./memberJoin");
		}
		
		model.addAttribute("result", msg);
		return url;
	}
	
	@RequestMapping(value="memberLogin")
	public void getMemberLogin() {
		
	}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.POST)
	public String postMemberLogin(MemberVO memberVO, HttpSession session, Model model) throws Exception {
		
		String url = "";
		memberVO = memberService.memberLogin(memberVO);
		if(memberVO != null) {
			System.out.println("로그인 성공");
			session.setAttribute("member", memberVO);
			url = "redirect: ../";
		} else {
			model.addAttribute("result", "로그인 실패");
			model.addAttribute("url", "./memberLogin");
			url = "common/result";
		}
		
		return url;
	}
	
	@RequestMapping(value="memberUpdate")
	public void getMemberUpdate() {
		
	}
	
	@RequestMapping(value="memberUpdate", method=RequestMethod.POST)
	public String postMemberUpdate(MemberVO memberVO, HttpSession session, Model model) throws Exception {
		
		
		String url = "";
		int result = memberService.memberUpdate(memberVO);
		if(result > 0) {
			session.setAttribute("member", memberVO);
			url = "redirect: ./memberPage";
			System.out.println("Update Success");
		} else {
			System.out.println("Update Fail");
		}
		
		return url;
	}
	
	@RequestMapping(value="memberPage")
	public void getMemberPage() {
		
	}
	
	@RequestMapping(value="memberDelete")
	public String getMemberDelete(MemberVO memberVO, HttpSession session, Model model) throws Exception {
		
		String msg = "회원 탈퇴 실패";
		String url = "common/result";
		memberVO = (MemberVO)session.getAttribute("member");
		int result = memberService.memberDelete(memberVO);
		if(result > 0) {
			msg = "회원 탈퇴 성공";
			session.invalidate();
		}
		model.addAttribute("result", msg);
		model.addAttribute("url", "../");
		
		return url;
	}
	
	@RequestMapping(value="memberLogout")
	public String getMemberLogout(HttpSession session) {
		
		String url = "redirect: ../";
		session.invalidate();
		
		return url;
	}
}
