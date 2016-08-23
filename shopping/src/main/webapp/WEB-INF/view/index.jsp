<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/header.jsp" %>
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
