<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page import="java.io.*,java.util.*,javax.servlet.*,hospitalM.Servlet.HomeController,hospitalM.Model.MedicineModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="main.css">
</head>
<body>
<%

	MedicineModel medicineModel = (MedicineModel) request.getAttribute("medi");
	if(medicineModel != null) System.out.println("We came to Home jsp and Name field value is "+medicineModel.getName());
	String success = (String) request.getAttribute("message");
	String fail = (String) request.getAttribute("error");
	Boolean btn = (Boolean) request.getAttribute("fb");
	if(btn == null){
		btn =true;
	}
	String action = "";
	if(btn) action ="ADD";
	else action = "UPDATE";
	String path = "";
	String type = "";
	String message = "";
	if (success != null)
		path = "<div class='alert alert-success alert-dismissible fade show'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>Success! </strong> "
		+ success + "</div> </div>";
	else if (fail != null)
		path = "<div class='alert alert-danger alert-dismissible fade show'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>Error!</strong> "
		+ fail + "</div>";

	%>



<div="container">

<div class="alert-box" style="margin-top: 10px;margin-bottom: -10px;margin-left: 10px;margin-right: 10px;">
<%=path %>
</div>
	
<div class="row">
    <div class="col-9">
     <div class="card-1">
     	 <table id="table_id" class="table">
    <thead class="table-primary">
        <tr>
            <th>S.Number</th>
            <th>Name</th>
            <th>Category</th>
            <th>Company</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>expDate</th>
            <th>fabDate</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
    	<c:forEach items="${medies}" var="medi">
        <tr>
            <td>${medi.getId()}</td>
            <td>${medi.getName()}</td>
            <td>${medi.getCategory()}</td>
            <td>${medi.getCompany()}</td>
            <td>${medi.getPrice()}</td>
            <td>${medi.getQuantity()}</td>
            <td>${medi.getExpdate()}</td>
            <td>${medi.getFabDate()}</td>
            <td><button type="button" class="btn btn-primary" style="margin: 0 4px;"  onclick="location.href='HomeController?action=EDIT&id=${medi.getId()}';">Edit</button><button type="button" class="btn btn-danger" onclick="location.href='HomeController?action=DELETE&id=${medi.getId()}';">Delete</button> </td>
        </tr>
       </c:forEach>
    </tbody>
</table>
     </div>
    </div>
    <div class="col-3">
    <div class = "card-heading" onclick="location.href='HomeController?action=ADD';" style="cursor: pointer;">
    	<h1 style="color: white;">Add Medicine</h1>
    </div>
    
     	<div class="card-2">
     	<form action="${pageContext.request.contextPath}/HomeController?action=<%=action %>" method="post">
	<input type="hidden"  id="id" aria-describedby="id" placeholder="Enter Category" name="id" value=${ medi.getId() }>
  <div class="form-group">
    <label for="mediName">Medicine Name</label>
    <input type="text" class="form-control" id="mediName" value="${ medi.getName() }" placeholder="Enter Medicine Name"  name="medicalname" >
  </div>
  <div class="form-group">
    <label for="cat">Category</label>
    <input type="text" class="form-control" id="cat" value="${ medi.getCategory() }"  placeholder="Enter Category" name="category" >
  </div>
   <div class="form-group">
    <label for="company">Company</label>
    <input type="text" class="form-control" id="company" value="${ medi.getCompany() }"  placeholder="Enter Company" name="company" >
  </div>
   <div class="form-group">
    <label for="expDate">Exp Date</label>
    <input type="date" class="form-control" id="expDate" value="${ medi.getExpdate() }"  placeholder="Enter Expire Date" name="expDate" >
  </div>
    <div class="form-group">
    <label for="fabDate">Fab Date</label>
    <input type="date" class="form-control" id="fabDate" value="${ medi.getFabDate() }" placeholder="Enter Fab DAte" name="fabDate" >
  </div>
  <div class="form-group">
    <label for="price">Price</label>
    <input type="text" class="form-control" id="price" value="${ medi.getPrice() }" placeholder="Enter Price" name="price" >
  </div>
    <div class="form-group">
    <label for="quantity">Quantity</label>
    <input type="number" class="form-control" id="quantity" value="${ medi.getQuantity() }" placeholder="Enter Quantity" name="quantity">
  </div>
  <center> <%if(btn) {%> <button type="submit"  name="submit"  class="btn btn-primary" value="Submit">ADD</button><%} else{ %>  <button type="submit" class="btn btn-primary" name="submit" value="Update">Update</button> <%} %>  </center>
	
	</form>
     	</div>
    </div>
  </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
<script >

$(document).ready( function () {
    $('#table_id').DataTable();
} );

</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</html>