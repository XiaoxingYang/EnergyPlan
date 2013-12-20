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
		<a href="index.html"><img src="img/logo.png" alt="Logo" id="logo" /></a>
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
			<p class="post-title custom">PLAN A NEW JOURNEY</p>
			<div class="post-img"><img src="img/dummies/path.jpg" alt="Image" /></a><span></span></div>
		</div>
		<!-- ENDS single-post -->
		
		<div id="main">
		
		<!-- left-content -->
		<div class="contact-left">
			<h5 class="custom">Use the form below to start a new journey</h5>
			<!-- form -->
			<form action="SaveSessionServlet" method="post">
				<fieldset>
					<p>
						<label>DEPARTURE:</label>
						<input class="brief" type="text" name="departure" id="departure" style="vertical-align:middle;width:180px;" /><a class="text" id="departure-link" href="#">Get my position</a>
					</p>
					<p>
						<label>DESTINATION:</label>
						<input class="brief" type="text" name="destination" id="destination" style="vertical-align:middle;width:180px;"/><a  class="text" id="destination-link" href="#">Get my position</a>
					</p>
					<p>
						<label>TIME:</label>
						<input  class="text" class="brief" id="date" name="date" type="text" onclick="new Calendar(null, null, 1).show(this);" style="vertical-align:middle;width:180px;" readonly="readonly" />
		 	
					    <select name="hour" id="hour" >
					     <option value="00">00</option>
					     <option value="01">01</option>
					     <option value="02">02</option>
					     <option value="03">03</option>
					     <option value="04">04</option>
					     <option value="05">05</option>
					     <option value="06">06</option>
					     <option value="07">07</option>
					     <option value="08">08</option>
					     <option value="09">09</option>
					     <option value="10">10</option>
					     <option value="11">11</option>
					     <option value="12">12</option>
					     <option value="13">13</option>
					     <option value="14">14</option>
					     <option value="15">15</option>
					     <option value="16">16</option>
					     <option value="17">17</option>
					     <option value="18">18</option>
					     <option value="19">19</option>
					     <option value="20">20</option>
					     <option value="21">21</option>
					     <option value="22">22</option>
					     <option value="23">23</option>
					    </select>
					  :  
					    <select name="minute" id="minute" >
					     <option value="00">00</option>
					     <option value="15">15</option>
					     <option value="30">30</option>
					     <option value="45">45</option>
					    </select>
					</p>
					<p>
						<label>PEOPLE:
						<select name="people" id="people"><option value="1">1</option>
					    <option value="2">2</option>
					    <option value="3">3</option>
					    <option value="4">4</option>
					    <option value="5">5</option>
					    <option value="6">6</option>
					    <option value="7">7</option>
					    <option value="8">8</option>
					    <option value="9">9</option></select></label>
					</p>
						
					<p><input type="submit" value=" " name="send" id="send" /></p>
				</fieldset>
				<p id="error">Message</p>
			</form>
			<p id="success">Thanks for your support.</p>
			<!-- ENDS form -->
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
				<li><a href="findCarRoute.jsp" class="custom"><span>Car Route</span></a></li>
				<li><a href="findBicycleRoute.jsp" class="custom">Cycle Route</a></li>
				<li><a href="findPlace.jsp" class="custom">Find Place</a></li>
				<li><a href="findCarpark.jsp" class="custom">Find Carpark</a></li>
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
