package com.song.member;

import java.util.Scanner;

import com.song.bank.BankCommonView;

public class MemberFrontController {

	Scanner sc = null;
	MemberInput memberInput = null;
	MemberService memberService = null;
	BankCommonView bankCommonView = null;
	MemberSubController memberSubController = null;
	
	public MemberFrontController() {
		// TODO Auto-generated constructor stub
		sc = new Scanner(System.in);
		memberInput = new MemberInput();
		memberService = new MemberService();
		bankCommonView = new BankCommonView();
		memberSubController = new MemberSubController();
	}
	
	public void start() throws Exception {
		
		MemberDTO memberDTO = new MemberDTO();
		String message = null;
		boolean check = true;
		boolean isLogin = false;
		
		while(check) {
			
			if (MemberSession.getSession("member") != null) {
				memberSubController.subStart();
			} else {
				System.out.println("1. 로그인");
				System.out.println("2. 회원가입");
				System.out.println("3. 종료");
				System.out.print("선택 : ");
				int select = sc.nextInt();
				int result = 0;
				
				switch (select) {
				case 1:
					memberDTO = memberInput.login();
					memberDTO = memberService.login(memberDTO);
					message = "로그인 실패";
					if(memberDTO != null) {
						message = "로그인 성공";
						MemberSession.setSession("member", memberDTO);
					}
					bankCommonView.view(message);
					break;
				case 2:
					memberDTO = memberInput.insert();
					result = memberService.insert(memberDTO);
					message = "회원 가입 실패";
					if(result > 0) {
						message = "회원 가입 성공";
					}
					bankCommonView.view(message);
					break;
				
				default:
					check = false;
					break;
				}
			}
		}
	}
}
