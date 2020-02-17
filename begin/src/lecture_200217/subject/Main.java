package lecture_200217.subject;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {

		boolean endFlag = true;
		Game game = null;
		
		while(endFlag) {
			
			// 게임 선택
			switch(menu()) {
				case 1: game = new GawiBawiBoGame(); break;
				case 2: game = new LottoGame(); break;
				case 3: game = new BingoGame(); break;
				case 4: game = new RpgGame(); break;
				case 5: endFlag = false; 
						System.out.println("게임끝!");
						break;
				default: 
						System.out.println("게임을 다시 선택해주세요");
						continue;
			}
			
			// 게임 실행
			game.run();
		}
	}
	
	public static int menu() {
		
		Scanner sc = ScannerSingleton.getInctance();
		
		System.out.println("====== REVIEW ALL ======");
		System.out.println("1. 가위 바위 보 게임");
		System.out.println("2. 로또");
		System.out.println("3. 빙고");
		System.out.println("4. RPG");
		System.out.println("5. 종료");
		System.out.println("> 선택 : ");
		int choice = sc.nextInt();
		
		//sc.close();	// java.util.NoSuchElementException 발생

		return choice;
	}
}
