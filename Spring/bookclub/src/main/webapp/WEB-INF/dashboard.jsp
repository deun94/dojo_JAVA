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
<title>Read Share</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <a href="/logout" class="float-end">Logout</a>
        <h1>Welcome, ${loggedInUser.userName} </h1>
        <a href="/books/new" class="float-end">+ Add a to my shelf!</a>
        <p>Books from everyone's shelves</p>
        <table class="table table-success">
            <thead>
                <tr>
                    <th scope="col">ID#</th>
                    <th scope="col"><a href="book/show"></a>Title</th>
                    <th scope="col">Author Name</th>
                    <th scope="col">Posted By</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items='${ allBooks }' var='bookObj'>
                    <tr>
                        <th scope="row">${bookObj.id}</th>
                        <td><a href="/books/${bookObj.id}/show">${bookObj.bookTitle}</a></td>
                        <td>${bookObj.authorName}</td>
                        <td>${bookObj.uploader.userName}</td>
                        <td>
                            <!--if the loggedinusers id is the same as the bookObj's uploaders' id, then they can see the edit link-->
                            <c:if test='${loggedInUser.id == bookObj.uploader.id }'>
                                <a href="/books/${bookObj.id}/edit">Edit</a> || 
                                <a href="/books/${bookObj.id}/delete">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
        
            </tbody>
        </table>
    </div>


</body>
</html>