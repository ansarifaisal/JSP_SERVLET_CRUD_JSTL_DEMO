<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
</head>
<body>
	<hr>
	<h3 align="center">Employee Details</h3>
	<hr>
	<table align="center" width="80%" border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Roll Number</th>
				<th>Year</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Address</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<c:forEach items="${students}" var="student">
			<tbody>
				<tr>
					<td>${student.id}</td>
					<td>${student.rollNumber}</td>
					<td>${student.year}</td>
					<td>${student.firstName}</td>
					<td>${student.lastName}</td>
					<td>${student.address}</td>
					<td><a href="StudentController.do?action=update&id=<c:out value="${student.id}"/>">Edit</a></td>
					<td><a href="StudentController.do?action=delete&id=<c:out value="${student.id}"/>">Delete</a></td>
				</tr>
				
			</tbody>
		</c:forEach>
		<tr>
			<td colspan="8" align="center"><a href="StudentController.do?action=insert">Add
					New Student</a></td>
		</tr>
	</table>	
</body>
</html>