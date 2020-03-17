package com.song.member;

import java.util.Scanner;

import com.song.bankbook.BankBookService;
import com.song.bankbook.BankBookView;

public class MemberSubController {

	private Scanner sc;
	private BankBookService bankBookService = null;
	private BankBookView bankBookView = null;
	private MemberInput memberInput = null;
	
	public MemberSubController() {
		sc = new Scanner(System.in);
		bankBookService = new BankBookService();
		bankBookView = new BankBookView();
		memberInput = new MemberInput();
	}
	
	public void subStart() {
		
		MemberDTO memberDTO = (MemberDTO)MemberSession.getSession("member");
		System.out.println(memberDTO.getMemberID()+"님 환영합니다");

		boolean check = true;
		while(check) {
			
			System.out.println("1. 상품리스트");
			System.out.println("2. 로그아웃");
			System.out.print("선택 : ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				bankBookView.view(bankBookService.selectList());
				String number = memberInput.buy();
				if(number != null) {
					System.out.println("Buy :" + number);
				}
				break;
			default:
				check = false;
				MemberSession.removeSession("member");
				break;
			}
		}
	}
}
