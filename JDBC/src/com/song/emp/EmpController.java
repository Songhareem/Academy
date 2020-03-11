package com.song.emp;

import java.util.ArrayList;
import java.util.Scanner;

import com.song.dept.DeptDAO;
import com.song.dept.DeptDTO;
import com.song.dept.DeptInput;
import com.song.dept.DeptView;

public class EmpController {


	public void start() {
		
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			
			System.out.println("======== 고용인 관리 프로그램 ========");
			System.out.println("1. 고용인 정보 등록");
			System.out.println("2. 고용인 정보 삭제");
			System.out.println("3. 고용인 전체 보기");
			System.out.println("4. 고용인 하나 보기");
			System.out.println("5. 고용인 월급 총계");
			System.out.println("6. 고용인 정보 수정");
			System.out.println("7. 종 료");
			System.out.printf("선택 : ");
			int pick = sc.nextInt();
			int result = 0;
			int empno = 0;
			int totalSal = 0;
			String msg = null;
			EmpDTO edto = null;
			EmpInput ei = null;
			
			switch(pick) {
			
			case 1:
				System.out.println("---- 고용인  정보 등록 ----");
				ei = new EmpInput();
				result = new EmpDAO().insert(ei.insert());
				if(result > 0) {
					new EmpView().view("정보 추가 성공");
				} else {
					new EmpView().view("정보 추가 실패");
				}
				break;
				
			case 2:
				System.out.println("---- 고용인  정보 삭제 ----");
				ei = new EmpInput();
				result = new EmpDAO().delete(ei.delete());
				if(result > 0) {
					new EmpView().view("정보 삭제 " + result + "개 성공");
				} else {
					new EmpView().view("정보 삭제 실패");
				}
				break;
			
			case 3:
				System.out.println("---- 고용인 전체 보기 ----");
				ArrayList<EmpDTO> edtoList = new EmpDAO().selectAll();
				if(edtoList == null) {
					new EmpView().view("조회하는 데이터가 없습니다");
				} else {
					new EmpView().view(edtoList);
				}
				break;	
			
			case 4:
				System.out.println("---- 고용인  하나 보기 ----");
				ei = new EmpInput();
				edto = new EmpDAO().selectOne(ei.selectOne());
				if(edto == null) {
					new EmpView().view("조회하는 데이터가 없습니다");
				} else {
					new EmpView().view(edto);
				}
				break;	

			case 5:
				System.out.println("---- 고용인 월급 총계 ----");
				totalSal = new EmpDAO().countSal();
				new EmpView().view(totalSal);
				break;
			
			case 6:
				System.out.println("---- 고용인 정보 수정 ----");
				ei = new EmpInput();
				result = new EmpDAO().update(ei.update());
				if(result > 0) {
					new EmpView().view("정보 수정 " + result + "개 성공");
				} else {
					new EmpView().view("정보 수정 실패");
				}
				break;
				
			case 7:
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
