package lecture_200217.subject;

import java.util.Arrays;
import java.util.Scanner;

public class LottoGame extends Game{

	public void gameLogic() {
		
		int lottoNum[] = new int[] {0, 0, 0, 0, 0, 0, 0};

		while(true) {
		
			if(lottoNum[lottoNum.length-1] != 0) {
				//System.out.println("break;");
				break;				
			}
			
			// 새 로또 값
			int tmp = (int)((Math.random()*45)+1);
			
			for(int i=0; i<lottoNum.length; i++) {

				// 들어간 값과 새 값이 같다면
				if(lottoNum[i] == tmp) {
					//System.out.println("inner break;");
					break;
				}
				
				// 로또 값
				if(lottoNum[i] == 0) {
					lottoNum[i] = tmp;
					break;
				}
			}
		}
		
		Arrays.sort(lottoNum, 0, lottoNum.length-1);
		System.out.print("이번 로또 번호는! : ");
		for(int i=0; i<lottoNum.length; i++)
			System.out.printf("%d ",lottoNum[i]);
		System.out.println();
		//*/
		
		//*/ 로또 번호 입력
		//int lottoNum[] = new int[] {1, 2, 3, 4, 5, 6, 7};
		int getNum[] = new int[6];
		Scanner sc = ScannerSingleton.getInctance();
		
		System.out.println("로또 번호(1~45)7개를 입력해주세요");
		
		int index = 0;
		while(true) {
			
			if(index > getNum.length - 1)
				break;
		
			boolean isOverlapped = false;
			int tmp = sc.nextInt();
			if(tmp<1 || tmp>45) {
				System.out.println("잘못입력했습니다");
				continue;
			}
			
			for(int i=0; i<index; i++) {
				if(getNum[i] == tmp) {
					System.out.println("중복값입니다");
					//System.out.printf("중복값입니다|i : %d|index : %d\n",i,index);
					isOverlapped = true;
					break;
				}
			}
			
			if(!isOverlapped)
				getNum[index++] = tmp;
		}
		Arrays.sort(getNum);
		
		for(int i=0; i<getNum.length; i++)
			System.out.printf("%d ",getNum[i]);
		System.out.println();
		
		// 맞는 갯수 체크 
		int correctNum = 0; 
		boolean bonusCheck = false;
		  
		// 보너스 제외 맞는지 확인 
		for(int i=0; i<lottoNum.length-1; i++) { 
			for(int j=0; j<getNum.length; j++) { 
				if(getNum[j] == lottoNum[i]) { 
					  correctNum++; 
					  break; 
				}
			} 
		}
		//System.out.println("일치하는 갯수는" + correctNum); 
		  
		// 보너스 맞는게 있는지 확인
		for(int i=0; i<getNum.length; i++) {
			if(getNum[i] == lottoNum[lottoNum.length-1]) {
				bonusCheck = true;
				break;
			}
		}
		//System.out.println("보너스는 일치하는지?" + bonusCheck);
		
		// 맞는갯수 및 보너스에 따른 결과 출력		
		switch(correctNum) {
		case 6: System.out.println("1등");
				break;
		case 5: if(bonusCheck)	System.out.println("2등");
				else			System.out.println("3등");
				break;
		case 4: System.out.println("4등");
				break;
		case 3: System.out.println("5등");
				break;
		default: System.out.println("낙첨되었습니다.."); 
				 break;
		}
	}

}
