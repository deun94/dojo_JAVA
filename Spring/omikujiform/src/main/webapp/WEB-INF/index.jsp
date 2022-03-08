<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji Form</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class = "container" style="width: 600px;">
		<h1 class="text-center">Send an Omikuji!!!</h1>
		<form class="text-right border border-dark mt-10" style="padding: 20px;" action= "/submit" method="post">
			<div class="form-group">
				<label for="number"> Pick any number from 5 to 25</label>
				<input type = "number" name = "number" min ="5" max= "25" class ="form-control" style="width: 50px;">
			</div>
			
			<div class="form-group">
				<label for="nameCity"> Enter the name of any city</label>
				<input type = "text" name = "nameCity" id = "" class ="form-control">
			</div>
			
			<div class="form-group">
				<label for="nameUser"> Enter the name of any real person</label>
				<input type = "text" name = "nameUser" id = "" class ="form-control">
			</div>
			
			<div class="form-group">
				<label for="hobby"> Enter professional endeavor or hobby</label>
				<input type = "text" name = "hobby" id = "" cldass ="form-control">
			</div>
			
			<div class="form-group">
				<label for="pet"> Enter any type of living organism</label>
				<input type = "text" name = "pet" id = "" class ="form-control">
			</div>
			
			<div class="form-group">
				<label for="description"> Say something nice to someone</label>
				<textarea name = "description" rows="4" cols = "50" class="form-control"></textarea>
			</div>
			
			<input type="submit" value="submit" class="btn btn-success">
		</form>
	</div>
	
</body>
</html>