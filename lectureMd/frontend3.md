
- Jquery
    - js 단점 보완한 확장판
    - jQuery API 다운
        - 서버에 다운 받아서 제공
        - CDN 방식 (Google)
            - <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    - 문법
        - $("css 선택자").action명(인자);

    - Event
        - mouse
            - click
            - dblclick
            - mouseenter
            - mouseleave
        - keyboard
            - keyup
            - keydown
            - keypress
        - form
            - submit
            - change
            - focus
            - blur
        - 문서
            - addpend()
            - prepend()
            - after()
            - before()

    - get/set
        - innerText
            - $("선택자").text() / $("선택자").text("set할 값");
        - innerHTML
            - $("선택자").html() / $("선택자").html("set할 값");
        - input의 value
            - $("선택자").val() / $("선택자").val("set할 값");
        - 속성
            - $("선택자").attr("속성명") / $("선택자").attr("속성명","set할 값")
                - 변경되지 않는 속성(초기화 후 변경없는 속성)을 읽어옴
            - $("선택자").prop("속성명") / $("선택자").prop("속성명","set할 값")
                - 변경되는 속성값을 읽을때 사용
    - Add
        - 선택된 요소의 자식으로 요소를 추가
            - $("선택자").append("내용")  : 선택된 요소 내부의 마지막에 추가
            - $("선택자").prepend("내용") : 선택된 요소 내부의 첫줄에 추가

        - 선택된 요소의 외부에 요소를 추가
            - $("선택자").after("내용")  : 선택된 요소 외부의 뒤에 추가
            - $("선택자").before("내용")  : 선택된 요소 외부의 앞에 추가

    - Remove
        - 선택된 요소의 자식 요소 삭제
            - empty
        - 선택된 요소와 자식 요소 삭제
            - remove
            
    - Event 적용
        - $("css선택자").이벤트명(값 또는 function);         : 하나의 이벤트를 적용
        - $("css선택자").on( { 이벤트명: function() }, ...); : 여러 이벤트를 한번에 적용

    - Event 위임
        - 보모의 자식인 부분이 눌렸을때 이벤트를 자식으로 전달
        - on 메소드에서만 가능
        - $("부모선택자").on("이벤트명","해당자식선택자",function())
    
    - CSS 
        - $("선택자").css("속성명","속성값"{, ...});
    - $("선택자").addClass("클래스명{ 클래스명 ...}");          : 해당 요소 클래서 추가
        - $("선택자").removeClass("클래스명{ 클래스명 ...}");   : 해당 요소 클래스 삭제
        - $("선택자").toggleClass("클래스명{ 클래스명 ...}");   

    - Traversing Up
        - $("선택자").parent();                         : 선택자 직속 부모
        - $("선택자").parents();                        : 선택자의 모든 부모
        - $("선택자").parentUntil("멈추고 싶은 tag명");

    - Traversing Down
        - $("선택자").children();               : 선택자의 직속 자식득
        - $("선택자").children();               : 선택자의 족속들중  자식
        - $("선택자").find("찾는 자식명");       : 선택자 아버지 를 찾는ㅁ 찾는 자식명

    - Traber siblings
        - next
        - nextAll
        - nextUtil
        - prev
        - prevAll
        - preUtil

    - 
    
- Ajax