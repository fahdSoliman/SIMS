<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIMS-Registration List</title>
</head>
<body>
<table>
				<tr>
					<th>Account Id</th>
					<th>Name</th>
					<th>Registration Date</th>
					<th>Email</th>
				</tr>
				<c:forEach var="tempaccount" items="${registered}">
				<tr>
						<td>${tempaccount.accountID} </td>
						<td>${tempaccount.fullName} </td>
						<td>${tempaccount.regDate} </td>
						<td>${tempaccount.email} </td>
						<td>
							<a href="<spring:url value='/coordinator/showdetails?uid=${tempaccount.accountID}'/>">Show Details</a>
							|
							<a href="<spring:url value='/coordinator/confirm?uid=${tempaccount.accountID}'/>">Confirm</a>
						</td>
				</tr>
				</c:forEach>
</table>

</body>
</html>