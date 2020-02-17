<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIMS-Message</title>
</head>
<body>
<h1 align="center">Message</h1>
<table>
	<tr>
			<td>Message Id:-</td>
			<td>${theMessage.messageID}</td> 
	</tr>
	<tr>
			<td>Name:-</td>
			<td>${theMessage.name}</td> 
	</tr>
	<tr>
			<td>Email:-</td>
			<td>${theMessage.email}</td> 
	</tr>
	<tr>
			<td>Mobile:-</td>
			<td>${theMessage.mobileNumber}</td> 
	</tr>
	<tr>
			<td>Subject:-</td>
			<td>${theMessage.subject}</td> 
	</tr>
	<tr>
			<td>Details:-</td>
			<td>${theMessage.details}</td> 
	</tr>
</table>
</body>
</html>