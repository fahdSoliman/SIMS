<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIMS-AnswerQuestions</title>
</head>
<body>
		<table>
				<tr>
					<th>Name</th>
					<th>Subject</th>
					<th>Mobile</th>
					<th>Action</th>
				</tr>
				<c:forEach var="tempmessage" items="${list}">
				<tr>
						<td>${tempmessage.name} </td>
						<td>${tempmessage.subject} </td>
						<td>${tempmessage.mobileNumber} </td>
						<td>
							
							<a href="<spring:url value='/coordinator/update?uid=${tempmessage.messageID}'/>">Read</a>
							|
							<a href="<spring:url value='/admin/update?uid=${tempmessage.messageID}'/>">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
</body>
</html>