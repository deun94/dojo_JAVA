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
<title>Create A Task</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Create a New TV Show</h1>
        <form:form action="/shows/create" method="post" modelAttribute="show">
            <form:input type="hidden" path="uploader" value="${idOfLoggedInUser}" />
            <div> 
                <form:label path="title">Title:</form:label>
                <form:errors path="title" class = "text-danger"/>
                <form:input path="title" type="text" class= "form-control"/>
            </div>
            <div> 
                <form:label path="network">Network:</form:label>
                <form:errors path="network" class = "text-danger"/>
                <form:input path="network" type="text" class= "form-control"/>
            </div>
            <div>
                <form:label path="description">Description:</form:label>
                <form:errors path="description" class = "text-danger"/>
                <form:textarea path="description" type="text"  class= "form-control"/>
            </div>

            <a href="/home" class= "btn btn-danger mt-3">Cancel</a>
            <input type="submit" value="Submit" class= "btn btn-success mt-3"/>
        </form:form>
    </div>

</body>
</html>