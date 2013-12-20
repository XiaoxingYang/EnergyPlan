function openPop(){
		
		document.getElementById('loginbg').style.display='block';
		document.getElementById('login').style.display='block';
		showPop();
	}
	function closePop(){
		document.getElementById('loginbg').style.display='none';
		document.getElementById('login').style.display='none';
	}
	function showPop(){
		var sWidth,sHeight;
		sWidth = screen.width;
		sWidth = document.body.offsetWidth;
		sHeight=document.body.offsetHeight;
		if (sHeight<screen.height){sHeight=screen.height;}
		document.getElementById("loginbg").style.width = sWidth + "px";
		document.getElementById("loginbg").style.height = sHeight + "px";
		document.getElementById("loginbg").style.display = "block";
		document.getElementById("loginbg").style.display = "block";
		document.getElementById("loginbg").style.right = document.getElementById("login").offsetLeft + "px";
	}
	function confirmOption(){
		for(var i=1;i<=5;i++){
		  if(document.getElementById("radiobutton"+i).checked){
			var v = document.getElementById("radiobutton"+i).value;
			var list = v.split(" ");
			var vehicle = list[0];
			var routeNo = list[1];
			javacript:location.href="AddDecisionServlet?vehicle="+vehicle+"&routeNo="+routeNo;
		  }
		}
	}

	 
	function radioAction(index){
		var v = document.getElementById("radiobutton"+index).value;
		var list = v.split(" ");
		var vehicle = list[0];
		var routeNo = list[1];
		var cost = document.getElementById("search").rows[index].cells[6].innerHTML;
		document.getElementById("totalCost").innerHTML = cost;
		calcDrivingRoute(routeNo,vehicle);
		
	}
	