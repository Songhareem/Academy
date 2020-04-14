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
		
	</div>
	
	<div class="container">
		<div class="row">
			<h1>pointList</h1>
			<table class="table table-hover">
				<tr>
					<td>번호</td>
					<td>이름</td>
					<td>평균</td>
				</tr>
				<c:forEach items="${requestScope.list}" var="pdto">
					<tr>
						<td>${pdto.num}</td>
						<td><a href="./pointSelect?num=${pdto.num}">${pdto.name}</a></td>
						<td>${pdto.avg}</td>
					</tr>
				</c:forEach>
			</table>
		
			<a href="./pointAdd" class="btn btn-primary">Point Add</a>
		</div>
	</div>
	
</body>
</html>