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
		<button id="btn2">BUTTON2</button>
		
	</div>

	<script type="text/javascript">
		$(`#btn`).click(function() {
			
			// jquery Ajax
			// Get(url, param)
			
			$.get("./json/json1", function(data) {
				//0. data가 String인지 Json Onject인지 판별
				// "key":"value" = String
				// object = json object
				console.log(data);
				
				//1. String 이라면, Json Object 변환
				//data = data.trim();
				//data = JSON.parse(data);
				console.log(data.num);
				console.log(data.title);
				console.log(data.writer);
				console.log(data.contents);
			});
		});
		
		$(`#btn2`).click(function() {
			$.get("https://api.manana.kr/exchange/rate.json?base=KRW&code=KRW,USD,JPY", function(data) {
				console.log(data[1].rate);
			});
		});
	
	</script>
</body>
</html>