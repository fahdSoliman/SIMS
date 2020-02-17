<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CUstomization the Institute</title>
</head>
<body>

	<sf:form method="post" modelAttribute="institute">
	<h4>${requestScope.status}</h4>
	<h4>${requestScope.room}</h4>
	<h4>${requestScope.diploma}</h4>
		<table style="background-color: cyan; margin: auto;" border="1">
		<tr>
				<td> Institute ID</td>
				<td><sf:input path="instituteID" readonly="true"/></td>
			</tr>
			<tr>
				<td>Enter Institute Name</td>
				<td><sf:input path="instituteName" /></td>
				<td><sf:errors path="instituteName" /></td>
			</tr>
			<tr>
				<td>Enter Scope of Institute</td>
				<td><sf:textarea  path="scope" /></td>
				<td><sf:errors path="scope" /></td>
			</tr>
			<tr>
				<td>Enter About As</td>
				<td><sf:textarea  path="aboutUs" /></td>
				<td><sf:errors path="aboutUs" /></td>
			</tr>
			<tr>
				<td>Enter Contact Us</td>
				<td><sf:textarea  type="text" path="contactUs" /></td>
				<td><sf:errors path="contactUs" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="btn" value="Customize Institute" /></td>
			</tr>

		</table>
		<table style="background-color: cyan; margin: auto;" border="1">
			<c:forEach var="r" items="${sessionScope.Institute.rooms}">
				<tr>
					<td>${r.roomName}</td>
					<td>${r.roomFloor}</td>
					<td>${r.roomSize}</td>
					<td><a href="<spring:url value='/admin/deleteroom?vid=${r.roomID}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<table style="background-color: cyan; margin: auto;" border="1">
			<c:forEach var="d" items="${sessionScope.Diploma.diplomas}">
				<tr>
					<td>${d.diplomaName}</td>
					<td>${d.passmark}</td>
					<td>${d.totalMark}</td>
					<td>${d.duration}</td>
					<td><a href="<spring:url value='/admin/deletedip?vid=${d.diplomaID}'/>">Delete</a></td>
					<td><a href="<spring:url value='/admin/viewdiploma?id=${d.diplomaID}'/>">View</a></td>
				</tr>
			</c:forEach>
		</table>
		<h4 align="center">
			<a href="<spring:url value='/admin/addroom'/>">Add New room</a><br>
			<a href="<spring:url value='/admin/diploma?id=${sessionScope.Institute.instituteID }'/>">Add Diploma</a>
		</h4>
	</sf:form>
</body>
</html>