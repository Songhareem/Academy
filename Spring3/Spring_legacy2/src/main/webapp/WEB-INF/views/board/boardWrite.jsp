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
		<form id="form" action="./${board}Write" method="post" enctype="multipart/form-data">
			<h1>${board}Write</h1>
			<div class="form-group">
				<label for="title">제목 : </label> 
				<input type="text" class="form-control" id="title" name="title">
			</div>
			<div class="form-group">
				<label for="content">글내용:</label> 
				<textarea rows="20" cols="" class="form-control" id="contents" name="contents"></textarea>
			</div>
			
			<input type="button" id="add" class="btn btn-default" value="Add File"/>
			<div id="fileDiv" class="form-group">
			</div>
				
				<!-- summerNote 입력해도 null 넘어가는 버그있는경우 -->
				<!-- <input type="hidden" id="buffer" name="contents"> -->
			
			<div>
				<input type="button" id="btn" class="btn btn-info" value = "Submit">
			</div>
		</form>

	</div>

	<script type="text/javascript" src="../resources/js/boardForm.js"></script>
</body>
</html>