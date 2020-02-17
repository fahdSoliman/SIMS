<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ask Us</title>
</head>
<body>
<form:form action="sendMessage" modelAttribute="message" method="POST">
					
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
							<form:errors path="name" color=red/>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
							<form:errors path="email" color=red/>
					</tr>
					<tr>
						<td><label>Mobile:</label></td>
						<td><form:input path="mobileNumber" /></td>
					</tr>
					<tr>
							<form:errors path="mobileNumber" color=red/>
					</tr>
					<tr>
						<td><label>Subject:</label></td>
						<td><form:input path="subject" /></td>
					</tr>
					<tr>
							<form:errors path="subject" color=red/>
					</tr>
					<tr>
						<td><label>Details:</label></td>
						<td>	<form:textarea path="address" rows="12" cols="60" /></td>
					</tr>
					<tr>
							<form:errors path="details" color=red/>
					</tr>
					<tr>
						<td><label></label><td>
						<td><input type="submit" value="Save"  /></td>
					</tr>

				
				</tbody>
			</table>
					
		
		</form:form>
	
</body>
</html>