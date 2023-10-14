<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/style.css" />
<meta charset="ISO-8859-1">
<title>Create Customer</title>
</head>
<body>
<div class="header">
		<div class="center"><a class="button" href="index.html">Home</a></div>
		<div class="center"><a class="button" href="login">LogIn</a></div>
	</div>
<div class="container">
	<h1 class="heading">Create Customer</h1>
	<form action="customers" method="post">
		First Name : <input type="text" name="firstName"/><br/>
		Email : <input type="email" name="email"/><br/>
		Password : <input type="password" name="password"/><br/>
		<input class="button" type="submit" value="Create"/>
	</form>
	</div>
</body>
</html>