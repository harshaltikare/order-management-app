<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/style.css" />
<meta charset="ISO-8859-1">
<title>Add Staff</title>
</head>
<body>
<div class="header">
		<div class="center"><a class="button" href="admin.jsp">DashBoard</a></div>
		<div class="center"><a class="button" href="logout">LogOut</a></div>
	</div>
<div class="container">
	<h1 class="heading">Add Staff</h1>
	<form action="admin" method="post">
		<div class="form-field">
			<label>First Name</label> 
			<input type="text" name="first_name"/>
		</div>
		<div class="form-field">
			<label>Last Name</label> 
			<input type="text" name="last_name"/>
		</div>
		<div class="form-field">
			<label>Phone Number</label> 
			<input type="tel" name="phone_number"/>
		</div>
		<div class="form-field">
			<label>E-Mail</label> 
			<input type="email" name="email"/>
		</div>
		<div class="form-field">
			<label>Password</label> 
			<input type="password" name="password"/>
		</div>
		<div class="form-field">
			<label>Role</label> 
			<input type="text" name="role"/>
		</div>
		<input type="hidden" name="action" value="add"/>
		<div class="center">
          <input class="button" type="submit" value="Add Staff" />
        </div>
	</form>
	</div>
</body>
</html>