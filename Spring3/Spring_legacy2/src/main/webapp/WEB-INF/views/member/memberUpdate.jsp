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
		<form action="./memberUpdate" method="post">
			<h2>memberUpdate</h2>
			<div class="form-group">
				<label for="id">ID:</label> 
				<input type="text" class="form-control" id="id" name="id" value="${sessionScope.member.id}" readonly>
			</div>
			<div class="form-group">
				<label for="pw">PW : </label> 
				<input type="password" class="form-control" id="pw" value="${sessionScope.member.pw}" name="pw">
			</div>
			<div class="form-group">
				<label for="name">Name:</label> 
				<input type="text" class="form-control" id="name" value="${sessionScope.member.name}" name="name">
			</div>
			<div class="form-group">
				<label for="age">Age:</label> 
				<input type="text" class="form-control" id="age" value="${sessionScope.member.age}" name="age">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> 
				<input type="email" class="form-control" id="email" value="${sessionScope.member.email}" name="email">
			</div>
			<div class="form-group">
				<label for="phone">Phone:</label> 
				<input type="text" class="form-control" id="phone" value="${sessionScope.member.phone}" name="phone">
			</div>
			<div class="form-group">
				<label for="file">File:</label> 
				<input type="file" enctype class="form-control" id="thumb" value="" name="thumb">
			</div>
			
			<button type="submit" class="btn btn-info">Update</button>
		</form>
	</div>
	
</body>
</html>