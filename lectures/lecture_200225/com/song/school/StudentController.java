package com.song.school;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {

	private StudentDAO sdao = new StudentDAO();
	private ArrayList<StudentVO> svoList = new ArrayList<StudentVO>();
	private StudentView sv = new StudentView();
	
	public void start() {
			
		// 1. 전체 학생 출력
		// 2. 학생 정보 추가
		// 3. 학생 정보 검색(이름으로)
		// 4. 학생 정보 삭제(번호로) - 덮어쓰기
		// 5. 프로그램 종료
		Scanner sc = null;
			
		while(true) {
			
			sc = new Scanner(System.in);
			
			System.out.printf("\t[학생 관리 서비스]\n");
			System.out.println("1. 전체 학생 출력");
			System.out.println("2. 학생 정보 추가");
			System.out.println("3. 학생 정보 검색");
			System.out.println("4. 학생 정보 삭제");
			System.out.println("5. 프로그램 종료");
			
			String service = sc.next();
			System.out.println(service);
			
			switch(service) {
				case "1":
					svoList = sdao.init();
					sv.view(svoList);
					break;
				case "2":
					StudentVO svo = sdao.addStudent("C:\\test\\student.txt");  
					svoList.add(svo);
					break;
				case "3":
					sdao.searchStudent(svoList);
					break;
				case "4":
					sdao.deleteStudent(svoList);
					break;
				case "5":
					System.out.println("프로그램이 종료됩니다");
					sc.close();
					return;
				default:
					System.out.println("잘못된 선택입니다 서비스 선택을 다시해주십시오");
					break;
			}
		}
		
	}
}
