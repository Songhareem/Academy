package lecture_200205;

import java.util.Scanner;

public class TypeCastingEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1) 임의의 문자 입력받아 해당 문자의 아스키 코드값을 10진수로 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("임의의 문자 하나를 입력해주세요 : ");
		char ascii = sc.nextLine().charAt(0);
		System.out.println("입력하신 문자의 아스키 코드 :" + (byte)ascii);
		
		System.out.println("=================================");
		
		System.out.print("임의의 아스키코드 숫자 하나를 입력해주세요 (0~127) : ");
		byte num = sc.nextByte();
		System.out.println("입력하신 아스키코드에 해당하는 문자 : " + (char)num);
	}
}
