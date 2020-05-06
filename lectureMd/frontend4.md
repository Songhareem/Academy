
- Ajax (Aysnchronous Javascript And Xml)
    - 요청 필요 3요소
        - 메소드
        - url
        - param
    - jQuery Ajax
        - ref : https://www.w3schools.com/jquery/jquery_ajax_get_post.asp
        - $.get(url, cb)
            - ```
                $.get("getList?curPage="+curPage, function(data, status) {
                    $("#data").append(data);
                });
            ```	
        - $.post(url, paramm, cb)
            - ```
                $.post("./memoInsert", {writer:writer, contents:contents}, function(data, status) {
                    data = data.trim();
                    if(data > 0) {
                        location.reload();
                    } else {
                        alert("status");
                    }
                });
            ```
        - $.ajax(type, url, data)
            - ```
                $.ajax({
                    traditional: true,      // 배열 data 전송시 사용
                    type:"get", 
                    url:"./memberDeletes",
                    data: {
                        ids : ids
                    },
                    success:(function(data) {
                        alert("ok")
                    })
                });

                $.ajax({
                    url         :   "/checkTest/save",
                    dataType    :   "json",
                    contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
                    type        :   "post",
                    data        :   objParams,
                    success     :   function(retVal){
 
                        if(retVal.code == "OK") {
                            alert(retVal.message);
                        } else {
                            alert(retVal.message);
                        }
                         
                    },
                    error       :   function(request, status, error){
                        console.log("AJAX_ERROR");
                    }
                });
              ```

# JSON (Java Script Object Notation)

- server to server에서 많이 사용

- API
    - jackson Databind
        - ```
            <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
            <dependency>
                <groupId>com.fasterxml.jackson.core</groupId>
                <artifactId>jackson-databind</artifactId>
                <version>2.10.1</version>
            </dependency>
        ```
        - key : vo의 멤버변수명
        - value : vo의 멤버변수에 해당하는 값
        - Controller내에 @ResponseBody 태그 사용
        - 해당 Contorller의 요청 메서드 return 값은 VO
        - @RestController : controller내부의 메서드 return이 모두 JSON방식일때, @Controller대신 사용

- { "key" : "value", ... } 형태

- VO -> JSON
    - { "vo변수명":"값", ... }

- VOs(List) -> JSON
    - [{ "vo변수명","값" ... }, ...]

- string -> Json (in JS)
    - JSON.parse("문자열")

- Json -> string (in JS)
    - JSON.stringify("json객체")

- 사용법
    - 변수명.key
    - 변수명[key]
    
    - 변수명[indexNum] (List일시)

    - 태그를 만들어서 데이터를 넣어줘야할때는 사용 X,
    - 단순한 값을 받아올때에 많이 사용

# api 모음 사이트
    - https://api.manana.kr/
    - 공공데이터 포털 : https://www.data.go.kr/