<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./template/boot.jsp"></c:import>
<link href="./css/test.css" rel="stylesheet" type="text/css">
</head>
<body>
	<c:import url="./template/nav.jsp"></c:import>
	<div class="container">
		<h1>index page</h1>
		<!-- <img src="./images/cover.png"> -->
		<%-- <h1><spring:message code="hello"></spring:message></h1>
		<h1><spring:message code="welcome" arguments="${sessionScope.member.id}/${sessionScope.member.pw}" argumentSeparator="/"></spring:message></h1>
		</h1><spring:message code="member.deny" text="Default message"></spring:message></h1>
		<spring:message code="test" text="test message" var="test"></spring:message>
		<h1>${test}</h1>
		<img src="./upload/notice/1f8b66ba-083e-4a50-9b17-dd5d97724441_back.jpg"> --%>
	</div>
	<script type="text/javascript" src="./js/test.js"></script>
</body>
</html>