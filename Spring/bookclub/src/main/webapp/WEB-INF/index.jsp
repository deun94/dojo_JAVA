<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reading Shore</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1 class="text-purple">Welcome!</h1>
        <p>A place for friends to share throughs on books</p>
        <div class="row">
            <div class="col">
                <h3>Register</h3>
                <form:form action="/register" method="post" modelAttribute="newUser">
                    <div>
                        <form:label path="userName">User Name</form:label>
                        <form:errors path="userName" class="text-danger"/>
                        <form:input path="userName" type="text" class= "form-control"/>
                    </div>
                    <div>
                        <form:label path="email">Email</form:label>
                        <form:errors path="email" class="text-danger"/>
                        <form:input path="email" type="email" class= "form-control"/>
                    </div>
                    <div>
                        <form:label path="password">Password</form:label>
                        <form:errors path="password" class="text-danger"/>
                        <form:input path="password" type="password" class= "form-control"/>
                    </div>
                    <div>
                        <form:label path="confirm">Confirm Password</form:label>
                        <form:errors path="confirm" class="text-danger"/>
                        <form:input path="confirm" type="password" class= "form-control"/>
                    </div>
                    
                    <input type="submit" value="Submit" class= "btn btn-success mt-3"/>
                </form:form>   
            </div>
            <div class="col">
                <h3>Login</h3>
                <form:form action="/login" method="post" modelAttribute="newLogin">

                    <div>
                        <form:label path="email">Email</form:label>
                        <form:errors path="email" class="text-danger"/>
                        <form:input path="email" type="email" class= "form-control"/>
                    </div>
                    <div>
                        <form:label path="password">Password</form:label>
                        <form:errors path="password" class="text-danger"/>
                        <form:input path="password" type="password" class= "form-control"/>
                    </div>
                    
                    <input type="submit" value="Login" class= "btn btn-success mt-3"/>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>