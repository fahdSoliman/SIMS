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
<title>View Diploma</title>
</head>
<body>

	<sf:form method="post" modelAttribute="diploma">
	<h4>${requestScope.diploma}</h4>
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td> diploma ID</td>
				<td><sf:input path="diplomaID" readonly="true"/></td>
			</tr>
			<tr>
				<td> Diploma Name</td>
				<td><sf:input path="diplomaName" /></td>
				<td><sf:errors path="diplomaName" /></td>
			</tr>
			<tr>
				<td>Pass Mark</td>
				<td><sf:textarea  path="passmark" /></td>
				<td><sf:errors path="passmark" /></td>
			</tr>
			<tr>
				<td>Fail Mark</td>
				<td><sf:textarea  path="failMark" /></td>
				<td><sf:errors path="failMark" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="btn" value="Add Diploma" /></td>
			</tr>
		</table>
		<table style="background-color: cyan; margin: auto;" border="1">
		<c:forEach var="m" items="${requestScope.diploma.modules}">
			<tr>
				<td>${m.courseName}</td>
				<td>${m.passMark}</td>
				<td>${m.failMark}</td>
				<td><a href="<spring:url value='/admin/delete?vid=${m.moduleID}'/>">Delete</a></td>
			</tr>
		</c:forEach>
</table>
<h4 align="center">
	<a href="<spring:url value='/admin/module?id=${sessionScope.diploma.diplomaID}'/>">Add New Module</a>
</h4>
	</sf:form>

</body>
</html>