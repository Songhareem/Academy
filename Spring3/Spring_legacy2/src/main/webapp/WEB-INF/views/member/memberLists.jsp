<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-hover">
	<tr class="info">
		<td>아이디</td>
		<td>이름</td>
		<td>이메일</td>
		<td>핸드폰</td>
		<td><input type="checkbox" id="checkAll">
			<button id="delBtn" class="btn btn-danger">Delete</button></td>
	</tr>
	<c:forEach items="${list}" var="vo" varStatus="i">
		<tr class="info">
			<td id="id${i.index}">${vo.id}</td>
			<td>${vo.name}</td>
			<td>${vo.email}</td>
			<td>${vo.phone}</td>
			<td><input type="checkbox" name="del" id="${vo.id}"
				title="id${i.index}" class="term"></td>
		</tr>
	</c:forEach>
</table>

<ul class="pagination">
	<c:if test="${pager.curBlock gt 1}">
		<li><a
			href="./memberList?curPage=${pager.startNum - 1}&kind=${pager.kind}&search=${pager.search}">이전</a></li>
	</c:if>
	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		<li><a
			href="./memberList?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
	</c:forEach>
	<c:if test="${pager.curBlock lt pager.totalBlock}">
		<li><a
			href="./memberList?curPage=${pager.lastNum + 1}&kind=${pager.kind}&search=${pager.search}">다음</a></li>
	</c:if>
</ul>

