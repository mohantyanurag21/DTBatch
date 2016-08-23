<html>
	
	<head>
		
		<title>Product Info Page</title>
		
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
			
		<style>
			.header
			{
				height: 10%;
				width: 100%;
				background-color: #000000;
				
			}
			.showcase
			{
				width: 40%;
				height: 80%;
				background-color: #F7F7F7;/**/
				float: left;
				
			}
			.right
			{
				width:60%;
				height: 80%;
				background-color: #FFFFFF;
				float: right;
				
			}
			.footer
			{
				clear: both;
				width: 100%;
				height: 10%;
				background-color: #000000;
				
			}
			.card {
				margin-top: 0;
				width: 80%;
				height: 70%;
				background-color: #006070;
				/* just in case there no content*/
				padding: 20px 25px 30px;
				margin: 0 auto 25px;
				margin-top: 50px;
				/* shadows and rounded borders */
				-moz-border-radius: 10px;
				-webkit-border-radius: 10px;
				border-radius: 10px;
				-moz-box-shadow: 5px 5px 5px 5px rgba(0, 0, 0, 0.3);
				-webkit-box-shadow: 5px 5px 5px 5px rgba(0, 0, 0, 0.3);
				box-shadow: 5px 5px 5px 5px rgba(0, 0, 0, 0.3);
			}
			
			.productImg{
				
				background-color: #000000;
				width: 80%;
				height: 80%;
				margin-left: 10%;
				
			}
			
			.thumbnail{
				width:90%;
				margin-left: 5%;
				height: 20%;
			}
			
			.shortInfo{
				background-color: darkturquoise;
				width: 80%;
				height: 10%;
				margin-left: 5%;
				border-radius: 5px;
				box-shadow: 2px 2px 2px #000000;
			}
		</style>
			
	</head>
	
	<body>
				<div class="header">
					
				</div>
				
				<div class="showcase">
					<div class="card card-container">
						
						<div class="productImg card-container"> <!--place for product image--->
							
						</div>
						
						<div class="thumbnail card-container"><!--place for Thumbnails--->
							<table width="100%" height="100%" cellspacing="5px" cellspacing="0px" style="background-color:#ffffff;" border="1px solid black">
								<tr>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</table>
						</div>
						
					</div>
		<!-- /card-container -->
					
				</div>
				
				<div class="right">
					
					<h1>${Productname} </h1> <br />
					<h3>MRP: ${Productprice}/- </h3>
					
					<div class="shortInfo jumbotron"> <!---short info about product--->
						
  						 <p>Short Description About Product</p>
					</div>
					
					
				<!---Accordions that display different info about the product--->
					 <div class="panel-group" id="accordion">
						<div class="panel panel-default">
							<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#productDescription">
								Product Description</a>
							</h4>
							</div>                                     <!---Product descriptions here--->
							<div id="productDescription" class="panel-collapse collapse in">
							<div class="panel-body">
								<p>${ProuductDescription} </p> 
								
							</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#techSpecs">
								Technical Specification</a>
							</h4>
							</div>                                    <!---technical Specifications here---->
							<div id="techSpecs" class="panel-collapse collapse">
							<div class="panel-body">
								
							</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#checkAvail">
								Check Availability</a>
							</h4>
							</div>
							<div id="checkAvail" class="panel-collapse collapse">
							<div class="panel-body">
								<table>
									<tr>
										<td><input
												type="number" id="inputEmail" class="form-control"
												placeholder="Your PIN Code" name = "pin" required autofocus maxlength="6" style="width:200px;"></td>
								
								<td>&nbsp;&nbsp;<button type="submit" class="btn btn-info">Check Availability </button></td>
									</tr>
								</table>
							</div>
							</div>
						</div>
					</div> 
					
					<!---End of Accordion--->
					
					  
					
				</div>
				
				<div class="footer">
					
				</div>
		
	</body>
	
</html>