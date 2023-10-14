<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/style.css">
<meta charset="ISO-8859-1">
<title>Delete Product</title>
</head>
<body>
	<div class="header">
		<div class="center"><a class="button" href="manage.jsp">DashBoard</a></div>
		<div class="center"><a class="button" href="logout">LogOut</a></div>
	</div>
	<div class="container">
	<h1 class="heading">Delete Product</h1>
	<form action="products" method="post">
		<div class="form-field">
		<label>Product Id</label>
		<input type="text" name="id"/>
		</div>
		<input type="hidden" name="action" value="delete"/>
		<div class=center><input class="button" type="submit" value="Delete"/></div>
	</form>
	</div>
</body>
</html>