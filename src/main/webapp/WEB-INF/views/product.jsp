
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form"    prefix="sform"  %>
<%@ taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>

<%@ include file="adminheader1.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sform:form action="addProduct"  method="post" modelAttribute="product"   enctype="multipart/form-data">
ProductName <sform:input  path="productName"  />
ProductDiscription <sform:input  path="productDescription" />
ProductPrice <sform:input  path="productPrice" />
ProductCategory 
<sform:select  path="productCategory"  >
<c:forEach items="${categoryList}" var="cat">
<sform:option value="${cat.categoryName} ">
${cat.categoryName} 
</sform:option>
</c:forEach>


</sform:select>

ProductSupplier
<sform:select  path="productSupplier"  >
<c:forEach items="${supplierList}" var="sup">
<sform:option value="${sup.supplierName} ">
${sup.supplierName}
</sform:option>
</c:forEach>


</sform:select>
 
  <sform:input  path="productId"  type="hidden"   />
ProductImage
<sform:input type="file"   path="proImage" />
<input type="submit"  value="${bname}" />

</sform:form>
</body>
</html>