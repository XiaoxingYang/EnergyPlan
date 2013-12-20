<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Low Carbon Journey</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <style type="text/css">
  	.firstBG1{
  	width: 100%;
	background-image: url(image/firstBG1.png);
	background-position: top center;
	position: absolute;
	z-index: 200;
	margin-left: -8px;
	top: -120px;
	padding: 550px 0px 100px 0px;
	color: #ffffff;
  	}
  	.title {
	float: left;
	position: absolute;
	left: 10%;
	top: 150px;
	z-index: 300;
	margin-left: 200px;
	}
  	.firstBG2{
  	width: 100%;
	background-image: url(image/firstBG2.png);
	background-position: top center;
	position: absolute;
	z-index: 200;
	margin-left: -8px;
	top: 60px;
	padding: 330px 0px 100px 0px;
	color: #ffffff;
  	}
  	.fair{
  	width: 100%;
	background-image: url(image/fair.png);
	background-position: top center;
	position: absolute;
	z-index: 250;
	margin-left: -8px;
	top: 307px;
	padding: 235px 0px 100px 0px;
	color: #ffffff;
  	}
	.ferris {
	float: left;
	position: absolute;
	left: 50%;
	top: 320px;
	z-index: 300;
	margin-left: 230px;
	}
	.rollercoasterCar {
	float: left;
	position: absolute;
	left: 50%;
	margin-left: -523px;
	z-index: 250;
	top: 283px;
	}
	.rollercoaster {
	float: left;
	position: absolute;
	left: 50%;
	margin-left: -523px;
	z-index: 300;
	top: 283px;
	}
	.login {
	float: right;
	position: absolute;
	right: 10%;
	margin-right: 100px;
	z-index: 350;
	top: 500px;
	}
	.register{
	color: #4ECDC4;
	text-decoration: none;
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font-family: "Comic Sans MS", cursive;
	vertical-align: baseline;
	}
	.submit{
	font-family: "Comic Sans MS", cursive;
	color: #4ECDC4;
	background-color: #FFF;
	border:0;
	font-weight: bold;
	height: 25px;
	width: 60px;
	}
	</style>
  </head>
  
  <body>
  	<div class="firstBG1"></div>
  	<div class="firstBG2"></div>
  	<div class="title"><img src="image/title.png" alt="low carbon journey"></div>
  	<div class="fair"></div>
  	<div class="ferris"><img src="image/ferris.gif" alt="ferris wheel"></div>
	<div class="rollercoasterCar"><img src="image/rollercoaster.gif" alt="rollercoaster"></div>
	<div class="rollercoaster"><img src="image/rollercoaster_bkg.png" alt="rollercoaster"></div>
  	<div class="login">
  	<form action="CheckUserServlet" method="post">
  	<input type="text" name="username" onFocus="javascript:if('username'==this.value)this.value=''" onBlur="javascript:if(''==this.value)this.value='username'" value='username'>
  	<input type="password" name="password" onFocus="javascript:if('password'==this.value)this.value=''" onBlur="javascript:if(''==this.value)this.value='password'" value='password'>
  	<input class="submit" type="submit" value="login">
  	<a class="register" href="register.jsp">new user?</a>
  	</form>
  	</div>
    
  </body>
</html>
