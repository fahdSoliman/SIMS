<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Institute User List</title>
</head>

<h3 align="center">${requestScope.status}</h3>
<table style="background-color: cyan; margin: auto;" border="1">
	<c:forEach var="acc" items="${requestScope.user_list}">
		<tr>
			<td>${acc.UID}</td>
			<td>${acc.fullName}</td>
			<td>${acc.address}</td>
			<td>${acc.mobileNo}</td>
			<td>${acc.email}</td>
			<td>${acc.regDate}</td>
			<td><a href="<spring:url value='/admin/update?uid=${acc.UID}'/>">Update</a></td>
			<td><a href="<spring:url value='/admin/delete?uid=${acc.UID}'/>">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<h4 align="center">
	<a href="<spring:url value='/admin/newuser'/>">Add New Account</a>
</h4>
<h5>
	<a href="<spring:url value='/user/logout'/>">Log Out</a>
</h5>

<body>

</body>
</html>