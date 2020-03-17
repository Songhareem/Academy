package com.song.bank;

import com.song.bankbook.BankBookController;
import com.song.member.MemberFrontController;

public class BankMain {

	public static void main(String[] args) {

		//BankBookController bankBookController = new BankBookController();
		//bankBookController.start();	
		try {
			MemberFrontController memberFrontController = new MemberFrontController();
			memberFrontController.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
