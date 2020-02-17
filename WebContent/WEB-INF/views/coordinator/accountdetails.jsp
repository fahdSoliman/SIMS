<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">Account details are:-</h3><br>
<table>
		<tr>
			<td>Account ID:-</td>
			<td>${theAccount.accountID}<td>
		</tr>
		<tr>
			<td>Name:-</td>
			<td>${theAccount.fullName}<td>
		</tr>
		<tr>
			<td>Address:-</td>
			<td>${theAccount.address}<td>
		</tr>
		<tr>
			<td>Mobile Number:-</td>
			<td>${theAccount.mobileNo}<td>
		</tr>
		<tr>
			<td>Email:-</td>
			<td>${theAccount.email}<td>
		</tr>
		<tr>
			<td>User Login:-</td>
			<td>${theAccount.userLogin}<td>
		</tr>
		<tr>
			<td>Registration Date:-</td>
			<td>${theAccount.regDate}<td>
		</tr>
		<tr>
			<td>Account Type:-</td>
			<td>${theAccount.type}<td>
		</tr>
</table>
<h2 align="center">
	<a href="<spring:url value='/coordinator/confirm?uid=${theAccount.accountID}'/>">Accept</a>
</h2>
<br>
<h3 align="center">
	<a href="<spring:url value='/coordinator/decline?uid=${theAccount.accountID}'/>">Decline</a>
</h3>
<br>
<h4>
	<a href="<spring:url value='/user/logout'/>">Log Out</a>
</h4>

</body>
</html>