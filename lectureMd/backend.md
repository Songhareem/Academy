
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

- Client to Server 방법
    - Web brower에 URL 직접입력
    - HTML a 태그 (개발자가 미리 작성)
    - JS 의 location.href 사용 (개발자가 미리 작성)
    - form태그 (개발자가 미리 작성, 데이터 작성은 client)

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

- URI
    - 서버 내부에서 쓰는 개념
    - URL에서 ip 및 포트부분을 제외한 개념

- 배포 서술자?
    - WAS 가 최초 구동될 때,  /WEB-INF 하위에 존재하는 web.xml 을 읽고 웹 어플리케이션을 설정


- Servlet
    - WA (SNS ... )
        - front 등등 
    -WAS
        - Web.Xml을 읽고
        - Servle 객체를 샐성(싱글톤)
        - 해당 servliet의 init메서도 사용
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
    - Reqeust
        - 요청이 발생하면 생성, 응답이 나갈때 삭제
        - 요총에 대한 모든 정보를 담고있나
    - Response
        - 생명주시는 Request 왜 동일
        - 응답으로 보낼 Data 담고 있다

- MVC2 모델 
    - Web Browser - JSP - servlet(controller) - service - DAO - DB
    -         (view)   -   (controller)    -   (model)
    - <img src="https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile5.uf.tistory.com%2Fimage%2F257DE14B54C8EBE025CE79">

- WebContent
    - META-INF, WEB-INF 폴더 내부는 클라이언트에서 URL로 직접 접근 불가능(서버는 가능)

- forward / redirect 방식 (중요)
    - forword (요청 1번)
        - 서버 내부에서 다른 파일을 요청하는 방식
        - RequestDispatcher 변수명 = request.getRequestDispatcher("요청하는 파일의 경로명과 파일명");
        - 변수명.forward(request, reponse)
        - 요청하면서 날렸던 데이터를 그대로 다른곳으로 이동시켜서 사용시킬 때 사용
    - redirect (요청 2번)
        - 접속할 URL을 클라로 보내서 다시 요청하게 하는 방식
        - response.sendRedirect("URL 명");
        - 요청할 때, 데이터를 같이 날리지 않는다면 사용
