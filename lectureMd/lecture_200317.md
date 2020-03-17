
# 트랜잭션(Transaction)

- 하나의 Connection으로 완전하게 끝나는 시점까지의 단위

- 모두 성공하거나, 하나가 실패하면 모두 실패

- 모두 성공이면, Commit / 실패면, Rollback(이전 커밋까지)

- JDBC는 디폴트 오토커밋

# JAVA에서의 트랜잭션

- Select 이외의 DML(Insert/Delete/Update) 사용시
    - 1 ) 같은 트랜잭션으로 묶어줘야함
        - Connection conn = DBConnect.getConnection을 main에서 한번 선언
        - DB와 연결된 Connection을 매개변수로 받아서 사용, 싱글톤 가능하지 않을까?
    - 2 ) Auto Commit 해제
        - 작업(select 제외 DML)이 두 번 이상인 메소드 내에서
        - DML 전에 auto commit 해제 후, 함수 종료 직전에 auto commit
        - conn.setAutoCommit(true/false)
    - 3 ) 작업 성공시, Commit
        - try 내부 마지막단에서
        - conn.commit();
    - 4) 작업 실패시, Rollback
        - insert/update/delete 작업 직후,
        - ``` 
          if(result < 1) {
              throw new Exception();
          }
          ```
        - catch 내부에서
        - conn.rollback();

# Oracle LPAD / RPAD

- 앞뒤에 값 붙여주는것

- 사용법
    - L(R)PAD(변수, 길이, 변형자)
    - ex : select L(R)PAD('DEER', 8, '^') from dual;