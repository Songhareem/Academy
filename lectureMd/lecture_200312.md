
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
- TRUNCATE TABLE
    - TABLE 구조는 유지하고 모든 데이터 삭제, 복구 불가능 

- DROP
    - 테이블 삭제, 단시간 이내라면 복구 가능, 용량이 줄어듦
    - DROP TABLE 테이블명;
    - 테이블 삭제시 앞에 BINS라는 문자가 붙으며 쓰레기 테이블로 메모리에 남음
    - 보이지 않는다면, ALTER SYSTEM SET "RECYCLEBIN"=on;
    - SELECT * FROM USER_RECYCLEBIN; 
    - 쓰레기 테이블 삭제
        - PURGE RECYCLEBIN;
    - 테이블 삭제시, 휴지통에 넣지않고 바로 삭제
        - DROP TABLE 테이블명 PURGE

- ALTER
    - 테이블 컬럼 추가하기(ALTER TABLE ADD)
        - ALTER TABLE 테이블명 ADD(컬럼명 데이타타입(사이즈));
        - ( EX ) USER라는 테이블에 USER_NAME이라는 컬럼을 VARCHAR2(13) 타입으로 추가할 때
        - -> ALTER TABLE USER ADD(USER_NAME VARCAHR2(13)); 
        - 제약조건도 추가 가능
            - ALTER TABLE 테이블명 ADD CONSTRAINT 제약조건명 제약조건 (컬럼명)

    - 테이블 컬럼 수정하기(ALTER TABLE MODIFY)
        - ALTER TABLE 테이블명 MODIFY(컬럼명 테이타타입(사이즈));
        - ( EX ) USER라는 테이블에 USER_AGE 라는 컬럼을 NUNBER(3) 타입으로 수정할 때
        - ALTER TABLE USER MODIFY(USER_AGE NUMBER(3));
        - 컬럼값이 비워져 있어야 가능 (해당 컬럼의 데이터를 전부 NULL 처리해야 가능)

    - 테이블 컬럼 삭제하기(ALTER TABLE DROP)
        - ALTER TABLE 테이블명 DROP COLUMN 컬럼명
        - ( EX ) USER라는 테이블에 USER_NAME 이라는 컬럼을 삭제할 때
        - -> ALTER TABLE USER DROP COLUMN USER_NAME;
        - 제약조건 삭제 가능
            - ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건이름 
            - ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건이름 CASCADE (FK 설정 컬럼)

    - 테이블 컬럼 이름 변경하기(ALTER TABLE RENAME)
        - ALTER TABLE 테이블명 RENAME COLUMN 원래컬럼명 TO 바꿀컬럼명;
        - ( EX ) USER라는 테이블에 USER_NAME 이라는 컬럼을 USER_FIRST_NAME으로 변경할 때

    - 테이블명을 변경 (RENAME 테이블명 TO 변경할 테이블명)

    - 테이블 내 컬럼을 사용하지 못하게 막기(ALTER TABLE SET UNUSED)
        - ALTER TABLE 테이블명 SET UNUSED(컬럼명);

# 제약조건

- PRIMARY KEY : UNIQUE + NOT NULL
- UNIQUE      : 중복 비허용
- NOT NULL    : NULL값 비허용
- CHECK       : 조건에 맞는 값만 허용
- DEFALUT     : 기본값 설정
- FOREIGN KEY :  
    - 다른 테이블을 참조하는 역할, 
    - 외부 참조 컬럼 의미, 
    - 다른 테이블과의 관계를 처리해야 함
    - 제공 되는 값만 사용하고, 제공되지 않는 값은 사용못하게 하기 위함

- CONSTRAINT  : 제약조건을 정리해서 설정하기 위해 사용 
    - 제약조건 이름 : 테이블명_컬럼명_제약조건약칭
        - PRIMARY KEY   : PK
        - FOREIGN KEY   : FK
        - UNIQUE        : U
        - CHECK         : C
    - 컬럼 레벨 방식
        - ```
          CREATE TABLE 테이블명 (
              컬럼명 테이터 타입 CONSTRAINT 제약조건명 제약조건,
              ...
          )

          CREATE TABLE 테이블명 (
              컬럼명 테이터 타입
              ...

              CONSTRAINT 
          )

          // FK 의 경우
          CREATE TABLE 테이블명 (
              컬럼명 테이터 타입 CONSTRAINT 제약조건명 REFERENTCES 참조 테이블명(참조할 컬럼명)
              ...
          )
          ```
    - 테이블 레벨 방식
        - ```
          CREATE TABLE 테이블명(
              컬럼명 데이터타입,
              ...
              CONSTRAINT 제약조건명 제약조건(컬럼명),
              CONSTRAINT 제약조건명 FOREIGN KEY 참조할 자식 컬럼명 REFERENCES 참조 테이블명(참조할 컬럼명),
              ...
          )
          ```

# CASCADE

- ON DELETE CASCADE  : 부모 삭제시 자식도 같이 삭제
- ON DELETE SET NULL : 부모 삭제시 자식 테이블 값을 NULL로 변경

- 제약조건들 확인
    - SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS;
    - DESC UESR_CONSTRAINTS

# SEQUENCE

- 시퀀스 생성
    - CREATE SEQUENCE 시퀀스명 START WITH 시작수 INCREMENT BY 증가수;
    - OPTIONS
        - ```
          CREATE SEQUENCE “스키마명.시퀀스명”
          MINVALUE -- 시퀀스가 시작되는 최초의 숫자
          MAXVALUE --시퀀스가 끝나는 최대 숫자
          INCREMENT BY -- 시퀀스가 증가되는 단위
          START WITH -- 시퀀스 생성이 시작되는 값
          NOCACHE  -- 캐시를 사용하지 않음
          NOORDER  --요청되는 순서대로 값을 생성하지 않음
          NOCYCLE  --초기값부터 다시 시작하지 않음
          ```

- 시퀀스 사용
    - NEXTVAL 속성
        - 새로운 시퀀스 번호를 반환
        - 시퀀스명.NEXTVAL
    - CURRVAL 속성
        - 현재 시퀀스 번호를 반환
        - NEXTVAL 속성이 먼저 사용되어야 사용가능
        - 시퀀스명.CURRVAL

- 시퀀스 수정
    - START WITH 수정 불가
    - 한번이라도 사용해야 수정가능
    - ALTER SEQUENCE 시퀀스명 
        - OPTIONS 수정할 값

- 시퀀스 삭제
    - DROP SEQENCE 시퀀스명

- 시퀀스 검색
    - SELECT * FROM SEQ;



# 번외

- 외래키가 설정된 테이블의 키를 가진 부모 테이블의 경우, 양쪽 테이블에 데이터가 있다면 삭제시, 자식 데이터 삭제 이후 부모 테이블 테이터 삭제
    - 쉽게? 외래키를 가진 컬럼을 삭제 하고 싶은 부모 테이블의 경우, 선 자식 삭제 후 부모 컬럼 삭제

- DUAL
    - 함수 반환값등을 확인하기 위해 사용하는 가상의 테이블

- 현시간 불러오기 
    - ORACLE : SYSDATE
    - MYSQL : NOW

# KEY 종류

- 후보키 (Candidate Key)
    - 릴레이션을 구성하는 속성들 중에서 튜플을 유일하게 식별할 수 있는 속성들의 부분집합을 의미합니다. 
    - 모든 릴레이션은 반드시 하나 이상의 후보키를 가져야합니다.
    - 릴레이션에 있는 모든 튜플에 대해서 유일성과 최소성을 만족시켜야합니다.
    - 기본키가 될 수 있는 키 = 후보키
    - ex) <학생> 릴레이션에서 '학번'이나 '주민번호'는 다른 레코드를 유일하게 구별할 수 있는 기본키로 사용할 수 있으므로 후보키가 될 수 있습니다.

- 기본키 (Primary Key)
    - 후보키 중에서 선택한 주키(Main Key)
    - 한 릴레이션에서 특정 튜플을 유일하게 구별할 수 있는 속성
    - Null 값을 가질 수 없습니다. (개체 무결성의 첫번째 조건)
    - 기본키로 정의된 속성에는 동일한 값이 중복되어 저장될 수 없습니다.(개체 무결성의 두번째 조건)
    - ex) <학생> 릴레이션에는 '학번'이나 '주민번호'가 기본키가 될 수 있고, <수강> 릴레이션에는 '학번'+'과목명'으로 조합해야 기본키가 만들어 질 수 있습니다. 왜냐면 <수강> 릴레이션에서는 '학번' 속성과 '과목명' 속성은 개별적으로 기본키로 사용할 수 없습니다. 다른 튜플들과 구별되지 않기 때문이지요..
    - ex) <학생> 릴레이션에서 '학번'을 기본키로 정의되면 이미 입력된 '1001'은 다른 튜플의 '학번' 속성 값으로 입력할 수 없습니다.

- 대체키 (Alternate Key)
    - 후보키가 둘 이상일 때 기본키를 제외한 나머지 후보키들을 말합니다.
    - 보조키라고도 합니다.
    - ex) <학생> 릴레이션에서 '학번'을 기본키로 정의하면 '주민번호'는 대체키가 됩니다. 

- 슈퍼키 (Super Key)
    - 슈퍼키는 한 릴레이션 내에 있는 속성들의 집합으로 구성된 키로서 릴레이션을 구성하는 모든 튜플 중 슈퍼키로 구성된 속성의 집합과 동일한 값은 나타내지 않습니다. 
    - 릴레이션을 구성하는 모든 튜플에 대해 유일성은 만족하지만, 최소성은 만족시키지 못합니다.
    - ex) <학생> 릴레이션에서는 '학번', '주민번호', '학번'+'주민번호', '학번'+'주민번호'+'성명' 등으로 슈퍼키를 구성할 수 있습니다. 또한 여기서 최소성을 만족시키지 못한다는 말은 '학번'+'주민번호'+'성명' 가 슈퍼기인 경우 3개의 속성 조합을 통해 다른 튜플과 구별이 가능하지만, '성명' 단독적으로 슈퍼키를 사용했을 때는 구별이 가능하지 않기 때문에 최소성을 만족시키지 못합니다. 즉 뭉쳤을 경우 유일성이 생기고, 흩어지면 몇몇 속성들은 독단적으로 유일성있는 키로 사용할 수 없습니다. 이것을 최소성을 만족하지 못한다고 합니다.

- 외래키 (Foreign Key)
    - 관계(Relation)를 맺고 있는 릴레이션 R1, R2에서 릴레이션 R1이 참조하고 있는 릴레이션 R2의 기본키와 같은 R1 릴레이션의 속성
    - 외래키는 참조되는 릴레이션의 기본키와 대응되어 릴레이션 간에 참조 관계를 표현하는데 중요한 도구로 사용됩니다.
    - 외래키로 지정되면 참조 테이블의 기본키에 없는 값은 입력할 수 없습니다. (참조 무결성 조건)
    - 각 릴레이션의 입장에서 속성은 기본키가 되기도하고, 외래키가 되기도 합니다.
    - ex) <수강> 릴레이션이 <학생> 릴레이션을 참조하고 있으므로 <학생> 릴레이션의 '학번'은 기본키이고, <수강> 릴레이션의 '학번'은 외래키입니다.
    - ex) <수강> 릴레이션의 '학번'에는 <학생> 릴레이션의 '학번'에 없는 값은 입력할 수 없습니다.
