<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border='2'>
	<tr><th>Product Id</th>
	<th>Product Name</th>
	<th>Quantity</th>
	<th>Price</th>
	<th>ldt</th>  <th>cid</th>
	<th>action</th>
	</tr>
	
	<c:forEach var="prod" items="${plist}">
	<tr>
		<td>${prod.pid}</td>
		<td>${prod.pname}</td>
		<td>${prod.qty}</td>
		<td>${prod.price}</td>
		<td>${prod.ldt}</td>  
		<td>${prod.cid}</td>
		<td><a href="deleteProduct/${prod.pid}">delete</a>
		<a href="editProduct/${prod.pid}">edit</a></td>
	</tr>
	</c:forEach>
	</table>
	<a href="/product/addProduct">Add new product</a>
	<a href="/product/getProducts">View Products</a>
</body>
</html>