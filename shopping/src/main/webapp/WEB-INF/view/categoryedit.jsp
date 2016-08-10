<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="<c:url value="/resources/admin.css" />">
<html>
<head>
<title>Category Page</title>

</head>
<body>
	<h1>Add a Category</h1>
	
	<c:url var="addAction" value="category/add"></c:url>

	<form:form action="${addAction}" commandName="category">
	<input type="text" name = "id" disabled = "true" readonly ="true" value = ${cid} > ID
	<input type="text" name = "name" value = ${cname} > Name
	<input type="text" name = "description" value = ${cdescription} > Description
	<input type = "submit" name = "Submit">
	
	</form:form>
	<h3>Category List</h3>
	<c:if test="${!empty categoryList}">
		<table class="tg">
			<tr>
				<th width="80">Category ID</th>
				<th width="120">Category Name</th>
				<th width="120">Category Description</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.id}</td>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td><a href="<c:url value='category/edit/${category.id}' />">Edit</a></td>
					<td><a href="<c:url value='/category/remove/${category.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</body>
	</html>
	
	