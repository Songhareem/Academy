package com.song.mysql.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	// 검증 메서드
	public boolean memberError(MemberVO memberVO, BindingResult bindingResult) throws Exception {
		
		// 1. Annotation으로 가능한 검증
		if(bindingResult.hasErrors()) {
			return true;
		}
		
		// 2. ID 중복 검증
		MemberVO isOverlab = memberRepository.memberSelectOne(memberVO);
		if(isOverlab != null) {
			
			bindingResult.rejectValue("id", "memberVO.id.same");
			return true;
		}
		
		// 3. pw 일치여부
		if(!memberVO.getPw().equals(memberVO.getPwCheck())) {
					
			bindingResult.rejectValue("pwCheck", "memberVO.password.notEqual");
			return true;
		}
		
		// 전부 통과
		return false;
	}
	
	public int memberJoin(MemberVO memberVO) throws Exception {
		
		return memberRepository.memberJoin(memberVO);
	}
	
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		
		return memberRepository.memberLogin(memberVO);
	}
}
