
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