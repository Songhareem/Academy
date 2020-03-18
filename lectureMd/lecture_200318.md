
# 인덱스(index)

- SQL 명령문의 처리속도 향상을 위해 어떤 컬럼에 대해 생성하는 오라클 객체
- 인덱스의 내부구조는 B+ 트리 형식
- 컬럼에 인덱스를 설정하면 이를 위한 B+ 트리도 생성해야 하므로, 인덱스를 생성하기 위한 시간이 필요하고, 인덱스 저장을 위한 추가 저장 공간 필요
- 인덱스를 생성한 후에 DML 작업을 수행하면, 인덱스 컬럼값 변경되므로 B+ 트리 내부구조도 수정되므로 DML작업이 무거워짐
- Primary Key 는 자동으로 index가 걸림

- 장점
    - 검색 속도 증가 
    - 시스템 전체 성능 향상(부하 감소)
- 단점
    - 인덱스 생성시 시간이 필요
    - 인덱스를 위한 저장공간이 추가로 필요
    - DML 작업이 자주 일어날 경우, 오히려 성능이 저하

- 효율적인 경우
    - WHERE절, Join조건에 주로 사용되는 컬럼
    - Unique 속성, NULL 속성이 많은 컬럼

- 효율적이지 않은 경우
    - 테이블이 작은 경우(데이터가 적은 경우)
    - 테이블 갱신이 자주 발생되는 경우
    - 다량의 데이터 조회되는 경우(select * from 테이블명)

- 인덱스 생성 구문
    - ```
      CREATE [UNIQUE] INDEX index_name 
      ON table_name (column | function)
      ```

- 인덱스 삭제
    - DEFAULT : 테이블이 삭제되면, 종속되어 있던 인덱스는 같이 삭제
    - DROP INDEX index_name
        - 테이블 남기고 index만 삭제

- 인덱스의 유형
    - unique 인덱스
        - Unique Index가 생성된 컬럼에는 중복값 포함 불가
    - NonUnique 인덱스
        - 빈번하게 사용하는 일반 컬럼 대상 생성
        - 주로 성능향상을 위한 목적 생성

- 결합 인덱스
    - 한 개의 컬럼으로 구성한 인덱스 = 단일 인덱스
    - 두 새 이상의 컬럼으로 구성한 인덱스 = 결합 인덱스

- 함수 기반 인덱스
    - select 절 where 절에 산술식이나 함수식이 사용된 경우
    - 인덱스의 적용을 받지 않음
    - 계산식이나 함수식으로 검색하는 경우가 많다면, 수식이나 함수식을 인덱스로 만듦

# View

- SELECT의 결과 화면을 미리 보여주는 화면
- 결과화면을 가상의 테이블처럼 저장해두고 사용
- 사용 목적
    - 보안 유리(쿼리를 덜 날리므로)
    - 복잡하고 긴 쿼리문을 View를 통해서 보기때문에 매번 쿼리문을 실행하지 않음
- View 생성 구문
    - ```
      CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW view_name [Alias] AS SubQuery 
      [With Check Option [Constraint Constraint_name]]
      [With Read Only [Constraint constraint_name]]

      Select * from View_name
      ```

# 딕셔너리

- 사용자와 데이터베이스 자원들을 관리하기 위한 정보들을 저장하는 시스템 테이블 집합
- 사용자가 테이블을 생성, 수정 등 모든 정보들이 자동으로 갱신
- 사용자는 데이터 딕셔너리의 정보를 직접 손댈수없음
- 데이터 딕셔너리는 읽기 전용 View 형태로 정보 제공
- 딕셔너리 분류
    - USER_ 
        - 사용자 계정이 소유한 정보 조회
            - SELECT table_name FROM user_tables;
        - 사용자가 소유한 제약조건 정보 조회
            - SELECT * FROM user_constraint;
        - 사용자가 소유한 시퀀스 정보 조회
            - SELECT * FROM user_sequences;
        - 사용자가 소유한 index 정보 조회
            - SELECT * FROM user_indexes;
        -사용자가 소유한 View 정보 죄회
            - SELECT * FROM user_views;
    - ALL_ : 사용자 계정과 권한을 부여받은 다른 사용자 객체 정보 조회 
        - 사용자가 소유하거나 권한을 부여받은 모든 테이블에 대한 정보 조회
            - SELECT owner, table_name FROM ALL_TABLES;

    - DBA_ : 데이터베이스 관리자만 접근 가능한 객체 정보 조회
        - DBA 권한을 가진 SYSTEM 계정으로 조회
            - SELECT owner, table_name FROM DBA_TABLES;

# PL/SQL

- Oracle 전용
- DB 프로그래밍

# Trigger

- 어떤 테이블에 insert/update/delete가 일어나면, 연관된 특정 테이블에 insert/update/delete가 같이 되도록 미리 짜줄 수 있는 DB단 기능
- 트랙잭션이 먹지 않음

# 번외

- lnitcap(컬럼명) : 단어 첫글자 대문자로 변환, 모두 대문자라면 첫글자만 대문자 나머지는 소문자
- Length (컬럼명) : 한글자,영문자 상관없이 글자 갯수 리턴
- lengthB(컬럼명) : 글자의 Bytse 리턴
- SubStr(컬럼명, 시작위치, 들어낼 글자의 갯수) : 들어낼 글자의 갯수를 삭제하면 끝까지 들어냄, 시작할 위치 음수라면, 끝에서 부터 잘라옴
- Trim(컬럼명) : 앞뒤 공백 제거
- LTrim | RTriem(컬럼명'제거 할문자') : 제거할 문자를 생략하면 공백 제거
- Replage (컬럼명,'문자1','문자2')  문자 1을 문자2 로 변환:

- Abs(컬럼명) : 절대값
- Trunc(컬럼명,자리수) : 지정자리수 이하는 버림
- Mod(컬럼명, 숫자) : 숫자로 나눈 나머지

- 날짜 데이터는 연산이 가능
- 날짜+ 숫자의 결과는 날짜 데이터
- DB의 사용언어가 한국어로 지정되어 있기때문에
- 요일이름에 한글 사용, 영어를 사용하면 ERR
- Add_Months(컬럼명, 더할 개월 수)
-Month_Between(컬럼명1, 컬럼명2)

- 형변환 함수
- to_char(숫자 또는 날짜, '포맷문자')
    - 숫자나 날짜를 원하는 포맷으로 바꾸어서 출력
    - 포맷문자는 대소를 구분하지 않음
    - 날짜
        - 'YYYY'    : 연도를 4자리로
        - 'MM'      : 월을 2자리로
        - 'DD'      : 일을 2자리로
        - 'DY'      : 요일 가져올 때
        - 'AM'      : 오전/오후 표기
        - 'HH'      : 시간
        - 'MI'      : 분
        - 'SS'      : 초
    - 숫자
        - 9 : 9의 갯수만큼 자릿수 표기
        - 0 : 빈자를 0으로 채우세요
        - $ : $ 문자를 추가해서 표기
        - L : 각국에 맞는 통화 표기
        - . : 소수점 이하를 표기
        - , : 천단위로 구분
- to_number(문자열 또는 문자, '포맷')
    - 문자열 및 문자를 숫자로 바꿔줌
    - 포맷 : 각 자리값이 무엇인지 표기
    - to_number('3000')             : 3000
    - to_number('30,000', '99,999') : 30000

- to_date('문자열','포맷')
    - 문자열을 날짜 데이터로 변환
    - to_date('2020/12/25','YYYY/MM/DD')
    - to_date('2020-12-25','YYYY-MM-DD')
    - to_date('20201215','YYYYMMDD')

