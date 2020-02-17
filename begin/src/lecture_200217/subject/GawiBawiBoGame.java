package lecture_200217.subject;

import java.util.Scanner;

public class GawiBawiBoGame extends Game{

	@Override
	public void gameLogic() {
		
		Scanner sc = ScannerSingleton.getInctance();

		while (true) {
			byte isWin = 0; // 0 : win, 1: lose, 2: draw
			int pick = 0;
			int meInt = 0, comInt = 0;
			String me = null, com = null;

			System.out.println("====== 가위 바위 보 ver. 0.1 ======");
			System.out.println("1. 사람 vs 컴퓨터");
			System.out.println("2. 사람 vs 사람(준비중)");
			System.out.println("3. 종료");
			System.out.print(">> 선택 :");
			pick = sc.nextInt();

			boolean exceptionChoice = false;
			switch (pick) {
			case 2:
				System.out.println("준비중 입니다");
				return;
			case 3:
				System.out.println("게임을 종료합니다");
				return;
			default:
				exceptionChoice = true;
				break;
			}
			// 1~3 이외의 값 입력시, 재시작
			if(!exceptionChoice)
				continue;

			System.out.println(">> 컴퓨터와 대결을 시작합니다");

			// Game Loop
			do {
				System.out.print(">> 가위 바위 보 중 하나를 입력하세요 : ");

				me = sc.next();

				switch (me) {
				case "가위":
					meInt = -1;
					break;
				case "바위":
					meInt = 0;
					break;
				case "보":
					meInt = 1;
					break;
				}
				comInt = (int) (Math.random() * 3) - 1;

				switch (comInt - meInt) {
				case -1:
				case 2:
					isWin = 0;
					break;
				case 1:
				case -2:
					isWin = 1;
					break;
				default:
					isWin = 2;
				}

				switch (comInt) {
				case -1:
					com = "가위";
					break;
				case 0:
					com = "바위";
					break;
				case 1:
					com = "보";
					break;
				}

				System.out.println(">> 컴퓨터와 대결을 시작합니다");
				System.out.println(">> 컴퓨터 : " + com + " vs. 사람 : " + me);

				switch (isWin) {
				case 0:
					System.out.println(">> 당신이 이겼습니다!");
					break;
				case 1:
					System.out.println(">> 당신이 졌습니다..");
					break;
				case 2:
					System.out.println(">> 비겼습니다");
					break;
				}

				System.out.print("게임을 계속 하시겠습니까?(y/n)");
				String str = sc.next();
				// equalsIgnoreCase 대소문자 상관없이 받음
				// if == "n", end Game Loop
				if (str.equalsIgnoreCase("n")) {
					System.out.println("게임이 끝났습니다!");
					break;
				}
			} while (true);
		}
	}
}
