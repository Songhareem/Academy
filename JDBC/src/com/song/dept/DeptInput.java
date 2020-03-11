package com.song.dept;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DeptInput {

	private Scanner sc = null;

	public int selectOne() {
		
		sc = new Scanner(System.in);
		
		int deptno;
		
		System.out.printf("데이터 볼 부서번호 입력 : ");
		deptno = sc.nextInt();
		
		return deptno;
	}
	
	public int delete() {
		
		sc = new Scanner(System.in);
		
		int deptno;
		
		System.out.printf("데이터 삭제할 부서번호 입력 : ");
		deptno = sc.nextInt();
		
		return deptno;
	}
	
	public DeptDTO insert() {
		
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
		
		return ddto;
	}
}
