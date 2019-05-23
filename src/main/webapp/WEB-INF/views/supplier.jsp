
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"    prefix="sform"  %>
<%@ include file="adminheader1.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sform:form action="addSup"  method="post" modelAttribute="sup">
SupplierName <sform:input  path="supplierName"  />
SupplierDiscription <sform:input  path="supplierDescription" />
  <sform:input  path="supplierId"  type="hidden" />

<input type="submit"  value="${bname}" />

</sform:form>
</body>
</html>