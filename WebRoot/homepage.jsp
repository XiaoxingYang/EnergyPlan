<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">  
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="en" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<script src="http://jqueryjs.googlecode.com/files/jquery-1.3.2.min.js" type="text/javascript"></script>
		<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
		
		<title>Low Carbon Journey</title>
		
		
		
		
		
		<!-- JS -->
		<script type="text/javascript" src="js/jquery_1.3.2.js"></script>
		<script type="text/javascript" src="js/jqueryui.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>
		<script type="text/javascript" src="js/jquery.cycle.all.js"></script>
		<script type="text/javascript" src="js/custom.js"></script>
		<script type="text/javascript" src="js/homecollect.js"></script>
		<!-- ENDS JS -->
		
		
		
		<!-- superfish -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/superfish-custom.css" /> 
		<script type="text/javascript" src="js/superfish-1.4.8/js/hoverIntent.js"></script> 
		<script type="text/javascript" src="js/superfish-1.4.8/js/superfish.js"></script> 
		<!-- ENDS superfish -->
		
		
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
			
			<!-- slideshow -->
			<div id="slideshow">
				<ul id="slides">
	                <li><img src="slides/homepage1.jpg"  alt="Imagen" /></li>
	                <li><img src="slides/homepage3.jpg"  alt="Imagen" /></li>
	                <li><img src="slides/homepage4.jpg"  alt="Imagen" /></li>
	          	</ul>
	          	<span></span>
	          	<a href="#"><img src="img/prev-slide.png"  alt="Prev" id="prev" /></a>
	          	<a href="#"><img src="img/next-slide.png"  alt="Next" id="next" /></a>
			</div>
			<!-- ENDS slideshow -->

			
			
			<!-- blocks -->
			<div class="holder">
				
				<div class="block">
					<div class="thumb-holder">
						<a href="#" ><img src="img/dummies/working.png" alt="Thumb" class="thumb" title="Hola tooltup" /> </a>
					</div>
					<h2 class="custom">OFFICE</h2>
					<h5 class="custom color2">EVERYDAY DESTINATION</h5>
					<p class="thumb-text"></p>
					<table id="workingTable">
				  	<% 
				  	if(((String)request.getAttribute("workingaddr")).equalsIgnoreCase("")){%>
				    <tr>
				    <td>
				    <p class="thumb-text2">Working Address is empty. Click more to edit it.</p>
				    </td>
				    </tr>
				    <% }else{
				    String[] workingaddrs = ((String)request.getAttribute("workingaddr")).split("@");
				    for(int i = 0; i < workingaddrs.length; i ++){%>
				    <tr>
				    <td>
				    <a class="text" onclick="getRoute('<%=workingaddrs[i] %>')"><%=workingaddrs[i] %></a>
				    </td>
				    </tr>
				    <%} }%>
				  	</table>
					<p><a href="ShowPersonInfoServlet" class="more">EDIT</a></p>
				</div>
				
				<div class="block">
					<div class="thumb-holder">
						<a href="gallery.html" ><img src="img/dummies/meeting.png" alt="Thumb" class="thumb" /> </a>
					</div>
					<h2 class="custom">MEETING</h2>
					<h5 class="custom color2">SOMETIMES DESTINATION</h5>
					<p class="thumb-text"></p>
					<table id="meetingTable" >
				    <% 
				  	if(((String)request.getAttribute("meetingaddr")).equalsIgnoreCase("")){%>
				    <tr>
				    <td>
				    <p class="thumb-text2">Meeting Address is empty. Click more to edit it.</p>
				    </td>
				    </tr>
				    <% }else{
				    String[] meetingaddrs = ((String)request.getAttribute("meetingaddr")).split("@");
				    for(int i = 0; i < meetingaddrs.length; i ++){%>
				    <tr>
				    <td>
				    <a class="text" onclick="getRoute('<%=meetingaddrs[i] %>')"><%=meetingaddrs[i] %></a>
				    </td>
				    </tr>
				    <%}} %>
				    </table>
					<p><a href="ShowPersonInfoServlet" class="more">EDIT</a></p>
				</div>
				
				<div class="block last">
					<div class="thumb-holder">
						<a href="gallery.html" ><img src="img/dummies/shopping.png" alt="Thumb" class="thumb" /> </a>
					</div>
					<h2 class="custom">LEISURE</h2>
					<h5 class="custom color2">TAKE A REST</h5>
					<p class="thumb-text"></p>
					<table id="leisureTable" >
				    <% 
				  	if(((String)request.getAttribute("leisureaddr")).equalsIgnoreCase("")){%>
				    <tr>
				    <td>
				    <p class="thumb-text2">Meeting Address is empty. Click more to edit it.</p>
				    </td>
				    </tr>
				    <% }else{ 
				    String[] leisureaddrs = ((String)request.getAttribute("leisureaddr")).split("@");
				    for(int i = 0; i < leisureaddrs.length; i ++){%>
				    <tr>
				    <td>
				    <a class="text" onclick="getRoute('<%=leisureaddrs[i] %>')"><%=leisureaddrs[i] %></a>
				    </td>
				    </tr>
				    <%}} %>
				    </table>
					<p><a href="ShowPersonInfoServlet" class="more">EDIT</a></p>
				</div>	
				
				<div class="block">
					<div class="thumb-holder">
						<a href="#" ><img src="img/dummies/trip.jpg" alt="Thumb" class="thumb" title="Hola tooltup" /> </a>
					</div>
					<h2 class="custom">TRIP</h2>
					<h5 class="custom color2">TRIPS DESTINATION</h5>
					<p class="thumb-text"></p>
					<table id="frequentTable">
				    <% 
				  	if(((String)request.getAttribute("frequentaddr")).equalsIgnoreCase("")){%>
				    <tr>
				    <td>
				    <p class="thumb-text2">Trip Address is empty. Click more to edit it.</p>
				    
				    </td>
				    </tr>
				    <% }else{
				    String[] frequentaddrs = ((String)request.getAttribute("frequentaddr")).split("@");
				    for(int i = 0; i < frequentaddrs.length; i ++){%>
				    <tr>
				    <td>
				    <a class="text" onclick="getRoute('<%=frequentaddrs[i] %>')"><%=frequentaddrs[i] %></a>
				    </td>
				    </tr>
				    <%} }%>
				  	</table>
					<p><a href="ShowPersonInfoServlet" class="more">EDIT</a></p>
				</div>
					
				<div class="block">
					<div class="thumb-holder">
						<a href="#" ><img src="img/dummies/home.png" alt="Thumb" class="thumb" title="Hola tooltup" /> </a>
					</div>
					<h2 class="custom">HOME</h2>
					<h5 class="custom color2">STAY AT HOME</h5>
					<p class="thumb-text"></p>
					<table id="homeTable">
				    <% 
				  	if(((String)request.getAttribute("homeaddr")).equalsIgnoreCase("")){%>
				    <tr>
				    <td>
				    <p class="thumb-text2">Home information is empty. Click more to edit it.</p>
				    </td>
				    </tr>
				    <% }else{%>
				    <tr>
				    <td>
				    <p class="thumb-text2">How Long are you going to stay?</p>
				    <form action="StayHomeServlet" method="post">
					    <input type="text" class="text" id="homehour" name="homehour"/> hours<br/>
					    <input type="submit" value="" id="send" class="send" />
				    </form>
				     
				    </td>
				    </tr>
				    <% }%>
				  	</table>
					
					
					<p><a href="ShowPersonInfoServlet" class="more">EDIT</a></p>
				</div>			
			</div>
			<!-- ENDS blocks -->
			
			
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
