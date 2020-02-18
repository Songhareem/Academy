package com.song.t1.ForTest1;

import java.util.Scanner;

public class ForTest3 {

	public static void main(String[] args) {

		int id = 1234;
		int pw = 5678;
		boolean login = false;
		String msg = "로그인에 실패했습니다 가까운 은행 방문을 방문해주세요";
		
		Scanner sc = new Scanner(System.in);
		
		// id, pw 입력 로그인 시도, 최대 3번
		for(int i=0; i<3; i++) {
			
			System.out.printf("아이디를 입력하세요");
			int scId = sc.nextInt();
			System.out.printf("비밀번호를 입력하세요");
			int scPw = sc.nextInt();
			
			if(scId == id && scPw == pw) {
				//login = true;
				msg = "로그인 성공";
				break;
			}
		
			System.out.printf("정보가 일치하지 않습니다 다시 시도해주세요 (%d회 오류)\n",i+1);
		}
		
		// 로그인 성공 : 로그인 성공 출력/ 실패 : 은행 방문 요구
		//if(login)
		//	System.out.println("로그인 성공");
		//else
		//	System.out.println("로그인에 실패했습니다 가까운 은행 방문을 방문해주세요");
		System.out.println(msg);
	}
}
