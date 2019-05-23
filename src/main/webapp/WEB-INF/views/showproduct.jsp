<%@page import="java.util.List"%>
<%@page import="com.harsha.model.Category"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<%@ include file="adminheader1.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2"  >
<tr>
<th>
ProductName
</th>
<th>
ProductDiscription
</th>
<th>
ProductPrice
</th>

<th>
ProductCategory
</th>
<th>
ProductSupplier
</th>
<th>
ProductImage
</th>
<th>
Edit
</th>
<th>
Delete
</th>
</tr>


<c:forEach items="${proList}"  var="pro">
<tr>
<td>${pro.productName}</td>
<td>${pro.productDescription}</td>
<td>${pro.productPrice}</td>
<td>${pro.productCategory}</td>
<td>${pro.productSupplier}</td>
<td><img src="resources/product-imgs/${pro.productId}.jpg" alt="image13" width="50" height="50"></td>
<td><a href="editproduct?proId=${pro.productId}">edit</a></td>
<td><a href="delproduct?proId=${pro.productId}">delete</a></td>
</tr>
</c:forEach>

</table>
</body>
</html>