package com.song.school;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDAO {
	
	public StudentVO addStudent(String path) {
		
		StudentVO svo = new StudentVO();
		Scanner sc = new Scanner(System.in);
		FileWriter fw = null;
		
		//*/
		System.out.println("---- 학생 추가 ----");
		System.out.print("이름 : ");
		svo.setName(sc.next());
		System.out.print("학번 : ");
		svo.setNum(sc.next());
		System.out.print("국어 : ");
		svo.setKor(sc.nextInt());
		System.out.print("영어 : ");
		svo.setEng(sc.nextInt());
		System.out.print("수학 : ");
		svo.setMath(sc.nextInt());
		//*/
		
		try {
			fw = new FileWriter(path, true);
			StringBuffer tmp = new StringBuffer();
			tmp.append(svo.getName()+",");
			tmp.append(svo.getNum()+",");
			tmp.append(svo.getKor()+",");
			tmp.append(svo.getEng()+",");
			tmp.append(svo.getMath()+"\r\n");
			
			fw.write(tmp.toString());
			fw.flush();
			
		} catch (Exception e) {
			System.out.println("fwWriterErr");
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				System.out.println("fwCloseErr");
				e.printStackTrace();
			}
		}		

		System.out.println("---- 추가 완료 ----");
		
		return svo;
	}
	
	// 읽어서 쉼표기준 파싱 해서 VO에 넣고 총점, 평균 만들어서 return
	public ArrayList<StudentVO> init() {
		
		ArrayList<StudentVO> svoList = new ArrayList<StudentVO>();
		
		// file read
		File file = new File("C:\\test", "student.txt");
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String str = null;
			while((str = br.readLine()) != null) {
				
				String[] tmp = str.split(",");

				StudentVO svo = new StudentVO();
				svo.setName(tmp[0]);
				svo.setNum(tmp[1]);
				svo.setKor(Integer.parseInt(tmp[2]));
				svo.setEng(Integer.parseInt(tmp[3]));
				svo.setMath(Integer.parseInt(tmp[4]));
				svo.setTotal();
				svo.setAvg();
				
				svoList.add(svo);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return svoList;
	}
	
	public void searchStudent(ArrayList<StudentVO> svoList) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("찾는 학생명 : ");
		String name = sc.next();
		
		for (StudentVO svo : svoList) {
			if(svo.getName().equals(name)) {
				System.out.println("---- 찾는 학생 정보 ----");
				System.out.printf("이름\t번호\t국어\t영어\t수학\t총점\t평균\n");
				System.out.printf("%s\t", svo.getName());
				System.out.printf("%s\t", svo.getNum());
				System.out.printf("%d\t", svo.getKor());
				System.out.printf("%d\t", svo.getEng());
				System.out.printf("%d\t", svo.getMath());
				System.out.printf("%d\t", svo.getTotal());
				System.out.printf("%.2f\n", svo.getAvg());
				return;
			}
		}
		
		System.out.println("찾는 학생이 없습니다");
	}
	
	public void deleteStudent(ArrayList<StudentVO> svoList) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("삭제할 학생 번호: ");
		String num = sc.next();
		StudentVO svo = new StudentVO(); 
		
		FileWriter fw = null;
		boolean writeFlag = false;
		
		// 해당하는 번호 학생이 있다면 svoList에서 삭제
		for(int i=0; i<svoList.size(); i++) {
			
			svo = svoList.get(i);
			if(svo.getNum().equals(num)) {
				// 삭제
				svoList.remove(i);
				writeFlag = true;
				break;
			}
		}
		
		// 삭제했다면 덮어쓰기 
		if(writeFlag) {
			
			try {
				fw = new FileWriter("C:\\test\\Student.txt", false);
				StringBuffer txt = new StringBuffer();
				for (StudentVO svoTmp : svoList) {
					txt.append(svoTmp.getName() +",");
					txt.append(svoTmp.getNum()+",");
					txt.append(svoTmp.getKor()+",");
					txt.append(svoTmp.getEng()+",");
					txt.append(svoTmp.getMath()+"\r\n");
				}
			
				fw.write(txt.toString());

			} catch (Exception e) {
				System.out.println("fwWriterErr");
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					System.out.println("fwCloseErr");
					e.printStackTrace();
				}
			}
			
			System.out.printf("%s번 학생 정보가 삭제되었습니다\n", num);
			return;
		}
		
		System.out.println("삭제할 학생 정보가 없습니다");
	}
}
