
# 나머지 연산자
- 나누기한 나머지를 반환
- 홀수 또는 짝수 검사에 활용

# 쉬프트 연산자
- 2의 제곱으로 곱하거나 나눔
- 곱셈 또는 나눗셈보다 빠르다

# 비교 연산자
- <, > 초과 미만
- <=, >= 이상 이하
- ==, != 같다면 다르다면 (stack 영역 내 비교)
- 기본형은 전부 사용가능
- 참조형은 == != 사용가능

# 비트 연산자
- 비트단위 연산
- 실수형을 제외한 모든 기본형에 사용 가능
- & : AND 연산, 피연산자가 모두 1이라면 1
- | :  OR 연산, 피연산자 중 하나라도 1이라면 1
- ^ : XOR 연산, 피연산자가 달라야 1

# 논리 연산자
- 피연산자가 t 또는 f 인 경우 사용
- 연산결과 bool
- || :  OR 연산자 - 두개중 하나라도 t 라면 t
- && : AND 연산자 - 둘다 t 라면 t
- || 보다 && 가 우선 순위가 높음

# 삼항 연산자
- 조건식 ? true 구문 : false 구문
- 조건이 true라면 true 구문 반환
- 조건이 false라면 false 구문 반환

# 과제 제출 코드

```
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
```
# 과제?

- 2-1)
    - 논리형 : boolean
    - 문자형 : char
    - 정수형 : byte, short, int, long
    - 실수형 : float, double

- 2-2)
    - long regNo = 0000000000000L;

- 2-3)
    - 리터럴 : 100, 100L, 3.14f
    - 변수 : i, l
    - 키워드 : int, long, float, final
    - 상수 : PI

- 2-4)
    - Byte

- 2-5)
    - "12"
    - "true"
    - "AB"
    - "12"
    - "12"
    - "Java"
    - Error

- 2-6)
    - True
    - NULL
    - Class

- 2-7)
    - $ystem
    - If
    - 자바
    - $MAX_NUM

- 2-8)
    - int
    - float

- 2-9)
    - int i = (int)ch;

- 2-11)
    - byte b = 256;
    - char c = '';
    - char answer = 'no';
    - float f = 3.14;

- 2-12)
    - public static void main(String[] args)
    - public static void main(String args[])
    - public static void main(String[] arv)

- 2-13)
    - float - 0.0
    - long - 0