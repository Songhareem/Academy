package com.song.account;

import java.util.ArrayList;

public class AccountView {

	public void view(ArrayList<AccountDTO> ar) {
		
		System.out.println("계좌번호\t 잔액");
		System.out.println("-----------------------------------");
		
		for (AccountDTO accountDTO : ar) {
			System.out.print(accountDTO.getAccountNum()+"\t");
			System.out.println(accountDTO.getAccountBalance());			
		}
	}
}
