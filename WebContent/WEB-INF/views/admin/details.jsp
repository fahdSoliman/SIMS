<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@ taglib uri="http://www.springframework.org/tags"  prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Administrator Page</title>
</head>
<body>
<h1>here the page of administrator</h1><br>
<h4 align="center">${sessionScope.status}</h4>
<h4 align="center">${requestScope.status}</h4>
<h4 align="center">welcome ${sessionScope.account_dtls.fullName}</h4>
<a href="<spring:url value='/admin/list?Type=ADMIN'/>">List Administrator Accounts</a><br>
<a href="<spring:url value='/admin/list?Type=COORDINATOR'/>">List Coordinators Accounts</a><br>
<a href="<spring:url value='/admin/list?Type=FACULTY'/>">List Faculty Accounts</a><br>
<a href="<spring:url value='/admin/custins'/>">Customize the institute</a><br>
<a href="<spring:url value='/user/logout'/>">Log Me Out</a><br>
<a href="<spring:url value='/user/resetpass'/>">reset my password</a>
</body>
</html>