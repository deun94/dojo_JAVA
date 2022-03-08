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
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <a href="/books/add">back to the shelves</a>
        <h1>Add a Book to Your Shelf!</h1>
        <form:form action="/books/create" method="post" modelAttribute="book">
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