package com.song.member;

import java.util.Scanner;


public class MemberInput {

	Scanner sc = null;
	MemberDTO memberDTO = null;
	
	public MemberInput() {
		sc = new Scanner(System.in);
	}
	
	public String buy() {
		
		String number = null;
		
		System.out.println("1. 구매");
		System.out.println("2. 취소");
		System.out.print("선택 : ");
		int select = sc.nextInt();
		
		if(select == 1) {
			System.out.print("구매할 상품의 번호를 입력 : ");
			number = sc.next();
		}
		
		return number;
	}
	
	public MemberDTO login() {
		
		memberDTO = new MemberDTO();
		
		System.out.print("ID : ");
		memberDTO.setMemberID(sc.next());
		System.out.print("PW : ");
		memberDTO.setMemberPW(sc.next());
		
		return memberDTO;
	}
	
	public MemberDTO insert() {
		
		sc = new Scanner(System.in);
		memberDTO = new MemberDTO();
		
		System.out.print("ID : ");
		memberDTO.setMemberID(sc.next());
		System.out.print("PW : ");
		memberDTO.setMemberPW(sc.next());
		System.out.print("이름 : ");
		memberDTO.setMemberName(sc.next());
		System.out.print("핸드폰번호: ");
		memberDTO.setMemberPhone(sc.next());
		System.out.print("이메일 : ");
		memberDTO.setMemberEmail(sc.next());
		
		return memberDTO;
	}
}
