<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	
	<div class="container">
		
		<!-- ${pageContext.request.contextPath} -->
		<form action="./${board}Reply" method="post">
			<h1>${board}Reply</h1>
			<div class="form-group">
				<label for="subtitle">제목 : </label> 
				<input type="text" class="form-control" id="title" name="title">
			</div>
			<div class="form-group">
				<label for="content">작성자:</label> 
				<input type="text" class="form-control" id="writer" name="writer">
			</div>
			<div class="form-group">
				<label for="content">글내용:</label> 
				<input type="text" class="form-control" id="contents" name="contents">
			</div>
			<div>
				<input type="hidden" class="form-control" id="num" name="num" value="${num}">
			</div>

			<button type="submit" class="btn btn-info">Submit</button>
		</form>
		
	</div>
</body>
</html>