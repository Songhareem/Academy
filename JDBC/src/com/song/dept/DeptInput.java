package com.song.dept;

import java.util.Scanner;

public class DeptInput {

	private Scanner sc = null;
	
	public void delete() {
		
		sc = new Scanner(System.in);
		
		int deptno;
		
		System.out.printf("데이터 삭제할 부서번호 입력 : ");
		deptno = sc.nextInt();
		
		DeptDAO ddao = new DeptDAO();
		ddao.delete(deptno);
	}
	
	public void insert() {
		
		// 부서번호, 부서명, 지역명을 입력받기
		sc = new Scanner(System.in);
		
		int deptno;
		String dname = null;
		String loc = null;
				
		System.out.printf("추가할 부서번호 입력 : ");
		deptno = sc.nextInt();
		System.out.printf("추가할 부서명 입력 : ");
		dname = sc.next();
		System.out.println("추가할 지역 입력 : ");
		loc = sc.next();
		
		DeptDTO ddto = new DeptDTO();
		ddto.setDeptno(deptno);
		ddto.setDname(dname);
		ddto.setLoc(loc);
		
		DeptDAO ddao = new DeptDAO();
		ddao.insert(ddto);
		
	}
}
