<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
<c:import url="../template/summernote.jsp"></c:import>
<!-- include summernote css/js -->
</head>
<body>
	<c:import url="../template/nav.jsp"></c:import>
	<div class="container">
		<h2>${board}${path}</h2>
		<c:import url="../template/boardForm.jsp"></c:import>
	</div>
	<script type="text/javascript">
		$('#contents').summernote({
			  height: 300,                 // set editor height
			  minHeight: null,             // set minimum height of editor
			  maxHeight: null,             // set maximum height of editor
			  focus: true                  // set focus to editable area after initializing summernote
		});

		// 글쓰기시, id값 null안가게 초기화
		var board='${path}';
		if(board == 'Write') {

			$('#num').val(0);
		}

		// file input
		$("#add").click(function() {

			console.log("click");
			$("#f").append('<input type="file" name="files">');
		});
	</script>
</body>
</html>