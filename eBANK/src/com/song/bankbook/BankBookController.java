package com.song.bankbook;

import java.util.ArrayList;
import java.util.Scanner;

import com.song.bank.BankCommonView;

public class BankBookController {

	private Scanner sc;
	private BankBookService bankBookService;
	private BankBookView bankBookView;
	private BankBookInput bankBookInput;
	private BankCommonView bankCommonView;

	
	public BankBookController() {
		sc = new Scanner(System.in);
		bankBookService = new BankBookService();
		bankBookView = new BankBookView(); 
		bankBookInput = new BankBookInput();
		bankCommonView = new BankCommonView();
	}

	
	public void start() {
		
		BankBookDTO bankBookDTO= null;
		String message=null;
		boolean check = true;
		
		while (check) {

			System.out.println("1. 상품 정보 리스트");
			System.out.println("2. 상품 정보 추가");
			System.out.println("3. 상품 판매 결정");
			System.out.println("4. 상품 관리 종료");
			System.out.print("선택 : ");
			int select = sc.nextInt();
			int result = 0;
			switch (select) {
			case 1:
				ArrayList<BankBookDTO> ar = bankBookService.selectList();
				bankBookView.view(ar);
				break;
			case 2:
				bankBookDTO = bankBookInput.insert();
				result = bankBookService.insert(bankBookDTO);
				message = "상품 정보 추가 실패";
				if (result > 0) {
					message = "상품 정보 추가 성공";
				}
				bankCommonView.view(message);
				break;
			case 3:
				bankBookDTO = bankBookInput.updateBookSale();
				result = bankBookService.updateBookSale(bankBookDTO);
				message = "상품 판매 결정 반영 실패";
				if(result > 0) {
					message = "상품 판매 결정 반영 성공";
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
