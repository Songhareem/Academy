package lecture_200206;

import java.util.Scanner;

public class OperatorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "haha";
		String s2 = "haha";
		String s3 = new String("haha");
		String s4 = new String("haha");
		
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s3==s4);
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("========= 시스템 로그인 ========");
		System.out.print("아이디 : ");
		//System.out.println(sc.nextLine() == "admin" ? "관리자 페이지":"일반 사용자 페이지");
		System.out.println(sc.nextLine().equals("admin") ? "관리자 페이지":"일반 사용자 페이지");
		
		sc.close();
	}

}
