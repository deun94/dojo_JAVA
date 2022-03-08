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
<title>Show Details</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>${bookToShow.bookTitle} on the shore</h1>
        <a href="/home" class-="float-end mt-3">Back to the Shelves</a>
        <div class="container-sm">
        <p><span class="text-danger">${bookToShow.uploader.userName}</span> read ${bookToShow.bookTitle}</p>
            <p>Here are ${bookToShow.uploader.userName}'s thoughts</p>
            <p>Author Name: ${bookToShow.authorName}</p>
            <p>Description:  ${bookToShow.myThoughts}</p>
    
            <a href="/books/${id}/edit">Edit</a>
        </div>
        
    </div>

</body>
</html>