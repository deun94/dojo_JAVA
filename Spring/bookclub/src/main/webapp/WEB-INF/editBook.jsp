 <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <!-- Formatting (like dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
    <!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit Book</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Change Your Entry</h1>
        <p><a href="/home" class="float-end">Back to the shelves</a></p>
        <form:form action="/books/${book.id}/update" method="post" modelAttribute="book">
    <!-- make sure that you are addressing the correct action -->
    <!-- make sure you are having the input of hidden for the edit method -->
            <input type="hidden" name="_method" value="put">
            <form:input type="hidden" path="uploader" value="${idOfLoggedInUser}" />
            <div> 
                <form:label path="bookTitle">Book title:</form:label>
                <form:errors path="bookTitle" class = "text-danger"/>
                <form:input path="bookTitle" type="text" class= "form-control"/>
            </div>
            <div>
                <form:label path="authorName">Author Name:</form:label>
                <form:errors path="authorName" class = "text-danger"/>
                <form:input path="authorName" type="text"  class= "form-control"/>
            </div>

            <div>
                <form:label path="myThoughts">My Thoughts:</form:label>
                <form:errors path="myThoughts" class = "text-danger"/>
                <form:textarea path="myThoughts" type="text" class= "form-control"/>
            </div>
            <input type="submit" value="Submit" class= "btn btn-success mt-3"/>
        </form:form>
    </div>
</body>
</html>
