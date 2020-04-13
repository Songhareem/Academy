
# 쌍용 주소

- http://lms1.sist.co.kr/worknet/SMember/index.asp

- 강사 PC : 211.238.142.212/download

# 200204 정리

- jdk se 8u241 설치

- jre1.8.0_241 설치

- docs.oracle.com/javase/8/docs/api 를 통해 se 8 api 설치

- IDE 이클립스 사용
    - 글꼴 변경
    - enc -> UTF-8로 맞춤
    - 이클립스에서 저장시 컴파일이 끝난 것
    - 브레이크 포인트 사용법
        - 라인에 더블클릭으로 포인트 잡고, f11로 진행 가능
        - f5: 내부로 들어가는 한 스탭 디버깅
        - f6: 외부에서 진행되는 한 스탭 디버깅
        - f7: 현재 메소드 끝까지 바로 가서 리턴한 후, 메소드 호출
        - f8: 멈췄던 쓰레드를 진행, 다음 브레이크 포인트까지 점프

- 환경변수
    - jdk1.8.0_241\bin 관련 환경변수 Path 설정
    - 사용자 변수 : 로컬
    - 시스템 변수 : 글로벌
    - 시스템 변수에 추가

# 200205 정리

- 리터럴
    - 리터럴의 종류
        - 논리 리터럴(boolean)
            - boolean
        - 문자 리터럴
            - char
        - 정수형 리터럴
            - byte, short, int, long
        - 실수형 리터럴
            - float, double
    - 각 리터럴의 값
        - boolean(1byte) : true or false
        - char(2byte) : '\u0000'등의 유니코드 저장, 아스키 코드와 호환
        - byte(1byte) : -128 ~ 127
        - short(2byte) : -32768 ~ 32767
        - int(4byte) : -2147483648 ~ 2147483647
        - long(8byte) : -9223372036854775808 ~ 9223372036854775807

- 참조 자료형
    - 참조 자료형의 선언 방법
        - ex) String sample;
    - 참조 자료형의 생성 방법
        - ex) new String();
    - 참조 자료형의 선언 및 생성 방법
        - ex) String sample = new String();
    - 참조 자료형의 선언 및 생성과 초기화 방법
        - ex) String sample = new String("Sample");

- printf()
    - 기본형 : System.out.printf()
    - C언어의 printf와 사용법이 같음

- Scanner 사용 방법
    - import java.util.Scanner 를 통해 사용
    - 키보드에서 값을 받기위해 System.in과 함께 사용
    - 선언 및 생성(키보드 인풋)
        - Scanner sc = new Scanner(System.in);
    - 주 사용 함수
        - sc.nextInt();
        - sc.nextLine();
    - 사용 종료시
        - sc.close(); 

- 형변환
    - 묵시적 변환
        - 작은 변수값을 큰 변수값에 넣을때 발생(int -> float 등)
        - casting을 따로 해줄 필요 없음
    - 명시적 변환
        - 큰 변수값을 작은 변수값에 넣을때 발생(float -> int 등)
        - casting 따로 필요, ex) int i = (int)5.5f;

# Project import 후 Err 해결?

- project
    - fire -> import -> General -> Existing Project ... -> Browser -> 플로젝트 폴더 선택
    - import할 프로젝트 선택

- Err 구간
    - JDK 에러(자바 코드 내에서 빨간 밑줄 가면 보통 JDK 에러)
        - 해결 : 프로젝트 우클릭 -> properties -> Java Build Path -> Libraries탭 -> JDK선택 -> Edit -> Alternate JRE 세팅 또는 Workspace default JRE 세팅
    - 서버 에러
        - 해결 : 프로젝트 우클릭 -> properties -> targeted runtimes -> 내가 프로젝트에 사용했던 서버로 변경