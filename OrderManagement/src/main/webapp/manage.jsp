<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/style.css" />
<meta charset="ISO-8859-1">
<title>Manager Dashboard</title>
</head>
<body>
	<div class="header">
		<div class="center">
			<a class="button" href="index.html">Home</a>
		</div>
		<div class="center">
			<a class="button" href="logout">LogOut</a>
		</div>
	</div>

	<div class="container">
		<h1 class="heading">Manager Dashboard</h1>
		<div class="button">
			<a href="products">View Products</a>
		</div>
		<div class="button">
			<a href="orders">View Orders</a>
		</div>
		<div class="button">
			<a href="createProduct.jsp">Add Product</a>
		</div>
		<div class="button">
			<a href="deleteProduct.jsp">Delete Product</a>
		</div>
	</div>
</body>
</html>