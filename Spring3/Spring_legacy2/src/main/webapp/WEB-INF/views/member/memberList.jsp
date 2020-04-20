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
			<form>
				<div class="input-group col-xs-4" action="./memberList">
					<select class="form-control input-" id="sel1" name="kind">
						<option value="id">id</option>
						<option value="name">name</option>
						<option value="email">email</option>
						<option value="phone">phone</option>
					</select> 
					<input type="text" class="form-control" placeholder="Search" name="search">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>
			<table class="table table-hover">
				<tr class="info">
					<td>아이디</td>
					<td>비번</td>
					<td>이름</td>
					<td>나이</td>
					<td>이메일</td>
					<td>핸드폰</td>
				</tr>
				<c:forEach items="${list}" var="vo">
				<tr class="info">
					<td>${vo.id}</td>
					<td>${vo.pw}</td>
					<td>${vo.name}</td>
					<td>${vo.age}</td>
					<td>${vo.email}</td>
					<td>${vo.phone}</td>
				</tr>
				</c:forEach>
			</table>
			
			<%-- <h1>startNum : ${pager.startNum}</h1>
			<h1>lastNum : ${pager.lastNum}</h1> --%>
			
			<ul class="pagination">
				<c:if test="${pager.curBlock gt 1}">
					<li><a href="./memberList?curPage=${pager.startNum - 1}&kind=${pager.kind}&search=${pager.search}">이전</a></li>
				</c:if>
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li><a href="./memberList?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
				</c:forEach>
				<c:if test="${pager.curBlock lt pager.totalBlock}">
					<li><a href="./memberList?curPage=${pager.lastNum + 1}&kind=${pager.kind}&search=${pager.search}">다음</a></li>
				</c:if>
			</ul>

		</div>
	</div>

</body>
</html>