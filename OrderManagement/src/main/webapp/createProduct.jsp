<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/style.css" />
<meta charset="ISO-8859-1">
<title>Create Product</title>
</head>
<body>
	<div class="header">
		<div class="center">
			<a class="button" href="manage.jsp">DashBoard</a>
		</div>
		<div class="center">
			<a class="button" href="logout">LogOut</a>
		</div>
	</div>
	<div class="container">
		<h1 class="heading">Create Product</h1>
		<form action="products" method="post">
			<div class="form-field">
				<label>Name</label> <input type="text" name="name" />
			</div>
			<div class="form-field">
				<label>Category Id</label> <input type="text" name="cat_id" />
			</div>
			<div class="form-field">
				<label>Price</label> <input type="text" name="price" />
			</div>
			<div class="form-field">
				<label>Description</label> <input type="text" name="description">
			</div>
			<div class="form-field">
				<label>Quantity</label> <input type="text" name="quantity" />
			</div>
			<input type="hidden" name="action" value="create" /> 
			<div class="center"><input class="button" type="submit" value="Create" /></div>
		</form>
	</div>
</body>
</html>