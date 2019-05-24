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

<form action="addtocart"  method="post" >
<input type="hidden"  name="proId"  value="${pro.productId}" />
<input type="number" name="proQuantity" min="1" max="5" />
<input type="submit"  value="AddToCart">
</form>

</body>
</html>