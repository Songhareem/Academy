
# 멀티쓰레드

# ORACLE DB 세팅

- Oracle DB는 삭제시, trash 값이 많이 남음
    - 가장 좋은 해결이 포멧
    - 그래서 VM위에 설치

- 가상 컴퓨터 솔루션
    - Virtual BOX <선택> (Window10.iso 준비)
    - VM ware 등

- virtual box setting
    - 새로만들기
    - 이름 기입, 경로는 영문 경로로, OS 및 버전 선택
    - 2G Ram
    - 새 가상 디스크 만들기
    - VDI 선택
    - 동적할당
    - (보통 디폴트값) 만들기
    
    - 새 가상 컴퓨터 설정
    - 마우스 우클릭 설정
        - 네트워크 탭
            - NAT 놔두고, 어댑터2에서 호스트 전용 어댑터 추가(Host Only) 후, 확인
        - 시스템 탭
            - Ram 차후 수정 가능
        - 저장소 탭
            - CD import window10.iso
    
    - 가상 컴퓨터 시작
        - 윈도우 설치
        - 사용자 지정 설치
        - 파티션은 실무에선 나누겠으나 현재는 나누지 않음

- 호스트 PC
    - 본래 OS가 깔린 PC
- 게스트 PC
    - 가상 OS가 깔린 가상 머신
    - 각 OS는 게스트로 호칭
    - 각 게스트는 호스트 PC를 공유기로 생각
    - NAT : 외부 네트워크와 통신
    - 호스트 전용 어댑터 : 호스트 PC와의 통신을 위해 사용

# Oracle DB 다운로드

- 게스트에
    - ref : https://www.oracle.com/kr/downloads/

    - 11g로 다운로드 및 설치
        - 다운로드 : https://www.oracle.com/database/technologies/xe-prior-releases.html
        - 관리자 아이디 : SYS
        - 비번 : oracle
        - Listener port : 1521
            - 로컬 접속 포트
        - HTTP Listener port : 8080
            - 웹으로 접속할 때 쓰는 포트

    - JDK se8 다운로드 및 설치
        - 설치 후, 환경변수

- 호스트에
    - Oracle DB 접속 개발자 툴(SQP Developer) 다운
        - jdk 8 안깔려있으면 포함된걸로 아니면 포함하는걸로

# DB 접속 방법

- SQLPLUS 도구로 접속
    - 내장된 SQLPLUS 직접실행 
        - 시작 - run sql command line
            - 관리자 로그인 : conn sys/oracle as sysdba;
            - 일반유저 로그인 : conn sys/oracle(= id/pw)
    - CMD 내에서 SQLPLUS 실행
        - cmd 실행
        - 관리자 로그인 sqlplus sys/oracle as sysdba
        - 일반유저 로그인 sqlplus sys/oracle

- SQL DEVELOPER 툴로 접속
    - 

- Web으로 접속
    - 잘 안씀

- 프로그래밍 언어로 접속
    - JDBC 등

# DB 활용

- 개발자
    - CRUD 작업
        - Create
        - Read
        - Update
        - Delete

- DBA
    - 정규화, 유저관리, 용량관리 등 DB 최적화

# SQL

- 여러줄에 걸쳐 작성가능

- 끝엔 세미콜론(;)

- 명령어의 대소문자 미구별 (대문자 권장)

- 단, Data는 대소문자 구별

- 함수 및 연산자를 제공

- 공부를 위해 예제 유저 활용
    - 설치시, 사용자 Block상태, 해제 시켜줘야함
        - 이전 경로\oracleexe\app\oracle\product\버전\server\rdbms\admin\scott.sql;
        - @위의 path를 입력

    - 명령어
        - show user; : 지금 접속중인 유저 확인
        - alter user scott IDENTIFIED BY tiger ACCOUNT UNLOCK : 유저'scott'의 비번을 tiger로 수정 및 계정 해제
        - commit : DB에 적용
        - select * from tab : 테이블s 보기
        - exit : db 연결 끊기
        
# docker

- 가상 컴퓨터 솔루션
    - 한번 세팅해서 웹에 띄워놓고 필요하면 다운해서 어떤 컴퓨터든지 같은 환경으로 세팅

- docker 한번 써보면 좋을 것
