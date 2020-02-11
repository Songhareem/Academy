package lecture_200205;

import java.util.Scanner;

public class ScannerInput {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		
		System.out.print("실수 입력 : "); System.out.println("입력 데이터: " +
		scan.nextDouble());
		
		scan.nextLine();
		
		System.out.println("문자열 입력: "); System.out.println("입력 문자열: " +
		scan.nextLine());
		
		System.out.print("정수 입력 : "); System.out.println("입력 데이터: " +
		scan.nextInt()); 

		scan.nextLine();
		
		System.out.print("정수 입력 : ");
		System.out.println("입력 데이터에 10을 더한 값: " + (10 + Integer.parseInt(scan.nextLine())));

		scan.close();
	}
}
