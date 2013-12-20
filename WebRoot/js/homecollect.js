
		  function getRoute(destination){
		  	if (typeof navigator.geolocation == "undefined") {
			  $("#error").text("Your browser doesn't support the Geolocation API");
			}
			navigator.geolocation.getCurrentPosition(function(position) {
			  var geocoder = new google.maps.Geocoder();
			  geocoder.geocode({
			    "location": new google.maps.LatLng(position.coords.latitude, position.coords.longitude)
			  },
			  function(results, status) {
			    if (status == google.maps.GeocoderStatus.OK)
		        {
		          var departure = results[0].formatted_address;
		          var now = new Date();
		          var date = now.getFullYear()+"-"+(now.getMonth()+1)+"-"+now.getDate();
		          var hour = now.getHours();
		          var minute = now.getMinutes();
		          window.location.href="SaveSessionServlet?destination="+destination+"&departure="+departure+"&date="+date+"&hour="+hour+"&minute="+minute+"&people=1";
		        }
			    else
			      $("#error").append("Unable to retrieve your address<br />");
			  });
			},
			function(positionError){
			  $("#error").append("Error: " + positionError.message + "<br />");
			},
			{
			  enableHighAccuracy: true,
			  timeout: 10 * 1000 // 10 seconds
			});
		  }