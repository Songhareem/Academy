package lecture_200211;

import java.util.Scanner;

public class ArrayBingo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 빙고 게임 만들기
		
		int size = 0;
		int max = 0;
		int min = 1;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("======== Bingo Game ========");
		
		// 빙고판의 크기 입력받기
		System.out.print("빙고판의 가로 세로 크기를 입력해주세요 : ");
		size = sc.nextInt();
		max = size*size;

		// 입력된 빙고판의 크기 만큼 숫자 입력받기
		System.out.printf("1 ~ %d 사이의 숫자를 입력해주세요\n", max);
		
		// 빙고판 초기화
		int[][] plate = new int[size][size];
		
		// 유저가 선택한 값들을 저장하기 위한 array 선언 및 초기화
		int cacheIndex = 0;
		int[] cache = new int[max];
		for(int i=0; i<max; i++) cache[i] = -1;
				
		// 빙고판 값 입력받기
		// 입력범위 이내인가?
		// 중복된 숫자는 아닌가?
		// 정상적인 숫자이면 빙고 배열에 저장
		for(int i=0; i<plate.length*plate[0].length; i++) {
			
			int row = i/plate[0].length;
			int col = i%plate[0].length;
			
			int tmp = sc.nextInt();
			boolean errFlag = false;
			
			// 입력범위 값 체크
			if(tmp>max || tmp<min) {
				System.out.println("입력 범위를 넘어선 값 입니다. 다시 입력해주세요");
				errFlag = true;
			}
			
			// 중복값 체크
			for(int j=0; j<max; j++) {
				if(cache[j] == tmp) {
					System.out.println("중복값입니다. 다시 입력해주세요");
					errFlag = true;
					break;
				}
			}
			
			// 문제가 있다면 재시도
			if(errFlag) {
				i--;
				continue;
			}
			
			// 정상적인 숫자는 빙고판에 순차저장, cache에도 저장
			//System.out.print("입력값은" + tmp);
			plate[row][col] = tmp;
			cache[cacheIndex++] = tmp;
		}
		
		// 게임 시작 전 빙고판 출력
		System.out.println("빙고판이 완성되었습니다");
		for (int i = 0; i < plate.length * plate[0].length; i++) {
			int row = i / plate[0].length;
			int col = i % plate[0].length;

			System.out.printf("%2d ", plate[row][col]);
			if (col == plate[0].length - 1)
				System.out.println();
		}
		
		// 유저가 선택한 값들을 저장하기 위한 array 초기화
		cacheIndex = 0;
		for(int i=0; i<max; i++) cache[i] = -1;
		
		// 숫자 입력받아 빙고게임 시작
		while(true) {

			int input = 0;
			boolean isContinue = false;
			boolean isBingo = false;
			System.out.printf("1 ~ %d 사이의 숫자를 입력하세요 (종료 : 0) >>", max);
			input = sc.nextInt();
			
			// 0 입력시 게임 종료
			if(input == 0)
				break;
			
			// 입력 값이 범위 밖이라면 continue;
			if (input > max || input < 1) {
				System.out.println("범위 밖의 값 입니다");
				continue;
			}
			
			// 이미 이전에 고른 값이라면 continue
			for(int i=0; i<max; i++) {
				if(cache[i] == input) {
					System.out.println("이미 골랐던 값 입니다");
					isContinue = true;
					break;
				}
			}

			if(isContinue)
				continue;
			
			// 빙고판 수정 로직
			for (int i = 0; i < plate.length * plate[0].length; i++) {
				int row = i / plate[0].length;
				int col = i % plate[0].length;
				
				// 숫자 교체 로직
				if(input == plate[row][col]) {
					cache[cacheIndex] = plate[row][col];
					plate[row][col]= 0;
					break;
				}
			}
			
			// 빙고판 출력
			for (int i = 0; i < plate.length * plate[0].length; i++) {
				int row = i / plate[0].length;
				int col = i % plate[0].length;

				System.out.printf("%2d ", plate[row][col]);
				if (col == plate[0].length - 1)
					System.out.println();
			}
			System.out.println();
			
			// 빙고 판정 로직
			for (int i = 0; i < plate.length * plate[0].length; i++) {
				int row = i / plate[0].length;
				int col = i % plate[0].length;
				
				int rowMax = plate[0].length;
				int colMax = plate[0].length;
				
				int[] sum = {-1, -1, -1, -1};
				
				// 세로 판정
				if(row == 0) {
					sum[0] = 0;
					for(int j=0; j<rowMax; j++) {
						sum[0] += plate[j][col];
					}
				}
					
				// 가로 판정
				if(col == 0) {
					sum[1] = 0;
					for(int j=0; j<colMax; j++) {
						sum[1] += plate[row][j];
					}
				}
				
				// 대각선 판정 (좌상우하 - 0,0)
				if(row == 0 && col == 0) {
					sum[2] = 0;
					for(int j=0; j<rowMax; j++) {
						sum[2] += plate[j][j];
					}
				}
				
				// 대각선 판정 (우상좌하 - 0,colMax)
				if(row == 0 && col == (colMax-1)) {
					sum[3] = 0;
					for(int j=0; j<rowMax; j++) {
						sum[3] += plate[j][(colMax-1)-j];
					}
				}
				
				// 빙고가 있다면, isBingo = true
				for(int val=0; val<sum.length; val++) {
					if (sum[val] == 0) {
						isBingo = true;
						break;
					}
				}
			}
			
			// 빙고라면 게임 종료
			if(isBingo) {
				System.out.println("빙고!");
				break;
			}
		}
		
		System.out.println("게임이 끝났습니다");
		
		sc.close();
	}
}
