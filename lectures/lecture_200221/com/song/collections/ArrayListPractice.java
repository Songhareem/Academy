package com.song.collections;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListPractice {

	public static void main(String[] args) {

		StudentDAO sdao = new StudentDAO();		
		ArrayList<StudentVO> arrSvo = sdao.makeStudent();
		//sdao.addStudent(arrSvo);
		sdao.view(arrSvo);
		sdao.removeStudent();
		sdao.view(arrSvo);
	}
}

class StudentDAO {
	
	private StringBuffer sb;
	private int studentNum = 4;
	ArrayList<StudentVO> arrSvo;
	StudentVO svo;
	
	public StudentDAO() {
		sb = new StringBuffer();
		sb.append("Han-3-20-30-40-");
		sb.append("Gam-4-50-36-72-");
		sb.append("Ann-1-25-85-37-");
		sb.append("Min-2-95-56-30-");
	}
	
	// makeStudent 메서드
	// 학생 담에서 ArrayList로 리턴
	public ArrayList<StudentVO> makeStudent() {
		
		arrSvo = new ArrayList<StudentVO>();
		
		// 파싱 작업
		String[] parsed = new String(sb).split("-");
		
		// 파싱된 데이터 svo에 삽입
		for(int i=0; i<parsed.length; i++) {
			
			int dataIndex = i%(parsed.length/studentNum);
			
			switch(dataIndex) {
			case 0:
				svo = new StudentVO();
				svo.setName(parsed[i]);
				break;
			case 1:
				svo.setNum(parsed[i]);
				break;
			case 2:
				svo.setKor(Integer.parseInt(parsed[i]));
				break;
			case 3:
				svo.setEng(Integer.parseInt(parsed[i]));
				break;
			case 4:
				svo.setMath(Integer.parseInt(parsed[i]));
				svo.setTotal();
				svo.setAvg();
				arrSvo.add(svo);
				break;
			default:
				System.out.println("error!");
				break;
			}
		}
		
		return arrSvo;
	}
	
	public ArrayList<StudentVO> addStudent(ArrayList<StudentVO> arrSvo) {
		
		Scanner sc = new Scanner(System.in);
		StudentVO svo = new StudentVO();
		
		System.out.println("=== 관리 학생 추가 ===");
		System.out.print("학생 이름 : ");
		svo.setName(sc.next());
		System.out.print("학생 번호 : ");
		svo.setNum(sc.next());
		System.out.print("국어 점수 : ");
		svo.setKor(sc.nextInt());
		System.out.print("영어 점수 : ");
		svo.setEng(sc.nextInt());
		System.out.print("수학 점수 : ");
		svo.setMath(sc.nextInt());
		
		svo.setTotal();
		svo.setAvg();
		
		arrSvo.add(svo);
		
		return arrSvo;
	}
	
	public void removeStudent() {
		
		System.out.println("==== 관리 학생 삭제 ====");
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 학생명 : ");
		String name = sc.next();
		String result = name + "학생 삭제 실패";
		for(int i=0; i<arrSvo.size(); i++) {
			StudentVO svo = arrSvo.get(i);
			if(svo.getName().equals(name)) {
				result = name + "학생 삭제 성공";
				arrSvo.remove(i);
				break;
			}
		}
		System.out.println(result);
	}

	public void view(ArrayList<StudentVO> arrSvo) {
		
		for(int i=0; i<arrSvo.size(); i++) {
			StudentVO svo = arrSvo.get(i);
			System.out.println("==== 성적 출력 ====");
			System.out.printf("이름 : %s\n",svo.getName());
			System.out.printf("번호 : %s\n",svo.getNum());
			System.out.printf("국어 : %d\n",svo.getKor());
			System.out.printf("영어 : %d\n",svo.getEng());
			System.out.printf("수학 : %d\n",svo.getMath());
			System.out.printf("합계 : %d\n",svo.getTotal());
			System.out.printf("평균 : %.2f\n",svo.getAvg());			
		}
	}
	
}

class StudentVO {
	
	private String name;
	private String num;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal() {
		this.total = this.kor + this.eng + this.math;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg() {
		this.avg = this.total/5.0;
	}
}
