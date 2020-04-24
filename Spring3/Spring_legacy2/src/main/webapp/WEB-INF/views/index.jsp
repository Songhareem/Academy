<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="./template/boot.jsp"></c:import>
</head>
<body>
	<c:import url="./template/header.jsp"></c:import>

	<!-- Jumbotron -->
	<div class="container">
		<div class="jumbotron">
			<h1>Bootstrap Tutorial</h1>
			<p>Bootstrap is the most popular HTML, CSS, and JS framework for
				developing responsive, mobile-first projects on the web.</p>
		</div>
		<p>This is some text.</p>
		<p>This is another text.</p>
		
		<h2>Index</h2>
		
		<button id="btn">BUTTON</button>
	</div>

	<script type="text/javascript">
		$(`#btn`).click(function() {
			
			// jquery Ajax
			// Get(url, param)
			alert("start");
			$.get("./notive/noticeSelect?num=100", function(result) {
				console.log(result);
			});
			alert("finish");
			
			// Post(url, param)
			$.post();
		});
	</script>
</body>
</html>