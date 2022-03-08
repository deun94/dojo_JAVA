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
		<div class="navbar">
			<h1>Welcome, ${loggedInUser.firstName}!</h1>
			<a href="/logout">log out</a>
		</div>

		<a href="/projects/new" class="btn-sm btn-success float-end mb-3">+ New Project</a>
		<p>All Projects</p>

		<div>
			
			<table class="table table-success">
				<thead>
					<tr>
						<th scope="col"><a href="projects/show"></a>Project</th>
						<th scope="col">Team Lead</th>
						<th scope="col">Due Date</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items='${ allProjects }' var='projectObj'>
						<!--if the loggedinusers id is not the same as the projectObj's uploaders' id-->
						<c:if test ='${!loggedInUser.getProjectsJoined().contains(projectObj) }' >
							<!-- look over this -->
						<tr>
							<!-- <th scope="row">${projectObj.id}</th> -->
							<td><a href="/projects/${projectObj.id}/show">${projectObj.projectTitle}</a></td>
							<td>${projectObj.uploader.firstName} ${projectObj.uploader.lastName}</td>
							<td>${projectObj.dueDate}</td>
							<td>
								<a href="/projects/${projectObj.id}/join">Join Team</a>
							</td>
						</tr>
						</c:if>
					</c:forEach>
			
				</tbody>
			</table>
			<div>
				<p>Your Projects</p>
				<table class="table table-success">
					<thead>
						<tr>
							<th scope="col"><a href="project/show"></a>Project</th>
							<th scope="col">Team Lead</th>
							<th scope="col">Due Date</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items='${loggedInUser.projectsJoined}' var='projectObj'>
							<tr>
								<!-- <th scope="row">${projectObj.id}</th> -->
								<td><a href="/projects/${projectObj.id}/show">${projectObj.projectTitle}</a></td>
								<td>${projectObj.uploader.firstName} ${projectObj.uploader.lastName}</td>
								<td>${projectObj.dueDate}</td>
								<td>
									<!--if the loggedinusers id is the same as the projectObj's uploaders' id, then they can see the edit link-->
									
									<c:if test='${loggedInUser.id == projectObj.uploader.id }'>
										<a href="/projects/${projectObj.id}/edit">Edit</a>
									</c:if>
									<c:if test='${loggedInUser.id != projectObj.uploader.id }'>
										<a href="/projects/${projectObj.id}/leave">Leave Team</a>
									</c:if>


								</td>
							</tr>
							
							
							<!-- else if the logged in user is not the uploader -->
						</c:forEach>

				
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>