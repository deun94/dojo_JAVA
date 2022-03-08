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
<title>Edit A task</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <a href="/home" class-="float-end mt-3">Back to the Dashboard</a>
        <h1>Edit Project!</h1>
        <form:form action="/projects/${project.id}/update" method="post" modelAttribute="project">
            
            <input type="hidden" name="_method" value="put">
            <!-- you need this for the edit method -->
            <form:input type="hidden" path="uploader" value="${idOfLoggedInUser}" />
            <div> 
                <form:label path="projectTitle">Project title:</form:label>
                <form:errors path="projectTitle" class = "text-danger"/>
                <form:input path="projectTitle" type="text" class= "form-control"/>
            </div>
            <div>
                <form:label path="description">Project Description:</form:label>
                <form:errors path="description" class = "text-danger"/>
                <form:textarea path="description" type="text"  class= "form-control"/>
            </div>

            <div>
                <form:label path="dueDate">Due Date:</form:label>
                <form:errors path="dueDate" class = "text-danger"/>
                <form:input path="dueDate" type="date" class= "form-control"/>
            </div>
            <a href="/home" class= "btn btn-danger mt-3">Cancel</a>
            <input type="submit" value="Submit" class= "btn btn-success mt-3"/>
        </form:form>
    </div>

</body>
</html>