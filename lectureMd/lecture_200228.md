
# DB

- DBMA(DataBase Management System)
    - DB를 관리, 응용 프로그램들이 DB를 공유하며 사용할 수 있는 환경을 제공하는 SW

- RDBMS (Relational DataBase Management System)
    - 관계형 DBMS
    - 저장소로 사용

- NOSQL (Not only SQL)
    - 비관계형 DBMS
    - 빅데이터/인공지능 쪽, 분석 등에 사용
    - 장점
        - 1_ 불필요한 Join의 최소화
        - 2_ 유연성있는 서버 구조 제공
        - 3_ 비정형 데이터 구조로 설계비용 감소
        - 4_ Read/Write가 빠르며 빅데이터 처리가 가능
        - 5_ 저렴한 비용으로 분산처리 및 병렬처리 가능
    - 종류
        - 1_ KEY-VALUE - Redis , Memcached
        - 2_ COLUMN - Hbase, Casandra
        - 3_ DOCUMENT - MongoDB, 
        - 4_ GRAPH - GraphDB
    - SQL 차이점
        - | RDBMS | NoSQL |
            | :---: | :---: |
            | Scale-up - 서버 한대 중심으로 확장 | Scale-out - 여러대의 서버를 중심으로 확장 |
            | 무결성 | 유연성 |
            | 데이터 중복 제거 | 데이터 중복 허용 |
            | 트랜잭션 | 빠른 쓰기, 읽기 |
    - 기타 ref : https://cionman.tistory.com/44

- Table (행과 열로 이루어진 2차원 구조 데이터 저장소, DB 기본 개념)
    - ROW : 행
    - COL : 열
    - Field : 한 칸

- SQL (Structured Query Language)
    - 관계형 DB를 조작하는 언어 
    - 문자열이나 데이터들은 앞뒤로 홑따음표로 감쌀것 
    - 종류
        - DML(Data Manipulation Languege)
            - 데이터 조작어
            - Insert : 새 데이터 추가
            - Update : 데이터 수정
            - Delete : 데이터 삭제
            - Select : 데이터 읽기
        - DDL(Data Definition Languege)
            - 데이터 정의어 (테이블 = 객체로 인식)
            - Create : 테이블(객체) 생성
            - Alter  : 테이블(객체) 수정
            - Drop   : 테이블(객체) 삭제
            - Rename : 테이블(객체) 재명명
            - Truncate: Data 삭제
        - DCL(Data Control Languege)
            - 데이터 제어어
            - Grant  : 권한 부여
            - Revoke : 권한 취소
            - Commit : 트랜젝션 저장
            - Rollback: 트랜젝션 취소
        
- Oracle Datatype
    - Number(전체자릿수, 소수밑자리수);
        - 정수 실수 포함
    - Varchar(바이트수)
        - 고정길이 문자열, 최대 2000byte
        - 영어는 1byte, 한글은 2byte ~ 3byte
    - Varchar2(바이트수)
        - 가변길이 문자열, 최대 4000byte
        - 영어는 1byte, 한글은 2byte ~ 3byte
        - 문자에서 주로 사용
    - Data
        - 날짜/시간 담는 타입
        - 년월일 시분초 담음
        - 한글 : yy/mm/dd
        - 영엉 : DD/MON/YY
    - Timestamp
        - 날짜/시간/millisec
        - 데이터 테이블 생성시 만듦
- CLOB
    - 최대 4Gb, e-pub,Text등 저장
 - BLOB
    - 최대 2Gb, 이진데이터 저장 (이미지 파일 등)
    - 효율떨어져서 안사용

# Select

- 질의어
- SELECT 결과물은 Resuit Set에 보관
- Resuit Set에 있는 결과를 보여주는 화면을 View라 함
- 실행순서
    - FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY

- ```
  SELECT [distinct] {*, 컬럼명1, 컬럼명2, 계산식, 함수} 
  FROM 테이블명
  [WHERE 조건식]
  [GROUP BY 그룹으로 묶을 컬럼명]
  [HAVING 그룹의 조건식]
  [ORDER BY 컬럼명 정렬방식];

- option
    - distinct : 중복제거

- 이중 셀렉트 문
    - select 보고싶은 컬럼명 ... from 컬럼명 있는 테이블 where 공통컬럼명 = (selcet 공통컬럼명 from 다른 테이블명 where 조건식)

- 연습문제
    - 사원명 SMITH 사원이 근무하는 부서명과 지역명
        - ```
          select dname, loc from dept where 
          deptno = (select deptno from emp where ename = 'SMITH');
          ```
    - 사원명 BLACK 가원의 매니저(상사)가 근무하는 지역명
        - ```
          select loc from dept where
          deptno = (select deptno from emp where
          empno = (select mgr from emp where ename = 'BLAKE'));
          ```
    - 사원명 CLARK 사원의 급여등급
        - ```
          select grade from salgrade where 
          losal <= (select sal from emp where ename = 'CLARK') AND
          (select sal from emp where ename = 'CLARK') <= hisal;

          select grade from salgrade where 
          (select sal from emp where ename = 'CLARK')
          between losal and hisal;
          ```
    - 매니저가 없는 사원의 급여등급
        - ```
          select grade from salgrade where
          losal <= (select sal from emp where mgr is null) AND
          (select sal from emp where mgr is null) <= hisal;

          select grade from salgrade where
          (select sal from emp where mgr is null)
          between losal and hisal;
          ```
    - 입사일이 1980년 1월 1일 부터 1981년 3월 1일 이전 입사한 사람들의 모든 정보
        - ```
          select * from emp where
          hiredate between '80/01/01' AND '81/03/01'; (80/1/1 도 상관 X)
          ```
    - 입사일이 1980년 1월 1일 부터 1981년 3월 1일 이전 입사한 사람들의 부서 번호
        - ```
          select distinct deptno from emp where
          hiredate between '80/1/1' and '81/3/1'
          order by deptno;
          ```
    - 입사일이 1980년이 아닌 사람들의 모든 정보
        - ```
          select deptno from emp where
          hiredate not between '80/1/1' and '80/12/31'
          ```
    - 부서번호가 10번 또는 30번인 사람들의 모든 정보
        - ```
          select * from emp where
          deptno in (10, 30);
          ```
    - 부서번호가 10번 또는 30번이 아닌 사람들의 모든 정보
        - ```
          select * from emp where
          deptno not in (10, 30);
          ```
    - 1900 년대 여자만 뽑아내는 방법 (LIKE 절만)
        - ```
          LIKE '9_ _ _ _ _-2_ _ _ _ _ _';
          ```
    - 사원중에서 사원이름이 'S'로 시작하는 사람들의 모든 정보
        - ```
          select * from emp where ename like 'S%';
          ```
    - 사원중에서 사원이름이 4글자인 사람들의 모든 정보
        - ```
          select * from emp where ename like '_ _ _ _';
          ```
    - 사원중에서 부서 번호가 30 인 사람들을 연봉 내림차순으로 모든 정보 
        - ```
          select * from emp where deptno = 30 order by sal desc;
          ```

# 조건식

- WHERE 절
    - true / false가 나오도록 해야함
        - 비교연산자 : >, <, >=, <=, =, !=
            - null 에 대한 비교 연산
            - where 컬럼명 is null / is not null  
        - 논리 연산자 : OR , AND, NOT
            - 여러 조건 비교시
    - BETWEEN 절
        - ~ 사이를 구할 때 사용하는 조건식
        - WHERE 컬럼명 BETWEEN 값1 AND 값2 
        - WHERE 컬럼명 NOT BETWEEN 값1 AND 값2 
    - IN 절
        - WHERE 컬럼명 = 값1 or 값2 or ...
        - WHERE 컬럼명 IN (값1, 값2, ...)
    - LIKE 절
        - '%' : 나머지 전체 
            - WHERE 컬럼명 LIKE '%.jpg' : .jpg로 끝나는 모든 것
        - '_' : 한 글자
            - WHERE 컬럼명 LIKE '_ A' : 2글자, A로 끝나는 것들
            - WHERE 컬럼명 LIKE '_ A _' : 3글자, A가 가운데
        - 조합도 가능
            - WHERE 컬럼명 LIKE '%A_B%' 등
        - ESCAPE 옵션
            - '%' , '_' 등의 DB에서 쓰이는 특수문자를 문자열로 취급하게 바꿔주는 방법
                - 칼럼명 LIKE '%#%a%' ESCAPE'#';
                - '%a'를 검색, %를 ESCAPE로 지정

- ORDER BY 절
    - 하나의 컬럼을 대상으로 내림차순 / 올림차순 정리
        - 오름차순 : ASC
        - 내림차순 : DESC
    - 다중정렬
        - ORDER BY 주정렬할 컬럼명 정렬방식, 컬럼명 정렬방식, ...

# 별칭 ALIAS

- 조회결과 View의 컬럼명을 지정 또는 변경해서 출력할때 사용

- 1_ 컬럼명 AS 별칭 (띄어쓰기 불가능)
- 2_ 컬럼명 "별칭" (띄어쓰기 가능)
- 3_ 연결연산자 || : 데이터 조회 결과값을 문장의 형식으로 보고싶을 때 사용
    - select 컬럼명1 || '문자열 ...' || 컬럼명2 ...

# 

# Oracle 함수 정리

- NVL(comm,0) : commisiond이 NUll이면 0으로 변경