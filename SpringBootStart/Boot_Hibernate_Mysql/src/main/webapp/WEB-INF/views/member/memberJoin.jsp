<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
<c:import url="../template/summernote.jsp"></c:import>
</head>
<body>
	<c:import url="../template/nav.jsp"></c:import>
	<div class="container">
		<form action="memberJoin" method="post">
		  <div class="form-group">
		    <label for="id">id</label>
		    <input name="id" type="text" class="form-control" id="id"/>
		  </div>
		  <div class="form-group">
		    <label for="pw">pw</label>
		    <input name="pw" type="password" class="form-control" id="pw"/>
		  </div>
		  <div class="form-group">
		    <label for="pwCheck">pwCheck</label>
		    <input name="pwCheck" type="password" class="form-control" id="pwCheck"/>
		  </div>
		  <div class="form-group">
		    <label for="name">name</label>
		    <input name="name" type="text" class="form-control" id="name"/>
		  </div>
		  <div class="form-group">
		    <label for="email">email</label>
		    <input name="email" type="email" class="form-control" id="email"/>
		  </div>
		   <div class="form-group">
		    <label for="phone">phone</label>
		    <input name="phone" type="text" class="form-control" id="phone"/>
		  </div>
		  <button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>
</html>