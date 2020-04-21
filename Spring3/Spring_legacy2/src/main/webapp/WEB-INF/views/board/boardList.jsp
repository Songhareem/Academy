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
			<h1>${board}List</h1>
			<form>
				<div class="input-group col-xs-4" action="./${board}List">
					<select class="form-control input-" id="sel1" name="kind">
						<option value="bt">title</option>
						<option value="bc">contents</option>
						<option value="bw">writer</option>
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
				<tr class="danger">
					<td>글번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일자</td>
					<td>조회수</td>
				</tr>
				<c:forEach items="${list}" var="vo">
				<tr class="info">
					<td>${vo.num}</td>
					<td>
						<c:catch>
							<c:forEach begin="1" end="${vo.dept}" var="i">
								--	
							</c:forEach>
						</c:catch>
						<a href="./${board}Select?num=${vo.num}">${vo.title}</a>
					</td>
					<td>${vo.writer}</td>
					<td>${vo.regDate}</td>
					<td>${vo.hit}</td>
				</tr>
				</c:forEach>
			</table>
			
			<div>
				<ul class="pagination">
				<c:if test="${pager.curBlock gt 1}">
					<li><a href="./${board}List?curPage=${pager.startNum - 1}&kind=${pager.kind}&search=${pager.search}">이전</a></li>
				</c:if>
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li><a href="./${board}List?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
				</c:forEach>
				<c:if test="${pager.curBlock lt pager.totalBlock}">
					<li><a href="./${board}List?curPage=${pager.lastNum + 1}&kind=${pager.kind}&search=${pager.search}">다음</a></li>
				</c:if>
				</ul>
			</div>
			
			<c:catch>
				<c:if test="${(member ne null && board eq 'qna') || (member.id eq 'admin' && board eq 'notice')}">
					<div>
						<a href="./${board}Write" class="btn btn-primary" >WRITE</a>
					</div>
				</c:if>
			</c:catch>
		</div>
	</div>
	
</body>
</html>