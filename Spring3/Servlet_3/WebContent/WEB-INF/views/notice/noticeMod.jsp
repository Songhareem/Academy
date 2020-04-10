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
		<div class="jumbotron">
			<h1>Bootstrap Tutorial</h1>
			<p>Bootstrap is the most popular HTML, CSS, and JS framework for
				developing responsive, mobile-first projects on the web.</p>
		</div>
		<p>This is some text.</p>
		<p>This is another text.</p>

		<!-- ${pageContext.request.contextPath} -->
		<form action="./noticeMod" method="post">
			<h1>noticeMod</h1>
			
			<input type="hidden" class="form-control" id="id" name="id" value="${ndto.id}">
			<input type="hidden" class="form-control" id="id" name="name" value="${ndto.name}">
			<input type="hidden" class="form-control" id="id" name="views" value="${ndto.views}">
			
			<div class="form-group">
				<label for="subtitle">제목 : </label> 
				<input type="text" class="form-control" id="name" name="subtitle" value="${ndto.subtitle}">
			</div>
			<div class="form-group">
				<label for="content">글내용:</label> 
				<input type="text" class="form-control" id="kor" name="content" value="${ndto.content}">
			</div>

			<button type="submit" class="btn btn-info">Submit</button>
		</form>
	</div>
</body>
</html>