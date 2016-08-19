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

									<li><a href="<c:url value='product/get/${product.id}' />">${product.name}</a></li>

								</c:forEach>

							</ul></li>
					</c:forEach>
				</c:if>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="myCart"><span class="glyphicon glyphicon-cart"></span>
							Cart(${value})</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-cart"></span>${message}</a></li>		
					<li><a href="login1"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
					
					
				</ul>
			</div>
		</div>
	</nav>
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
		<a href="about">About</a> <a href="#">Services</a> <a href="#">Clients</a>
		<a href="#">Contact</a>
	</div>
	<span style="font-size: 30px; cursor: pointer" onclick="openNav()">
		Menu</span>
	<marquee>This text will scroll from right to left</marquee>
	<script>
		function openNav() {
			document.getElementById("mySidenav").style.width = "250px";
		}

		function closeNav() {
			document.getElementById("mySidenav").style.width = "0";
		}
	</script>
	<h3>${msg}</h3>
	<div class="container">
		<br>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>
			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<a href="index"> <img src="resources\photos\welcome.jpg"
						alt="Chania" width="460" height="345">
					</a>

				</div>

				<div class="item">
					<a href="clothing"> <img src="resources\photos\clothing.jpg"
						alt="Chania" width="460" height="345">
					</a>
				</div>

				<div class="item">
					<a href="electronics"> <img
						src="resources\photos\Electrics.jpg" alt="Flower" width="460"
						height="345">
					</a>
				</div>

				<div class="item">
					<img src="resources\photos\cosmetics.jpg" alt="Flower" width="460"
						height="345">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<br>
	<br>
	<br>

	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading">NEW OPENING SALE</div>
					<div class="panel-body">
						<img src="http://placehold.it/150x80?text=IMAGE"
							class="img-responsive" style="width: 100%" alt="Image">
					</div>
					<div class="panel-footer">Buy 3 Tshirts and get 1 free</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-danger">
					<div class="panel-heading">ELECTRONICS MELA</div>
					<div class="panel-body">
						<img src="http://placehold.it/150x80?text=IMAGE"
							class="img-responsive" style="width: 100%" alt="Image">
					</div>
					<div class="panel-footer">Upto 10% off on all Electronic
						Items</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-success">
					<div class="panel-heading">Every</div>
					<div class="panel-body">
						<img src="http://placehold.it/150x80?text=IMAGE"
							class="img-responsive" style="width: 100%" alt="Image">
					</div>
					<div class="panel-footer">Buy 50 mobiles and get a gift card</div>
				</div>
			</div>
		</div>
	</div>
	<br>

</body>
</html>
