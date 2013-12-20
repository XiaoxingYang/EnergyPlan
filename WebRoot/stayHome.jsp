<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">  
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="http://jqueryjs.googlecode.com/files/jquery-1.3.2.min.js" type="text/javascript"></script>
		<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
		<meta http-equiv="Content-Language" content="en" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
	
		<title>Low Carbon Journey</title>
		
		<!-- CSS -->
		<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="css/spring.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="js/prettyPhoto/css/prettyPhoto.css" type="text/css" media="screen" />
		<!--[if IE 6]>
			<link rel="stylesheet" type="text/css" media="screen" href="css/ie-hacks.css" />
			<script type="text/javascript" src="js/DD_belatedPNG.js"></script>
			<script>
          		/* EXAMPLE */
          		DD_belatedPNG.fix('*');
        	</script>
		<![endif]-->
		<!-- ENDS CSS -->
		
		
		
		<!-- JS -->
		<script type="text/javascript" src="js/jquery_1.3.2.js"></script>
		<script type="text/javascript" src="js/jqueryui.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>
		<script type="text/javascript" src="js/jquery.cycle.all.js"></script>
		<script type="text/javascript" src="js/form-validation.js"></script>
		<script type="text/javascript" src="js/custom.js"></script>
		<script type="text/javascript" src="js/getRoute.js"></script>
		<script type="text/javascript" src="js/calendar.js"></script>
		<script type="text/javascript" src="js/filterable.pack.js"></script>
		<script type="text/javascript" src="js/prettyPhoto/js/jquery.prettyPhoto.js"></script>
		<!-- ENDS JS -->
		
		
		<!-- superfish -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/superfish-custom.css" /> 
		<script type="text/javascript" src="js/superfish-1.4.8/js/hoverIntent.js"></script> 
		<script type="text/javascript" src="js/superfish-1.4.8/js/superfish.js"></script> 
		<!-- ENDS superfish -->
		
		
		<!-- Cufon -->
		<script src="js/cufon-yui.js" type="text/javascript"></script>
		<script src="js/bebas_400.font.js" type="text/javascript"></script>
		<script type="text/javascript">
			Cufon.replace('.custom', { fontFamily: 'bebas', hover: true });
		</script>
        <!-- /Cufon -->

        <!-- Prettyphotos -->
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function(){
				$("a[rel^='prettyPhoto']").prettyPhoto();
			});
		</script>
		<!-- ENDS  Prettyphotos -->
        
		
		
		
		
	</head>
	<body>
	<!-- WRAPPER -->
	<div id="wrapper">
	
	<!-- navigation -->
	<ul id="nav" class="sf-menu">
	 	<li class="custom"><a href="LogoutServlet">LOGOUT</a></li>
	 	<li class="custom"><a href="ShowPersonInfoServlet" >INFORMATION</a></li>
	 	<li class="custom"><a href="ShowAllDecisionServlet">DECISIONS</a></li>
	 	<li class="custom"><a href="journeyplan.jsp">JOURNEY</a>
		    <ul>
				<li><a href="findCarRoute.jsp">CAR ROUTE</a></li>
				<li><a href="findBicycleRoute.jsp">CYCLE ROUTE</a></li>
				<li><a href="findPlace.jsp">FIND PLACE</a></li>
				<li><a href="findCarpark.jsp">FIND CARPARK</a></li>
			</ul>
		</li>
		<li class="custom"><a href="ShowHomeServlet">HOME</a></li>
	</ul>
	<!-- ENDS navigation -->
	
	
	
	<!-- HEADER -->
	<div id="header">
		<img src="img/logo.png" alt="Logo" id="logo" /></a>
		<form action="" method="post" id="search">
			<p><input type="text" onfocus="defaultInput(this)" onblur="clearInput(this)" name="keyword" id="keyword" title="Search..." value="Search..."/></p>
			<p><input type="submit" id="go" value="" /></p>
			<div class="clear"></div>
		</form>
	</div>
	<!-- ENDS HEADER -->
	
	
	
	
	
	

		
	<!-- MAIN -->
	<div id="main">
		
	
	<!-- posts -->
	<div id="posts">
		
		<!-- single-post -->
		<div class="post">
			<p class="post-title custom">STAY AT HOME</p>
			<div class="post-img"><a href="single.html"><img src="img/house.jpg" alt="Image" /></a><span></span></div>
		</div>
		<!-- ENDS single-post -->
		
		<div id="main">
		
		<!-- left-content -->
		<div class="contact-left">
			<h5 class="custom">STAY AT HOME FOR <%=request.getAttribute("homehour") %> HOURS WILL GENERATE</h5>
			<h3 class="custom"><%=request.getAttribute("homeCarbon") %> kg CO2</h3>
			<p><input type="button" id="send" onclick="window.location.href='AddHouseServlet?carbon='+<%=request.getAttribute("homeCarbon") %>+'&homehour='+<%=request.getAttribute("homehour") %>" /></p>
			<form action="StayHomeServlet" method="post">
				<fieldset>
					<p>
						<label>EDIT THE TIME TO STAY AT HOME:</label>
						<input class="brief" type="text" name="homehour" id="homehour" style="vertical-align:middle;width:180px;" />
					</p>
					<p><input type="submit" value=" " name="send" id="send" /></p>
				</fieldset>
			</form>
		</div>
		
		
		
		
		
		<!-- ENDS left-content -->
		
		</div>
		
		
	</div>
	<!-- ENDS posts -->
	
	
	
		
	
	
		<!-- sidebar -->
		<div id="sidebar">
			
			<!-- side-block -->
			<ul class="side-block">
				<li><a href="#" class="custom">Information</a></li>
				<li><a href="#" class="custom"><span>Car Route</span></a></li>
				<li><a href="#" class="custom">Cycle Route</a></li>
				<li><a href="#" class="custom">Find Place</a></li>
				<li><a href="#" class="custom">Find Carpark</a></li>
				<li><a href="#" class="custom">Train</a></li>
				<li><a href="#" class="custom">Flight</a></li>
				<li><a href="#" class="custom">Carpooling</a></li>
			</ul>
			<!-- ENDS side-block -->
			
			<!-- side-block -->
			<ul class="side-block">
				<li><a href="#" class="custom">Tips</a></li>
				<li><a href="#" class="custom">Heating</a></li>
				<li><a href="#" class="custom">Driving</a></li>
				<li><a href="#" class="custom">Energy</a></li>
				<li><a href="#" class="custom">Carbon</a></li>
			</ul>
			<!-- ENDS side-block -->


		</div>
		<!-- ENDS sidebar -->
	
		<ul id="portfolio-list" class="gallery">
		
			<li class="cat-images">
				<a href="ShowPic?type=transport" rel="prettyPhoto[images]">
				<span></span>
				<img src="img/transportcarbon.jpg" alt="Image" /></a>
				<em>Check Your Transport Carbon</em>
			</li>
			
			<li class="cat-images">
				<a href="ShowPic?type=house" rel="prettyPhoto[images]">
				<span></span>
				<img src="img/housecarbon.jpg" alt="Image" /></a>
				<em>Check Your Home Carbon</em>
			</li>
			
			<li class="cat-images">
				<a href="ShowPic?type=total" rel="prettyPhoto[images]">
				<span></span>
				<img src="img/totalcarbon.jpg" alt="Image" /></a>
				<em>Check Your Home Carbon</em>
			</li>
		</ul>
		
	</div>
	<!-- ENDS MAIN -->
	
	
	
	
	
	
	
	</div>
	<!-- ENDS WRAPPER -->
	
	
	
	<!-- FOOTER -->
	<div id="footer">
		<div id="footer-wrapper">
			
			<ul id="follow">
				<li><p>Follow us: </p></li>
				<li><a href="#"><img src="img/twitter.png" alt="Twitter" /></a></li>
				<li><a href="#"><img src="img/facebook.png" alt="Facebook" /></a></li>
				<li><a href="#"><img src="img/linkedln.png" alt="Facebook" /></a></li>
			</ul>
		
			<div class="footer-cols">
				<div>
					<ul>
						<li><a href="#" class="custom">New Journey</a></li>
						<li><a href="#">Car park</a></li>
						<li><a href="#">Place</a></li>
						<li><a href="#">Car Route</a></li>
						<li><a href="#">Cycle route</a></li>
					</ul>
				</div>
				<div>
					<ul>
						<li><a href="#" class="custom">Decisions</a></li>
						<li><a href="#">Heating Tips</a></li>
						<li><a href="#">Driving Tips</a></li>
						<li><a href="#">Saving Energy</a></li>
					</ul>
				</div>
				<div>
					<ul>
						<li><a href="blog.html" class="custom">Personal Information</a></li>
						<li><a href="#">Show</a></li>
						<li><a href="#">Edit</a></li>
						<li><a href="#">Edit</a></li>
					</ul>
				</div>
				<div class="last">
					<ul>
						<li><a href="about.html" class="custom">Contact us</a></li>
						<li><a href="#">Email</a></li>
						<li><a href="#">Twitter</a></li>
						<li><a href="#">FaceBook</a></li>
						<li><a href="#">LinkedIn</a></li>
					</ul>
				</div>
			</div>
			
			<div class="footer-bottom">
				<p class="legal">By Xiaoxing</p>
			</div>

		</div>
	</div>
	<!-- ENDS FOOTER -->
	
	
	<!-- start cufon -->
	<script type="text/javascript"> Cufon.now(); </script>
	<!-- ENDS start cufon -->
	
	</body>
</html>
