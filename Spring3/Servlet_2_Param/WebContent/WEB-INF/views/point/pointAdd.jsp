<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="container">
		<h2>Point Input</h2>
		<form action="./pointAdd" method="post">
			<div class="form-group">
				<label for="name">Name:</label> 
				<input type="text"	class="form-control" id="name" placeholder="이름을 적어주세요" name="name">
			</div>
			
			<div class="form-group">
				<label for="num">Num:</label> 
				<input type="text"	class="form-control" id="num" placeholder="번호를 적어주세요" name="num">
			</div>
			
			<div class="form-group">
				<label for="kor">Kor:</label> 
				<input type="text"	class="form-control" id="kor" placeholder="국어 점수를 적어주세요" name="kor">
			</div>
			
			<div class="form-group">
				<label for="eng">Eng:</label> 
				<input type="text"	class="form-control" id="eng" placeholder="영어 점수를 적어주세요" name="eng">
			</div>
			
			<div class="form-group">
				<label for="math">Math:</label> 
				<input type="text"	class="form-control" id="math" placeholder="수힉 점수를 적어주세요" name="math">
			</div>
			
			<div class="form-group"> 
				<input type="checkbox"	class="form-control" name="check" value="A">
			</div>
			
			<div class="form-group"> 
				<input type="checkbox"	class="form-control" name="check" value="B">
			</div>
			
			<div class="form-group"> 
				<input type="checkbox"	class="form-control" name="check" value="C">
			</div>

			<button type="submit" class="btn btn-default">등록</button>
		</form>
	</div>

</body>
</html>