package com.song.member;

import java.util.Scanner;

import com.song.member.MemberDTO;

public class MemberInput {

	Scanner sc = new Scanner(System.in);
	
	public MemberDTO updateMemGetSns() {
		
		MemberDTO mdto = new MemberDTO();
		
		System.out.print("수정하려는 컬럼의 ProNum 입력 : ");
		mdto.setMemNum(sc.nextLong());
		// 0 ~ 1 != 반복
		System.out.print("ProSale 값 입력(판매중  = 1 , 판매중단 = 0) : ");
		mdto.setMemGetSns(sc.nextBoolean());

		return mdto;
	}
	
	// delete
	public MemberDTO delete() {
		
		MemberDTO mdto = new MemberDTO();
		
		System.out.print("지우려는 컬럼의 NumNum 입력 : ");
		mdto.setMemNum(sc.nextLong());

		return mdto;
	}
	
	// insert
	public MemberDTO insert() {
		
		MemberDTO mdto = new MemberDTO();
		
		System.out.print("MemNum 입력 : ");
		mdto.setMemNum(sc.nextLong());
		System.out.print("MemName 입력 : ");
		mdto.setMemId(sc.next());
		System.out.print("MemComment 입력 : ");
		mdto.setMemPw(sc.next());
		System.out.print("ProRate 입력(% 제외) : ");
		mdto.setMemName(sc.next());
		System.out.print("ProRate 입력(% 제외) : ");
		mdto.setMemName(sc.next());
		System.out.print("ProRate 입력(% 제외) : ");
		mdto.setMemName(sc.next());
		System.out.print("ProRate 입력(% 제외) : ");
		mdto.setMemName(sc.next());
		System.out.print("ProRate 입력(% 제외) : ");
		mdto.setMemName(sc.next());
		System.out.print("ProRate 입력(% 제외) : ");
		mdto.setMemName(sc.next());

		return mdto;
	}
}
