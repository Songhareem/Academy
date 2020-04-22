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
			<h1>memberPage</h1>
			<table class="table table-hover">
				<tr>
					<td>ID</td>
					<td>이름</td>
					<td>나이</td>
					<td>이메일</td>
					<td>전화번호</td>
					<td>프로필<td>
				</tr>
				<tr>
					<td>${member.id}</td>
					<td>${member.name}</td>
					<td>${member.age}</td>
					<td>${member.email}</td>
					<td>${member.phone}</td>
					<td><img src="../resources/images/memberUpload/${file.fileName}"/></td>
					<td><a href="./memberFileDelete">fileDelete</a></td>
				</tr>
				
			</table>
			
			<!--
			<a href="./memberUpdate" class="btn btn-primary" >Update</a>
			<a href="./memberDelete" class="btn btn-danger" >Delete</a>
			 -->
			 
			 <button id="update" class="btn btn-primary">Update</button>
			 <button id="delete" class="btn btn-danger">Delete</button>
		</div>
	</div>
	
	<script type="text/javascript">
		// js 복습
		var del = document.getElementById("delete");
		del.addEventListener("click", function() {
			var result = confirm("정말 삭제 하시겠습니까?");
			if(result)
				location.href="./memberDelete";
		});
		
		// jQurey 복습
		$("#update").click(function() {
			location.href="./memberUpdate";
		});
	</script>
	
</body>
</html>