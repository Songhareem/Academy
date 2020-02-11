package lecture_200207;

import java.util.Scanner;

public class ifEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 과제 1)
		// 등급처리	90 이상 A
		// 			80 이상 B
		//			70 이상 C
		//			60 이상 D
		// 			나머지 F
				
		Scanner sc = new Scanner(System.in);
		
		String name = null;
		int kor = 0, eng = 0, math = 0;
		float avg = 0.0f;
		char grade = ' ', gradeOpt = ' ';
		
		System.out.println("========= 성적표 =========");
		System.out.print("학생 이름 : "); name = sc.nextLine();
		System.out.print("국어 점수: "); kor = sc.nextInt();
		System.out.print("수학 점수: "); math = sc.nextInt();
		System.out.print("영어 점수: "); eng = sc.nextInt();
		
		avg = ((float)(kor+eng+math))/3;
		System.out.println("========================");
		System.out.println("총점 : " + (kor+eng+math));
		System.out.printf("평균 : %.2f\n", avg);
		
		if(avg>=90) grade = 'A';
		else if(avg>=80) grade = 'B';
		else if(avg>=70) grade = 'C';
		else if(avg>=60) grade = 'D';
		else grade = 'F';
		
		if((avg/10.0f-(int)avg/10.0f) >= 0.5) gradeOpt = '+';
		else gradeOpt = '0';
		
		System.out.println("나의 등급은 :" + grade + gradeOpt);
		
		sc.close();
	}

}
