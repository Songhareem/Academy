package com.song.emp;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class EmpInput {

	Scanner sc = null;
	
	// sal, comm 수정 empno 사용
	public EmpDTO update() {
		
		EmpDTO edto = new EmpDTO();
		
		sc = new Scanner(System.in);
		
		System.out.println("수정할 고용인 정보 입력");
		System.out.print("수정할 고용인 사번 : ");
		edto.setEmpno(sc.nextInt());
		System.out.print("수정할 고용인 연봉액 : ");
		edto.setSal(sc.nextDouble());
		System.out.print("수정할 고용인 인센액 : ");
		edto.setComm(sc.nextDouble());
		
		return edto;
	}
	
	// empno 사용
	public EmpDTO delete() {
		
		EmpDTO edto = new EmpDTO();
		
		sc = new Scanner(System.in);
		
		System.out.print("삭제할 고용인 사번 : ");
		edto.setEmpno(sc.nextInt());
		
		return edto;
	}
	
	public EmpDTO insert() {
		
		EmpDTO edto = new EmpDTO();
		
		sc = new Scanner(System.in);
		
		System.out.println("고용인 정보 입력"); 
		System.out.print("empno : ");
		edto.setEmpno(sc.nextInt()); 
		System.out.print("ename : ");
		edto.setEname(sc.next()); 
		System.out.print("job : "); edto.setJob(sc.next());
		System.out.print("mgr : "); edto.setMgr(sc.next()); 
		SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd"); 
		String date = format1.format(System.currentTimeMillis()); 
		edto.setHiredate(Date.valueOf(date));
		System.out.print("sal : "); edto.setSal(sc.nextDouble());
		System.out.print("comm : "); edto.setComm(sc.nextDouble());
		 
		int deptno = 0;
		boolean checkDeptno = true;
		while(checkDeptno) {
			System.out.print("deptno(10,20,30 중 기입): ");		
			deptno = sc.nextInt();
			switch(deptno) {
			case 10:
			case 20:
			case 30:				
				edto.setDeptno(deptno);
				checkDeptno = false;
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해주세요");
				break;
			}
		}
		
		/*
		 * while(true) { System.out.println("save"); if((sc.next()).equals("1")) {
		 * break; } }
		 */
		
		return edto;
	}
	
	public EmpDTO selectOne() {
		
		EmpDTO edto = new EmpDTO();
		
		sc = new Scanner(System.in);
		
		System.out.print("찾는 사람의 이름을 입력하세요(부분입력 가능) : ");
		String ename = sc.next();
		
		edto.setEname(ename);
		
		return edto;
	}
}
