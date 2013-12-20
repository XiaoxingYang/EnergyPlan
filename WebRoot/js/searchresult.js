function radioAction(index){
	var vehicle = document.getElementById("searchresult").rows[index].cells[0].innerHTML;
	var routeNo = document.getElementById("searchresult").rows[index].cells[1].innerHTML;
	var cost = document.getElementById("searchresult").rows[index].cells[6].innerHTML;
	document.getElementById("totalCost").innerHTML = "This decision would produce:"+cost;
	if(parseFloat(cost)>=5.0){
		document.getElementById("stayhome").innerHTML = "Stay at home will be greener (average 12 kg per day)."
	}else{
		document.getElementById("stayhome").innerHTML = "You've made a good choice."
	}
	calcDrivingRoute(Number(routeNo),vehicle);

}

function confirmOption(){
	for(var i=1;i<=5;i++){
	  if(document.getElementById("radiobutton"+i).checked){
		  var vehicle = document.getElementById("searchresult").rows[i].cells[0].innerHTML;
		  var routeNo = document.getElementById("searchresult").rows[i].cells[1].innerHTML;
		  javacript:location.href="AddDecisionServlet?vehicle="+vehicle+"&routeNo="+routeNo;
	  }
	}
}

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


function initialize() {
  
  geocoder = new google.maps.Geocoder();
  directionsDisplay = new google.maps.DirectionsRenderer();
  var mapOptions = {
    zoom: 7,
    mapTypeId: google.maps.MapTypeId.ROADMAP,
    center: new google.maps.LatLng(41.850033, -87.6500523)
  };
  var map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);
  directionsDisplay.setMap(map);
  directionsDisplay.setPanel(document.getElementById('directions-panel'));
  
  }

function calcDrivingRoute(routeNo,selectedMode) {
  var request = {
    origin: start,
    destination: end,
     	travelMode: google.maps.TravelMode[selectedMode],
     	provideRouteAlternatives: true,
     	transitOptions: {
     	  departureTime: departureTime
     	}
  };
  directionsService.route(request, function(response, status) {
    if (status == google.maps.DirectionsStatus.OK) {
      directionsDisplay.setDirections(response);
      directionsDisplay.setRouteIndex(routeNo);
      
      }
  });
}