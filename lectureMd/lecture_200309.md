
# VM

- 파일 - 호스트 네트워크 관리자
    - 

# sql developer

- Host PC에서 GUI로 Guest PC의 DB에 접속할 수 있는 프로그램

- 접속 필요정보
    - Guest PC ip 
    - port : Oracle default : 1521
    - SID : ex / orcl
    - ID/PW

# SELECT

- 그룹함수
    - 컬럼의 여러개 값을 읽어서, 하나의 결과를 리턴
    - SELECT 절에서는 단일행 함수(NVL등)와 그룹함수는 함께 사용 못함
    - NULL 값은 계산에 포함되지 않음
    - WHERE 절에서 사용 불가능
    - REF : 오라클과 PL/SQL 158P

    - COUNT(컬럼명)
        - SELECT COUNT(EMPNO) FROM EMP;
        - NULL이 포함된 컬럼에 대해 COUNT를 실행할 경우, NULL은 세지 않는다
            - SELECT COUNT(NVL(COMM, 0)) FROM EMP; 로 해결

    - SUM(컬럼명)
        - SELECT SUM(SAL) FROM EMP;
        - SELECT SUM(SAL + NVL(COMM,0)) FROM EMP;

    - MAX(컬럼명)
        - SELECT MAX(SAL) FROM EMP ORDER BY SAL DESC;

    - MIN(컬럼명)
        - SELECT MIN(HIREDATE) FROM EMP;

    - AVG(컬럼명)
        - SELECT AVG(SAL) FROM EMP;

- 단일 함수
    - REF : 오라클과 PL/SQL 70P

    - 숫자 함수
        - REF : 오라클과 PL/SQL 86P

    - 날짜 함수
        - REF : 오라클과 PL/SQL 89P

        - SYSDATE
            - 날짜 반환

    - 형변환 함수
        - REF : 오라클과 PL/SQL 99P

    - 일반 함수
        - 

- Join 

- SubQuery

# Insert

- Create
    - 테이블에 삽입시, 순서 보장 x

- ```
  // 권장
  INSERT INTO 테이블명 [{컬럼명1, 컬럼명2, ...}]
  VALUES(컬럼값1, 컬럼값2, ...)
  
  // 비권장
  INSERT INTO DEPT (DEPTNO, DNAME) 
  VALUES (50, 'IT');
  ```

# Update

- 테이블의 데이터 수정
- ```
  UPDATE 수정할 테이블명
  SET 수정할 컬럼명1 = 값1, 수정할 컬럼명2 = 값2, ...
  [WHERE 조건식]
      
  UPDATE DEPT SET LOC = 'BUSAN'
  WHERE DEPTNO = 50;

  UPDATE EMP SET COMM = 0
  WHERE COMM IS NULL;
  ```

# Delete

- 테이블에서 데이터 삭제
- ```
  DELETE 삭제할 테이블명
  [WHERE 조건식]

  
  ```

# ROLLBACK

- 지금까지 수행한 커리문 적용 취소

# GROUP BY / HAVING

- GROUP BY
    - 그룹 함수 사용시 사용

- HAVING 
    - GROUP BY에 조건을 줄 때 사용 (WHERE 절과 유사)

- ```
  SELECT DEPTNO, SUM(SAL), AVG(SAL) FROM EMP
  GROUP BY DEPTNO
  HAVING AVG(SAL) > 2000 
  ORDER BY DEPTNO ASC;

  // 급여가 2000 이상인 직원의 정보를 가지고, 
  // 부서별 급여의 합계,부서번호, 부서 평균 구하기
  SELECT DEPTNO, SUM(SAL), AVG(SAL) FROM EMP
  WHERE SAL >= 2000
  GROUP BY DEPTNO
  ORDER BY DEPTNO ASC;
  ```

# Constraint (제약조건)

- UNIQUE        : 중복 허용 X
- NOT NULL      : NULL값 허용 X
- PRIMARY KEY   : UNIQUE + NOT NULL

# JDBC 연동

- https://www.oracle.com/downloads/

- drivers and Utilities
    - jdbc 드라이버 (11g/ojdbc6.jar)
    - 새 플젝마다 한번씩 연동


- API(라이브러리) 추가
    - 프로젝트 우클릭 - build path - configure build path - Libraries 탭 - Add External JARs - 다운받은 .jar 파일 선택

# 번외

- Statement를 사용 안하는 이유는 SQL injection 공격때문

- DTO, VO
    - 접근제어자 private
    - Setter, Getter
    - 생성자는 여러개 가능, Default 생성자는 꼭 필요
    - 멤버변수의 이름과 데이타타입 테이블의 컬럼명과 타입과 일치(동일)