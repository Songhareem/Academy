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
		
		<!-- ${pageContext.request.contextPath} -->
		<form action="./memberLogin" method="post">
			<h2>memberLogin</h2>
			<div class="form-group">
				<label for="id">ID:</label> 
				<input type="text" class="form-control" id="id" name="id">
			</div>
			<div class="form-group">
				<label for="pw">PW : </label> 
				<input type="password" class="form-control" id="pw" name="pw">
			</div>
			
			<div class="checkbox">
      			<label><input type="checkbox" name="remember">Remember me</label>
   			</div>
			
			<button type="submit" class="btn btn-info">Login</button>
		</form>
	</div>
		
</body>
</html>