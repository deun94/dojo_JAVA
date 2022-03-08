<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji Result</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container text-center" style="margin: auto; padding: auto; ">
		<h1>Here is your Omikuji info!!!</h1>
		<div class="d-flex justify-content-center">
			<div class=" bg-primary text-dark h4 text-start" style="width: 400px; padding: 20px; border: 5px black;">
				<p>In <%= session.getAttribute("n") %> years, you will live in <%=session.getAttribute("city") %> with <%=session.getAttribute("user") %> as your room-mate, selling <%=session.getAttribute("h") %> for a living. The next time you see a <%=session.getAttribute("p") %> you will have good luck. Also,<%=session.getAttribute("d") %> </p>
			</div>
		
		</div>
		<a href="/" class="btn btn-primary mt-10"> Go back</a>
	</div>

</body>
</html>