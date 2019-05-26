<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<%@ include file="userheader.jsp" %>
<hr>
</div>
<div>
<sf:form action="loginsuccess" method="post" modelAttribute="user">
Email <sf:input path="email" />
Pasword <sf:input path="password" />



<input type="submit"  value="Login" />

</sf:form>
<h2> ${loginerrormsg}</h2>
</div>
</body>
</html>