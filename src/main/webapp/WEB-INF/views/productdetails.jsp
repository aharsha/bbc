<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="userheader.jsp" %>
<img src="resources/product-imgs/${pro.productId}.jpg" alt="image13" width="200" height="200">
${pro.productName}
${pro.productDescription}
${pro.productPrice}
<td>${pro.productCategory}
${pro.productSupplier}
</body>
</html>