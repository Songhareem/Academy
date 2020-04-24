package com.song.Spring_legacy2.member;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.song.Spring_legacy2.member.memberFile.MemberFileVO;
import com.song.Spring_legacy2.util.Pager;

@Controller
@RequestMapping(value = "/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping("memberIdCheck")
	public ModelAndView memberIdCheck(MemberVO memberVO, ModelAndView mv) throws Exception {
		
		long result = memberService.memberIdCheck(memberVO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@RequestMapping(value = "memberList")
	public ModelAndView getMemberList(Pager pager, ModelAndView mv) throws Exception {
		
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
	public ModelAndView postMemberJoin(ModelAndView mv, MemberVO memberVO, MultipartFile thumb, HttpSession session) throws Exception {
		
		// 파일 업로드시 실제 이름
		//String thumbName = thumb.getOriginalFilename();
		// 파라미터 명
		//System.out.println(thumb.getName());
		// 파일 사이즈(용량)
		//System.out.println(thumb.getSize());
		// 파일 확장자
		//System.out.println(thumb.getContentType());
		
		// 클라와의 연결 스트림
		// thumb.getInputStream();
		
		int result = memberService.memberJoin(memberVO, thumb, session);
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
	public ModelAndView getMemberLogin(ModelAndView mv, @CookieValue(value = "uid", required = false) String uid) throws Exception {
		
		//mv.addObject("uid", uid);
		mv.setViewName("member/memberLogin");
		return mv;
	}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	public ModelAndView postMemberLogin(ModelAndView mv, String remember, MemberVO memberVO, HttpServletResponse response, HttpSession session) throws Exception {
		
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
	
	// memberFileDelete
	@RequestMapping(value = "memberFileDelete")
	public ModelAndView getMemberFileDelete(ModelAndView mv, HttpSession session) throws Exception {
		
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId(memberVO.getId());
		int result = memberService.MemberFileDelete(memberFileVO, session);
		if(result > 0) {
			mv.setViewName("redirect: ./memberPage");
		}
		
		return mv;
	}
	
	// memberDelete
	@RequestMapping(value = "memberDelete")
	public ModelAndView getMemberDelete(ModelAndView mv, MemberVO memberVO, HttpSession session) throws Exception {
		
		memberVO = (MemberVO)session.getAttribute("member");
		int result = memberService.memberDelete(memberVO);
		if(result > 0) {			
			session.invalidate();
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
