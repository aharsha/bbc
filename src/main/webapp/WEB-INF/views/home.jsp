<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="adminheader1.jsp" %>
<!DOCTYPE html>
<html>
<head>

<style>
  /* Make the image fully responsive */
  .carousel-inner img {
      width: 50%;
      height: 50%;
  }
  </style>
</head>
<body>

  
  


<div id="demo" class="carousel slide" data-ride="carousel">

  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>
  
  <!-- The slideshow -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="resources/crsl-imgs/1.jpg" alt="image3"" width="1100" height="400">
    </div>
    <div class="carousel-item">
      <img src="resources/crsl-imgs/2.jpg" alt="image2" width="1100" height="500">
    </div>
    <div class="carousel-item">
      <img src="resources/crsl-imgs/3.jpg" alt="image1" width="1100" height="500">
    </div>
  </div>
  
  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>



</body>
</html>