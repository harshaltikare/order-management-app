<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/style.css" />
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<div class="container">
		<h1 class="heading">Login</h1>
		<form action="login" method="post">
			<div class="form-field">
				<p class="error">
					<%=request.getAttribute("error")!=null?request.getAttribute("error"):""%>
				</p>
				<label>Email</label> <input type="email" name="email"
					required="required" />
			</div>
			<div class="form-field">
				<label>Password</label> <input type="password" name="password"
					required="required" />
			</div>
			<input type="checkbox" name="isStaff" value="true" /> Are you an employee?
			<br/>
			<div class="center">
				<input class="button" type="submit" value="Login" />
			</div>
			<br />
			<br />
			<h2 class="heading">New User!</h2>
			<a class="button" href="createUser.jsp">SignUp!!</a>
		</form>
	</div>

</body>
</html>