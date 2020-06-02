<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
	<c:import url="../template/nav.jsp"></c:import>
	<div class="container">
		<h2>${board}List</h2>
		<table class="table talbe-hover">
			<!-- 모바일 웹같은 곳에서는 ul / li 를 테이블 대신 씀 -->
			<tr>
				<td>${vo.num}</td>
				<td>${vo.title}</td>
				<td>${vo.writer}</td>
				<td>${vo.contents}</td>
				<td>${vo.regDate}</td>
				<td>${vo.hit}</td>
			</tr>
		</table>
		<a class="btn btn-info" href="${board}Update?num=${vo.num}">Update</a>
		<a class="btn btn-danger" href="${board}Delete?num=${vo.num}">delete</a>
	</div>
</body>
</html>