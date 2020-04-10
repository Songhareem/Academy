<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Navbar -->
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">WebSiteName</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
			<li><a href="${pageContext.request.contextPath}/point/pointList">pointList</a></li>
			<li><a href="${pageContext.request.contextPath}/notice/noticeList">noticeList</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<c:if test="${empty sessionScope.member}">
				<li><a
					href="${pageContext.request.contextPath}/member/memberJoin"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a
					href="${pageContext.request.contextPath}/member/memberLogin"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</c:if>
			<c:if test="${not empty sessionScope.member}">
				<li><a
					href="${pageContext.request.contextPath}/member/memberPage"><span
						class="glyphicon glyphicon-user"></span> My Page</a></li>
				<li><a
					href="${pageContext.request.contextPath}/member/memberLogout"><span
						class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</c:if>
		</ul>
	</div>
</nav>
