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
		<form action="./pointAdd" method="post">
			<h1>pointAdd</h1>
			<div class="form-group">
				<label for="num">번호:</label> 
				<input type="text" class="form-control" id="num" name="num">
			</div>
			<div class="form-group">
				<label for="name">이름 : </label> 
				<input type="text" class="form-control" id="name" name="name">
			</div>
			<div class="form-group">
				<label for="kor">국어:</label> 
				<input type="text" class="form-control" id="kor" name="kor">
			</div>
			<div class="form-group">
				<label for="eng">영어:</label> 
				<input type="text" class="form-control" id="eng" name="eng">
			</div>
			<div class="form-group">
				<label for="math">수학:</label> 
				<input type="text" class="form-control" id="math" name="math">
			</div>

			<button type="submit" class="btn btn-default">Submit</button>
		</form>

	</div>
	
</body>
</html>