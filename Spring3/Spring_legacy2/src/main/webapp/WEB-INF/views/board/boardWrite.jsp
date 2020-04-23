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
	
	
	<div class="container">
		
		<!-- ${pageContext.request.contextPath} -->
		<form action="./${board}Write" method="post" enctype="multipart/form-data">
			<h1>${board}Write</h1>
			<div class="form-group">
				<label for="title">제목 : </label> 
				<input type="text" class="form-control" id="title" name="title">
			</div>
			<div class="form-group">
				<label for="content">글내용:</label> 
				<textarea rows="20" cols="" class="form-control" id="contents" name="contents"></textarea>
			</div>
			<div class="form-group">
				<label for="file">Files:</label>
				<input type="file" class="form-control" id="file" name="files"> 
				<input type="file" class="form-control" id="file" name="files">
			</div>

			<button type="submit" class="btn btn-info">Submit</button>
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
	});
	
	</script>
</body>
</html>