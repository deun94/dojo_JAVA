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
<title>Show My Task</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <div class="navbar">
            <h1>${showToShow.title}</h1>
            <a href="/home" class-="float-end">Back to the Dashboard</a>
        </div>

        <div class="container-sm">
            <p>Posted By : ${showToShow.uploader.name}</p>
            <p>Network: ${showToShow.network}</p>
            <p>Description : ${showToShow.description}</p>
            <c:if test='${loggedInUser.id == showToShow.uploader.id }'>
                <a href="/shows/${showToShow.id}/edit" class="btn btn-success mt-3">Edit</a>
            </c:if>
            
        </div>
        <div>
            <p>------------------------------------------------------------------</p>
            <table class="table table-success">
                <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Rating</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items='${ allShows }' var='showObj'>
                        <tr>
                            <td>${showObj.uploader.name}</a></td>
                            <td>${showObj.rating}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form:form action="/shows/${showToShow.id}/rate" method="post" modelAttribute="show">
                <input type="hidden" name="_method" value="put">
                <form:input type="hidden" path="uploader" value="${idOfLoggedInUser}" />
                <form:input type="hidden" path = "title" value="${showToShow.title}"/>
                <form:input type="hidden" path = "network" value="${showToShow.network}"/>
                <form:input type="hidden" path = "description" value="${showToShow.description}"/>
                <div> 
                    <form:label path="rating">Leave a rating:</form:label>
                    <form:errors path="rating" class = "text-danger"/>
                    <form:input path="rating" type="number" min="1" max="5" step="0.1" class= "form-control"/>
                </div>
                <input type="submit" value="Rate!">
            </form:form>
        </div>
</body>
</html>