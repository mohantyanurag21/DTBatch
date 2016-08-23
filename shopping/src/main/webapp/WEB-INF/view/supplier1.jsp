<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="<c:url value="/resources/admin.css" />">
<html>
<head>
<title>supplier Page</title>

</head>
<body>
	<h1>Add a supplier</h1>

	<c:url var="addAction" value="/supplier/add"></c:url>

	<form:form action="${addAction}" commandName="supplier">
	<input type="text" name = "id"> ID
	<input type="text" name = "name"> Name
	<input type="text" name = "address"> Address
	<input type = "submit" name = "Submit">
	
	</form:form>
	<h3>supplier List</h3>
	<c:if test="${!empty supplierList}">
		<table class="tg">
			<tr>
				<th width="80">Supplier ID</th>
				<th width="120">supplier Name</th>
				<th width="120">supplier Address</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${supplierList}" var="supplier">
				<tr>
					<td>${supplier.id}</td>
					<td>${supplier.name}</td>
					<td>${supplier.address}</td>
					<td><a href="<c:url value='/supplier/edit/${supplier.id}' />">Edit</a></td>
					<td><a href="<c:url value='/supplier/remove/${supplier.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</body>
	</html>
	
	