
# 조건식

- 조건식의 결과 : boolean인 경우 사용

- ```
  if(조건식) {
    ...
  }
  
  if(조건식)
    ...

  if(조건식) {
    ...
  } else {
    ...
  }
  ```

- ```
  switch( 조건식 ) {
      case 1: ~
              break;
      case 2: ~
              break;
      case 3: ~
              break;
      defalut: break;
  }

# 반복문

- for

- while

- do while

# 과제 

```
// 과제 1)
// 등급처리	 90 이상 A
// 			80 이상 B
//			70 이상 C
//			60 이상 D
// 			나머지 F

Scanner sc = new Scanner(System.in);
		
String name = null;
int kor = 0, eng = 0, math = 0;
float avg = 0.0f;
char grade = ' ', gradeOpt = ' ';
		
System.out.println("========= 성적표 =========");
System.out.print("학생 이름 : "); name = sc.nextLine();
System.out.print("국어 점수: "); kor = sc.nextInt();
System.out.print("수학 점수: "); math = sc.nextInt();
System.out.print("영어 점수: "); eng = sc.nextInt();
		
avg = ((float)(kor+eng+math))/3;
System.out.println("========================");
System.out.println("총점 : " + (kor+eng+math));
System.out.printf("평균 : %.2f\n", avg);
		
if(avg>=90) grade = 'A';
else if(avg>=80) grade = 'B';
else if(avg>=70) grade = 'C';
else if(avg>=60) grade = 'D';
else grade = 'F';
		
if((avg/10.0f-(int)avg/10.0f) >= 0.5) gradeOpt = '+';
else gradeOpt = '0';
		
System.out.println("나의 등급은 :" + grade + gradeOpt);
		
sc.close();


// 과제 2)
// 가위바위보

Scanner sc = new Scanner(System.in);
		
byte isWin = 0;	// 0 : win, 1: lose, 2: draw
int pick = 0;
int meInt = 0, comInt = 0;
String me = null, com = null;
		
System.out.println("====== 가위 바위 보 ver. 0.1 ======");
System.out.println("1. 사람 vs 컴퓨터");
System.out.println("2. 사람 vs 사람(준비중)");
System.out.println("3. 종료");
System.out.print(">> 선택 :");
pick = sc.nextInt();
		
switch(pick) {
	case 2: System.out.println("준비중 입니다");
		 	return;
	case 3: System.out.println("게임을 종료합니다");
	        System.exit(0);
}
		
System.out.println(">> 컴퓨터와 대결을 시작합니다");
System.out.print(">> 가위 바위 보 중 하나를 입력하세요 : ");
		
me = sc.next();
		
switch(me) {
	case "가위" : meInt = -1; break;
	case "바위" : meInt = 0; break;
	case "보" : meInt = 1; break;
}
comInt = (int)(Math.random() * 3) - 1;

switch(comInt-meInt) {
	case -1:
	case 2: isWin = 0; break;
	case 1:
	case -2: isWin = 1; break;
	default : isWin = 2;
}
		
switch(comInt) {
	case -1: com = "가위"; break;
	case 0: com = "바위"; break;
	case 1: com = "보"; break;
}
		
System.out.println(">> 컴퓨터와 대결을 시작합니다");
System.out.println(">> 컴퓨터 : " + com + " vs. 사람 : " + me);
		
switch(isWin) {
	case 0: System.out.println(">> 당신이 이겼습니다!"); break;
	case 1: System.out.println(">> 당신이 졌습니다.."); break;
	case 2: System.out.println(">> 비겼습니다"); break;
}
		
sc.close();

// 과제 3.
// 이중 for문으로 구구단 가로 출력

for(int mul=1; mul<=18; mul++) {
			
    if(mul == 10)
    	System.out.println();
	
	if(mul<=9) {
		for(int n=2; n<=5; n++) {
			System.out.printf("%2d * %2d = %2d\t", n, mul, n*mul);
		}
		System.out.println();
	}
			
	else {
		int tmp = mul - 9;
		for(int n=6; n<=9; n++) {
			System.out.printf("%2d * %2d = %2d\t", n, tmp, n*tmp);
		}
		System.out.println();	
	}
}