<%@page import="com.example.om.model.Product"%>
<%@page import="com.example.om.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("productId"));
	Product product = new ProductDAO().getProductById(id);
	%>
	<div class="container">
		<h1 class="heading"><%=product.getName()%></h1>
		<div class="details">
			Product Id : <%= product.getId() %><br/>
			Product Name : <%= product.getName() %><br/>
			Category Id : <%= product.getCategoryId() %><br/>
			Description : <%= product.getDescription() %><br/>
			Price : <%= product.getPrice() %><br/>
			Quantity Available : <%= product.getQuantity() %><br/>
		</div>
		<br/><br/>
		<form action="cart" method="post">
			<div class="form-field">
				<label>Quantity Required</label>
				<input type="number" name="qty" required="required" />
			</div>
			<input type="hidden" name="action" value="create">
			<input type="hidden" name="productId" value="<%= product.getId() %>" required="required" />
			<div class="center">
				<input class="button" type="submit" value="Add To Cart"/>
			</div>
		</form>
	</div>
</body>
</html>