<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>


<style>

body  {
    background-image: url("http://paper-backgrounds.com/textureimages/2012/08/light-brown-wood-furniture-texture.jpg");
	width="1900";
	height="800";
}

.imagee {
	-webkit-column-count: 4; /* Chrome, Safari, Opera */
	-moz-column-count: 4; /* Firefox */
	column-count: 4;
	-webkit-column-gap: 40px; /* Chrome, Safari, Opera */
	-moz-column-gap: 40px; /* Firefox */
	column-gap: 40px;
}
</style>
<script
src="http://maps.googleapis.com/maps/api/js">
</script>

<script>
function changeHashOnLoad() { 
    window.location.href += "#"; 
    setTimeout("changeHashAgain()", "50");  
} 

function changeHashAgain() { 
 window.location.href += "1"; 
} 

var storedHash = window.location.hash; 
window.setInterval(function () { 
   if (window.location.hash != storedHash) { 
        window.location.hash = storedHash; 
   } 
}, 50);

var map;
var myCenter=new google.maps.LatLng(42.3584308, -71.0597732);

function initialize()
{
var mapProp = {
  center:myCenter,
  zoom:5,
  mapTypeId:google.maps.MapTypeId.ROADMAP
  };

  map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

  google.maps.event.addListener(map, 'click', function(event) {
    placeMarker(event.latLng);
  });
}

function placeMarker(location) {
  var marker = new google.maps.Marker({
    position: location,
    map: map,
  });
  var infowindow = new google.maps.InfoWindow({
    content: 'Latitude: ' + location.lat() + '<br>Longitude: ' + location.lng()
  });
  infowindow.open(map,marker);
}

google.maps.event.addDomListener(window, 'load', initialize);




</script>
</head>

<body onload="changeHashOnLoad(); ">

	<div class="w3-content w3-section">

		<img class="mySlides w3-animate-fading"
			src="http://images.cityhdwallpapers.com/images/1920x1080/Boston%20city%20night%20life%20wallpaper.jpg"
			width="1900" height="800"> <img
			class="mySlides w3-animate-fading"
			src="http://alumni.virginia.edu/uvaclubs/wp-content/uploads/sites/15/2013/04/Boston.jpg"
			width="1900" height="800"> <img
			class="mySlides w3-animate-fading"
			src="http://www.urbansplatter.com/wp-content/uploads/2013/11/boston-1.jpg" width="1900"
			height="800"> <img class="mySlides w3-animate-fading"
			src="http://3.bp.blogspot.com/_Rmav50MtQoU/TGCdC4FFsLI/AAAAAAAADbk/LbyNPveIFCg/s1600/Ferry+-+Boston+Downtown2.JPG"
			width="1900" height="800">

	</div>

	<h1 align="center">
		<font size="9"><b>Click On One Of The Image To Explore
				Different Places In Boston</b></font>
	</h1>

	<div class="imagee" align="center">

		<div style="border: 1px solid #000;">
			<a href="restaurent.htm"><img
				src="http://messagenote.com/wp-content/uploads/2012/02/Fine-Australian-Restaurant.jpg"
				alt="HTML tutorial" style="width: 400px; height: 400px;"> <figcaption
					align="center"> <font size="6" color="black"><b>Restaurants</b></font></figcaption>
			</a>
		</div>

		<div style="border: 1px solid #000;">
			<a href="nightclub.htm"><img
				src="http://www.destination360.com/europe/uk/images/s/uk-nightlife.jpg"
				alt="HTML tutorial" style="width: 400px; height: 400px;"> <figcaption
					align="center"> <font size="6" color="black"><b>Night
						Life</b></font></figcaption></a>
		</div>

		<div style="border: 1px solid #000;">
			<a href="hotel.htm"><img
				src="https://phgcdn.com/images/uploads/MLAEH/corporatemasthead/grand-hotel-excelsior_masthead.jpg"
				alt="HTML tutorial" style="width: 400px; height: 400px;"> <figcaption
					align="center"> <font size="6" color="black"><b>Hotels</b></font></figcaption> </a>
		</div>

		<div style="border: 1px solid #000;">
			<a href="museum.htm"><img
				src="http://blogs.plos.org/paleo/files/2012/12/Field_Museum_of_Natural_History1.jpg"
				alt="HTML tutorial" style="width: 400px; height: 400px;"> <figcaption
					align="center"> <font size="6" color="black"><b>Museums</b></font></figcaption></a>
		</div>

		
		
		
			
		

	</div><br>
	<br><h1 align="center"><font size="9"><b>Map</b></font></h1><div align="center">
	<div id="googleMap" style="width:1500px;height:700px;" align="center" ></div></div>
	<br>
	<br>



	<div class="imagee" align="center"></div>
	<br>
	<br>
	<script>
		var myIndex = 0;
		carousel();

		function carousel() {
			var i;
			var x = document.getElementsByClassName("mySlides");
			for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";
			}
			myIndex++;
			if (myIndex > x.length) {
				myIndex = 1
			}
			x[myIndex - 1].style.display = "block";
			setTimeout(carousel, 4000);
		}
	</script>
</body>
</html>