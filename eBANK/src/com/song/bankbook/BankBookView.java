package com.song.bankbook;

import java.util.ArrayList;

public class BankBookView {

	public void view(ArrayList<BankBookDTO> ar) {
		
		System.out.println("Number\t\tName\t\tContents\tRate\tSale");
		for(BankBookDTO bankBookDTO: ar) {
			System.out.print(bankBookDTO.getBookNumber() + "\t");
			System.out.print(bankBookDTO.getBookName() + "\t\t");
			System.out.print(bankBookDTO.getBookContents() + "\t\t");
			System.out.print(bankBookDTO.getBookRate()+"%\t");
			if(bankBookDTO.getBookSale()==0) {
				System.out.println("판매 중단");
			}else {
				System.out.println("판매 중");
			}
			System.out.println("------------------------------");
		}
	}
}
