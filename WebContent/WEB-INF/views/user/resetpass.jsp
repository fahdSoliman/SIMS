<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>
<h4 align="center">${requestScope.status}</h4>
	<form method="post">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Enter New Password</td>
				<td><input type="text" name="newPass" /></td>
			</tr>
			<tr>
				<td>Re-Enter Password</td>
				<td><input type="password" name="rePass" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="resetpass" /></td>
			</tr>
		</table>
	</form>
</body>
</html>