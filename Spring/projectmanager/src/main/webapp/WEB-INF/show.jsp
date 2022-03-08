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
        <h1>Project Details</h1>
        <a href="/home" class-="float-end mt-3">Back to the Dashboard</a>
        <div class="container-sm">
            <p>Project : ${projectToShow.projectTitle}</p>
            <p>Description : ${projectToShow.description}</p>
            <p>Due Date: ${projectToShow.dueDate}</p>

            <a href="/projects/{id}/task">See Tasks!</a>
            
            <c:if test='${loggedInUser.id == projectToShow.uploader.id }'>
				<a href="/projects/${id}/delete" class= "btn btn-danger mt-3 float-end">Delete Project</a>
            </c:if>
        </div>
        
    </div>
</body>
</html>