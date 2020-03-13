package com.song.product;

import java.util.Scanner;

public class ProductInput {

	Scanner sc = new Scanner(System.in);
	
	public ProductDTO updateProSale() {
		
		ProductDTO pdto = new ProductDTO();
		
		System.out.print("수정하려는 컬럼의 ProNum 입력 : ");
		pdto.setProNum(sc.next());
		// 0 ~ 1 != 반복
		System.out.print("ProSale 값 입력(판매중  = 1 , 판매중단 = 0) : ");
		pdto.setProSale(sc.nextInt());

		return pdto;
	}
	
	public ProductDTO delete() {
		
		ProductDTO pdto = new ProductDTO();
		
		System.out.print("지우려는 컬럼의 ProNum 입력 : ");
		pdto.setProNum(sc.next());

		return pdto;
	}
	
	public ProductDTO insert() {
		
		ProductDTO pdto = new ProductDTO();
		
		System.out.print("ProNum 입력 : ");
		pdto.setProNum(sc.next());
		System.out.print("ProName 입력 : ");
		pdto.setProName(sc.next());
		System.out.print("ProComment 입력 : ");
		pdto.setProComment(sc.next());
		System.out.print("ProRate 입력(% 제외) : ");
		pdto.setProRate(sc.nextDouble());
		// 0 ~ 1 != 반복
		System.out.print("ProSale 입력(판매중 = 1, 판매중단 = 0) : ");
		pdto.setProSale(sc.nextInt());

		return pdto;
	}
}
