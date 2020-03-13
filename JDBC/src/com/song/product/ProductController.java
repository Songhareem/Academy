package com.song.product;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductController {

public void start() throws Exception {
		
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		ProductInput pi = new ProductInput();
		
		while(run) {
			
			System.out.println("======== 상품(계좌)관리 ========");
			System.out.println("1. 상품 정보 등록");
			System.out.println("2. 상품 전체 보기");
			System.out.println("3. 상품 판매 설정");
			System.out.println("4. 상품 정보 삭제");
			System.out.println("5. 종 료");
			System.out.printf("선택 : ");
			int pick = sc.nextInt();
			int result = 0;
			String msg = null;
			ProductDTO pdto = null;
			ProductDAO pdao = new ProductDAO();
			
			System.out.println();
			switch(pick) {
			
			case 1:
				System.out.println("// 상품 정보 등록 //");
				pdto = new ProductInput().insert();
				new ProductView().viewResult(pdao.insert(pdto));
				break;
				
			case 2:
				System.out.println("// 상품 정보 보기 //");
				new ProductView().viewSelect(pdao.selectList());
				break;
			
			case 3:
				System.out.println("// 상품 판매 설정 //");
				pdto = new ProductInput().updateProSale();
				new ProductView().viewResult(pdao.updateProSale(pdto));
				break;
			
			case 4:
				System.out.println("// 부서 전체 보기 //");
				pdto = new ProductInput().delete();
				new ProductView().viewResult(pdao.delete(pdto));
				break;	
			
			case 5:
				System.out.println("프로그램을 종료합니다");
				run = false;
				break;	
			
			default :
				System.out.println("잘못된 선택입니다");
				break;
			}
		}
		
		sc.close();
	}
}
