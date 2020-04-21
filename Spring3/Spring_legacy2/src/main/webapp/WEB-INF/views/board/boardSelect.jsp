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
			<h1>${board}Select</h1>
			<table class="table table-hover">
				<tr class="danger">
					<td>글번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일자</td>
					<td>조회수</td>
				</tr>
				<tr class="info">
					<td>${vo.num}</td>
					<td>${vo.title}</td>
					<td>${vo.writer}</td>
					<td>${vo.regDate}</td>
					<td>${vo.hit}</td>
				</tr>
			</table>
	
			<div class="well">${vo.contents}</div>
			
			<div>
				<a href="./${board}Update?
					num=${vo.num}&title=${vo.title}&
					writer=${vo.writer}&regDate=${vo.regDate}&
					hit=${vo.hit}&contents=${vo.contents}" 
					class="btn btn-primary" > Update </a>
				<a href="./${board}Delete?num=${vo.num}" class="btn btn-danger" >Delete</a>
				<c:if test="${board ne 'notice'}">
					<a href="./${board}Reply?num=${vo.num}" class="btn btn-info" >Reply</a>
				</c:if>
			</div>
			
		</div>
	</div>	
</body>
</html>