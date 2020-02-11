package lecture_200207;

import java.util.Scanner;

public class ForEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 입력받은 99단 출력
		Scanner sc = new Scanner(System.in);
		
		int n = 0; 
		System.out.print("출력할 단수를 입력해주세요 : ");
		n = sc.next().charAt(0) - '0';	// char2int
		
		for(int i=1; i<=9; i++) {
			System.out.println(n+" x "+i+" = "+(n*i));
		}
		
		sc.close();
	}
}
