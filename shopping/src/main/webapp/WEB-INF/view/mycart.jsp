<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/view/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Cart List</h3>
	<c:if test="${!empty cartList}">
		<table class="tg">
			<tr>
				<th width="80">Cart ID</th>
				<th width="120">UserName </th>
				<th width="120">Product Name </th>
				<th width="120">Quantity  </th>
				<th width="120">Price </th>
				<th width="120">Status </th>
				
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${cartList}" var="cart">
				<tr>
					<td>${cart.cart_id}</td>
					<td>${cart.userId}</td>
					<td>${cart.productname}</td>
					<td>${cart.quantity}</td>
					<td>${cart.price}</td>
					<td>${cart.status}</td>
					<td><a href="<c:url value='cart/edit/${cart.cart_id}' />">Edit</a></td>
					<td><a href="<c:url value='/cart/remove/${cart.cart_id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<h3>Total Amount = ${Amount}</h3>
</body>
</html>