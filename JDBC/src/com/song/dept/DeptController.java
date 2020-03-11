package com.song.dept;

import java.util.ArrayList;
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
			System.out.println("1. 부서 정보 등록");
			System.out.println("2. 부서 정보 삭제");
			System.out.println("3. 부서 전체 보기");
			System.out.println("4. 부서 하나 보기");
			System.out.println("5. 종 료");
			System.out.printf("선택 : ");
			int pick = sc.nextInt();
			int result = 0;
			int deptno = 0;
			String msg = null;
			DeptDTO ddto = null;
			
			switch(pick) {
			
			case 1:
				System.out.println("---- 부서 정보 등록 ----");
				ddto = di.insert(); 
				result = new DeptDAO().insert(ddto);
				msg = "업데이트 실패";
				if(result > 0) {
					msg = result + "개의 컬럼 업데이트";
				}
				new DeptView().view(msg);
				break;
				
			case 2:
				System.out.println("---- 부서 정보 삭제 ----");
				deptno = di.delete();
				result = new DeptDAO().delete(deptno);
				msg = "삭제 실패";
				if(result > 0)
					msg = result + "개의 컬럼 삭제";
				new DeptView().view(msg);
				break;
			
			case 3:
				System.out.println("---- 부서 전체 보기 ----");
				ArrayList<DeptDTO> ddtoList = new ArrayList<DeptDTO>();
				ddtoList = new DeptDAO().select();
				if(ddtoList == null) {
					new DeptView().view("조회하는 데이터가 없습니다");
				} else {
					new DeptView().view(ddtoList);
				}
				break;	
			
			case 4:
				System.out.println("---- 부서 하나 보기 ----");
		        deptno = di.selectOne();
				ddto = new DeptDAO().selectOne(deptno);
				if(ddto == null) {
					new DeptView().view("조회하는 데이터가 없습니다");
				} else {
					new DeptView().view(ddto);
				}
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
