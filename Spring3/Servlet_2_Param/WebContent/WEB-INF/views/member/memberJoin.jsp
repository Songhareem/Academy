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
  <h2>member Join</h2>
  <form action="./memberJoin" method="post">
    <div class="form-group">
      <label for="id">ID:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
    </div>
    
    <div class="form-group">
      <label for="pw">Password:</label>
      <input type="password" class="form-control" id="pw" placeholder="Enter pw" name="pw">
    </div>
    
    <div class="form-group">
		<label for="name">Name:</label> 
		<input type="text"	class="form-control" id="name" placeholder="Enter name" name="name">
	</div>

	<div class="form-group">
		<label for="age">Age:</label> 
		<input type="text"	class="form-control" id="age" placeholder="Enter age" name="age">
	</div>
	
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    
     <div class="form-group">
      <label for="phone">Phone:</label>
      <input type="text" class="form-control" id="phone" placeholder="Enter phone" name="phone">
    </div>
    
    <button type="submit" class="btn btn-default">Join</button>
  </form>
</div>

</body>
</html>