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
		<form action="./memberJoin" method="post">
			<h2>memberJoin</h2>
			<div class="form-group">
				<label for="id">ID:</label> 
				<input type="text" class="form-control" id="id" name="id">
			</div>
			<div class="form-group">
				<label for="pw">PW : </label> 
				<input type="password" class="form-control" id="pw" name="pw">
			</div>
			<div class="form-group">
				<label for="name">Name:</label> 
				<input type="text" class="form-control" id="name" name="name">
			</div>
			<div class="form-group">
				<label for="age">Age:</label> 
				<input type="text" class="form-control" id="age" name="age">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> 
				<input type="email" class="form-control" id="email" name="email">
			</div>
			<div class="form-group">
				<label for="phone">Phone:</label> 
				<input type="text" class="form-control" id="phone" name="phone">
			</div>
			
			<button type="submit" class="btn btn-info">Join</button>
		</form>
	</div>
	
</body>
</html>