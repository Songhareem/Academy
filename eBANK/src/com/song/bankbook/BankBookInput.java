package com.song.bankbook;

import java.util.Scanner;

public class BankBookInput {

	private Scanner sc = null;

	public BankBookInput() {
		sc = new Scanner(System.in);
	}

	public BankBookDTO insert() {
		BankBookDTO bankBookDTO = new BankBookDTO();
		System.out.print("계좌명 : ");
		bankBookDTO.setBookName(sc.next());
		System.out.print("계좌 상품 정보 : ");
		bankBookDTO.setBookContents(sc.next());
		System.out.print("이율 : ");
		bankBookDTO.setBookRate(sc.nextDouble());
		bankBookDTO.setBookSale(0);
		return bankBookDTO;
	}
	
	public BankBookDTO updateBookSale() {
		BankBookDTO bankBookDTO = new BankBookDTO();
		System.out.print("계좌일련번호 : ");
		String serial = String.valueOf(sc.nextInt());
		bankBookDTO.setBookNumber(serial);
		System.out.print("계좌 판매 여부 : ");
		bankBookDTO.setBookSale(sc.nextInt());
		
		return bankBookDTO;
	}

}
