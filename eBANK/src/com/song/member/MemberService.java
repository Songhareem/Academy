package com.song.member;

public class MemberService {

	private MemberDAO memberDAO = null;

	public MemberService() {
		
		memberDAO = new MemberDAO();
	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		
		return memberDAO.login(memberDTO);
	}
	
	public int insert(MemberDTO memberDTO) throws Exception {
		
		// BankBook insert
		// 일련번호(겹치지 않는 랜덤한 수) 만들어주기
		// 1. 현재 시간을 밀리세컨즈로 변환
		// 2. DB시퀀스 번호를 받아오기(DB에서 시퀀스 미리 만들어줘야 함)
		// 3. Java에서 제공하는 API
		
		// this.useTime();
		// this.useApi();
		
		int result = 0;
		result = memberDAO.insert(memberDTO);
		
		return result;
	}
}
