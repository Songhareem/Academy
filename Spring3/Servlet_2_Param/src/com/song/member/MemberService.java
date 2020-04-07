package com.song.member;

public class MemberService {

	private MemberDAO memberDAO = null;
	
	public MemberService() {
		
		memberDAO = new MemberDAO(); 
	}
	
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		
		int result = memberDAO.memberJoin(memberDTO);
		
		return result;
	}
}
