package com.song.school;

import java.util.ArrayList;

public class StudentView {

	public void view(ArrayList<StudentVO> svoList) {
		
		System.out.print("========================");
		System.out.print(" 성적 출력 ");
		System.out.println("========================");
		System.out.printf("이름\t번호\t국어\t영어\t수학\t총점\t평균\n");
		for(int i=0; i<svoList.size(); i++) {
		
			StudentVO svo = new StudentVO();
			svo = svoList.get(i);
			
			System.out.printf("%s\t", svo.getName());
			System.out.printf("%s\t", svo.getNum());
			System.out.printf("%d\t", svo.getKor());
			System.out.printf("%d\t", svo.getEng());
			System.out.printf("%d\t", svo.getMath());
			System.out.printf("%d\t", svo.getTotal());
			System.out.printf("%.2f\n", svo.getAvg());
			
		}
	}
}
