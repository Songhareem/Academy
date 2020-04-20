package com.song.Spring_legacy2.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.song.Spring_legacy2.member.memberPage.MemberPager;

@Controller
@RequestMapping(value = "/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "memberList")
	public ModelAndView getMemberList(MemberPager pager, ModelAndView mv) throws Exception {
		
		List<MemberVO> mvoList = memberService.memberList(pager);
		mv.addObject("list", mvoList);
		mv.addObject("pager", pager);
		mv.setViewName("member/memberList");
		
		return mv;
	}
	
	// memberJoin
	@RequestMapping(value = "memberJoin")
	public ModelAndView getMemberJoin(ModelAndView mv) throws Exception {
		
		mv.setViewName("member/memberJoin");
		
		return mv;
	}
	
	// memberJoin
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public ModelAndView postMemberJoin(ModelAndView mv, MemberVO memberVO) throws Exception {
		
		int result = memberService.memberJoin(memberVO);
		if(result > 0) {
			mv.addObject("result", "회원가입 성공");
			mv.addObject("url", "../");
		} else {
			mv.addObject("result", "회원가입 실패");
			mv.addObject("url", "./memberJoin");
		}
		
		mv.setViewName("common/result");
		
		return mv;
	}

	// memberLogin
	@RequestMapping(value = "memberLogin")
	public ModelAndView getMemberLogin(ModelAndView mv) throws Exception {
		
		mv.setViewName("member/memberLogin");
		
		return mv;
	}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	public ModelAndView postMemberLogin(ModelAndView mv, MemberVO memberVO, HttpSession session) throws Exception {
		
		memberVO = memberService.memberLogin(memberVO);
		if(memberVO != null) {
			System.out.println("로그인 성공");
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect: ../");
		} else {
			mv.addObject("result", "로그인 실패");
			mv.addObject("url", "./memberLogin");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	// memberUpdate
	@RequestMapping(value = "memberUpdate")
	public ModelAndView getMemberUpdate(ModelAndView mv) throws Exception {
		
		mv.setViewName("member/memberUpdate");
		return mv;
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public ModelAndView postMemberUpdate(ModelAndView mv, MemberVO memberVO, HttpSession session) throws Exception {
		
		int result = memberService.memberUpdate(memberVO);
		if(result > 0) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect: ./memberPage");
			System.out.println("Update Success");
		} else {
			System.out.println("Update Fail");
		}
		
		return mv;
	}
	
	// memberPage
	@RequestMapping(value = "memberPage")
	public ModelAndView getMemberPage(ModelAndView mv) throws Exception {
		
		mv.setViewName("member/memberPage");
		return mv;
	}
	
	// memberDelete
	@RequestMapping(value = "memberDelete")
	public ModelAndView getMemberDelete(ModelAndView mv, MemberVO memberVO, HttpSession session) throws Exception {
		
		memberVO = (MemberVO)session.getAttribute("member");
		int result = memberService.memberDelete(memberVO);
		if(result > 0) {			
			mv.addObject("result", "회원 탈퇴 성공");
			mv.addObject("url", "./memberLogin");
		} else {
			mv.addObject("result", "회원 탈퇴 실패");
			mv.addObject("url", "./memberPage"); // 미완
		}
		mv.setViewName("common/result");
		return mv;
	}
	
	@RequestMapping(value="memberLogout")
	public ModelAndView getMemberLogout(ModelAndView mv, HttpSession session) {
		
		session.invalidate();
		mv.setViewName("redirect: ../");
		
		return mv;
	}
}
