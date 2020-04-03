<%@page import="com.song.test.Test"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		
		int result = new Test().getRandom(100); 
		
		
	%>
	<h1 id="d1"><%=result%></h1>
</body>
</html>