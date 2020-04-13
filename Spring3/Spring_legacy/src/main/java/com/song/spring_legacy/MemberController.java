package com.song.spring_legacy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/member")
public class MemberController {

	@RequestMapping(value="/memberJoin")
	public void getMemberJoin() {
		
	}
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.POST)
	public void postMemberJoin() {
		System.out.println("memberJoin post");
	}
	
	@RequestMapping(value="/memberLogin")
	public void getMemberLogin() {
		
	}
	
	@RequestMapping(value="/memberLogin", method=RequestMethod.POST)
	public void postMemberLogin() {
		System.out.println("memberLogin post");
	}
	
	@RequestMapping(value="/memberUpdate")
	public void getMemberUpdate() {
		
	}

	@RequestMapping(value="/memberUpdate", method=RequestMethod.POST)
	public String postMemberUpdate() {
		System.out.println("memberUpdate post");
		
		return "redirect: ../";
	}
	
	@RequestMapping(value="/memberPage")
	public void getMemberPage() {
		
	}
	
	@RequestMapping(value="/memberDelete")
	public void getMemberDelete() {
		System.out.println("memberDelete get");
	}
}
