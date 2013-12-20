<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,java.util.*,com.yxx.model.*"  errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"  xml:lang="en" lang="en">  
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
		<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
		
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
		<p class="section-title"><span class="title custom">DECISIONS</span><span class="desc"></span></p>
		<!-- filter -->
		<ul id="portfolio-filter">
	    	<li>ALL YOUR DECISIONS</li>
		</ul>
		<!-- filter -->
		<div class="top-img">
		<% 
    	ArrayList al = (ArrayList)request.getAttribute("decision");	
		%>
		<form name="optiontable">
	    <table id="searchresult"   class="table" align="center">
	    	<thead>
	    	<tr style="height: 50px" valign="baseline">
	    	<td style="width: 100px" align="center">DecisionId</td>
    		<td style="width: 180px" align="center">Home Hour</td>
    		<td style="width: 180px" align="center">Carbon</td>
    		</tr>
	    	</thead>
	    	<tbody>
	    	<%
    			for(int i = 1; i<=al.size();i++){
   					HomeDecisionBean tb = (HomeDecisionBean)al.get(i-1);
	    			%>
	    			<tr align="center">
	    			<td align="center"><%=tb.getDecisionId() %></td>
					<td align="center"><%=tb.getHomehour() %></td>
   					<td align="center"><%=tb.getCarbon() %>kg</td>
			    		
		    			<%
		    		}
		    	 %>
		    	 </tr>
		   	    </tbody>
		   	  </table>
		   	  </form>		
	        <img src="img/bottom-shadow.png"  alt="Img" class="bottom-shadow" />
	        <%
		   	  int pageNow = ((Integer)request.getAttribute("pageNow")).intValue();
		   	  int pageCount = ((Integer)request.getAttribute("pageCount")).intValue();
		   	 	
		   	  if(pageNow!=1){
			   	  out.print("<a href=ShowHomeDecisionServlet?pageNow="+(pageNow-1)
			   	 +">previous</a>&nbsp");
		   	  }
		   	  
		   	  for(int i =1;i<=pageCount;i++){
			   	  out.print("<a href=ShowHomeDecisionServlet?pageNow="+i
			   	  +">"+i+"</a>&nbsp");
		   	  }
		   	  
		   	  if(pageNow!=pageCount){
			   	  out.print("<a href=ShowHomeDecisionServlet?pageNow="+(pageNow+1)
			   	  +">next</a>&nbsp");
		   	  }
		   	  %>
		</div>

		
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
