<%@page import="java.util.List"%>
<%@page import="com.harsha.model.Category"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="userheader.jsp" %>
<div class="container-fluid">











<div class="row">
<c:forEach items="${proList}"  var="pro">

<div class="col-sm-4" style="background-color:white;"><img src="resources/product-imgs/${pro.productId}.jpg" alt="image13" width="50" height="50">
ProductName : ${pro.productName}
ProductDiscription :${pro.productDescription}
ProductPrice :${pro.productPrice}
ProductCategory : ${pro.productCategory}
ProductSupplier : ${pro.productSupplier}

<a href="productdetails?proId=${pro.productId}">ViewDetails </a>
</div>
</c:forEach>
</div>


</body>
</html>