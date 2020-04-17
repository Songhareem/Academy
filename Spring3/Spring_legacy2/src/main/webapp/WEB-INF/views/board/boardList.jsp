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
			<h1>${board}List</h1>
			<table class="table table-hover">
				<tr class="danger">
					<td>글번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일자</td>
					<td>조회수</td>
				</tr>
				<c:forEach items="${list}" var="vo">
				<tr class="info">
					<td>${vo.num}</td>
					<td><a href="./noticeSelect?num=${vo.num}">${vo.title}</a></td>
					<td>${vo.writer}</td>
					<td>${vo.regDate}</td>
					<td>${vo.hit}</td>
				</tr>
				</c:forEach>
			</table>
			
			<div>
				<a href="./${board}Write" class="btn btn-primary" >WRITE</a>
			</div>
		</div>
	</div>
	
</body>
</html>