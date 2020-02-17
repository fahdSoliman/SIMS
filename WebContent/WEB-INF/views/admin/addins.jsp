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
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Enter Institute Name</td>
				<td><sf:input path="InstituteName" /></td>
				<td><sf:errors path="InstituteName" /></td>
			</tr>
			<tr>
				<td>Enter Scope of Institute</td>
				<td><sf:textarea  path="Scope" /></td>
				<td><sf:errors path="Scope" /></td>
			</tr>
			<tr>
				<td>Enter About As</td>
				<td><sf:textarea  path="AboutUs" /></td>
				<td><sf:errors path="AboutUs" /></td>
			</tr>
			<tr>
				<td>Enter Contact Us</td>
				<td><sf:textarea  type="text" path="ContactUs" /></td>
				<td><sf:errors path="ContactUs" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="btn" value="Add Institute" /></td>
			</tr>

		</table>
	</sf:form>

</body>
</html>