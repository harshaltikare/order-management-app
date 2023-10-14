<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/style.css" />
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
</head>
<body>
	<div class="header">
		<div class="center"><a class="button" href="index.html">Home</a></div>
		<div class="center"><a class="button" href="logout">LogOut</a></div>
	</div>
	<div class="container">
		<h1 class="heading">Admin Dashboard</h1>
		<div class="button">
			<a href="addStaff.jsp">Create Staff</a>
		</div>
		<div class="button">
			<a href="deleteStaff.jsp">Delete Staff</a>
		</div>
		<div class="button">
			<a href="admin?type=staff">View Staff</a>
		</div>
		<div class="button">
			<a href="admin?type=customer">View Customers</a>
		</div>
	</div>
	>
</body>
</html>