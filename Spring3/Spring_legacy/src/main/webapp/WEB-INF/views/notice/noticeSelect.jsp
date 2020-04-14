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
	
	<div class="container">
		<div class="row">
			<h1>noticeSelect</h1>
			<table class="table table-hover">
				<tr class="danger">
					<td>글번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일자</td>
					<td>조회수</td>
				</tr>
				<tr class="info">
					<td>${ndto.id}</td>
					<td>${ndto.subtitle}</td>
					<td>${ndto.name}</td>
					<td>${ndto.date}</td>
					<td>${ndto.views}</td>
				</tr>
			</table>
	
			<div class="well">${ndto.content}</div>
			
			<c:if test="${member.id ne null}">
				<c:if test="${member.id eq 'admin'}">
					<a href="./noticeMod?id=${ndto.id}" class="btn btn-primary" >Update</a>
					<a href="./noticeDel?id=${ndto.id}" class="btn btn-danger" >Delete</a>
				</c:if>
			</c:if>
			
		</div>
	</div>
	
	
</body>
</html>