package com.song.spring_legacy.member;

public class MemberService {

	private MemberDAO memberDAO;
	
	// 의존성 주입(DI)를 위한 생성자 및 setter
	
	
	public MemberService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	// DI 테스트
	public void test() {
		this.memberDAO.test();
		System.out.println("memberService Test");
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
