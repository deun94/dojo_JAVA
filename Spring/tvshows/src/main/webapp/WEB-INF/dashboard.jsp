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
<title>Project Manager Dashboard</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <a href="/logout" class="float-end">Logout</a>
        <h1>Welcome, ${loggedInUser.name} </h1>
        <p>TV Shows</p>
        <table class="table table-success">
            <thead>
                <tr>
                    <th scope="col">Show</th>
                    <th scope="col">Network</th>
                    <th scope="col">Average Rating</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items='${ allShows }' var='showObj'>
                    <tr>
                        <td><a href="/shows/${showObj.id}/show">${showObj.title}</a></td>
                        <td>${showObj.network}</td>

                    </tr>
                </c:forEach>
        
            </tbody>
        </table>

        <a href="shows/new" class="btn btn-primary">Add a show</a>
    </div>


</body>
</html>