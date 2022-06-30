<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style type="text/css">
body{
	background: url("images/login_background.jpg");
	background-size: cover;
}
.container{
color:white;
font-weight:bolder;
font-size:large;
background-image: linear-gradient(to left top, #1c92d2, #5caedb, #8ec9e4, #bfe3ef, #f2fcfe);
padding: 10px 10px;
transform:translate(10%,50%);
max-width: 500px;
border-radius: 15px;
}

.logo{
	width: 200px;
	height: 200px;
	border-radius: 50%;
}

</style>
</head>
<body>
<%
	String message = (String) request.getAttribute("message");
	
%>

<div class="container">
<%if(message != null){ %>
<div class="alert alert-danger" role="alert" style="font-weight: normal;font-size: medium;font-family: sans-serif;">
  <%=message %>
</div>
<%} %>
<form action="${pageContext.request.contextPath}/LoginController?action=CHECK" method="post">
  <div class="form-group">
  	<center><img src="images/logo.png" class="logo"></center>
    <label for="InputEmail">Email address</label>
    <input type="email" class="form-control" id="InputEmail" aria-describedby="emailHelp" placeholder="Enter email" name="email">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
  </div>
 <center> <button type="submit" class="btn btn-primary">Login</button></center>
</form>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>