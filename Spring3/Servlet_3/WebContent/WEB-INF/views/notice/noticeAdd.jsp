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
		<form action="./noticeAdd" method="post">
			<h1>noticeAdd</h1>
			<div class="form-group">
				<label for="subtitle">제목 : </label> 
				<input type="text" class="form-control" id="name" name="subtitle">
			</div>
			<div class="form-group">
				<label for="content">글내용:</label> 
				<input type="text" class="form-control" id="kor" name="content">
			</div>

			<button type="submit" class="btn btn-info">Submit</button>
		</form>
	</div>
</body>
</html>