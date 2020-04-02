
# js를 이용한 동적 페이지 생성

- javascript
    - HTML 문서내에 동적요소 할당
    - HTML 엘리먼트 생성, 수정, 삭제
    - HTML css 생성, 수정, 삭제
    - interpreter 언어
    - HTML 문서내에 <script></script>내에 작성
        1) 외부 파일
        2) 내부 작성
    
    - BOM(Browser Object Model)
        - Window
            - Document      : MHTL 문서 담당
            - History       : 뒤로가기 등 담당
            - navigator     : 웹 브라우저에 대한 정보
            - Screen        : 전체화면의 위치(x,y축)등, 화면
            - Location      : url 주소 창 담당

        - 속성
            - window.속성명
            - window.메서드명
        
        - window의 생략 가능
            - Print
            - console.log("출력할 내용");
            - alert("출력할 내용");

    - DOM(Document Object Model)
        - window.Document.~ 트리 구조를 한통으로 DOM이라 함
        <img src="../image/domtree.gif">
        - Document Node (문서 노드)
            - 트리의 최상위에 존재, DOM Tree에 접근하기 위한 시작점
        - Element Node ( != tag )
            - Html의 요소 (tag 안의 모든 것을 포함)
        - Attribute Node
            - tag의 속성
        - Text Node
            - HTML내의 텍스트

    - get
        - 선택(Selector) 
            - 하나의 Element 선택 (Id)
                - window 생략 가능
                - document.getElementById("id명");
            - 다중 Element 선택 (class, tag)
                - document.getElementsByClassName("클래스명");
                    - 배열을 return
                - document.getElementsByTagName("태그명");
                    - 배열 return
            - form 관련 Element 선택 (name 사용)
                - ```
                    <form action="" name="form">
                        <input type="text" name="yId">
                    </form>
                    
                    <script type="text/javascript">
                        document.form.yId.value = "sample";             
                    </script>
                  ```
            - CSS Selector
                - css Selector : css 문법을 사용
                - querySelector("css selector");
                - document.querySelector();
                - document.querySelectorAll();

        - innerText
            - 변수
            - 선택한 Element내의 모든 Text node들의 내용을 담는 변수
        - innerHTML
            - 변수
            - 선택한 Element내의 모든 Element들의 내용을 담는 변수
            - get : var getter = 변수명.innerHTML;
            - set : 변수명.innerHTML = "변경될 값"
        - Attribute
            - var 변수명 = getElementById("아이디명);
            - get
                - var getter = 변수명.속성명;
                - 변수명.getAttribute("속성명");
            - set
                - 변수명.속성명 = "변경할 값";
                - 변수명.setAttribute("속성명", "변경할 값");
    
    - javascript    
        - 변수 
            - number
            - string (문자 타입은 존재하지 않음)
            - boolean
            - 
        - 변수 선언
            - var varName = ...;
        - 연산자
            - 산술연산자 (+,-,*,/,%)
            - 비교연산자 (>,<,>=,<=,==,!=,===,!==,&&,||)
            - 논리연산자 (&,|,!)
            - 증감연산자 (++, --)
            - 삼항연산자
            - typeof연산자 (typeof(변수명))
        - 제어문
            - if
            - if ~ else
            - if ~ else if ~ else
            - switch ~ case
        - 반복문
            - for
            - while
                - break;
                - continue;
        - 번외
            - confirm("text") : true / false 선택창
            - prompt : 입력창
        - 배열(Array)
            - ```
              // 선언
              var ar = [];
		      var ar2 = new Array();
              
              // pop : 마지막 원소 삭제, 삭제한 원소 return
              ar.pop();
              
              // push : 마지막에 원소 추가, 늘어난 길이 return
              ar.push(data);

              // shift : 첫번째 원소 삭제, 삭제한 원소 return
              ar.shift();

              // unshift() : 첫번째에 원소 추가, 늘어난 길이 return
              ar.unshift(data);
              
              // reverse() : 배열 값 뒤집기
              ar.reverse();

              // sort() : 배열 정령하기
              ar.sort();

              var points = [40, 100, 1, 5, 25, 10];
              points.sort(function(a, b){return a-b}); ASC
              
              var points = [40, 100, 1, 5, 25, 10];
              points.sort(function(a, b){return b-a}); DESC

              //concat() : str 이어붙이기
              ```
        - 값 변형
            - string type으로 변환
                - toString()
                - + ""
            - number type으로 변환
                - parseInt()
                - * 1

        - function
            - 명명함수 : 이름있는 함수
                - ```
                  function 함수명 (매개변수선언) {

                  }

                  함수명(매개변수);
                   ```
            - 익명함수 : 이름이 없는 함수
                - ```
                  function(매개변수선언) {

                  }
                  ```
        - Event
            - 종류
                - mouse Event
                    - click     : 마우스 클릭
                    - dbclick   : 마우스 더블클릭
                    - mousedown : 마우스 버튼을 누르고 있을 때
                    - mouseup   : 마우스 버튼을 누르다가 떼었을 때
                    - mousemove : 마우스를 움직일 때
                    - mouseover : 어떤 요소 위로 마우스가 위치할 때
                    - mouseout  : 어떤 요소 밖으로 나갔을 때
                
                - keyboard Event
                    - keydown   : 키를 누르고 있을때,
                    - keyup     : 누르고 있던 키를 해제할 때
                    - keypress  : 어떤 요소 밖으로 나갔을 때
                
                - Form Event
                    - focus/focusin     : 요소가 포커스를 얻었을 때
                    - blur/ focusout    : 요소가 포커스를 잃었을 때
                    - change            : value값 변경시
                    - submit            : form태그를 action의 주소로 전송

            - 이벤트 등록 방식
                - inline 방식
                    - 해당 태그에 on이벤트명 = "함수명()"
                    - 여러개의 함수 사용 가능
                - property 방식
                    - 스크립트 내에서 익명함수를 이용해 함수 사용
                    - ~.on이벤트명 = function() { ~ }
                    - 같은 이벤트로 여러개 함수 호출 불가능
                - addEventListener
                    - var id = document.getElementById("아이디명");
                    - id.addEventListener("이벤트명", 함수명);
        
        - Event 강제 실행
            - 다른 요소의 설정된 이벤트를 강제로 실행하고 싶을때
            - 선택자.이벤트명();

()        - Event 전파
            - 영역이 중첩된 요소들(div 등)은 부모와 자식 관계
                - 부모와 자식간에 같은 Event가 등록 되어있다면, 자식 Event발생시 부모쪽도 해당 Event 발생 (이벤트 전파)
            - Event.preventDefault()
                - a 태그나 submit 클릭이 페이지 이동으로 이어질 시, 클릭으로 발생하는 해당 태크의 속성 동작을 중단 (href 등)
            - Event.stopPropagation()
                - 자식의 Event가 부모 요소로 전파되는 것을 중단시키기 위해 사용
        
        - Event 위임
            - ref: https://joshua1988.github.io/web-development/javascript/event-propagation-delegation/

        - 내장객체
            - window
                - open()    : 새창만들기
                - opener    : 새창을 만들 부모의 handle
                - close()   : 윈도우 닫기 clase

                - setTimeout(function, millsec)        : 일정한 시간뒤에 한번만 실행
                - clearTimeout(setTimeout 실행 함수명)  : 실행전에 timeout 종료
                - setInterval(function, millsec)       : 일정한 간격으로 function 실행
                - clearInterver(setInterval 실행 함수명): interval 종료
            - document
                - w3c 참조
            - location
                - href  : url 주소를 입력하면 a 태그처럼 실행 
            - history
                - length    : 이동 가능한 페이지의 총 갯수
                - back()    : 페이지 앞으로가기
                - foword()  : 페이지 뒤로가기
                - go(n)     : n만큼 페이지 이동(- : back / + : foword); 
            - screen
                - w3c 참조
            - navigator
                - w3c 참조
