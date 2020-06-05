<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<form:form modelAttribute="memberVO" action="memberJoin" method="post">
		  <div class="form-group">
		    <label for="id">id</label>
		    <form:input path="id" type="text" class="form-control" id="id"/>
		  	<form:errors path="id"/>
		  </div>
		  <div class="form-group">
		    <label for="pw">pw</label>
		    <form:input path="pw" type="text" class="form-control" id="pw"/>
		    <form:errors path="pw"/>
		  </div>
		  <div class="form-group">
		    <label for="pwCheck">pwCheck</label>
		    <form:input path="pwCheck" type="text" class="form-control" id="pwCheck"/>
		    <form:errors path="pwCheck"/>
		  </div>
		  <div class="form-group">
		    <label for="age">age</label>
		    <form:input path="age" type="text" class="form-control" id="age"/>
		    <form:errors path="age"/>
		  </div>
		  <div class="form-group">
		    <label for="email">email</label>
		    <form:input path="email" type="email" class="form-control" id="email"/>
		    <form:errors path="email"/>
		  </div>
		  
		  <button type="submit" class="btn btn-default">Submit</button>
		</form:form>
	</div>
</body>
</html>