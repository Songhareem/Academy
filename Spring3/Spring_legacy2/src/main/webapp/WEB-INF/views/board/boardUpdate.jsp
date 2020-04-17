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
				<input type="text" class="form-control" id="contents" name="contents" value="${vo.contents}">
			</div>

			<button type="submit" class="btn btn-info">Submit</button>
		</form>
	</div>
</body>
</html>