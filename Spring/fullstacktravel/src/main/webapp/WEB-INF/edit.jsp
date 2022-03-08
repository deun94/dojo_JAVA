<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Expense</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<p class="float-end"><a href="/expenses">Go back</a></p>
		<h3 class="text-success"> Edit Expense</h3>
		<!-- nmust match the model attribute -->
		<form:form action="/expenses/update/${editExpense.id}" method="post" modelAttribute="editExpense">
			<input type="hidden" name="_method" value = "put">
			<!-- to put the values there -->
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
		    	<input type="submit" value="Submit" class="float-end btn btn-primary shadow-lg"/>
		</form:form>    
    
	</div>


</body>
</html>