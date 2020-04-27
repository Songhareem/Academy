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
		<form action="./memberJoin" method="post" enctype="multipart/form-data">
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
			
			<div class="form-group">
				<label for="thumb">Thumb:</label> 
				<input type="file" class="form-control" id="thumb" name="thumb">
			</div>
			
			<button type="submit" class="btn btn-info">Join</button>
		</form>
	</div>

	<script type="text/javascript">
		$(`#id`).blur(function() {
			var id = $(`#id`).val();
			if(id == "") {
				return;
			}
			
			// Ajax 방식
			$.ajax({
				type: "post",			// method 형식 "get" / "post"
				url: "./memberIdCheck",	// URL 주소
				data: {					// param
					id : id
				},
				success: function(data, status) {
					alert(data);
				},
				error: function() {
					alert("err");
				}
			});
			
			
			// post 방식
			/* 	$.post("./memberIdCheck", {id : id}, function(result) {
				result = result.trim();
				if(result == 1) {
					alert("중복ID");
					$(`#id`).val("");
					$(`#id`).focus();
				} else {
					alert("사용가능한 ID");
					$(`#id`).attr("readOnly", "readOnly");
					$(`#pw`).focus();
				}
			}); */
		});
	</script>
</body>
</html>