<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="userheader.jsp" %>
<div class="container">
<table class="table">
<tr>
<th>ProductId</th>
<th>Product</th>
<th>Price</th>

<th>Quantity</th>
<th>Supplier</th>
<th>TotalPrice</th>
</tr>
<c:forEach items="${cartData}" var="cart">
<tr>
<td>${cart.productId}</td>
<td>${cart.productName}</td>
<td>${cart.productPrice}</td>
<td>${cart.productQuantity}</td>
<td>${cart.productSupplier}</td>

<td>${cart.totalPrice}</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>