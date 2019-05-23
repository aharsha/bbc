<%@page import="java.util.List"%>
<%@page import="com.harsha.model.Supplier"%>
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
SupplierName
</th>
<th>
SupplierDiscription
</th>
<th>
Edit
</th>
<th>
Delete
</th>
</tr>


<c:forEach items="${supList}"  var="sup">
<tr>
<td>${sup.supplierName}</td>
<td>${sup.supplierDescription}</td>
<td><a href="editsupp?supId=${sup.supplierId}">edit</a></td>
<td><a href="delsupp?supId=${sup.supplierId}">delete</a></td>
</tr>
</c:forEach>

</table>
</body>
</html>