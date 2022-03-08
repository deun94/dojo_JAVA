<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Showing expense</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<p class="float-end"><a href="/expenses">Go back</a></p>
		<h1 class="text-primary">Expense Details</h1>
		
		
		<div class="smallcontainer">
		<!-- it is not the exp obj we are passing in the travelExpsne attribute -->
			<p> Expense Name : ${travelExpense.name}</p>
			<p> Expense Description: ${travelExpense.description}</p>
			<p> Vendor : ${travelExpense.vendor}</p>
			<p> Amount : ${travelExpense.amount}</p>
		</div>
	</div>
</body>
</html>