<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add your Dojo</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>New Dojo</h1>
        <a href="/ninja/add">Add a new ninja</a>
        <form:form action="/dojo/create" method="post" modelAttribute="dojo">
            <p>
                <form:label path="name">Name: </form:label>
                <form:errors path="name" class= "text-danger"/>
                <form:input path="name" type="text" class= "form-control"/>
            </p>
            <input type="submit" value="Submit" class="btn btn-primary float-end"/>
        </form:form>    
	</div>

</body>
</html>