
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

- DAO와 DTO는 항상 같이 만들기

- DB 순서 체크리스트
    - DB 연결
    - SQL 작성
    - SQL 미리 전송
    - ? 값 세팅
    - 최종 전송 후 결과 처리
    - 자원 해제

# Spring Framework

- 특징
    - POJO
    - IOC
    - DI (Dependency Injection)
        - 다른 클래스가 필요한 클래스에서 해당 클래스를 받는것(생성하는 것)
        - DI 방법
            - 생성자에서 세팅
            - setter를 통해 세팅
        - Spring에서의 방법
            - Annotation
            - XML
    - AOP
    - 영속성과 관련된 다양한 서비스를 지원
    - 높은 확장성

- 디자인 패턴 + API 관리
- Container : 객체의 생명주기 관리자

- 개발환경
    - perspective를 제외하고 Servlet과 환경 동일
    - window -> perspective -> open perspective -> other -> spring

- 프로젝트 생성
    - file -> new -> spring legacy project
    - 깃 폴더명과 같아야한다고 함(???)
    - Template에서 Spring MVC Project 선택
    - 패키지 명을 입력 (3레벨), 폴더명이 Context(Root) Name으로 지정됨

- Spring project 생성 후 Error 
    - 프로젝트 우클릭 -> Run as -> Maven clean : class 파일들 삭제 (class not found exception 등)
    - 프로젝트 우클릭 -> maven -> update project : recompile 또는 API 재 다운
    - C:\users\user명\.m2\repository\하위 폴더 전부 삭제 후 STS 시작 : 모든 API 삭제
    - 다른 사람의 오류가 없는 repository 복사 후 .m2 폴더에 붙여넣기