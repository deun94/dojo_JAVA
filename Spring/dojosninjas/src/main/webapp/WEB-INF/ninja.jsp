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
<title>Ninja page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Add a new ninja!</h1>
        <a href="/"> Home</a>
        <form:form action="/ninja/create" method="post" modelAttribute="ninja">
            <div>
                <form:label path="dojo">Which Dojo?: </form:label>
                <form:errors path="dojo" class= "text-danger"/>
                <form:select path="dojo" name="" class= "form-select">
                <!-- for the dropdown -->
                <!-- loop through all the dojos -->
                    <c:forEach items = "${alldojo}" var="dojoObj">
                        <option value="${dojoObj.id}">${dojoObj.name}</option>
                    </c:forEach>
                </form:select>
            </div>
            <div>
                <form:label path="firstName">First Name: </form:label>
                <form:errors path="firstName" class= "text-danger"/>
                <form:input path="firstName" type="text" class= "form-control"/>
            </div>
            <div>
                <form:label path="lastName">Last Name: </form:label>
                <form:errors path="lastName" class= "text-danger"/>
                <form:input path="lastName" type="text" class= "form-control"/>
            </div>
            <div>
                <form:label path="age">Age: </form:label>
                <form:errors path="age" class= "text-danger"/>
                <form:input path="age" type="number" value="15" min="15" class= "form-control"/>
            </div>

            <input type="submit" value="create" class="btn btn-success float-end"/>
        </form:form>    
	</div>
    </div>

</body>
</html>