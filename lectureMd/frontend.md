
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

# HTML

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
    - ```
      
      ```
    - 속성
        - action    : URL 데이터 전송될 URL
        - method    : 데이터 전달 방식(GET/POST)
        - enctype   : 전송될 데이터 파일존재
        - 

# CSS

# javascript

# Jquery

# Ajax