<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>
<sf:form method="post" modelAttribute="room">
	<h4>${requestScope.status}</h4>
		<table style="background-color: cyan; margin: auto;" border="1">
	
			<tr>
				<td>Enter Room Name</td>
				<td><sf:input path="roomName" /></td>
				<td><sf:errors path="roomName" /></td>
			</tr>
			<tr>
				<td>Enter Room Size</td>
				<td><sf:input  path="roomSize" /></td>
				<td><sf:errors path="roomSize" /></td>
			</tr>
			<tr>
				<td>Enter Floor Number</td>
				<td><sf:input  path="roomFloor" /></td>
				<td><sf:errors path="roomFloor" /></td>
			</tr>
		</table>
<h4 align="center">
	<input type="submit" name="btn" value="Add Room" />
</h4>
	</sf:form>
</body>
</html>