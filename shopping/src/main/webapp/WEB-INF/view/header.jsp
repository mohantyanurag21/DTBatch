<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	margin: auto;
	height: 500px;
	max-height: 500px;
}
</style>
<style>
body {
	font-family: "Lato", sans-serif;
	background="\resources\photos\background.jpg";
}

.sidenav {
	height: 100%;
	width: 0;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #111;
	overflow-x: hidden;
	transition: 0.5s;
	padding-top: 60px;
}

.sidenav a {
	padding: 8px 8px 8px 32px;
	text-decoration: none;
	font-size: 25px;
	color: #818181;
	display: block;
	transition: 0.3s
}

.sidenav a:hover, .offcanvas a:focus {
	color: #f1f1f1;
}

.closebtn {
	position: absolute;
	top: 0;
	right: 25px;
	font-size: 36px !important;
	margin-left: 50px;
}

@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
	.sidenav a {
		font-size: 18px;
	}
}
</style>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="temp">ShoppingKart</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index">Home</a></li>
						<c:if test="${not empty categoryList}">
					<c:forEach items="${categoryList}" var="category">
						<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href=${category.name}>${category.name}<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<c:forEach items="${category.products}" var="product">
									<li><a href="<c:url value='/get/${product.id}' />">${product.name}</a></li>
								</c:forEach>

							</ul></li>
					</c:forEach>
				</c:if>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<c:if test="${pageContext.request.userPrincipal.name != null}">
                            <li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
                            <li><a href="<c:url value="j_spring_security_logout" />">Logout</a></li>

                            <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
                                <li><a href="<c:url value="/myCart" />">CART</a></li>
                            </c:if>

                            <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                                <li><a href="<c:url value="/admin" />">Admin</a></li>
                            </c:if>

                        </c:if>

                        <c:if test="${pageContext.request.userPrincipal.name == null}">
                            <li><a href="<c:url value="/login1" />">Login</a></li>
                            <li><a href="<c:url value="/register" />">Register</a></li>
                        </c:if>
					
					 <li><a href="myCart"><span class="glyphicon glyphicon-cart"></span>
							Cart(${value})</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-cart"></span>${message}</a></li>		
					<li><a href="login1"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
					
					
				</ul>
			</div>
		</div>
	</nav>