<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="row">
			<h1>memberPage</h1>
			<table class="table table-hover">
				<tr>
					<td>ID</td>
					<td>이름</td>
					<td>나이</td>
					<td>이메일</td>
					<td>전화번호</td>
				</tr>
				<tr>
					<td>${sessionScope.member.id}</td>
					<td>${sessionScope.member.name}</td>
					<td>${sessionScope.member.age}</td>
					<td>${sessionScope.member.email}</td>
					<td>${sessionScope.member.phone}</td>
				</tr>
				
			</table>
			<a href="./memberUpdate" class="btn btn-primary" >Update</a>
			<a href="./memberDelete" class="btn btn-danger" >Delete</a>
		</div>
	</div>
	
</body>
</html>