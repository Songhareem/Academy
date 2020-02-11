package lecture_200205;

import java.util.Scanner;

public class ScannerInputEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String name = null;
		int principal = 0;
		double interestRate = 0;
		
		System.out.println("===== 이자 계산기 =====");
		System.out.print("고객명 : ");
		name = sc.nextLine();
		System.out.print("원   금 : ");
		principal = sc.nextInt();
		System.out.print("이   율 : ");
		interestRate = sc.nextDouble();
		System.out.println("================================");
		System.out.printf("%s 고객님의 원금 %,d 원의 이자는 %,d 원 입니다\n", name, principal, (int)(principal*interestRate));
		System.out.printf("(이율 %d%% 적용)", (int)(interestRate*100));
		
		sc.close();
	}

}
