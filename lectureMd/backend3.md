
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
- root-context.xml에 properties 읽어오는 bean 추가 및 DB 에 적용
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
- java 소스 코드에서 사용
    - ```
        @Value("${oracle.user}")
	    private String user;
      ```

# AOP (Aspect Orientied Programming)

- OOP 언어 대체가 아닌 보완 해주는 개념(횡적 관심사)

- 사용처
    - 트랜젝션
    - 개발시 console logger

- 주요 용어
    - Join Point
        - 횡단 관심이 동작 할 수 있는 실행 가능한  위치
        - 관심 사항이 있는 위치(clas)
    - point cut
        - join point 의 실제 관심 사항(method)
    - advice
        - join point에서 동작하는 코드(point cut 앞뒤로 행해지는 코드)
    - aspect
        - advice 와 point cut 의 조합
    - weaving
        - point cut에 advice를 적용하는 과정

- advice 적용 시점
    - before advice : point cut 실행 전
    - after Return advice : point cut 시행 후(예외가 발생되지 않았을때)
    - after Throwing advice : point cut 실행 후 (예외 발생시)
    - after advice : point cut 실행후 (정상종료 또는 예외 발생)
    - arround :point cut 실행 전 후 (정상종료 또는 예외 발생)

- execution(접근지정자 패키지명.클래스명.메서드명(매개변수))
    - 메서드 단위로 weaving
    - execution(public *.*)  : public 메서드
    - execution(* set*(..))  : 메서드명이 set으로 시작하는 모든 메서드
    - execution(* com.iu.Test.*(..)): com.iu.Test 클래스 내의 모든 메서드
    - execution(* com.iu.*.*(..))   : com.iu 패키지 내의 모든 클래스의 모든 메서드
    - execution(* com.iu..*.*(..))  : com.iu 모든 하위 패키지 내의 모든 클래스의 모든 메서드
    - execution(* get())            : 메서드명이 get으로 시작하는 모든 메서드(매개변수 없음)
    - execution(* get(*))           : get메서드 중 매개변수 하나
    - execution(* get(*,*))         : get메서드 중 매개변수 두개
    - execution(* get(..))          : 모든 get메서드 (매개변수 갯수 상관 없음)
    - execution(* get(Integer))     : get메서드 중 매개변수 하나, Integer
    - execution(* get(Integer,..))  : get메서드 중 Integer, 이후 매개변수 상관 x
    - execution(* get(*)) && excution(* get*(Integer)) : and연산
    - execution(* get(*)) || excution(* get*(Integer)) : or연산

- within
    - 클래스 단위로 weaving
    - within(com.iu.*)  : com.iu패키지 내의 모든 클래스의 메서드
    - within(com.iu..*)  : com.iu 하위 패키지 포함 모든 클래스의 메서드 

- aop 적용    
    - API 등록 (pom.xml)
        - Spring-aop
            - ```
                <!-- https://mvnrepository.com/artifact/org.springframework/spring-aop -->
                <dependency>
                    <groupId>org.springframework</groupId>
                    <artifactId>spring-aop</artifactId>
                    <version>${org.springframework-version}</version>
                </dependency>
            ```
        - aspect-Jweaver
            - ```
                <!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
                <dependency>
                    <groupId>org.aspectj</groupId>
                    <artifactId>aspectjweaver</artifactId>
                    <version>${org.aspectj-version}</version>
                </dependency>
              ```
    - 사용법
        - xml 이용 (*.context)
            - new Spring bean configuration file(aop-context.xml)
            - web.xml에 등록(root-context param이 있는곳에 적용)
            - namespace aop 체크
            - aop-context.xml 내부
                - ```
                    <bean class="com.song.Spring_legacy2.transfer.Transfer" id="transfer"></bean>
	
                    <bean class="com.song.Spring_legacy2.transfer.Card" id="card"></bean>
                    <aop:config>
                        <aop:aspect id="cardCheck" ref="card">
                            <aop:pointcut expression="execution(* com.song.Spring_legacy2.transfer.Transfer.*())" id="trans"/>
                            <aop:around method="cardCheck" pointcut-ref="trans"/>
                        </aop:aspect>		
                    </aop:config>
                  ```
            - advices에 해당하는 클래스 내부
                - ```
                    public class Card {
                        public Object cardCheck(ProceedingJoinPoint join) throws Throwable {
                            
                            System.out.println("---------------------");
                            System.out.println("카드chekc in");
                        
                            Object object = join.proceed();
                            
                            System.out.println("카드chekc out");
                        
                            return object;
                        }
                    }
                  ```
        - Annotation 이용
            - new Spring bean configuration file(aopAnno-context.xml)
            - web.xml에 등록(servlet-context param이 있는곳에 적용)
            - namespace aop 체크
            - aopAnno-context.xml 내부
                - ```
                    <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
                  ```
            - advice 클래스 내부
                - 

# 트랜젝션

- 삽입, 삭제, 수정 중 두가지 이상이 한 작업에서 일어날 때, 트랜젝션 처리 필요
