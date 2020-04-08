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
			<h1>pointSelect</h1>
			<table class="table table-hover">
				<tr class="danger">
					<td>번호</td>
					<td>이름</td>
					<td>국어</td>
					<td>영어</td>
					<td>수학</td>
					<td>총점</td>
					<td>평균</td>
				</tr>
				<tr class="info">
					<td>${pdto.num}</td>
					<td>${pdto.name}</td>
					<td>${pdto.kor}</td>
					<td>${pdto.eng}</td>
					<td>${pdto.math}</td>
					<td>${pdto.total}</td>
					<td>${pdto.avg}</td>
				</tr>
				
			</table>
			<a href="./pointDel?num=${pdto.num}" class="btn btn-info" >Delete</a>
			
		</div>
	</div>
</body>
</html>