<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About us</title>
</head>
<body>
Welcome to About us
Congratulations!!! You have successfully registered
<h3>${message}</h3>
<h3>${name}</h3>
			<sf:form action ="registered" modelAttribute="userDetails" commandName="userDetails">
					<sf:label path="id">UserName:</sf:label>${userDetails.id}
					<br /><br />
					<sf:label path="password">Password:</sf:label>${userDetails.password}
					<br /><br />
					<sf:label path="address">Address :</sf:label>${userDetails.address}
					<br /><br />
					<sf:label path="name">Username:</sf:label>${userDetails.name}
					<br /><br />
					<sf:label path="mailID">Mobile No:</sf:label>${userDetails.contactNumber}
					<br /><br />
					<!-- for triggering webflow events using form submission,
					 the eventId to be triggered is given in "name" attribute as:
					-->
					<input type="submit" value="Edit" /> 
					<input type="submit" value="Submit" /><br />
				</sf:form>
</body>
</html>