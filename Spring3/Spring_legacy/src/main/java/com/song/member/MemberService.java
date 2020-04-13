package com.song.member;

public class MemberService {

	private MemberDAO memberDAO;
	
	public MemberService() {
	
		memberDAO = new MemberDAO();
	}
	
	// memberJoin
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		
		return memberDAO.memberJoin(memberDTO);
	}
	
	// memberLogin
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		
		return memberDAO.memberLogin(memberDTO);
	}
	
	// memberUpdate
	public int memberUpdate(MemberDTO memberDTO) throws Exception {
		
		return memberDAO.memberUpdate(memberDTO);
	}
	
	// memberDelete
	public int memberDelete(MemberDTO memberDTO) throws Exception {
	
		return memberDAO.memberDelete(memberDTO);
	}
}
