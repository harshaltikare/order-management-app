<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/style.css" />
<meta charset="ISO-8859-1">
<title>Delete Staff</title>
</head>

<body>
<div class="header">
		<div class="center"><a class="button" href="admin.jsp">DashBoard</a></div>
		<div class="center"><a class="button" href="logout">LogOut</a></div>
	</div>
<div class="container">
<h1 class="heading">Delete Staff</h1>
<form action="admin" method="post">
<div class="form-field">
		<label>Staff Id</label> <input type="text" name="id"/></div>
		<input type="hidden" name="action" value="delete"/>
	<div class="center"><input class="button" type="submit" value="Delete"/></div>
	</form>
	</div>
</body>
</html>