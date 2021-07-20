
<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title> project</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body style="height:1500px">

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">AkshayaSukkal Project</a>
    </div>
    <ul class="nav navbar-nav">

   <c:if test="${sessionScope.role==null}">
    	<li class="nav-item"> <a class="nav-link" href="HomePage">Home</a></li>
    	<li class="nav-item"><a class="nav-link" href="Login">Sign In</a></li>
    	<li class="nav-item"><a class="nav-link" href="Register">Sign Up</a></li>
    	  <li class="nav-item">
    <a class="nav-link" href="<c:url value='/Category'/>">Category</a> 
    </li>
    <li class="nav-item">
    <a class="nav-link" href="<c:url value='/supplier'/>">Supplier</a> 
    </li>s 
    </c:if>
  </ul>
</nav>

</body>
