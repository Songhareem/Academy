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
			
			<div id="result">
				<table class="table table-hover">
					<tr class="info">
						<td>아이디</td>
						<td>이름</td>
						<td>이메일</td>
						<td>핸드폰</td>
						<td><input type="checkbox" id="checkAll">
							<button id="delBtn" class="btn btn-danger">Delete</button>
						</td>
					</tr>
					<c:forEach items="${list}" var="vo" varStatus="i">
					<tr class="info">
						<td id="id${i.index}">${vo.id}</td>
						<td>${vo.name}</td>
						<td>${vo.email}</td>
						<td>${vo.phone}</td>
						<td><input type="checkbox" name="del" id="${vo.id}" title="id${i.index}" class="term"></td>
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
	</div>
<script type="text/javascript">
	
	//=========================================================
	// ajax와 함께 쓰는 이벤트 위임
	//=========================================================
		
	// checkAll로 terms on/off
	$("#result").on("click", "#checkAll", function() {
		$(".term").prop("checked", $("#checkAll").prop("checked"));
	});
	
	// terms 확인 후 checkAll on/off
	$("#result").on("click", ".term", function() {
		var isCheckAll = true;
		$(".term").each(function() {
			
			if(!$(this).prop("checked")) {
				isCheckAll = false;
			}
		});
		
		$("#checkAll").prop("checked", isCheckAll);
	});
	
	// delete button
	$("#result").on("click", "#delBtn", function() {
	
		var ids = [];
		$(".term").each(function(index) {

			if($(this).prop("checked")) {
				var id = $(this).attr("id");
				console.log(id);
				ids.push(id);
			}
		});
		
		console.log(ids);
		$.ajax({
			traditional: true,
			type:"get", 
			url:"./memberDeletes",
			data: {
				ids : ids
			},
			success:(function(data) {
				data = data.trim();
				alert(data+"명 회원 탈퇴 성공");
				$.get("./memberLists", function(data) {
					$("#result").html(data);
				});
			})
		});
	});
	
	// delBtn
	// 중복값이 있는 곳 필드에 적용시,
	/* $("#delBtn").click(function(){
		
		$(".term").each(function(index) {

			if($(this).prop("checked")) {
				var id = $(this).attr("title");
				console.log($("#"+id).text());
			}
		});
	}); */
	
	// 유니크값 필드에 적용시
	/* $("#delBtn").click(function(){
		
		var ids = [];
		$(".term").each(function(index) {

			if($(this).prop("checked")) {
				var id = $(this).attr("id");
				console.log(id);
				ids.push(id);
			}
		});
		
		console.log(ids);
		$.ajax({
			traditional: true,
			type:"get", 
			url:"./memberDeletes",
			data: {
				ids : ids
			},
			success:(function(data) {
				alert(data+"명 회원 탈퇴 성공");
				$.get("./memberLists", function(data) {
					$("#result").html(data);
				});
			})
		});
	}); */
	
</script>
</body>
</html>