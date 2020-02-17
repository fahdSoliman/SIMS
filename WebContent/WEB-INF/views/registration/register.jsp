<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SIMS-New Registration</title>
</head>
<body>
<h4 align="center">${requestScope.status}</h4>
	<form:form action="getregistered" modelAttribute="account" method="POST">
					
			<table>
				<tbody>
					<tr>
						<td><label>Full Name:</label></td>
						<td><form:input path="fullName" /></td>
					</tr>
					<tr>
							<form:errors path="fullName" color=red/>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
							<form:errors path="email" color=red/>
					</tr>
					<tr>
						<td><label>Mobile:</label></td>
						<td><form:input path="mobileNo" /></td>
					</tr>
					<tr>
							<form:errors path="mobileNo" color=red/>
					</tr>
					<tr>
						<td><label>Address:</label></td>
						<td><form:input path="address" /></td>
					</tr>
					<tr>
							<form:errors path="address" color=red/>
					</tr>
					<tr>
						<td><label>User Login Id</label></td>
						<td>	<form:input path="userLogin" /></td>
					</tr>
					<tr>
							<form:errors path="userLogin" color=red/>
					</tr>
					<tr>
						<td><label>Password</label></td>
						<td>	<form:input path="password" /></td>
					</tr>
					<tr>
							<form:errors path="password" color=red/>
					</tr>
					<tr>
						<td><input type="submit" value="Register"  /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
</body>
</html>