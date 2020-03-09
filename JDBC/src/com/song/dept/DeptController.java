package com.song.dept;

import java.util.Scanner;

public class DeptController {

	// Start 메서드
	// 1. 부서 등록
	// 2. 부서 삭제
	// 3. 종 료
	
	public void start() {
		
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		DeptInput di = new DeptInput();
		
		while(run) {
			
			System.out.println("======== 부서관리 프로그램 ========");
			System.out.println("1. 부서 등록");
			System.out.println("2. 부서 삭제");
			System.out.println("3. 종 료");
			System.out.printf("선택 : ");
			int pick = sc.nextInt();
			
			switch(pick) {
			
			case 1:
				System.out.println("---- 부서 등록 ----");
				di.insert();
				break;
			case 2:
				System.out.println("---- 부서 삭제 ----");
				di.delete();
				break;
			case 3:
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
