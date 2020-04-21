
# 백엔드 환경 설정

- 사용할 개발환경
    - spring 3 버전(3.9.12)
        - https://download.springsource.com/release/STS/3.9.12.RELEASE/dist/e4.15/spring-tool-suite-3.9.12.RELEASE-e4.15.0-win32-x86_64.zip

- test front page
    - bootstrap 3 사용
        - https://www.w3schools.com/bootstrap4/bootstrap_get_started.asp
        - ref : ```

                <!-- Latest compiled and minified CSS -->
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

                <!-- jQuery library -->
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

                <!-- Latest compiled JavaScript -->
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
                ```
    - 다양한 라이브러리들 있음
        - w3c tutorials ref : https://www.w3schools.com/bootstrap3/default.asp

- API 등록
    - WEB-INF/lib 폴더에 복붙

# 백 프론트 연결

- servlet
    - xml 파일로 java 클래스와 url을 매핑
    - html파일을 java 클래스에서 작성

- jsp
    - java 소스코드가 기입 가능한 html 파일
    - html파일에서 java 소스 코드를 작성

# HTTP/HTTPS

- Request(요청)
    - Client의 정보 : URL, 파라미터, 그외정보 ...
    
- Response(응답)
    - Server에서 Client로 보내는 데이터 (HTML,JS,CSS,images)

- Client to Server (Request) 방법
    - (GET)Web brower에 URL 직접입력
    - (GET)HTML a 태그 < a href="URL{?이름=값&이름=값&...}">
    - (GET)JS 의 location.href : location.href="URL{?이름=값&이름=값&...}";
    - (GET)form 태그 < form action="URL주소" method="GET">
    - (POST)form 태그 < orm action="URL주소" method="POST">

- Parameter?
    - Client에서 Server로 보내는 Data
    - 이름 : 값 (key:value)형식
    - Serber내에서 Name은 String, Value는 String 타입

    - 파라미터 이름이 하나일 때,
        - String value = request.getParameter("param명");
    - 파라미터 이름이 같고 값이 여러개 일때,
        - String[] values = request.getParameter("param명);
    - 파라미터 이름을 모를 때,
        - request.getParameterNames(); 로 param 명을 Enumeration<String>으로 가져옴
        - ```
          Enumeration<String> names = request.getParameterNames();
          while(names.hasMoreElements()) {
		    	System.out.println(names.nextElement());
		  }
          ```
    - 서버 내에서 사용하는 파라미터
        - web.xml에 파라미터를 등록해서 사용
            - ServletConfig
                - 각각의 Servlet에서 사용하는 파라미터
                - getServletConfig().getInitParameter("");
            - ServletContext
                - 전체의 Servlet에서 사용하는 파라미터
                - getServletContext().getInitParameter("");-

- Method
    - 요청 메서드 
        - Get
            - 주소창에 직접입력, a 태그, location.href, form 태그의 method 속성을 get으로 지정했을때

            - 요청 파라미터가 주소창에 노출
            - 요청 파라미터가 header에 담김
            - 보안이 요구되지 않을 때
            - 작은 Data
        - Post  
            - form태그의 method 속성을 읽어서 post
            - 요청 파라미터가 주소창에 노출 x
            - 요청 파라미터가 body에 담김
            - 보안이 필요할 때
            - 큰 Data

- URL
    - http://ip:port?파라미터 이름 = 값 & 파라미터 이름 = 값
    - ? 이전 까지는 url
    - ? 이후 부터는 파라미터
    - String url = request.getRequestURL();

- URI
    - 서버 내부에서 쓰는 개념
    - URL에서 ip 및 포트부분을 제외한 개념
    - String uri = request.getRequestURI();

- Context Name
    - 하나의 프로젝트 내에서 최상위 프로젝트(Root 의미)
    - String ctx = request.getContextPath();

- 배포 서술자?
    - WAS 가 최초 구동될 때,  /WEB-INF 하위에 존재하는 web.xml 을 읽고 웹 어플리케이션을 설정

- Apatch VS Tomcat  
    - 아파치
        - 정적인 페이지만 가능
    - 톰캣
        - 동적인 페이지도 가능

- Servlet
    -WAS
        - Web.Xml을 읽고
        - Servlet 객체를 생성(싱글톤)
        - 해당 servliet의 init메서드 사용
        - 요청이 오기를 기다림
        - URL 패턴에 맞는 요청이 오면
        - WAS가 Requset(요청에 대한 모든 정보)와 Response(응답에 대한 모든 정보) 객체 생성
        - 해당 servlet service메소드 호출, 매개변수로 Req, Res 전달
            - 요청 메서드가 get이면 doGet호출
            - 요청 메서드가 post이면 doPost호출
            - 맺개변수로 받아온 Req, Res에 매개변수로 전달
        - 응답이 오면, 다시 요청 기다림

- 내장 객체?
    - 개발자가 만드는 객체가 아니라 WAS가 생성하는 객체
    - 생명주기가 짧은 객체에서 보다 긴 객체를 반환 받을 수 있음(반대 불가)
    - Reqeust
        - 요청이 발생하면 생성, 응답이 나갈때 삭제
        - 요청에 대한 모든 정보를 담고있음
        - HttpServletRequest request;
    - Response
        - 생명주기는 Request 와 동일
        - 응답으로 보낼 Data 담고 있다
        - HttpServletResponse response;
    - Session
        - Server에 존재
        - Web Browser별로 하나씩 생성
        - HttpSession session;
    - Config
        - Servlet(jsp)의 자체 정보를 가지는 객체
        - servlet : getServletConfig();
    - Application
        - web application의 공통 정보를 가지는 객체
        - servlet : getServletContext();

- Attribute
    - 내장객체의 어떤값을 저장하거나 꺼내올때 사용
    - 형식: key(String):value(Object)값으로 되어있음
    - 참조변수명.setAttrubute("만들 키값", Oject2)
    - 참조변수명.getAttribute;;
    - 서버 내부에서 데이터 전달시 많이 사용

- jsp
    - 스크립틀릿을 사용
        - <% 자바 코드 %>       : 자바 코드를 기술
        - <%=변수명 또는 값 %>  : 자바 값 출력
    - EL(Express Language)
        - ${스코프영역.속성명}
            - 스코프영역 : 내장 객체의 생명주기와 같음
                - pageScope : 현재 페이지가 실행하면 생성, 페이지가 끝나면 소멸
                - requestScope : 요청 발생시 생성, 응답 발생시 소멸
                - sessionScope : 웹브라우저가 처음 웹서버에 요청했을때 생성, 일정 시간이 흐르거나 웹브라우저 종료시 소멸
                - applicationScope : 서버(WSA) 실행시 생성, 서버(WSA) 종료시 소멸
                - scope는 생략가능
                    - page -> req -> session -> application으로 속성명 탐색
                    - 서로 다른 scope에 같은 속성명이 있을 경우 처음 찾은거 사용
        - 연산자
            - 산술 연산자
                - +, -, *, /, %
                - ${가져온 값 div 2}
                - ${가져온 값 mod 3}
            - 비교 연산자
                - ==, !=, >, <, >=, <= 
                - == : ${가져온 값 eq 비교값}
                - != : ${가져온 값 ne 비교값}
                - >  : ${가져온 값 gt 비교값}
                - <  : ${가져온 값 lt 비교값}
                - >= : ${가져온 값 ge 비교값}
                - <= : ${가져온 값 le 비교값}
            - 논리 연산자
                - &&, ||, !
                - && : ${논리값1 AND 논리값2}
                - !  : ${not 논리값1}
            - empty
                - 값이 null, 값이 빈문자열"", 길이가 0인 배열, 컬렉션 크기가 0?
                - ${empty 값}
                - ${not empty 값}
            - 삼항연산자
                - ${조건식?a:b}
            - Cookie
                - ${cookie.쿠키명.value}
                
    - JSTL (Java Server Pages Standard Tag Library)
        - 라이브러리 다운 필요
            - ref : https://mvnrepository.com/
            - ref : https://mvnrepository.com/artifact/javax.servlet/jstl/1.2
        - 받은 라이브러리 WEB-INF/lib/ 에 넣기(복붙)
        - JSTL을 사용할 jsp 에 incluse
            - <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        - 문법
            - <c:forEach> : for문, step에 음수는 넣을수 없다
                - <c:forEach begin="시작번호" end="끝번호" var="변수명" varStatus="변수명" step="증가값">
                -  <c:forEach items="컬렉션명" var="변수명" varStatus="변수명">

- MVC2 모델 
    - Web Browser - JSP - servlet(controller) - service - DAO - DB
    -         (view)   -   (controller)    -   (model)
    - <img src="https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile5.uf.tistory.com%2Fimage%2F257DE14B54C8EBE025CE79">

- WebContent
    - META-INF, WEB-INF 폴더 내부는 클라이언트에서 URL로 직접 접근 불가능(서버는 가능)

- forward / redirect 방식 (중요)
    - URL 기준
        - 현재 웹 브라우저의 URL 기준
    - forword (요청 1번)
        - 서버 내부에서 다른 파일을 요청하는 방식
        - RequestDispatcher 변수명 = request.getRequestDispatcher("서버 내부 파일 파일의 경로명과 파일명");
        - 변수명.forward(request, reponse)
        - 요청하면서 날렸던 데이터를 그대로 다른곳으로 이동시켜서 사용시킬 때 사용
    - redirect (요청 2번)
        - 접속할 URL을 클라로 보내서 다시 요청하게 하는 방식
        - response.sendRedirect("URL 명");
        - 요청할 때, 데이터를 같이 날리지 않는다면 사용

# form 태그 중요한것

- name tag => back에서 받는 key이름

- form에서 데이터 넘어가는지 확인?
    - 개발자툴 Network 하단 Form Data 살펴보기

# Filter   

- 일종의 Java Class
- 요청이 발생하면 Filter -> Controller(Servlet)
- 응답시 Filter -> Client
- 요청시 필터의 순서는 web.xml 위에서 아래로
- 응답시 필터의 순서는 web.xml 아래에서 위로