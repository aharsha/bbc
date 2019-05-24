<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

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
<sf:form action="register" method="post" modelAttribute="user">
Email <sf:input path="email" />
Pasword <sf:input path="password" />

UserName<sf:input path="userName" />
MobileNumber <sf:input path="phonenumber" />

Address <sf:input path="address" />

<input type="submit"  value="Register" />

</sf:form>
</div>
</body>
</html>