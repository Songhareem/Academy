
# 정리
 
- back : java, Servlet

- front : css, js, img, jsp

- request : URL + Method + Params

# DB 연결 준비

- 방화벽 설정은 됐는지

- WEB-INF/lib/ 에 lib(ojdbc) 넣었는지?

- DB 연결 클래스를 통해 DB에 연결 준비가 끝났는지
    - ID/PW 틀렸을 경우
    - DB에 해당 유저가 생성되지 않은 경우
    - 유저의 권한이 적용되지 않은 경우
    - ip ,port, xe 등의 정보가 틀렸을 경우
    - 물리적으로 연결이 안되거나, DB서버가 종료된 경우
    - Listener 문제, DB 재시동
    - 드라이버명이 틀린 경우
    - JDBC(ojdbc.jar) 가 없는 경우

- 연결 후 main Test를 통해 확인