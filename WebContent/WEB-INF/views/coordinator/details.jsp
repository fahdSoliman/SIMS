<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>SIMS-Coordinator Account</title>
</head>
<body>
<h4 align="center">${sessionScope.status}</h4>
<h4 align="center">${requestScope.status}</h4>
<h4 align="center">Welcome ${sessionScope.account_dtls.fullName}</h4>
<a href="/coordinator/messagelist">Answer Questions</a><br>
<a href="/coordinator/registartionlist">Show Registrations</a>
</body>
</html>