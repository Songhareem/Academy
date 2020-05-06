
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