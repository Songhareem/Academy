package lecture_200206;

import java.util.Scanner;

public class OperatorEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		//*/1. 0 ~ 100 임의의 정수 입력 받아서
		//   3배수 => "3의 배수 맞음"
		//   그렇지 않으면 "3의 배수 아님"
		
		System.out.println("========= 3의 배수 알아보기 ========");
		System.out.print("0 ~ 100 사이의 숫자 하나 입력: ");
		int i = sc.nextInt();
		System.out.println(((0<=i && i<=100) && (i%3 == 0)) ? "3의 배수 맞음":"3의 배수 아님");
		//*/
		
		//*/2. 윤년 계산하기
		//   연도 입력 받아 4로 나누어 떨어지고 100으로 나누어 떨어지지 않으면 윤년
		//   단, 400으로 나누어 지는 경우에는 윤년
		System.out.println("========= 윤년 알아보기 =========");
		System.out.print("연도를 입력해주세요 :");
		int year = sc.nextInt();
		System.out.println((year%400 == 0) || ((year%4 == 0) && (year%100 != 0))?"윤년":"윤년 아님");
		//*/
		
		//*/3. 출금 요청 처리
		//   출금액을 입력받아 동전으로 지급하기
		//   단, 10원 미만은 반올림
		//   ex) 출금액 : 7777원
		//              500원 짜리 :
		//              100원 짜리 :
		//               50원 짜리 :
		//               10원 짜리 :
		
		System.out.print("출금액 :");
		double money = sc.nextDouble();
		int remainMoney = (int)Math.round(money/10)*10;
		
		int coin500 = remainMoney/500;
		remainMoney %= 500;
		
		int coin100 = remainMoney/100;
		remainMoney %= 100;
		
		int coin50 = remainMoney/50;
		remainMoney %= 50;
		
		int coin10 = remainMoney/10;
		remainMoney %= 10;
		
		System.out.printf("500원 짜리 : %02d개\n100원 짜리 : %02d개\n 50원 짜리 : %02d개\n 10원 짜리 : %02d개\n",
				coin500, coin100, coin50, coin10); 
		//*/
		
		sc.close();
	}

}
