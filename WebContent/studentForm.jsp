<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details</title>
</head>
<body>
	<hr><h3 align="center">Employee Details</h3><hr>
	<form action="StudentController.do" method="POST">
		<table>
			<tr>
				<td><label for="rollNumber">Roll Number</label></td>
				<td><input type="text" name="rollNumber" value="${student.rollNumber}" placeholder="Roll Number">
					<input type="hidden" name="id" value="${student.id}">
				</td>
			</tr>
			<tr>
				<td><label for="year">Year</label></td>
				<td><input type="text" name="year" value="${student.year}" placeholder="Year"></td>
			</tr>
			<tr>
				<td><label for="firstName">First Name </label></td>
				<td><input type="text" name="firstName" value="${student.firstName}" placeholder="First Name"></td>
			</tr>
			<tr>
				<td><label for="lastName">Last Name </label></td>
				<td><input type="text" name="lastName" value="${student.lastName}" placeholder="Last Name"></td>
			</tr>
			<tr>
				<td><label for="address">Address </label></td>
				<td><input type="text" name="address" value="${student.address}" placeholder="Address"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>