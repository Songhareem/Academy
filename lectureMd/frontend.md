
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

# 웹 브라우저

- HTML, CSS, JS 코드 컴파일 및 실행

- 언어별 역할
    - HTML : 전체 페이지 디자인 구성
    - CSS : 디자인 역할
    - JS : 동적 요소 추가

- HTML
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

- 텍스트 관련

# HTML

# CSS

# javascript

# Jquery

# Ajax