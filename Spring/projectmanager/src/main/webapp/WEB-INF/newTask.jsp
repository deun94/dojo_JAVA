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
<title>Props Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container" style="background-color: rgb(228, 165, 165);">
        <h1>Project: </h1>
        <div>
            <form:form action="/projects/{id}/tasks/create" method="post" modelAttribute="project">
            <form:input type="hidden" path="uploader" value="${idOfLoggedInUser}" />
            <div> 
                <form:label path="taskTicket">Task Ticket:</form:label>
                <form:errors path="taskTicket" class = "text-danger"/>
                <form:input path="taskTicket" type="text" class= "form-control"/>
            </div>
        </div>
    </div>

</body>
</html>