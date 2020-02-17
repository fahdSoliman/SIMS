<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@ taglib uri="http://www.springframework.org/tags"  prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Create New Account</title>
</head>
<body>
<h4 align="center">${requestScope.status}</h4>
<h4 align="center">${sessionScope.account_dtls}</h4>

	<form method="post">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Enter Your Full Name</td>
				<td><input type="text" name="FullName" /></td>
			</tr>
			<tr>
				<td>Enter Mobile Number</td>
				<td><input type="text" name="MobileNo" /></td>
			</tr>
			<tr>
				<td>Enter Your Address</td>
				<td><input type="text" name="Address" /></td>
			</tr>
			<tr>
				<td>Enter Your Email</td>
				<td><input type="text" name="Email" /></td>
			</tr>
			<tr>
				<td>Enter Login User</td>
				<td><input type="text" name="UserLogin" /></td>
			</tr>
			<tr>
				<td>Enter Password User</td>
				<td><input type="password" name="UserPass" /></td>
			</tr>
			<tr>
				<td><select name="Type">
					<option value="ADMIN">Admin</option>
					<option value="COORDINATOR">Coordinator</option>
					<option value="FACULTY">Faculty</option>
					<option value="STUDENT">Student</option>
					<option value="REGISTRATION">Registration</option>
				  </select></td>
			</tr>
			<tr>
				<td><input type="submit" value="newuser" /></td>
			</tr>
		</table>
	</form>
</body>
</html>