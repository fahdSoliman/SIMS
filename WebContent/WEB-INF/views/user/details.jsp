<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%--import spring supplied JSP tag lib --%>
	<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	In details page ...
	<br>
	<h4 align="center">${sessionScope.status}</h4>
	<h5>
		<a href="<spring:url value='/user/logout'/>">Log Me Out</a><br>
		<a href="<spring:url value='/user/resetpass'/>">reset my password</a>
	</h5>
</body>
</html>