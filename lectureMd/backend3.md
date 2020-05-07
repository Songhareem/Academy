
# interceptor

- Servlet Filter
    - 위치 : Controller 진입 전(필수), 후(필수)
    - web.xml에서 URL Pattern으로 Filter를 설정

- interceptor
    - Servlet 의 필터와 비슷
    - 위치 : Controller 진입 전(선택), 후(선택), 렌더링(JSP)이 끝난 후

- interceptor 클래스 작성
    - Java class 작성 (POJO)
    - HandlerInterceptorAdapter 클래스 상속
    - method 오버라이딩
        - preHandle : Controller 진입 전
            - return true : Controller 이동
            - return false : Controller 이동 X
        - postHandle : Controller 진입 후
        - afterCompletion : 렌더링(JSP)이 끝난 후
    - ***-context.xml에서 URL Pattern으로 Interceptor를 설정(servlet-context.xml 추천)
    - interceptor 적용
        - ***-context.xml
            - ```
                <interceptors>
                    <interceptor>
                        <!-- URL Pattern -->
                        <mapping path="/*"/>
                        <!-- Interceptor class -->
                        <beans:bean class="com.song.Spring_legacy2.interceptor.TestInterceptor">
                        </beans:bean>
                    </interceptor>
                    
                    <interceptor>
                        <!-- URL Pattern -->
                        <mapping path="/notice/*"/>
                        <!-- 해당 경로 제외 -->
                        <exclude-mapping path="/notice/noticeList"/>
                        <exclude-mapping path="/notice/noticeSelect"/>
                        <!-- 생성한 객체 참조 (@Component 참조) -->
                        <beans:ref bean="noticeInterceptor"/>
                    </interceptor>
                </interceptors>
              ```
        - @Component

# properties

- 필요 데이터를 외부에 두고 읽어서 사용, key value 형식
- 위치 : src/main/resources/*
- properties 파일 생성
- .gitignore에 properties 파일 추가할 것
- *.propertices
    - ```
        oracle.user = user02
        oracle.pw = user02
        oracle.url = jdbc:oracle:thin:@192.168.56.101:1521:xe
        oracle.driver = oracle.jdbc.driver.OracleDriver
      ```
- root-context.xml에 properties 읽어오는 bean 추가 및 DB 에 적용(안되면 servlet-context에도 적용)
    - ```
        <!-- properties 읽어오기 -->
        <bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer" id="propertyPlaceholderConfigurer">
            <property name="locations" value="classpath:DB/config/*.properties"></property>
        </bean>
        
        <!-- db pool 가져오기 -->
        <bean class="org.springframework.jdbc.datasource.DriverManagerDataSource" id="dataSource">
            <property name="username" value="${oracle.user}"/>
            <property name="password" value="${oracle.pw}"/>
            <property name="url" value="${oracle.url}"/>
            <property name="driverClassName" value="${oracle.driver}"/>
        </bean>
      ```
- *-context.xml에 다른 방식으로 bean 추가 및 적용
    - ```
        <context:property-placeholder location="classpath:DB/config/*.properties"/>
      ```
- java 소스 코드에서 사용
    - ```
        @Value("${oracle.user}")
	    private String user;
      ``` 