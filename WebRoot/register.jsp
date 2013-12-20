<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,java.util.*,com.yxx.model.*"  errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">  
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
		<script type="text/javascript" src="js/filterable.pack.js"></script>
		<script type="text/javascript" src="js/prettyPhoto/js/jquery.prettyPhoto.js"></script>
		<script type="text/javascript" src="js/custom.js"></script>
		<script type="text/javascript" src="js/register.js"></script>
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
		<a href="ShowHomeServlet.html"><img src="img/logo.png" alt="Logo" id="logo" /></a>
		<form action="" method="post" id="search">
			<p><input type="text" onfocus="defaultInput(this)" onblur="clearInput(this)" name="keyword" id="keyword" title="Search..." value="Search..."/></p>
			<p><input type="submit" id="go" value="" /></p>
			<div class="clear"></div>
		</form>
	</div>
	<!-- ENDS HEADER -->
	
	
	
	
	
	

		
	<!-- MAIN -->
	<div id="main">
	 <form id="infoForm" method="post">
		<p class="section-title"><span class="title custom">REGISTER</span><span class="desc">PLEASE FILL THE FORM</span>
		<input name="save" type="button"  value="Save" onclick="checkBlank()"/>
		</p>
		<!-- filter -->
		<ul id="portfolio-filter">
	    	<li>BASIC PERSONAL INFORMATION:</li>
		</ul>
		<!-- filter -->
		
		<!-- basic information -->
		<div class="edit">
		
		<!-- right-content -->
		<div class="contact-right">
		<div class="taped-image"><span></span><img src="img/personalinfo.jpg" alt="map"/></div>
		</div>
		<!-- ENDS right-content -->
		<span></span>
		<table id="search" class="table">
	    	<tbody>
			<tr >
	  		<td  align="center" >Username*</td>
			<td  align="center"><input name="username" type="text" /></td>
	  		</tr>
	   		
	   		<tr >
	  		<td  align="center">Password*</td>
			<td  align="center"><input name="password" type="text" /></td>	  		</tr>
	  		
	  		<tr >
	  		<td  align="center">Identity*</td>
			<td  align="center">
			<select name="usertype" id="usertype">
			  <option>student</option>
			  <option>teacher</option>
			</select>		</td>
	  		</tr>
	  		
	  		<tr>
	  		<td  align="center">Email*</td>
			<td  align="center"><input name="email" type="text" /></td>	  		</tr>
		</tbody>
		</table>
		
		</div>
		
		<!-- END basic information -->
		
		
		
		
		<!-- filter -->
		<ul id="portfolio-filter">
	    	<li>ENERGY PLAN:</li>
		</ul>
		<!-- filter -->
		
		<!-- energy information -->
		
		<div class="edit">
		<!-- right-content -->
		<div class="contact-right">
		<div class="taped-image"><span></span><img src="img/energyinfo.jpg" alt="map"/></div>
		</div>
		<!-- ENDS right-content -->
		<span></span>
		<table id="search" class="table">
	    	<tbody>
	  		<tr >
	  		<td  align="center">Plan*</td>
			<td  align="center">
			<select name="plan" id="plan">
			  <option>Energy Saving</option>
			  <option>Time Saving</option>
			  <option>Money Saving</option>
			</select>		</td>
	  		</tr>
	  		
	  		<tr >
	  		<td  align="center">Carbon Plan*</td>
			<td  align="center">
			<select name="carbonplan" id="carbonplan">
			  <option>2000</option>
			  <option>3000</option>
			  <option>4000</option>
			  <option>5000</option>
			  <option>6000</option>
			</select>		</td>
	  		</tr>
		</tbody>
		</table>
		<!-- more galleries -->
		<div class="one-col">
			
			<div class="col">
				
				<h3 class="custom title-1">EXPLINATION</h3>
				
				<h5 class="toggle-trigger custom"><a href="#">PLAN</a></h5>
				<div class="toggle-container">
					<div class="block">
						<ul class="more-galleries ">
							<p>Energy Saving will get the greenest way to implement your task.<br/> 
							Time Saving will get the quickest way to implement your task.<br/>
							Money Saving will get the most economical way to implement your task.</p> 
							
						</ul>
					</div>
				</div>
				
				<h5 class="toggle-trigger custom"><a href="#">CARBON PLAN</a></h5>
				<div class="toggle-container">
					<div class="block">
						
						<ul class="more-galleries ">
							<p> The world average carbon emission is 4000 kg per year. </p> 
							
						</ul>
					</div>
				</div>
			</div>
			
						
		</div>
		<!-- ENDS more galleries -->
		
		</div>
		
		<!-- END energy information -->
		
		<!-- filter -->
		<ul id="portfolio-filter">
	    	<li>TRANSPORT INFORMATION:</li>
		</ul>
		<!-- filter -->
		<!-- transport information -->
		
		<div class="edit">
		<!-- right-content -->
		<div class="contact-right">
		<div class="taped-image"><span></span><img src="img/MAPS-3.jpg" alt="map"/></div>
		</div>
		<!-- ENDS right-content -->
		<span></span>
		<table id="search" class="table">
	    	<tbody>
		  		
	  		<tr >
	  		<td  align="center">Home Address</td>
			<td  align="center"><input name="homeaddr" type="text" /></td>
	  		</tr>
	  		
	  		<tr >
	  		<td  align="center">Working/School Addr</td>
	  		<td>
	  		<table id="workingaddr" align="center" style="border: 0px; width: 300px" >
	  		<tr><td  align="center"><input name="dailydestination" type="text" /></td></tr>
			<tr style="border: 0px">
			<td>
			<input type="button" value="add" onclick='addRow("workingaddr")'/>
			<input type="button" value="delete" onclick='deleteRow("workingaddr")'/>
			</td>
			</tr>
			</table>
			</td>
	  		</tr>
	  		
	  		<tr >
	  		<td  align="center">Meeting Address</td>
	  		<td>
	  		<table id="meetingaddr" align="center" style="border: 0px; width: 300px" >
	  		<tr><td  align="center"><input name="dailydestination" type="text" /></td></tr>
			<tr style="border: 0px">
			<td>
			<input type="button" value="add" onclick='addRow("meetingaddr")'/>
			<input type="button" value="delete" onclick='deleteRow("meetingaddr")'/>
			</td>
			</tr>
			</table>
			</td>
	  		</tr>
	  		
	  		<tr >
	  		<td  align="center">Leisure Address</td>
	  		<td>
	  		<table id="leisureaddr" align="center" style="border: 0px; width: 300px" >
	  		<tr><td  align="center"><input name="dailydestination" type="text" /></td></tr>
			<tr style="border: 0px">
			<td>
			<input type="button" value="add" onclick='addRow("leisureaddr")'/>
			<input type="button" value="delete" onclick='deleteRow("leisureaddr")'/>
			</td>
			</tr>
			</table>
			</td>
	  		</tr>
	  		
	  		<tr >
	  		<td  align="center">Frequent Destination</td>
	  		<td>
	  		<table id="frequentaddr" align="center" style="border: 0px; width: 300px" >
	  		<td  align="center"><input id="dailydestination" name="dailydestination" type="text" /></td>
			<tr style="border: 0px">
			<td>
			<input type="button" value="add" onclick='addRow("frequentaddr")'/>
			<input type="button" value="delete" onclick='deleteRow("frequentaddr")'/>
			</td>
			</tr>
	   	  </table>   	 </td>
	  		</tr>
		</tbody>
		</table>
		
		</div>
		
		<!-- END house information -->
		
		<!-- filter -->
		<ul id="portfolio-filter">
	    	<li>HOUSE INFORMATION:</li>
		</ul>
		<!-- filter -->
		<!-- transport information -->
		
		<div class="edit">
		<!-- right-content -->
		<div class="contact-right">
		<div class="taped-image"><span></span><img src="img/homeheating1.jpg" alt="map"/></div>
		</div>
		<!-- ENDS right-content -->
		<span></span>
		<table id="search" class="table">
	    	<tbody>
	  		<tr>
	  		<td  align="center">HouseType</td>
			<td  align="center">
			<select name="housetype" id="housetype">
			  <option>Small house/flat</option>
			  <option>Medium</option>
			  <option>Large house</option>
			</select>		</td>
	  		</tr>
	  		<tr>
	  		<td  align="center">People</td>
			<td  align="center">
			<select name="housepeople" id="housepeople">
			  <option>1</option>
			  <option>2</option>
			  <option>3</option>
			  <option>4</option>
			  <option>5</option>
			  <option>6</option>
			</select>		
			</td></tr>
	  		<tr>
	  		<td  align="center">Heat type</td>
			<td  align="center">
			<select name="heattype" id="heattype">
			  <option>gas</option>
			  <option>electric</option>
			</select>		</td>
	  		</tr>
	  		<tr>
	  		<td  align="center">Temperature</td>
			<td  align="center">
			<select name="temperature" id="temperature">
			  <option value="cool">Cool (11-14°C)</option>
			  <option value="comfortable">Comfortable (14-17°C)</option>
			  <option value="warm">Warm (18-21°C)</option>
			  <option value="hot">Hot (over 22°C)</option>
			</select>		</td>
	  		</tr>
		</tbody>
		</table>
		<input name="save" type="button"  value="Save" onclick="collectData()"/>
	    </div>
		
		<!-- END house information -->
		
		
		
		
		
		


		
		
		</form>
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
