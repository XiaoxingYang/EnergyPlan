<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,java.util.*,com.yxx.model.*"  errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"  xml:lang="en" lang="en">  
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="http://jqueryjs.googlecode.com/files/jquery-1.3.2.min.js" type="text/javascript"></script>
		<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
		<link href="http://code.google.com//apis/maps/documentation/javascript/examples/default.css" rel="stylesheet" type="text/css" />
		
		<meta http-equiv="Content-Language" content="en" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		
		<title>Low Carbon Journey</title>
		
		
		
		
		
		<!-- JS -->
		<script type="text/javascript" src="js/jquery_1.3.2.js"></script>
		<script type="text/javascript" src="js/jqueryui.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>
		<script type="text/javascript" src="js/jquery.cycle.all.js"></script>
		<script type="text/javascript" src="js/custom.js"></script>
		<script type="text/javascript" src="js/jquery.cycle.all.js"></script>
		<script type="text/javascript" src="js/filterable.pack.js"></script>
		<script type="text/javascript" src="js/prettyPhoto/js/jquery.prettyPhoto.js"></script>
		<script type="text/javascript" src="js/searchresult.js"></script>
		<script type="text/javascript">
	
		var directionsDisplay;
		var directionsService = new google.maps.DirectionsService();
		var geocoder;
		
		var start = "<%=session.getAttribute("departure") %>";
		var end = "<%=session.getAttribute("destination") %>";
		
		var now = new Date();
		var tzOffset = (now.getTimezoneOffset() + 60)*60*1000;
		var time = new Date();
		time.setHours(<%=session.getAttribute("hour")%>);
		time.setMinutes(<%=session.getAttribute("minute")%>);
		var ms = time.getTime() - tzOffset;
		if(ms < now.getTime()){ms += 24*60*60*1000;}
		var departureTime = new Date(ms);
		
		google.maps.event.addDomListener(window, 'load', initialize);
		
		function generateChart(){
		
		openPop();
		}
	
	</script>
		<!-- ENDS JS -->
		
		
		
		<!-- superfish -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/superfish-custom.css" /> 
		<script type="text/javascript" src="js/superfish-1.4.8/js/hoverIntent.js"></script> 
		<script type="text/javascript" src="js/superfish-1.4.8/js/superfish.js"></script> 
		<!-- ENDS superfish -->
		
		
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
	
	<div id="loginbg"></div>
	<div id="login" style="display:none;">
	<div class="chatu" align="center" style="margin-top: 30px;margin-bottom: 20px"><img src="img/sky.jpg"/></div>
	
	<div class="poptext" align="center">
	<%
	DecisionBeanOperator dbo = new DecisionBeanOperator();
	int count = dbo.getDecisionCount((String)session.getAttribute("username"));
	float accumulation = dbo.getCarbonAccumulation(count);
	UserBeanOperator ubo = new UserBeanOperator();
	float plan = ubo.getCarbonplan((String)session.getAttribute("username"));
	HomeDecisionOperation hdo = new HomeDecisionOperation();
	int count2 = hdo.getDecisionCount((String)session.getAttribute("username"));
	float accumulation2 = hdo.getCarbonAccumulation(count2);
	%>
	<div id="totalCost" ></div>
	You have already generated <%=accumulation %> kg CO2 in transport.<br/>
	Your carbon plan is: <%=plan %> kg CO2.<br/>
	<div id="stayhome"></div>
	
	 </div>
	 
	<div align="center" style="margin-top: 20px">
	<img src="img/confirm.png" id="confirm" onclick="confirmOption()" />
	<img src="img/stayhome.png" id="home" onclick="window.location.href='StayHomeServlet?homehour=8'" />
	<img src="img/close.png" id="cancel" onclick="closePop()" />
	</div>
	</div>
	
	
	
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
		<p class="section-title"><span class="title custom">Routes</span><span class="desc">CHOOSE ONE FROM THE FOLLOWING</span></p>
		
		<!-- filter -->
		<ul id="portfolio-filter">
	    	<li>From <%=session.getAttribute("departure")%> to <%=session.getAttribute("destination") %></li>
		</ul>
		<!-- filter -->
		
		<input type="button" name="showallresult" value="More Options"  onclick="javascript:location.href='ShowAllOptionServlet'" />
		<input type="button" name="confirm" value="Confirm"  onclick="openPop()" />
		
		<div class="top-img">
		<% 
    	ArrayList al = (ArrayList)request.getAttribute("result"); 	
		%>
		<form name="optiontable">
	    <table id="searchresult" border="1" width="960" align="left" class="table">
	    	<thead>
	    	<tr style="height: 50px" valign="baseline">
	    	<td style="width: 50px; height: 30px" align="center">Vehicle</td>
	    	<td style="width: 30px; height: 30px" align="center">Route</td>
	    	<td style="width: 200px; height: 30px" align="center">Leave</td>
	    	<td style="width: 200px; height: 30px" align="center">Arrive</td>
	    	<td style="width: 150px; height: 30px" align="center">Duration</td>
	    	<td style="width: 60px; height: 30px" align="center">Distance</td>
	    	<td style="width: 80px; height: 30px" align="center">Carbon</td>
	    	<td style="width: 50px; height: 30px" align="center">Select</td></tr>
	    	</thead>
	    	<tbody>
	    	<%
	    		for(int i = 1; i<=al.size();i++){
	    			TransportBean tb = (TransportBean)al.get(i-1);
	    			%>
	    			<tr align="center">
	    			<td style="height: 30px"><%=tb.getVehicle() %></td>
	    			<td style="height: 30px"><%=tb.getRouteNo() %></td>
	    			<td style="height: 30px"><%=tb.getLeavingTime() %></td>
	    			<td style="height: 30px"><%=tb.getArrivingTime() %></td>
	    			<td style="height: 30px"><%=tb.getDurationText()%></td>
	    			<td style="height: 30px"><%=tb.getDistanceText()%></td>
	    			<td style="height: 30px"><%=tb.getCarbon()%>kg</td>
	    			<td style="height: 30px" align="center">
	    			
		    			<input type="radio" name="radiobutton" id="radiobutton<%=i%>" 
		    			value="<%=tb.getVehicle()%> <%=tb.getRouteNo() %>" 
		    			onclick="radioAction(<%=i%>)"/>   		
		    		</td>
			    		
		    			<%
		    		}
		    	 %>
		    	 </tr>
		   	    </tbody>
		   	  </table>
		   	  </form>		
	        <img src="img/bottom-shadow.png"  alt="Img" class="bottom-shadow" />
		</div>
		
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
		
		
		
		
		<!-- two col -->
		<div class="all"id="all">
	  	<div class="directions-panel" id="directions-panel"></div>
	    <div class="map-canvas" align="center" id="map-canvas"></div>
	  </div>
		<!-- ENDS two col -->
		
		
		
		
		
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
