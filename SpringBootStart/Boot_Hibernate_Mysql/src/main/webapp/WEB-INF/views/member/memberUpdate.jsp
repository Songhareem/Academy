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
		<form action="memberUpdate" method="post">
		  <div class="form-group">
		    <label for="id">id</label>
		    <input name="id" type="text" class="form-control" id="id" value="${sessionScope.member.id}" readonly/>
		  </div>
		  <div class="form-group">
		    <label for="pw">pw</label>
		    <input name="pw" type="password" class="form-control" id="pw" value="${sessionScope.member.pw}" readonly/>
		  </div>
		  <input name="pwCheck" type="hidden" class="form-control" id="pwCheck" value="${sessionScope.member.pwCheck}" />
		  <div class="form-group">
		    <label for="name">name</label>
		    <input name="name" type="text" class="form-control" id="name" value="${sessionScope.member.name}" readonly/>
		  </div>
		  <div class="form-group">
		    <label for="email">email</label>
		    <input name="email" type="email" class="form-control" id="email" value="${sessionScope.member.email}" readonly/>
		  </div>
		   <div class="form-group">
		    <label for="phone">phone</label>
		    <input name="phone" type="text" class="form-control" id="phone" value="${sessionScope.member.phone}" readonly/>
		  </div>
		  <input id="updateBtn" type="button" class="btn btn-default" value="update">
		  <button style="display: none;" id="updateSubmit" type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
	<script type="text/javascript">
		$(function() {

			$("#updateBtn").click(function(){

				$("#pw").attr("readonly",false);
				$("#name").attr("readonly",false);
				$("#email").attr("readonly",false);
				$("#phone").attr("readonly",false);
				$("#updateSubmit").attr("style","display: inline");
				
			});
		});
	</script>
</body>
</html>