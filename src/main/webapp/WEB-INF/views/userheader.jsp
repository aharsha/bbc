<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar fixed-top navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="home">Ecomm</a>

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">AboutUs</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">ContactUs</a>
    </li>

    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
       Products
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="userproducts">Desktops</a>
        <a class="dropdown-item" href="userproducts">Laptops</a>
      </div>
    </li>
    
    <li class="nav-item">
      <a class="nav-link" href="showcart">cart</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="register">Register</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="login">Login</a>
    </li>
  </ul>
</nav>
<br>
  
<div class="container">
  
</div>
</body>
</html>