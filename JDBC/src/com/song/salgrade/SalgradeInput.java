package com.song.salgrade;

import java.util.Scanner;

public class SalgradeInput {

private Scanner sc = null;
	
	public void delete() {
		
		sc = new Scanner(System.in);
		
		int grade;
		
		System.out.printf("데이터 삭제할 연봉 등급 입력 : ");
		grade = sc.nextInt();
		
		new SalgradeDAO().delete(grade);
	}
	
	public void insert() {
		
		// 부서번호, 부서명, 지역명을 입력받기
		sc = new Scanner(System.in);
		
		SalgradeDTO sdto = new SalgradeDTO();
		System.out.printf("추가할 연봉 등급 입력 : ");
		sdto.setGrade(sc.nextInt());
		System.out.printf("추가할 최저연봉 입력 : ");
		sdto.setLosal(sc.nextInt());
		System.out.println("추가할 최고연봉 입력 : ");
		sdto.setHisal(sc.nextInt());
		
		new SalgradeDAO().insert(sdto);
	}
}
