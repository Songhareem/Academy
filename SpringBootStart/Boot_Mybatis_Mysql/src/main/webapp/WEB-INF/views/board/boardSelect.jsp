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
				<td>${boardVO.num}</td>
				<td>${boardVO.title}</td>
				<td>${boardVO.writer}</td>
				<td>${boardVO.contents}</td>
				<td>${boardVO.regDate}</td>
				<td>${boardVO.hit}</td>
			</tr>
		</table>
		<a class="btn btn-info" href="${board}Update?num=${boardVO.num}">Update</a>
		<a class="btn btn-danger" href="${board}Delete?num=${boardVO.num}">delete</a>
		<c:if test="${board ne 'notice'}">
			<a class="btn btn-success" href="${board}Reply?num=${boardVO.num}">Reply</a>
		</c:if>
	</div>
</body>
</html>