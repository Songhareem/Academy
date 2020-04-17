package com.song.Spring_legacy2.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	// memberJoin
	public int memberJoin(MemberVO memberVO) throws Exception {

		return memberDAO.memberJoin(memberVO);
	}

	// memberLogin
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {

		return memberDAO.memberLogin(memberVO);
	}

	// memberUpdate
	public int memberUpdate(MemberVO memberVO) throws Exception {

		return memberDAO.memberUpdate(memberVO);
	}

	// memberDelete
	public int memberDelete(MemberVO memberVO) throws Exception {

		return memberDAO.memberDelete(memberVO);
	}
}
