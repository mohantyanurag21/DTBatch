<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="<c:url value="/resources/admin.css" />">
<html>
<head>
<title>product Page</title>

</head>
<body>
	<h1>Add a product</h1>

	<c:url var="addAction" value="/product/add"></c:url>

	<form:form action="${addAction}" commandName="product">
	<input type="text" name = "id" readonly = "true" value = ${pid}> ID
	<input type="text" name = "name" value = ${pname}> Name
	<input type="text" name = "description"value = ${pdescription}> Description
	<input type="number" name = "quantity" value = ${pquantity}> Quantity
	<input type="text" name = "company" value = ${pcompany}> CompanyName
	<input type="number" name = "price" value = ${pprice}> Price
	<input type = "submit" name = "Submit">
	
	</form:form>
	<h3>product List</h3>
	<c:if test="${!empty productList}">
		<table class="tg">
			<tr>
				<th width="80">product ID</th>
				<th width="120">product Name</th>
				<th width="120">product Description</th>
				<th width="120">product Price</th>
				<th width="120">product Company</th>
				<th width="120">product Quantity</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.price}</td>
					<td>${product.company}</td>
					<td>${product.quantity}</td>
					<td><a href="<c:url value='product/edit/${product.id}' />">Edit</a></td>
					<td><a href="<c:url value='product/remove/${product.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</body>
	</html>
	
	