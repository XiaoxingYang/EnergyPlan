
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
		  	calcWalkingRoute();
		 	calcBicyclingRoute();
		 	calcTransitRoute();
		 	setTimeout('toServlet()',5000);
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
		      var Json = JSON.parse(route);
		      $.ajax({
			    type : 'POST',
			    dataType : 'json',
			    data: {driving: JSON.stringify(Json)},
			    url : 'GetRouteFromGoogleServlet',
			    success : function(data, textStatus) {
			        // whatever
			    },
			    error : function(xhr, textStatus, errorThrown) {
			        // whatever
			    }
			 });
		      }
		  });
		}
		
		
		function calcWalkingRoute() {
		  var request = {
		    origin: start,
		    destination: end,
	      	travelMode: google.maps.TravelMode.WALKING,
	      	provideRouteAlternatives: true,
	      	transitOptions: {
	      	  departureTime: departureTime
	      	}
		  };
		  directionsService.route(request, function(response, status) {
		    if (status == google.maps.DirectionsStatus.OK) {
		      directionsDisplay.setDirections(response);
		      var route = '{"walking":[';
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
		      var Json = JSON.parse(route);
		      $.ajax({
			    type : 'POST',
			    dataType : 'json',
			    data: {walking: JSON.stringify(Json)},
			    url : 'GetRouteFromGoogleServlet',
			    success : function(data, textStatus) {
			        // whatever
			    },
			    error : function(xhr, textStatus, errorThrown) {
			        // whatever
			    }
			 });
		      }
		  });
		}
		
		
		function calcBicyclingRoute() {
		  var request = {
		    origin: start,
		    destination: end,
	      	travelMode: google.maps.TravelMode.BICYCLING,
	      	provideRouteAlternatives: true,
	      	transitOptions: {
	      	  departureTime: departureTime
	      	}
		  };
		  directionsService.route(request, function(response, status) {
		    if (status == google.maps.DirectionsStatus.OK) {
		      directionsDisplay.setDirections(response);
		      var route = '{"bicycling":[';
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
		      var Json = JSON.parse(route);
		      $.ajax({
			    type : 'POST',
			    dataType : 'json',
			    data: {bicycling: JSON.stringify(Json)},
			    url : 'GetRouteFromGoogleServlet',
			    success : function(data, textStatus) {
			        // whatever
			    },
			    error : function(xhr, textStatus, errorThrown) {
			        // whatever
			    }
			 });
		      }
		  });
		}
		
		function calcTransitRoute() {
		  var request = {
		    origin: start,
		    destination: end,
	      	travelMode: google.maps.TravelMode.TRANSIT,
	      	provideRouteAlternatives: true,
	      	transitOptions: {
	      	  departureTime: departureTime
	      	}
		  };
		  directionsService.route(request, function(response, status) {
		    if (status == google.maps.DirectionsStatus.OK) {
		      directionsDisplay.setDirections(response);
		      var route = '{"transit":[';
		      for(var i = 0; i < response.routes.length; i ++){
		      	var distanceText = response.routes[i].legs[0].distance.text;
			    var distance = response.routes[i].legs[0].distance.value;
			    var durationText = response.routes[i].legs[0].duration.text;
			    var duration = response.routes[i].legs[0].duration.value;
			    var departure_time = response.routes[i].legs[0].departure_time.value;
			    var arrival_time = response.routes[i].legs[0].arrival_time.value;
			    route += '{"distanceText":"'+distanceText+'","distance":'+distance+',"durationText":"'+durationText+'","duration":'+duration+',"departure_time":"'+departure_time+'","arrival_time":"'+arrival_time+'"}';
		      	if(i!=response.routes.length-1){
		      		route += ',';
		      	}
		      }
		      route += ']}';
		      var Json = JSON.parse(route);
		      $.ajax({
			    type : 'POST',
			    dataType : 'json',
			    data: {transit: JSON.stringify(Json)},
			    url : 'GetRouteFromGoogleServlet',
			    success : function(data, textStatus) {
			        // whatever
			    },
			    error : function(xhr, textStatus, errorThrown) {
			        // whatever
			    }
			 });
		      }
		  });
		  
		  
		  
		}
		function toServlet(){
			window.location.href = "ShowRecomendServlet";
		}
		