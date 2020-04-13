
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
    - POJO(Plain Old Java Object) : 상속없는 순수한 자바 클래스
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


# Spring

- 용어 정리
    - bean : container에서 생성 및 관리 하는 객체
    - container : 객체 생명주기 관리


- DispatcherServlet Class
    - 모든 요청은 DispatchServlet으로 전달
    - DispatchServlet 에서 HandlerMapping에 URL 전달
    - HandlerMapping은 DispatcherServlet에 다시 전달
    - Dispatcher는 Controller로 request 전달
    - Controller를 통해 받은 값으로 DispatcherServlet은 InterView에 값 전달
    - InterView는 값을 통해 어떤 .jsp파일로 가야할지 반환
    - DispatcherServlet은 .jsp 파일을 찾아감 

    - DispatcherServlet 설정 파일
        - /WEB-INF/spring/appServlet/servlet-context.xml
            - DispatcherServlet, Controller 설정
            - ```
              <beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		        <beans:property name="prefix" value="/WEB-INF/views/" />
		        <beans:property name="suffix" value=".jsp" />
	          </beans:bean>
              ```
            - prefix + 경로명 + suffix
            - /WEB-INF/ 하위의 폴더를 수정한다면 prefix 경로도 수정

        - /WEB-INF/spring/root-context.xml 
            - App 전체 설정

- Controller 작성법
    - POJO로 작성
        - 일반 클래스 작성(컨트롤러)
        - @Controller 선언
        - @RequestMapping(value="요청url 공통 경로")
        - public String 메서드명 작성(컨트롤러 내부)
        - @RequestMapping(value="요청url" method = RequestMethod.GET|POST)
    
    - 메서드 return
        - String    : Client에서 보내고자 하는 .jsp의 url
        - void      : value와 url가 같을 때, void로 해도 상관 없음

- front에 필요한 것들
    - css/js/image 등은 resources 폴더 내에 넣어야한다
    - 혹은 servlet-context.xml 에서 resources 맵핑을 추가로 해야한다
    - ```
      <resources mapping="/resources/**" location="/resources/" />
      ```