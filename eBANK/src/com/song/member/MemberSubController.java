package com.song.member;

import java.util.ArrayList;
import java.util.Scanner;

import com.song.account.AccountDTO;
import com.song.account.AccountService;
import com.song.account.AccountView;
import com.song.bank.BankCommonView;
import com.song.bankbook.BankBookService;
import com.song.bankbook.BankBookView;

public class MemberSubController {

	private Scanner sc;
	private BankBookService bankBookService = null;
	private BankBookView bankBookView = null;
	private MemberInput memberInput = null;
	private AccountService accountService = null;
	private BankCommonView bankCommonView = null;
	private AccountView accountView = null;
	
	public MemberSubController() {
		sc = new Scanner(System.in);
		bankBookService = new BankBookService();
		bankBookView = new BankBookView();
		memberInput = new MemberInput();
		accountService = new AccountService();
		bankCommonView = new BankCommonView();
		accountView = new AccountView();
	}
	
	public void subStart() {
		
		MemberDTO memberDTO = (MemberDTO)MemberSession.getSession("member");
		String userId = memberDTO.getMemberID();
		System.out.println(userId +"님 환영합니다");

		boolean check = true;
		String message = null;
		while(check) {
			
			System.out.println("1. 상품리스트");
			System.out.println("2. 가입상품조회");
			System.out.println("3. 로그아웃");
			System.out.print("선택 : ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				bankBookView.view(bankBookService.selectList());
				String number = memberInput.buy();
				if(number != null) {
					System.out.println("Buy :" + number);
					AccountDTO accountDTO = new AccountDTO();
					accountDTO.setBookNumber(number);
					accountDTO.setMemberID(userId);
					select = accountService.insert(accountDTO);
					message = "계좌 개설 실패";
					if(select > 0) {
						message = "계좌 개설 성공";
					}
					bankCommonView.view(message);
				}
				break;
			case 2:
				ArrayList<AccountDTO> ar2 = accountService.selectList(memberDTO.getMemberID());
				accountView.view(ar2);				
				break;
			default:
				check = false;
				MemberSession.removeSession("member");
				break;
			}
		}
	}
}
