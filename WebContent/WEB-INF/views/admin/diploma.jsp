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
<title>Add Diploma</title>
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
				<td>Enter Diploma Name</td>
				<td><sf:input path="diplomaName" /></td>
				<td><sf:errors path="diplomaName" /></td>
			</tr>
			<tr>
				<td>Enter Pass Mark </td>
				<td><sf:input  path="passmark" /></td>
				<td><sf:errors path="passmark" /></td>
			</tr>
			<tr>
				<td>Enter total Mark</td>
				<td><sf:input  path="totalMark" /></td>
				<td><sf:errors path="totalMark" /></td>
			</tr>
			<tr>
				<td>Enter Duration</td>
				<td><sf:input  path="duration" /></td>
				<td><sf:errors path="duration" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="btn" value="Add Diploma" /></td>
			</tr>
		</table>
	</sf:form>

</body>
</html>