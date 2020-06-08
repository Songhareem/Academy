
# Spring Boot

- Library 관리가 좀 더 편리
- XML 설정을 Java에서 관리
- 레거시 프로젝트를 다루려면 추가 라이브러리 설치 필요
- jsp를 권장하지 않음(typeleaf 등등을 사용 권장)
- 다운로드
    - https://spring.io/tools
    - eclipse for window
- 설치
    - 설치할 폴더에 받아온 spring-tool-suite-4-4.?.?.RELEASE-e4.15.0-win32.win32.x86_64.self-extracting.jar 파일을 옮김
    - 터미널에서 java -jar spring-tool-suite-4-4.?.?.RELEASE-e4.15.0-win32.win32.x86_64.self-extracting.jar 실행
    - sts-4.?.? 폴더 생성 확인
    - workspace 만들고 연결
- 프로젝트 생성
    - SpringBootStart/springbootSetupimg 폴더 참고
- 환경설정
    - window - preperence
        - encode - utf-8
        - General - web browser - external - 원하는 브라우저
        - General - contentTypes - text - java properties file - encode를 UTF-8 후, update클릭
- 실행
    - 프로젝트 우클릭 - run as - spring boot app
- 사용
    - app.properties 에서 모든 properties 관리
    - junit 테스트 필요 어노테이션 = @SpringBootTest
- 추가 라이브러리 다운
    - mvnrepository
        - spring boot ~ 검색
        - dependency 복사 붙여넣기
        - version 에러시, version 명시 삭제
- src/main/resources
    - static (배포시에 사라지는 폴더)
        - 이미지, js 등을 넣는 폴더
# Annotation

- 객체 생성
    - @Controller
    - @RestController
    - @AdviceController (예외처리 컨트롤러)
    - @Service{("이름")}
    - @Repository{(name="이름")}
    - @Component{("이름")}
    - 보조
        - @Qualifier("이름")
            - 객체(Bean)의 이름 지정

- 객체 주입
    - @Autowired
        - Type으로 찾아서 매핑
        - Type으로 찾아서 없으면 Name으로 매핑
        - 보조
            - @Qualifier("이름")
                - 해당 이름으로 객체(Bean) 찾기
    - @Inject
        - Type으로 찾아서 매핑
        - regacy 까지만 있음
    - @Resource{("이름")}
        - Name으로 찾아서 매핑
        - Name으로 찾아서 없으면 Type으로 매핑

# xml을 대체하는 POJO

- Annotation을 못쓰는 경우(라이브러리), xml 또는 POJO를 사용하여 선언 필요

- @Configuration
    - 설정 정보를 가지는 java class 생성(xml 대체)
- @Bean
    - 객체를 생성할 메서드 선언부에 선언

# junit

- @SpringBootTest
    - TestCase class 선언부에 작성

- @Test
    - Test Method 선언부에 작성

- @BeforeAll(junit4 - @BeforeClass)
    - Test Class 시작시 딱 1번 호출

- @AfterAll(junit4 - @AfterClass)
    - Test Class 종료시 딱 1번 호출

- @BeforeEach(junit4 - @Before)
    - Test Method 실행전에 호출

- @AfterEach(junit4 - @After)
    - Test Method 실행후에 호출

# Mysql

- 다운로드 : docker로 mysql 다운되므로, workbench만 다운
    - https://dev.mysql.com/downloads/file/?id=495322

- 설치 및 실행
    - docker
        - docker run --name mysql -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root 30f937e841c8
        - docker exec mysql -it bin/bash
    - mysql shell
        - mysql -u root -p 엔터 후 비번으로 root 치고 엔터
        - create database user;
        - select user(); : 현재 접속 유저 확인
        - 유저 생성 및 접속 가능 주소 설정
            - create user 'user01'@'%' identified with mysql_native_password by 'user01'
        - 유저 권한 설정
            - create database DB명;
            - grant all privileges on DB명.* to '유저명'@'접속 경로';
            - flush privileges;
            - commit;
        - 유저로 재접속
            - mysql -u user01 -p 엔터 후 user01

- 접속 프로그램
    - mysql installer
        - custom - workbench 및 connector J 만 설치
        - next 누르면서 install
    - mysql workbench
        - 접속 트고 시작하면 됨!

- mybatis
    - DAO는 interface로 생성
        - DAO(Mapper.java)의 패키지명.클래스명과 Mapper.xml의 이름과 Namespace의 이름가 동일하게 생성
        - 메소드명과 Mapper.xml의 id랑 동일하게 생성
        - 인터페이서 선언부에 @Mapper 선언
    - Mapper.xml위치
        - 1 ) /src/main/resources/**/*Mapper.xml
            - application.properties에 위치 등록 필요
        - 2 ) DAO(Mapper.java)와 같은 패키지에 생성
            - application.properties에 위치 등록 필요 X
    - pager 달라진 점
        - Pager limit 시작번호, 갯수 (startNum , perPage)
        - SELECT * FROM notice ORDER BY num DESC LIMIT 20, 10;
    - 검색 달라진 점
        - 검색 like concat('%',#{search}, '%')

- Hybernate용 유저 생성
    - 

# Docker

- 메모리 / CPU 자원 공유는 같으나, OS만 하나 더 쓰는식
- 다운로드
    - https://www.docker.com/get-started
    - for window
- 설치
    - 작업관리자 - 성능 - CPU - 가상화(사용) 확인 (안되어 있다면, 바이오스에서 설정)
    - 제어판 - 프로그램 및 기능 - 왼쪽 window 기능 켜기/끄기 - hiperV 체크 해제 상태인지? (docker 깔고나서 체크되는지 확인)
- 사용
    - 도커 가입
    - https://hub.docker.com/ 들어가서 검색
        - cmd 에서 docker search 검색어로 검색하는 방법도 가능
    - docker pull command 복사해서 cmd에서 실행(OS 및 설정 다운로드)
    - cmd에서 docker images 입력
        - docker images : 다운받은 이미지들 정보 확인
        - image : 원본
        - container : 원본을 복사해서 사용하는 것
    - cmd에서 docker run --name 이미지명 -d -p HostPort:GeustPost 이미지id
        - --name : docker는 이름으로 image 구분, 이름 지정
        - -d : 백그라운드로 돌게함
        - -p : 포트 설정
            - HostPort:GeustPost => HostPort로 들어오는 정보를 GeustPost로 보내줌
        - 이미지id : 다운받은 이미지id(docker images에서 확인)
    - cmd에서 docker ps 입력
        - 현재 실행중인 컨테이너 확인
        - -a 옵션 추가시, 실행/정지 중인 컨테이너 확인
    - cmd에서 docker exec -it 이름명 bin/bash

- 명령어
    - docker images : 다운받은 image확인
    - docker run --name 이미지명 -d -p HostPort:GeustPost 이미지id
    - docker ps
    - dokcer ps -a 
    - docker start 컨테이너명 : 컨테이너 실행
    - docker restart 컨테이너명 : 컨테이너 재실행
    - docker stop 컨테이너명 : 컨테이너 실행 중지
    - docker rm 컨테이너명 : 컨테이너 삭제
    - docker rmi 이미지명 : 이미지 삭제
    - docker exec -it(= -i -t) 이름명 실행할shell종류 : 실행중인 컨테이너로 진입
        - shell 종류 : bin/bash

- Oracle 예제
    - Oracle image를 hub에서 다운
        - ref : https://hub.docker.com/r/oracleinanutshell/oracle-xe-11g
    - cmd 에서 docker pull ~
    - 컨테이너 생성 및 실행
        - cmd 에서 docker run --name ~ -d -p 1521:1521 ~
    - 컨테이너 종료 / 시작 / 재시작
        - cmd 에서 docker stop/start/restart ~
    - 컨테이너 삭제
        - cmd 에서 docker rm ~
    - 이미지삭제
        - cmd 에서 docker rmi ~
    
    
# front

- jsp 연동
    - webapp 폴더 아래에 WEB-INF/views 두 폴더 생성
    - application.properties에 추가
        - spring.mvc.view.prefix=/WEB-INF/views/
        - spring.mvc.view.suffix=.jsp
    - JSP 관련 API 추가
        - jstl : https://mvnrepository.com/artifact/javax.servlet/jstl/1.2
        - Tomcat Embed Jasper : 

# fileUpload

- API는 이미 등록되어 있음

- mutipartFileResolver 등록 필요
    - application.properties에 등록
        - ```
            # mutipartFileResolver
            # multipart 사용여부
            spring.servlet.multipart.enabled=true
            # 각 파일 당 최대 파일 크기
            spring.servlet.multipart.max-file-size=10MB
            # 총 파일 크기
            spring.servlet.multipart.max-request-size=50MB 
          ``` 

- form태그 method="post" enctype="multipart/form-data"

- controller의 매개변수로 multipartFile 선언

# Transaction

- 트랜젝션이 필요한 서비스 선언부에 @Transactional 선언
    - @Transactional(rollbackFor = Exception.class)

- 테스트 클래스에서 값이 넣어지길 원지않고 테스트만 원한다면, 선언부에
    - @Transactional(value=true)

# AOP

- API 다운
    - https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-aop/2.3.0.RELEASE
- 설정
    - Main Class (main메서드를 포함한 클래스) 선언부에 @EnableAspectJAutoProxy 추가 (생략해도 되나, 동작하지 않으면 필히 선언)
    - advice class 생성
        - @Component
        - @Aspect
- @Before
- @After
- @AfterThrowing
    - 예외발생시
- after-returnning
- around

# Interceptor

- Interceptor 실행되는 때
    - Controller 진입전
    - Controller 진입후
    - JSP 랜더링 후

- 인터셉터는 위에서 아래로 순차로 실행

# Message 다국어

- 한글 KO / 영어 EN
    - 영어 / 한글 버전 메시지 파일 생성

- 생성위치 
    - /src/main/resources
    - message 폴더 생성
    - message_ko.properties
    - message_en.properties
    - message.properties

- application.properties에 적용
    - ```
        # message properties 설정
        # 위치 / encoding / key값이 없는 경우 처리 / properties 파일의 변경을 감지할 시간 간격(sec)
        spring.messages.basename=message/message
        spring.messages.encoding=UTF-8
        # true : 키 자체 출력 / false : 예외 발생
        spring.messages.use-code-as-default-message=true
        spring.messages.cache-duration=60
      ```
- jsp 에서 사용
    - 선언부 : <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    - 사용 : <spring:message code="hello"></spring:message>

- 언어 구분 방법 (2가지 방법)
    - session 이용
    - cookie 사용

- 구현
    - Interceptor 사용해서 언어 구분

# Form 검증

- API : https://mvnrepository.com/artifact/org.hibernate.validator/hibernate-validator/6.1.5.Final

- jsp 페이지에서 form:form으로 교체
    - jsp 페이지로 이동할 때, model에 VO를 첨부해야함 (필수, 빈 VO라도 넣어줘야함)

- Controller에 post 처리
    - 매개변수 변경
    - @Vaild VO, BindingResult ... (BindingResult위치는 검증하는 데이터 바로 뒤)

- VO 처리
    - 검증 필요 멤버변수에 @NotEmpty(javax.validation.constraints.NotEmpty) 선언

- 검증 메시지
    - Annotation뒤에 선언
        - @NotEmpty(message = "제목을 입력하세요")
    - message properties 파일에 작성
        - 검증Annotation명=메세지 (해당 Annotation 일괄)
        - 검증Annotation명.멤버변수명=메세지 (해당 변수명에만 줄 메세지)
        - 검증Annotation명.VO명.멤버변수명 (VO명의 첫글자는 소문자)

- 검증 Annotation
    - javax.validation.constraints.NotEmpty 제공
        - @NotNull  : null 여부
        - @NotEmpty : 데이터 존재여부
        - @Max      : Max 설정값 보다 데이터 넘으면 X
        - @Min      : Min 설정값 보다 데이터 작으면 X
        - @Size(max=, min=)
        - @AssertFalse  : false면 ok
        - @AssertTrue   : true 면 ok
        - @DecimalMax   : MAX 이상의 실수면 X
        - @DecimalMin   : MIN 이하의 실수면 X
        - @Future       : 기존 날짜보다 미래의 날짜면 ok
        - @Past         : 기존 날짜보다 과거의 날짜면 ok
        - @Pattern(regex="정규표현식")
    - org.hibernate.validator.constraints 제공
        - @Email                : 이메일 형식 검증
        - @Length(min=, max=)   : 문자열 길이 검증
        - @Range(min=, max=)    : 숫자 범위 검증
        - @URL                  : URL 형식 검증

- 검증이 필요한데 어노테이션으로는 못하는 것들
    - id 중복확인
    - pw , pw confirm 같은지 확인
    - 해결 : 커스텀 어노테이션

- 커스텀 어노테이션
    - 사용자 정의 에러 메시지 작성
    - 검증할 클래스 생성 및 검증 메서드 생성 or Service 클래스내에 검증 메서드를 생성

# 예외처리

- 각 Controller 별로 처리

- Error 전용 Controller에서 처리

# schedule

- 특정 시간이나 주기적으로 반복적인 작업을 해야할 때 사용

- 사용 
    - main 메서드 클래스 선언부에 @EnableScheduling 선언
    - Schedule 구현하는 클래스 생성
        - 반복작업을 할 메서드 선언, 선언부에 @Schedule() 선언
        - @Schedule(fixedRate=1000)          : 숫자로 컨트롤 (ms 단위)
        - @Schedule(fixedRateString="1000")  : 문자로 컨트롤 (ms 단위)
        - @Schedule(fixedDelay=1000)         : 숫자로 컨트롤 (ms 단위)
        - @Schedule(fixedDelayString="1000") : 문자로 컨트롤 (ms 단위)

- 부록
    - fixedRate : app 실행 후, 고정간격으로 실행
    - fixedDelay : app 종료 후, 고정간격으로 실행
    - 둘의 차이?
        - Rate : 호출된 작업이 종료 상관없이, 시간간격마다 호출
        - Delay : 호출된 작업이 종료 되어야, 시간간격 뒤 실행

- 활용
    - 디버그 로그?
    - 실시간 서버 만들 때?
    - 일정 기간 지난 후, 백업/불필요 파일 삭제 등

- Cron = *(초) *(분) *(시) *(일) *(월) *(요일)
    - Linux에서 온 개념
    - 초 : 0 ~ 59
    - 분 : 0 ~ 59
    - 시 : 0 ~ 23
    - 일 : 1 ~ 31
    - 월 : 1 ~ 12
    - 요일 : 0(일) ~ 6(토) + 7(일) : 0 , 7 일요일
    - ****** : 1초마다 반복
    - 10***** : 매분 10초에 반복
    - 0 10 **** : 매시 10분 0초에 반복
    - 0 0 0 *** : 매일 자정에 반복
    - 0 0 0 1 ** : 매월 1일 자정에 반복
    - 0 0 0 25 12 * : 년에 한번 12월 24일 자정에 반복
    - 0 0 0 * * 1 : 월요일 자정마다 반복
    - */10 * * * * * : 10초 간격 반복
    - 0 20 */3 * * * : 3시간 간격 매 20분에 반복
    - 0 0 0 * * 6-7 : 매 토요일 일요일 자정에 반복
    - 0 0 0 * * 1,3 : 매 월,수요일 자정에 반복
    - 10,30 0 0 * * * : 매 10,30초 마다 반복
    - 0 0 9-18/2 * * 1-5 : 매 평일 9~18시 안에서 2시간 간격으로 반복 

- Cron 적용
    - @Scheduled(cron = "* * * * * *")

- 멀티쓰레드 설정
    - application.properties
    - ``` 
        # Schedule
        spring.task.scheduling.pool.size=8
        spring.task.scheduling.thread-name-prefix=custom_
      ```
# Rest API

- ```
        @Controller
        public class RestTestController {

            // Rest는 자원의 역할을 하는 인자에 의해, 동적 url로 변함
        //	@GetMapping("/test/select/{num}")
        //	public void test(@PathVariable(value="num", required = true) int num) {
        //		System.out.println("num : "+num);
        //	}
            @GetMapping("/test/select/{num}/{name}")
            public void test(@PathVariable(value="num", required = true) int num, String namefw1fw) {
                System.out.println("num : "+num);
            }
            
        //	@GetMapping("/test/list/{curPage}/{kind}/{search}")
        //	public void listTest(
        //			@PathVariable int curPage, 
        //			@PathVariable String kind,
        //			@PathVariable String search) {
        //		System.out.println("curPage : "+curPage);
        //		System.out.println("kind : "+kind);
        //		System.out.println("search : "+search);
        //	}
            
            @GetMapping("/test/list/{curPage}/{kind}/{search}")
            public void listTest(Pager pager) {
                System.out.println("curPage : "+pager.getCurPage());
                System.out.println("kind : "+pager.getKind());
                System.out.println("search : "+pager.getSearch());
            }
        }
  ```

# Lombock

- API 다운
    - https://projectlombok.org/download

- 적용
    - 다운받은 jar file 더블클릭해서 이클립스 경로잡고 설치

# JPA (Java Persistent Api)

- Java 표준 ORM API

- interface 묶음

- Java언어 ORM 기준 스펙 

- ORM?
    - Object relational mapping

- Hibernate
    - JPA를 사용할 수 있도록 Overriding 된 구현체

- Spring Data JPA
    - Hibernate를 이용하여 스프링에서 처리할 수 있도록 지원하는 라이브러리

- JPA 장점
    - 데이터베이스에 종속적이지 않고 개발 가능
    - 데이터베이스에 관련된 코드가 유연함

- JAP 단점
    - 러닝커브 큼
    - 객체개념 필수
    - 데이터베이스의 고유기능 사용에 제한적

# JPA Project 생성

- 설정 : 
    - Spring Web, Spring data jpa, Jdbc driver(mysql), DevTools
    - application.properties
    - vo 생성
        - @Entity : 엔티티 매니저가 관리함을 의미
            - name : Entity의 이름을 지정, 다른 패키지나 클래스에 같은 이름이 있으면 Error, 이름을 쓰지 않으면 클래스 이름을 기본값으로 지정(단, 이름이 첫글자가 소문자 아님)
        - @Table : 엔티티와 매핑할 테이블 연결, 이름을 생략하면 엔티티와 같은 이름의 테이블 매핑
            - name : 맵핑할 테이블 명 지정
            - catalog : catalog 기능이 있는 DB에 catalog 매핑 (catalog?)
            - schema : schema 기능이 있는 DB에 schema 매핑 (schema?)
            - UniqueConstraints : DDL 생성시, Unique 제약조건 생성, 2개 이상의 복합키 쓸 때 사용
    - vo 멤버변수에 Annotation 적용
        - @Id : 기본키 매핑(PK)
        - @Column : 멤버변수명과 테이블의 컬럼명과 매핑, 멤버변수명과 컬럼명이 일치한다면 생략 가능
            - name : DB의 컬럼명과 멤버변수명 매핑
            - insertalbe : true (insert허용) / false (읽기 전용)
            - updatealbe : true (update허용) / false (읽기 전용)
            - table : 하나의 엔티티를 두개 이상의 테이블에 매핑할 때 사용(거의 사용 안함)
            - nullable : null값 허용 여부, true (null 허용 -Default-) / false(not null 제약조건 생성)
            - unique : unique 제약조건 생성시 사용, 두 컬럼 이상이면 UniqueConstraints
            - length : 문자 길이에 제한, String에서만 가능
            - precision : BigDecimal / BigInt 타입에 사용, 소수점 포함 전체 자리수
            - scale : BigDecimal / BigInt 타입에 사용, 소수점 자리수
                - @Column(precision=10, scale=2)
        - @Enumerated : java enum 타입을 매핑 할때 사용
            - EnumType.ORDINAL : enum 순서번호를 데이터베이스에 저장
            - EnumType.STRING : enum 이름을 데이터베이스에 저장
        - @Temporal : 날짜 타입(java.util.Date, java.uti.Calendar)을 매핑 할 때 사용
            - TemporalType.DATE : 날짜, 데이터베이스 Date타입과 매핑 (2020-01-01)
            - TemporalType.TIME : 시간, 데이터베이스 Time타입과 매핑 (17:50:50)
            - TemporalType.TIMESTAMP : 날짜와 시간, 데이터베이스 Timestamp 타입과 매핑 (2020-01-01 17:50:50)
        - @Lob : 데이터베이스 BLOB, CLOB 타입과 매핑
            - CLOB : 멤버변수가 문자면(char [], String)
            - BLOB : 멤버변수가 문자 이외(byte [] ...)
        - @Transient : 테이블에서 제외할 멤버변수명




    