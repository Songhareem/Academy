
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
    - POJO (Plain Old Java Object) : 상속없는 순수한 자바 클래스
    - IOC (Inversion Of Control)
        - 제어의 역전
        - 객체의 생성, 생명 주기의 관리까지 모든 객체에 대한 제어권을 사용자에서 컨테이너로 위임 하는 개념
        - IOC 등록 방법
            - XML 이용
                - /webapp/WEB-INF/spring/*-content.xml
                - /webapp/WEB-INF/spring/appServlet/*-content.xml
                - ```
                  // 객체 생성 예시 (setter 이용, primitive )
                  <bean class="com.song.spring_legacy.robot.Leftarm" id="leftarm">
		              <property name="name" value="leftarm"/>
		              <property name="size" value="10"/>
	              </bean>
                  
                  // 객체 생성 예시 (setter 이용, reference )
                  <bean class="com.song.spring_legacy.member.MemberService" id="memberService">
		              <property name="memberDAO" ref="memberDAO"/>
	              </bean>
                  
                  // 객체 생성 예시 (생성자 이용)
                  <bean class="com.song.spring_legacy.robot.Rightarm" id="rightarm">
                      <constructor-arg name="power" value="10"/>
                      <constructor-arg name="color" value="red"/>
                  </bean>
                  ```
            - Annotation 이용
                - @Autowired
                
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
            - resources
                - ```
                  <resources mapping="/resources/**" location="/resources/" />
                  ```
                - front에 관련된 js, css, images를 넣어놓는 폴더
        - /WEB-INF/spring/root-context.xml 
            - DispatcherServlet, Controller를 제외한 App 설정

- Controller 작성법
    - POJO로 작성
        - 일반 클래스 작성(컨트롤러)
        - @Controller 선언
        - @RequestMapping(value="요청url 공통 경로")
        - public String 메서드명 작성(컨트롤러 내부)
        - @RequestMapping(value="요청url" method = RequestMethod.GET|POST)
    
    - 메서드 return
        - String        : Client에서 보내고자 하는 .jsp의 url
        - void          : value와 url가 같을 때, void로 해도 상관 없음
        - ModelAndView  : ModelAndView를 매개변수로 받아서 쓸 때 사용

    - 메서드의 매개변수
        - HttpServletRequrst request, HttpServletResponse response
            - Servlet 때와 사용법이 같음
        - @RequestMapping(value="val" int value)
            - val의 값이 value에 넣어져서 매개변수로 들어옴
        - DTO or VO
            - DTO 또는 VO의 멤버 변수와 setter, 그리고 jsp의 name 값이 같을때, 해당 값을 자동으로 넣어줌
        - model (Interface 타입)
            - request와 같은 생명주기를 가지는 Model 인터페이스를 상속받아 만들어진 객체
            - forword방식, response 나오면 죽음
            - model.addAttribute("key", value);
            - model.addAttribute(value);    // key value가 이름이 같을때
        - modelAndView (class 타입)
            - model과 생명주기 같음
            - forword방식, response 나오면 죽음
            - model과 view를 합친것
            - ModelAndView mv
            - mv.addObject("key", name);
            - mv.setViewName("jsp명");      // 경로명과 보여줄 페이지가 다를때 많이 사용
            - return mv; 

- Annotation
    - Annotation 선언시, 싱글톤
    - 객체를 생성하는 Annotation
        - @Controller : Controller 객체임을 명시 및 DS에서 생성하도록 유도
        - @Service  : Service 객체임을 명시 및 DS에서 생성하도록 유도
        - @Repository  : DAO 객체임을 명시 및 DS에서 생성하도록 유도
        - @Component : DS에서 생성하도록 유도
    - 객체를 주입하는 Annotatoin
        - @Autowired : 객체 주입, Spring 제공, 주사용
            - 객체주입 우선순위
                - Type 검색
                - 이름 검색
            - 사용
                - setter
                - 일반메서드
                - 생성자
                - 멤버변수
        - @Inject   : 객체 주입, Java 제공
            - 객체주입 우선순위
                - Type 검색
                - 이름 검색
            - 사용
                - setter
                - 일반메서드
                - 생성자
                - 멤버변수
        - @Resource : 객체주입, 실행시 타입이 안맞으면 에러
            - 객체주입 우선순위
                - 이름 검색

# Mybatis(DB Framework, ORM)

- Java에서 SQL문을 XML로 분리

- API 등록
    - mybatis, mybatis-spring, spring jdbc(spring framework의 버전과 같은 버전), oracle OR mysql jdbc 를 mvn에서 검색후 pom.xml에 넣기

- 공식 Homepage
    - https://blog.mybatis.org/
    - docs : https://mybatis.org/mybatis-3/

# test용 Junit

- API 등록
    - junit 버전 4.7->4.12이상으로 교체, spring testContext...(spring framework의 버전과 같은 버전) pom.xml에 등록

- src/test/java
    - new -> junit test case 생성
    - 클래스 선언부에 추가
        - ```
            @RunWith(SpringJUnit4ClassRunner.class)
            @ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})         
          ```
    - test 메서드 추가
        - 메서드 선언부에 @Test 추가
        - assert 단정문을 통해 테스트

# root-context.xml

- API 등록
    - Connection pool
        - ```
            <bean class="org.springframework.jdbc.datasource.DriverManagerDataSource" id="dataSource">
                <property name="username" value="user02"/>
                <property name="password" value="user02"/>
                <property name="url" value="jdbc:oracle:thin:@192.168.56.101:1521:xe"></property>
                <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"></property>
            </bean>
          ```
    - SqlSessionFactoryBean
        - ```
            <bean class="org.mybatis.spring.SqlSessionFactoryBean" id="sqlSessionFactoryBean">
                <property name="dataSource" ref="dataSource"/>
                <property name="mapperLocations" value="classpath:DB/mapper/*Mapper.xml"/>
            </bean>
          ```
    - SqlSession
        - ```
            <bean class="org.mybatis.spring.SqlSessionTemplate" id="sqlSession">
                <constructor-arg name="sqlSessionFactory" ref="sqlSessionFactoryBean"/>
            </bean>
          ```

# Mapper file

- src/main/resources/** 에 생성
    - **에 생성할 폴더와 파일명은 개발자 임의로 지정, 단 SqlSessionFactoryBean에 있는 패턴대로 만들어야 함
    - 생성된 xml 파일에 스키마 생성
        - ```
            // 예시
            <?xml version="1.0" encoding="UTF-8"?>
            <!DOCTYPE mapper
            PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
            "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
            
            <mapper namespace="com.song.Spring_legacy2.qna.QnaDAO">

                <!-- 부분 SQL -->
                <sql id="search">
                    LIKE '%'||#{search}||'%'
                </sql>
                
                <sql id="search2">
                    WHERE
                    <choose>
                        <when test="kind == 'bt'"> title </when>
                        <when test="kind == 'bw'"> writer </when>			
                        <otherwise>contents</otherwise>
                    </choose>
                    <include refid="search"></include>
                </sql>
                
                <!-- resultMap : 조회된 컬럼명과 VO의 변수명이 일치되지 않을 때 강제 Mapping 시키는 태크-->
                <!-- 보통 Join의 결과물을 맵핑하고 싶을 때 사용 -->
                <resultMap type="MemberVO" id="">
                    
                    <!-- PK 로 꺼내오는 값은 id 태그, 나머지는 result 태그 -->
                    <id column = "조회결과의 컬럼명" property="VO의 멤버변수명"/>
                    <result column = "조회결과의 컬럼명" property="VO의 멤버변수명"/>
                    
                    <!-- 1대1관계 (1부모 : 1자식) -->
		            <association property="멤버변수명" javaType="멤버변수 타입명(풀 패키지명)">
                        <id column = "조회결과의 컬럼명" property="멤버변수의 멤버변수명"/>
                        <result column = "조회결과의 컬럼명" property="멤버변수의 멤버변수명"/>
                    </association>

                </resultMap>

                <!-- if, switch(choose) SQL -->
                <select id="boardCount" parameterType="Pager" resultType="Long">
                    SELECT COUNT(num) FROM qna
                    <where>
                        <if test="kind == 'bt'">
                            title <include refid="search"></include>
                        </if>
                        <if test="kind == 'bw'">
                            writer <include refid="search"></include>
                        </if>
                        <if test="kind == 'bc'">
                            contents <include refid="search"></include>
                        </if>
                    </where>
                </select>
                
                <select id="boardList" parameterType="Pager" resultType="QnaVO">
                    SELECT * FROM
                    (SELECT Q.*, rownum R FROM
                    (SELECT * FROM qna 
                    <include refid="search2"></include>
                    ORDER BY ref DESC, step ASC) Q)
                    WHERE R BETWEEN #{startRow} AND #{lastRow}
                </select>
                
                <select id="boardSelect" parameterType="Long" resultType="QnaVO">
                    SELECT * FROM qna WHERE num=#{num}
                </select>
                
                <insert id="boardWrite" parameterType="QnaVO">
                    INSERT INTO qna VALUES(
                    board_seq.nextval, #{title}, #{writer}, #{contents}, sysdate, 0, board_seq.currval, 0, 0 )
                </insert>
                    
                <insert id="boardReply" parameterType="QnaVO">
                    INSERT INTO qna VALUES(
                    board_seq.nextval, #{title}, #{writer}, #{contents}, sysdate, 0,
                    (SELECT ref FROM qna WHERE num = #{num}),
                    (SELECT step FROM qna WHERE num = #{num}) + 1,
                    (SELECT dept FROM qna WHERE num = #{num}) + 1 
                    )
                </insert>
                
                <update id="boardReplyUpdate" parameterType="QnaVO">
                    UPDATE qna SET step = 1 + step WHERE
                    ref = (SELECT ref FROM qna WHERE num = #{num})
                    AND
                    step > (SELECT step FROM qna WHERE num = #{num})
                </update>
                
                <update id="boardUpdate" parameterType="QnaVO">
                    UPDATE qna SET title=#{title}, writer=#{writer}, contents=#{contents}, regdate=sysdate WHERE num = #{num}
                </update>
                
                <update id="hitUpdate" parameterType="QnaVO">
                    UPDATE qna SET hit = 1+(SELECT hit FROM qna WHERE num = #{num}) WHERE num = #{num}
                </update>
                
                <delete id="boardDelete" parameterType="Long">
                    DELETE FROM qna WHERE num=#{num}
                </delete>
            </mapper>
          ```
        - id 는 DAO의 메서드명으로(필수는 아님)
        - parameterType은 Type의 풀패키지(Long 같은 경우, java.lang.Long)
        - 매개변수는 getter에서 get을 땐 것을 #{}로 감싼것
        - DAO 클래스 내에 SqlSession 타입의 멤버변수 선언 
-           - @Autowired
            - String NAMESPACE="Maapper XML namespacr 값과 동일한 ";
        - SqlSessoin
        - sqlSesssion.Insert(NAMESPACE명, id명)
        - sqlSesssion.Insert(NAMESPACE명, parameter)

        - Select의 결과
            - 결과가 한개 일때 (결과가 여러개 나오면 ERR!!)
                - sqlSession.selectOne(NAMESPACE명, id명)
                - sqlSession.selectOne(NAMESPACE명, parameter)
            - 결과가 여러개 일때
                - sqlSession.selectList(NAMESPACE명, id명)
                - sqlSession.selectList(NAMESPACE명, parameter) 
        
        - Insert시 seqNum을 받아오는 방법
            - ```
                <selectKey keyProperty="결과값을 받을 파라미터변수 내의 멤버변수명" order="BEFORE" resultType="리턴받을 값의 타입">
                    select board_seq.nextval from dual
                </selectKey>
              ```
# List page 처리

- 파라미터
    - 현재 페이지 번호
    - 검색 종류
    - 검색어

- DB에서 일정한 수 만큼 조회
    - ROWNUM 으로 조회
    - startRow, lastRow
    - 검색처리 (Like 이용)

- 페이지 처리 계산
    - 전체글의 수(검색 처리 포함)
    - 전체글의 수로 전체 페이지 수를 구하기
    - 전체 페이지 수로 전체 블럭 수를 구하기
    - 현재 페이지 번호로 현재 블럭 번호 구하기
    - 현재 블럭번호로 시작번호 및 끝번호 구하기
    - 현재 블럭번호가 전체 블럭과 같으면 끝번호에 전체 페이지 수 넣기

- 검색 처리

# Status Code

- 400번대 : front
    - 403 Forbidden : 권한에 의한 요청 거절 
    - 404 Not Found : 요청한 페이지를 찾을 수 없음 (해당 url controller가 있는지?, jsp가 존재하는지)
    - 405 Method Not Allowd : 메소드 맵핑 에러

- 500번대 : back
          : Exception 발생

- 기타 : 실행자체가 안될때는 각종 xml 파일 확인

# Config.xml

- src/main/resources/**
- 폴더 생성과 파일명은 개발자 마음
- new -> xml 파일 생성
- xml 파일내 스키마 생성
    - ```
        <!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
      ```
- xml 파일 내에 alias 선언
    - ```
        <configuration>
            <typeAliases>
                <typeAlias type="java.lang.Long" alias="Long"/>
                <typeAlias type="com.song.Spring_legacy2.notice.NoticeVO" alias="NoticeVO"/>
                <typeAlias type="com.song.Spring_legacy2.member.MemberVO" alias="MemberVO"/>
                <typeAlias type="com.song.Spring_legacy2.qna.QnaVO" alias="QnaVO"/>	
                <typeAlias type="com.song.Spring_legacy2.util.Pager" alias="Pager"/>
            </typeAliases>
        </configuration>
      ```
- root-context.xml
    - ```
        <bean class="org.mybatis.spring.SqlSessionFactoryBean" id="sqlSessionFactoryBean">
		    ...
		    <property name="configLocation" value="classpath:DB/config/mybatisConfig.xml"></property>
		    ...
	    </bean>
      ```

# Session & Cookie

- Session : 서버 생성, 서버 저장
- Cookie : 서버 생성, 클라 저장(작은 용량의 text)
    - 클라에서 요청시, cookie 같이 이동
    - 발행한 서버에서만 사용 가능
    - key(String), value(String) 형식

# FileUpload & FileDonwload

- API
    - ```
        <!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
        <dependency>
            <groupId>commons-fileupload</groupId>
            <artifactId>commons-fileupload</artifactId>
            <version>1.4</version>
        </dependency>
      ```
    - xxx-context.xml(root-context.xml)
        - ```
            <!-- multipart resolver -->
            <bean class="org.springframework.web.multipart.commons.CommonsMultipartResolver" id="multipartResolver">
                <!-- 인코딩 설정 -->
                <property name="defaultEncoding" value="UTF-8"></property>
                <!-- 파일 하나당 용량 제한 단위 byte 예시 10MB -->
                <property name="maxUploadSizePerFile" value="10485760"></property>
                <!-- 총 파일의 용량 제한 단위 byte 예시 100MB -->
                <property name="maxUploadSize" value="104857600"></property>
            </bean>
          ```
- client
    - form tag
        - method = POST
        - enctype="multipart/form-data"

- back
    - controller의 해당 url 매개변수로 MultipartFile
        - 파일이 한개인 경우, MultipartFile Client에서_선언한_변수명
        - 파일이 여러개인 경우, MultipartFile[] Client에서_선언한_변수명
    - multipart Method
        - ```
                // 파일 업로드시 실제 이름
                String thumbName = thumb.getOriginalFilename();
                // 파라미터 명
                System.out.println(thumb.getName());
                // 파일 사이즈(용량)
                System.out.println(thumb.getSize());
                // 파일 확장자
                System.out.println(thumb.getContentType());              
                // 0,1 로 파일 뽑아냄
                System.out.println(thumb.getBytes());
          ```
- 저장
    - DB
        - BLOB Type : 최대 2GB (DB에서 이진데이터를 저장하는 타입)
    - HDD
        - 서버 HDD에 파일 저장
            - 저장할 폴더의 실제 경로를 알아옴
        - 경로명 DB에 저장
        - service단에서 해결
