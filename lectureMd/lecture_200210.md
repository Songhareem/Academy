
# while(조건식)
- 조건식 결과가 true인 경우에만 처리

# do-while
- 최소 1회 수행 보장하는 while문

# 배열
- 동일한 자료형들을 연속적인 공간에 저장
- 저장된 데이터의 위치는 인덱스를 이용하여 접근
- 한 번 생성된 이후에는 크기변경 불가
    - (더 큰공간이 필요하면 새로운 배열 만들어서 복사처리)
- 많은 데이터 저장할 곳을 한번에 생성
- 자바에서 배열은 하나의 객체로 인식
    - 길이값을 갖는 멤버변수(length)와 여러 메서드 가짐
    - 배열 선언하고 생성하지 않으면 null 값 가짐
    - 변수가 참조하는 객체가 없을 경우 초기값 
- 1차원부터 무한대의 다채원 배열 생성 가능
    - 2차원 이상의 배열은 배열의 배열구조

# 과제

```
        // 로또번호
		// 1 ~ 45 사이의 정수 중, 중복되지 않는 번호 6개
		// 모두 일치하면 1등
		// 5개 일치하고 보너스 일치하면 2등
		// 5개가 일치하면 3등
		// 4개가 일치하면 4등
		// 3개가 일치하면 5등
		// 그 외는 X
		
		// 임의의 당첨번호 6자리와 보너스 번호 1개를 생성
		// 나의 로또 번호 6개를 입력 받아 당첨 여부 확인
		
		//*//
		int lottoNum[] = new int[] {0, 0, 0, 0, 0, 0, 0};

		while(true) {
		
			if(lottoNum[lottoNum.length-1] != 0) {
				//System.out.println("break;");
				break;				
			}
			
			// 새 로또 값
			int tmp = (int)((Math.random()*45)+1);
			
			for(int i=0; i<7; i++) {

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
		
		System.out.print("이번 로또 번호는! : ");
		for(int i=0; i<lottoNum.length; i++)
			System.out.printf("%d ",lottoNum[i]);
		System.out.println();
		//*/
		
		//*/ 로또 번호 입력
		//int lottoNum[] = new int[] {1, 2, 3, 4, 5, 6, 7};
		int getNum[] = new int[6];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("로또 번호(1~45)7개를 입력해주세요");
		
		int index = 0;
		while(true) {
			
			if(index > getNum.length - 1)
				break;
		
			int tmp = sc.nextInt();
			if(tmp<1 || tmp>45) {
				System.out.println("잘못입력했습니다");
				continue;
			}
			
			getNum[index++] = tmp;
		}
		
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

		sc.close();
		//*/
    ```