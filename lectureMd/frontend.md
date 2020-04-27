
# 환경설정

- IDE       : 이클립스
- Server    : Tomcat 9(https://tomcat.apache.org/download-90.cgi)
- Web browser : Chrome

- Tomcat 설치
    - Tomcat 압축해제
    
    - Tomcat 환경변수 설정(시스템변수)
    - 변수명 : CATALINA_HOME
    - 변수값 : Tomcat의 bin 폴더를
    - Path 변수 추가 : %CATALINA_HOME%\bin
    
    - conf 폴더(bin과 같은 경로)/server.xml 편집
    - Connector port="8080" => Connector port="80" URLEncoding="UTF-8"

    - 인바운드 규칙
    - 80번 포트 규칙 생성

    - 테스트
    - bin 폴더/startup.bat

    - webapps폴더가 기본 경로

- Eclipse 설정
    - preperance
        - enco 검색 후, utf-8로 설정

    - window - perspective - open perspective - other - javaEE
    - window - webbrowser - Chrome

- Eclipse Tomcat 연동
    - preperance runtime검색, runtime environment - add - Apache Tomcat 9
    - dir = bin앞까지의 경로 , jdk든 jre든 선택 후 설정 종료

- 테스트용 예제 프로젝트
    - dynamic web project 생성

# 배포

- 프로젝트 우클릭 - Export war파일

- Tomcat의 기본 폴더 (Webapps)에 war파일 넣고, tomcat의 startup.bat 실행

# 웹 브라우저

- HTML, CSS, JS 코드 컴파일 및 실행

- 언어별 역할
    - HTML : 전체 페이지 디자인 구성
    - CSS : 디자인 역할
    - JS : 동적 요소 추가

# DOCS (HTML, js, css)

- ref : https://www.w3schools.com/

# HTML

- w3school

- 기본문법
        - Tag, Element, 요소
        - ```
          <tag명> content </tat명>
          ```
    - 부모 자식 관계
        - ```
          <div>
            contents
            <p>another Contents</p>
          </div>
          ```
    - 단독 사용 태그
        - ```
          <br>, <hr>, etc...
          ```
    - Attribute(속성)
        - 태그 내에서 부가적인 의미 전달
        - ```
          <태그명 속성명1 = "속성값" 속성명2 .../>
          ```

- 경로 지정
    - 절대 경로 방식
        - 루트 디렉토리로부터의 경로 지정
    - 상대 경로 방식
        - 현 디렉토리 기준으로 경로 지정
    - ```
        <h3>절대 경로 방식</h3>
	        <a href="https://www.naver.com">Go Naver</a>
	        <a href="/TestProject/hyper/result_1.html">Go Result_1</a>
	        <a href="/TestProject/test.html">Go Test</a>
	        <a href="/TestProject/text/text1.html">Go Text1</a>
	
	    <h3>상대 경로 방식</h3>
	        <a href="./result_1.html">Go Result_1</a>
	        <a href="../test.html">Go Test</a>
	        <a href="../text/text1.html" target="_self">Go Text1</a>	<!-- target _self : 현재창에서 이동 -->
	        <a href="../text/text1.html" target="_blank">Go Text1</a>	<!-- target _blank : 새창으로 이동(외부링크시 사용) -->
      ```

- 웹 접근성
    - 몸이 불편한 사람도 접근이 가능토록 만드는 것

- 이미지 긁어올때, 막힌거 뚫기 : f12 - f1 - disable javascript

- 미디어    
    - 이미지
        - ```
          <img src ="이미지 (절대/상대)경로">
          -- 속성
          width, heigth => css에서 지정
        ```
    - 오디오
        - ```
          <audio src="오디오 (절대/상대)경로>
          -- 속성
          autoplay  : 자동실행여부
          loop      : 반복 여부
          controls  : 빨리감기 뒤로감기
          ```
    - 비디오    
        - ```
          <video src="동영상 파일 경로">
          -- 속성
          autoplay  : 자동실행여부
          loop      : 반복 여부
          controls  : 빨리감기 뒤로감기
          poster    : 동영상 준비중에 보여줄 이미지
          width
          height
          ```
- 목록 태그
    - 순서가 있는 List
        - ```
          <ol>
            <li></li>
          </ol>
          ```
    - 순서가 없는 List
        - ```
          <ul>
            <li></li>
          </ul>
    - 속성
        - type: 순서를 나타내는 문자 변경
            - "A" : 대문자 순서
            - "a" : 소문자 순서
            - "I" : 대문자 로마숫자 순서
            - "i" : 소문자 로마숫자 순서
        - start: 시작값 지정

- 테이블
    - ```
      <table>
          <tr><td>(0,0)</td><td>(0,1)</td><tr>
          <tr><td>(1,0)</td><td>(1,1)</td><tr>
          <tr><td>(2,0)</td><td>(2,1)</td><tr>
      </table>
      ```
- 입력 태그
    - form
    - ```
      
      ```
    - 속성
        - type
            - text
            - password
            - email
            - date
            - file
            - color
        - action      : URL 데이터 전송될 URL
        - method      : 데이터 전달 방식(GET/POST)
        - enctype     : 전송될 데이터 파일존재
        - name        : 데이터 입력받는 key 및 서버로 갈때의 key 값
        - value       : 표기되는 default 값 및 서버로 갈때의 value 값
        - readonly    : 읽기 전용 - 입력 불가 - 값은 서버로 넘어감
        - placeholder : 입력 필드 설명을 위한 주석 표기
        - disabled    : 읽기 전용 - 입력 불가 - 값도 전송되지 않음

- 공간 분할 태그
    - div(block), span(inline) 
    - semantec
        - ```
          1) header     : <header>      - header 역할
          2) footer     : <footer>      - footer 역할
          3) nav        : <nav>         - 네비게이션 역할
          4) section    : <section>     - Contents의 묶음
          5) article    : <article>     - 각 Content
          6) aside      : <aside>       - side에 위치한 content
          ```
    - 공간을 분할하거나 태그들을 그룹으로 지정

- Global Attribute
    - id    : css, js 식별자, 한 페이지내에 중복은 불가능
    - class : css, js 식별자로 사용, 중복 지정이 가능
    - title : 제목을 지정, 중복가능
    - style : css 직접 입력시 사용    

# CSS

- 크기 단위
    - px        : 고정크기
    - em        : 상대크기(1.1em = 1.1배)
    - rem       : r(root) 최상위 요소(html)의 사이즈 기준
    - %         : 상대크기

- 선택자
    - *                : 모든 선택
    - 태그명            : 태그 선택자
    - #아이디명         : id 선택자
    - .아이디명         : class 선택자
    - 선택자1, 선택자2  : 동시선택
    - .c2 .c3          : 후손선택자
        - c2 아래의 c3 전부
    - .c2 > c3         : 자손선택자
        - c2 바로 아래의 c3
    - .c2, c3          : 다중선택자(?)
        - 둘다

- 각 브라우저는 고유의 css 적용되어 있으므로, 초기화 필요
    - 초기화 전용 css : reset.css

- boxModel
    - width
        - min/max-width
    - border
        - 테두리
        - Top, Right, Botton, Left
        - 선의 색깔, 선의 종류, 선의 두께
		- border-spacing: 테두리 간격
		- border-collapse: 선분할 여부
    - margin
        - element와 element간의 간격

- Margin
    - Element와 Elemenet  간격
        - Top, Right, bottom, Left'
        - margin 40px;
        - margin 10px, 20px, 30p, 40px;
        - margin 10px, 20px; 
        - margin 10px;
    - 적용하고 싶은 컨텐츠에 사용
    - 오버플로우 allowFlow

- padding
    - 적용하고 싶은 컨텐츠의 부모에 사용
    - 부모 태그와 컨텐츠 간의 간격
    - 패딩을 사용하면 수치만큼 박스가 확장
    - box-sizing(css opt)
        - content-box : 패딩 추가시 확장(기본값)
        - border-box : 패딩 추가해도 확장 없음

- 정렬
    - 수평정령
        - Block 태그 정렬
            - margin : 0px auto;
        - Inline 태그 정렬
            - padding: 좌우 패딩값을 동일

    - 수직정렬
        - Block 태그 정렬
            - 
        - Inline 태그 정렬 
            - padding: 상하 패딩값을 동일
        - 위 아래 정렬
            -line-height : 수치를 태그의 높이와 일치
- display
    - display : 태그의 속성 변경
        - inline? block? inline-block?, none?
        - inline : contents의 넓이만큼 자리를 차지, mirgin 안먹음
        - block :  contents의 넓이만큼 자리를 차지, 수정 지정가능
        - inline-block : inline 속성과 block태그의 속성을 가짐
        - none : 화면에 출럭 X, 공간X(없는 태그처럼 취급)

- visibility
    - visible : 해당요소를 화면에 출력(기본값)
    - hidden : 해당요소를 화면에서 숨김

- opacity
    - 반투명에 만들기(0.0 ~ 1.0)
    - 부모의 opacity 값을 자식이 상속

- Float
    - display : inline and 위치조정
    - none : 기본값
    - left : 왼쪽 정렬
    - right : 오른쪽 정렬
    - float 영향받기를 원치않는다면, clear: both 사용

- List
    - list-style : none 으로 사용

- font
    - font 위치 -> C:\windows\Fonts
    - font-size : font 크기
    - font-family : font 서체
    - font-style : 기울기
    - font-weight : 폰트 굵기

- text
    - text-decoration : 선 꾸미기, 윗줄, 아랫줄
    - text-indent : 들여쓰기
    - text-align : 텍스트 정렬
    - word-spacing : 단어와 단어의 간격
    - letter-spacing : 글자와 글자간 간격
    - line-height : 상하줄 간격

- background
    - background-image : url("상대/절대 경로")
    - background-repeat : repeat-x | repeat-y | repeat(defalut) | no-repeat
    - background-position : top, center, bottom, left, right, (30px, 60px)
    - background-size : 100px, 200px, 
        - cover : 이미지의 비율 유지, 부모의 width, height 중 큰값에 배경이미지를 맞추고 나머지는 자동으로 비율계산
        - contain : 이미지의 비율을 유지하고 이미지 다 보일 수 있게 스케일 조정
    - background-attachment : 스크롤시 배경이미지 고정여부
        - scroll - 스크롤시 같이 움직임
        - fixed - 스크롤시 고정

- position
    - static(default)   : 기본, 부모 Block 내부에서의 절대위치
    - absolute          : 절대위치
        - 부모의 position이 static이면, body 기분으로 절대위치
        - 부모의 position이 relative이면, 부모 기준으로 절대위치
    - fixed             : 절대위치, 보이는 화면 내부에서의 절대위치
    - relative          : 상대위치
    - z-index           : static에서는 사용불가, z-index를 이용하여 3차원 표현 가능(0~999)
    
# ref

- 배경화면 이미지 down : https://grafolio.naver.com/works/list.grfl