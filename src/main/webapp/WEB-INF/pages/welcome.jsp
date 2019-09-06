<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 
</head>
<body>

<h1 class="text-info">welcome to the employee management</h1>
<br>
<div class="container">
<p class="text-primary">click below link to get employee details</p>
<a href="getAll">
<button class="btn btn-primary" >clickMe</button>
</a>
</div>
<br>
<div class="container">
 <h2 class="text-primary">New Employee Registration</h2>
</div>
<br> 
<div class="container">
<form action="save" method="post">
<div class="form-group">
    <label>No:</label>
    <input type="text" class="form-control" name="no">
  </div>
  <div class="form-group">
    <label>Name:</label>
    <input type="text" class="form-control" name="name">
  </div>
  <div class="form-group">
    <label for="email">address:</label>
    <input type="text" class="form-control" name="addr" >
  </div>
  <div class="form-group">
    <label for="pwd">email:</label>
    <input type="text" class="form-control" name="email" >
  </div>
 
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
<div class="container">
<p class="text-denger">${msg}</p>
</div>





<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>