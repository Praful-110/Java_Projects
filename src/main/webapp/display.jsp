<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="base.css">
</head>
<body>

	<div class="container">
		<table align="center">
			<thead>

				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Mark</th>
					<th>Address</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="std"   items="${student}">
				<tr>
					<td>${std.sid}</td>
					<td>${std.sname}</td>
					<td>${std.smark}</td>
					<td>${std.saddr}</td>


					<td><a href="../web_project02/delete/${std.sid}" class="btn btn-lg btn-danger">Delete</a>
						<a href="../web_project02/edit/${std.sid}" class="btn btn-lg btn-danger">Edit</a></td>

				</tr>

			</c:forEach>
		</table>
	</div>

</body>
</html>