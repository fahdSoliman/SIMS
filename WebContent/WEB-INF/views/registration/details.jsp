<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>SIMS-Registration Details</title>
</head>
<body>
<h4 align="center">${sessionScope.status}</h4>
<h4 align="center">${requestScope.status}</h4>
<h2 align="center">Welcome ${sessionScope.account_dtls.fullName}</h2><br><br>
<h3 align="center">Your account details are:-</h3><br>
<table>
		<tr>
			<td>Account ID:-</td>
			<td>${account_dtls.accountID}<td>
		</tr>
		<tr>
			<td>Name:-</td>
			<td>${account_dtls.fullName}<td>
		</tr>
		<tr>
			<td>Address:-</td>
			<td>${account_dtls.address}<td>
		</tr>
		<tr>
			<td>Mobile Number:-</td>
			<td>${account_dtls.mobileNo}<td>
		</tr>
		<tr>
			<td>Email:-</td>
			<td>${account_dtls.email}<td>
		</tr>
		<tr>
			<td>User Login:-</td>
			<td>${account_dtls.userLogin}<td>
		</tr>
		<tr>
			<td>Registration Date:-</td>
			<td>${account_dtls.regDate}<td>
		</tr>
</table>
<h2 align="center">
<a href="<spring:url value='/user/logout'/>">Log Out</a>
</h2>
</body>
</html>