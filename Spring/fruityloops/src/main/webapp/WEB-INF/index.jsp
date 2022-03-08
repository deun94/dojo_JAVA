<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fruity Loopy loop</title>
</head>
<body>
	<div class="container w-50 d-flex justify-content-center">
		<h1> Fruit Store</h1>
		<div style="background-color: rgba(255,0,0,0.1); ">
			<table class="table">
	  			<thead>
	    			<tr>
	      				<th scope="col">Name</th>
	      				<th scope="col">Price</th>
	    			</tr>
	  			</thead>
	  			<tbody>
	  			<c:forEach var="fruitObj" items="${fruitItems}">
	  				<tr>
	  					<td scope="col">${fruitObj.name}</td>
	  					<td scope="col">${fruitObj.price}</td>
	  				</tr>
	  			</c:forEach>
	  			</tbody>
			</table>
		</div>
	</div>

</body>
</html>
