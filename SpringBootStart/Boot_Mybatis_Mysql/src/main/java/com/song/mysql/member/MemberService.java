package com.song.mysql.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		
		return memberRepository.memberLogin(memberVO);
	}
}
