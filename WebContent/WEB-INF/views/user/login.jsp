<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SIMS-Login</title>
</head>
<body>
<h4 align="center">${requestScope.status}</h4>
	<form method="post">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Enter User Email</td>
				<td><input type="text" name="UserLogin" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="Password" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>