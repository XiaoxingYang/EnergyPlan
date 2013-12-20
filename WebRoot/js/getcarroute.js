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
		  
		  	calcDrivingRoute();
		 	//setTimeout('toServlet()',3000);
		  }
	
		function calcDrivingRoute() {
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
		      var route = '{"driving":[';
		      for(var i = 0; i < response.routes.length; i ++){
		      	var distanceText = response.routes[i].legs[0].distance.text;
			    var distance = response.routes[i].legs[0].distance.value;
			    var durationText = response.routes[i].legs[0].duration.text;
			    var duration = response.routes[i].legs[0].duration.value;
			    route += '{"distanceText":"'+distanceText+'","distance":'+distance+',"durationText":"'+durationText+'","duration":'+duration+'}';
		      	if(i!=response.routes.length-1){
		      		route += ',';
		      	}
		      }
		      route += ']}';
		      window.location.href = "GetSingleRouteFromGoogleServlet?driving="+route;
		     
		      }
		  });
		}