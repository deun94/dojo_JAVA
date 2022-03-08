<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Travel Expense</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	
	<div class="container">
	<h1 class="text-primary">Save Travels</h1>
	<table class="table table-primary table-striped table-hover">
		<thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Expenses</th>
		      <th scope="col">Vendors</th>
		      <th scope="col">Amounts</th>
		    </tr>
		</thead>
	  	<tbody>
	  		<c:forEach items = "${allTravelExpense}" var="expObj">
	  		
	    		<tr>
	      			<th scope="row">${expObj.id}</th>
	      			<td><a href="/expenses/${expObj.id}">${expObj.name}</a></td>
	      			<td>${expObj.vendor}</td>
	      			<td>$ ${expObj.amount}</td>
	      			<td>
	      				<a href="/expenses/edit/${expObj.id}">Edit</a> ||
	      				<a href="/expenses/delete/${expObj.id}" class="text-danger">Delete</a> 
	      			</td>
	    		</tr>
	    	
	    	</c:forEach>
	</table>
	
	<h3> Add Expense</h3>
	<form:form action="/expenses/create" method="post" modelAttribute="travelExpense">
	<p>
        <form:label path="name">Expense Name: </form:label>
        <form:errors path="name" class="text-danger"/>
        <form:input path="name" class="form-control"/>
    </p>
    <p>
        <form:label path="vendor">Vendor: </form:label>
        <form:errors path="vendor" class="text-danger"/>
        <form:input path="vendor" class="form-control"/>
    </p>
    <p>
        <form:label path="amount">Amount: </form:label>
        <form:errors path="amount" class="text-danger"/>
        <form:input type= "number" path="amount" step="0.01" class="form-control"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description" class="text-danger"/>     
        <form:textarea path="description" class="form-control"/>
    </p>    
    	<input type="submit" value="Submit" class="btn btn-primary float-end"/>
	</form:form>    
    
	</div>

</body>
</html>