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
  calcDrivingRoute(routeNo);
  }

function calcDrivingRoute(routeNo) {
  var request = {
    origin: start,
    destination: end,
     	travelMode: google.maps.TravelMode.DRIVING,
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