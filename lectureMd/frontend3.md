
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
            - $("선택자").prop("속성명") / $("선택자").prop("속성명","set할 값")

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

- Ajax