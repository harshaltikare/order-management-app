<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@page import="com.example.om.model.Customer"%>
<%@page import="com.example.om.model.Staff"%>
<%@page import="com.example.om.model.Product"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/style.css" />
<meta charset="ISO-8859-1">
<title>View <%=request.getAttribute("itemType")%></title>
</head>
<body>

	<%!public static List<Map<String, String>> getMap(HttpServletRequest request) {
		String type = (String) request.getAttribute("itemType");
		Object obj = (Object) request.getAttribute("items");
		List<Map<String, String>> output = new ArrayList<>();
		if (type.equals("Product")) {
			@SuppressWarnings("unchecked")
			List<Product> list = (List<Product>) obj;
			for (Product product : list) {
				Map<String, String> map = product.getDetails();
				output.add(map);
			}
		} else if (type.equals("Customer")) {
			@SuppressWarnings("unchecked")
			List<Customer> list = (List<Customer>) obj;
			for (Customer customer : list) {
				Map<String, String> map = customer.getDetails();
				output.add(map);
			}
		} else if (type.equals("Staff")) {
			@SuppressWarnings("unchecked")
			List<Staff> list = (List<Staff>) obj;
			for (Staff staff : list) {
				Map<String, String> map = staff.getDetails();
				output.add(map);
			}
		}
		return output;

	}%>

	<div class="header">
		<div class="center">
			<a class="button" href="index.html">Home</a>
		</div>
		<div class="logo"></div>
		<div class="h-flex">
			<c:if test='${itemType.equals("Product")}'>
				<a class="button" href='cart'>Cart</a>
			</c:if>
			<div class="center">
				<a class="button" href="logout">LogOut</a>
			</div>
		</div>
	</div>
	<div class="items">
		<c:forEach var="itemMap" items="<%=getMap(request)%>">
			<div class="card">
				<c:forEach items="${itemMap.entrySet()}" var="entry">
					<c:out value="${entry.getKey()} : "></c:out>
					<c:out value="${entry.getValue()}"></c:out>
					<br />
				</c:forEach>
				<c:if test='${itemType.equals("Product")}'>
					<a class="button"
						href='productDetails.jsp?productId=${itemMap.get("id")}'>View
						Details</a>
				</c:if>
			</div>
		</c:forEach>
	</div>
</body>
</html>