
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


