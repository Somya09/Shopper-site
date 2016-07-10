<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Decor</title>
 <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  </style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand">Home Decor</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/">Home</a></li>
      <li><a href="aboutus">About Us</a></li>
      <li><a href="contact">Contact Us</a></li> 
      <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Product
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Bed</a></li>
            <li><a href="#">Sofas</a></li>
            <li><a href="#">Wardrobes</a></li>
            <li><a href="#">Dining Tables</a></li>
          </ul>
        </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="loginUser"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="<c:url value="/resources/img/very-large-bed.jpg"/>" alt="Bed">
        <div class="carousel-caption">
          <h3>Beds</h3>
          <p>Carefully Curated,Perfectly Coordinated </p>
        </div>
      </div>

      <div class="item">
        <img src="<c:url value="/resources/img/sofa1.jpg"/>" alt="Sofa">
        <div class="carousel-caption">
          <h3>Sofas</h3>
          <p>The Perfect Antidote To Long,Hard Day </p>
        </div>
      </div>
    
      <div class="item">
        <img src="<c:url value="/resources/img/large-wardrobe-closet.jpg"/>" alt="Wardrobe">
        <div class="carousel-caption">
          <h3>Wardrobes</h3>
          <p></p>
        </div>
      </div>
      <div class="item">
        <img src="<c:url value="/resources/img/images.jpg"/>" alt="Dinning Table">
        <div class="carousel-caption">
          <h3>Dining Tables</h3>
          <p>Come Gather At Your Table</p>
        </div>
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
<div class="container-fluid">
  <h3>What We Have For You</h3><br>
  <div class="row">
    <div class="col-sm-4">
      <img class="img-responsive" src="<c:url value="/resources/img/imgg.jpg"/>" alt="Bed">
          </div>
    <div class="col-sm-4">
       <img class="img-responsive" src="<c:url value="/resources/img/sofa.jpg"/>" alt="Sofa">
          </div>
    <div class="col-sm-4">
       <img class="img-responsive" src="<c:url value="/resources/img/wardrobe.jpg"/>" alt="Wardrobe">
          </div>
    </div>
</div><br>

<footer class="container-fluid text-center">
<h4>Home Decor</h4><br>
  <p>Home Decor offers a unique selection of stylish, contemporary, and chic furniture online.All our wooden furniture designs are available online at urbanladder.com. On our portal, you can browse as many furniture designs across categories as you like.</p>
  <p>Furniture is what turns your house into a home.The furniture you choose for a room can make or break it. The furniture designs you choose are what determine the personality of the room and say something about the inhabitants of the house. Modern furniture design is all about finding the right balance between design and functionality, while traditional designs have evolved over time, reflecting the fashion fads of each period. Whether you are on the lookout for modern designs or more traditional styles, there are some features to keep an eye out for. </p>
  
</footer>
</body>
</html>