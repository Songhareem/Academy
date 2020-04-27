<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="../template/boot.jsp"></c:import>
	<c:import url="../template/summerNote.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<!-- Jumbotron -->
	<div class="container">

		<!-- ${pageContext.request.contextPath} -->
		<form action="./${board}Update" method="post">
			<h1>${board}Update</h1>
			
			<input type="hidden" class="form-control" id="num" name="num" value="${vo.num}">
			<input type="hidden" class="form-control" id="writer" name="writer" value="${vo.writer}">
			<input type="hidden" class="form-control" id="hit" name="hit" value="${vo.hit}">
			
			<div class="form-group">
				<label for="subtitle">제목 : </label> 
				<input type="text" class="form-control" id="title" name="title" value="${vo.title}">
			</div>
			<div class="form-group">
				<label for="content">글내용:</label> 
				<textarea rows="20" cols="" class="form-control" id="contents" name="contents">
					${vo.contents}
				</textarea>
			</div>
			<div class="form-group">
				<label for="file">Files:</label>
				<c:forEach items="${vo.boardFileVOs}" var="fileVO">
					<p>${fileVO.originName} <i id="${fileVO.fileNum}" class="glyphicon glyphicon-remove-sign fileDelete"></i></p>
				</c:forEach> 
				<!-- <input type="file" class="form-control" id="file" name="files">
				<input type="file" class="form-control" id="file" name="files"> -->
			</div>

			<input type="submit" class="btn btn-info" value="Submit"/>
		</form>
	</div>
	<script type="text/javascript">
	$(document).ready(function() {
		$('#contents').summernote({
			  height: 400,                 // set editor height
			  minHeight: 100,             // set minimum height of editor
			  maxHeight: 400,             // set maximum height of editor
			  focus: true                  // set focus to editable area after initializing summernote
			});
		//$('#contents').summernote(${vo.contents});
	});
	
	$(".fileDelete").click(function(){
		var target = $(this);
		var fileNum = $(this).attr("id");
		console.log(fileNum);
		$.post("../boardFile/fileDelete", {fileNum: fileNum},function(data){
			data = data.trim(); 
			alert(data);
			if(data > 0) {
				target.parent().remove();
			} else {
				alert("file delete fail");
			}
		});
	});
	
	</script>
</body>
</html>