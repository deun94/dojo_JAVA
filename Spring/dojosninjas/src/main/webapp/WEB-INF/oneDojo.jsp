<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Showing Dojo with Ninjas</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h4><a href="/" class="float-end">Home</a></h4>
        <h1>${showOneDojo.name} Location Ninjas</h1>
        <table class="table table-primary">
            <thead>
                <tr>
                    <th scope="col">Ninja ID</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Age</th>
                    <th scope="col">Current Dojo</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ showOneDojo.ninjas }" var="ninjaObj">
                    <tr>
                        <th scope="row">${ninjaObj.id}</th>
                        <td>${ninjaObj.firstName}</td>
                        <td>${ninjaObj.lastName}</td>
                        <td>${ninjaObj.age}</td>
                        <td>${ninjaObj.dojo.name}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>