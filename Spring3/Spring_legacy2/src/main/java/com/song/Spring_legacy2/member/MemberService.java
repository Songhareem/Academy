package com.song.Spring_legacy2.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.Spring_legacy2.member.memberPage.MemberPager;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	// memberList
	public List<MemberVO> memberList(MemberPager pager) throws Exception {
		
		pager.makeRow();
		long totalCount = memberDAO.memberCount(pager);
		pager.makePage(totalCount);
		return memberDAO.memberList(pager);
	}
	
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
