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
CategoryName
</th>
<th>
CategoryDiscription
</th>
<th>
Edit
</th>
<th>
Delete
</th>
</tr>


<c:forEach items="${catList}"  var="cat">
<tr>
<td>${cat.categoryName}</td>
<td>${cat.categoryDiscription}</td>
<td><a href="edit?catId=${cat.categoryId}">edit</a></td>
<td><a href="del?catId=${cat.categoryId}">delete</a></td>
</tr>
</c:forEach>

</table>
</body>
</html>