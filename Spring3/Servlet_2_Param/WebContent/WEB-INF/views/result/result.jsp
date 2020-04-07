<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert('${requestScope.result}');
	location.href="../";
</script>
</head>
<body>
	<h1>등록 성공</h1>
	<h1>${requestScope.result}</h1>
</body>
</html>