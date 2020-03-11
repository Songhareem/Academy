
# SubQuery

- 쿼리문 내에 포함된 또다른 쿼리문

- 메인 쿼리문에서 사용할 값을 조회할 목적으로 사용함
- 사용 : 서브쿼리문 앞 뒤로 (서브쿼리)
- 위치
    - SELECT 절, FROM 절, WHERE절, GROUP BY절, INSERT 절, UPDATE 절, DELETE 절 등
    - Create Table, Create View 등

- 단일행 서브쿼리 : 서브쿼리의 결과로 한개의 값이 나온 경우
    - 비교연산자를 통한 결과 (>,<, >= , <=, =, !=)

- 다중행 서브쿼리 : 서브쿼리의 결과가 한개 이상이 나온경우
    - IN / NOT IN / ANY / ALL 을 사용한 연산
    - IN = 모든 값에 대해 EQUAL? 결과에 대해 각각 따로 RETURN
    - NOT IN = IN 후, 여집합 RETURN
    - ANY = 모든 값에 대해 부등호? 하나라도 조건을 만족하면 RETURN 
        - COLUMN > ANY (값1, 값2, ...)
        - SAL > ANY (100,200,300)
    - ALL = 모든 값들이 부등호? 모든값이 조건을 만족해야 함 
        - COLUMN > ANY (값1, 값2, ...)
        - SAL > ANY (100,200,300)

- 다중 컬럼 서브쿼리
    - 비교해야할 쿼리가 여러개 일 때
    - WHERE (SAL, DEPTNO) IN (SELECT SAL, DEPTNO FROM EMP WHERE DEPTNO = 30 AND COMM IS NOT NULL);

- AND 연산
    - ~하면서

- OR
    - 

- EXISTS, NOT EXISTS
    - EXIST : 서브쿼리 결과물이 존재하면 실행
    - NOT EXISTS : 서브쿼리의 결과물이 존재하지 않아도 실행

# JOIN

- 여러 테이블 합쳐서 하나의 가상의 테이블로 사용

- JOIN 순서
    - 두 테이블에 공통 컬럼이 있는가?
    - 컬럼명이 다르지만 같은 값을 가지고 있는가?
    - 베이스 테이블 지정하고 JOIN

- 종류
    - EQUI JOIN
        - 가장 일반적인 JOIN
        - INNER JOIN : 수동으로 같은 컬럼 찾아서 지정
        - NATURAL JOIN : 자동으로 같은 컬럼을 찾아서 INNER 조인
    - SELF JOIN
        - 자기 자신과 JOIN
    - OUTTER JOIN
        - NULL값 까지 JOIN할때 사용
        - LEFT, RIGHT, FULL OUTER JOIN
            - LEFT JOIN : 왼쪽 테이블의 NULL값을 전부 표현
            - RIGHT JOIN : 오른쪽 테이블의 NULL값을 전부 표현
            - FULL JOIN : 양쪽 테이블의 NULL값을 전부 표현
    - NON EQUI JOIN

- 사용 (ANSI 표기법)
    - 기본
        - ```
          SELECT {컬럼명...} 
          FROM 베이스 테이블명 [INNER] | [LEFT|RIGHT] OUTER | SELF | NATURAL
          JOIN 조인할 테이블명
          ON (베이스 테이블명.컬럼명 = 조인할테이블명.컬럼명) | USING (컬럼명) 
          ```
    - EQUI JOIN
        - ```
          -- INNER JOIN
          SELECT E.ENAME, E.JOB, E.SAL, D.DNAME, D.LOC
          FROM EMP E INNER JOIN DEPT D
          ON E.DEPTNO = D.DEPTNO
          WHERE E.ENAME = 'SMITH'

          -- NATURAL JOIN
          SELECT EMP.ENAME, EMP.JOB, EMP.SAL, DEPT.DNAME, DEPT.LOC
          FROM EMP E NATURAL JOIN DEPT D
          WHERE E.ENAME = 'SMITH'
          ```
    - SELF JOIN
        - ```
          SELECT E1.EMPNO, E1.ENAME, E1.MGR, E2.ENAME AS MGR_NAME 
          FROM EMP E1 JOIN EMP E2
          ON E1.MGR = E2.EMPNO;
          ```
    - OUTER JOIN
        - 

# DDL

- CREATE
    - ADMIN으로 해줘야할 선작업
        - USER 만들기
            - ```
            -- ID : USER01 / PASSWORD : USER01
            CREATE USER USER01 IDENTIFIED BY USER01;
            ```
        - USER 권한 지정
            - ```
            -- 유저 권한 적용
            -- CONNECT : DB 접속 권한
            -- RESOURCE : CRUD 권한
            GRANT CONNECT, RESOURCE TO USER01;
            ```
    - 새로 만들어진 USER로 작업
        - 테이블 생성
            - ```
              CREATE TABLE 테이블명 {

                  컬럼명1 데이터타입 [제약조건],
                  컬럼명2 데이터타입 [제약조건],
                  컬럼명3 데이터타입 [제약조건],
                  ...
              }

              -- 데이터 타입
              -- NUMBER(정수자리수, 소수자리수)
              -- VARCHAR(바이트수) : 고정길이 문자열
              -- VARCHAR2(바이트수) : 가변길이 문자열 (최대바이트 수 = 인자로 넣는 수)
              --

              -- 제약조건
              -- PRIMARY KEY : UNIQUE + NOT NULL
              -- UNIQUE : 중복 비허용 NULL 허용
              -- NOT NULL : NULL 비허용
              
              CREATE TABLE POINT (
                  NUM   NUMBER(3) PRIMARY KEY,
                  NAME  VARCHAR2(100),
                  KOR   NUMBER(3),
                  ENG   NUMBER(3),
                  MATH  NUMBER(3),
                  TOTAL NUMBER(3),
                  MEAN  NUMBER(5,2),
              )
              ```

# ORACLE 올림, 버림, 반올림

- 올림 : CEIL(컬럼명)
- 버림 : TRUNC(컬럼명)
- 반올림 : ROUND(컬럼명)

# ORACLE 형식지정자

- TO CHAR(컬럼명, '9,999.99')
    - 각 자릿수는 1~9까지 가능
    - 정수자리는 ,자리에 ',' 표기
    - 소수점 뒤는 표기되는 소수의 자릿수(2자리까지 허용)

# 번외 

- CAFE 24 DB 호스팅
    - ORACLE DB의 일부분(제한된 용량)을 빌려줌
    - 계정을 만들어서 빌려주고 해당 계정은 자신만의 TABLE에만 접근 가능