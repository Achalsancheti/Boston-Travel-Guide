<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<style>
.myTable1 {
	width: 100%;
	text-align: left;
	background-color: #e0e0e0;
}
.button {
	background-color: #99ccff;
	border: none;
	color: black;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<title>View Offer</title>
</head>
<script>
function myFunction() {
    var myWindow = window.open("", "", "left=200, top=100, width=1500, height=860");
    myWindow.document.write("<iframe src='https://www.google.com/maps/embed?pb=!1m10!1m8!1m3!1d60346.40780835085!2d-71.07155395034205!3d42.36801736375855!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sus!4v1459635794139' width='1500' height='860' frameborder='0' style='border: 0' allowfullscreen></iframe>");
    myWindow.
    myWindow.blur();
}
</script>
<body>



	<div data-role="page" id="pageone">
		<div data-role="main" class="ui-content">
			<div align="center">
				<a href="contents.jsp">Home</a>

				<h2 align="center">
					<font size="6">View Offers Posted</font>
				</h2>
			</div>
			<form class="ui-filterable">
				<input id="myFilter" data-type="search">
			</form>
			<p id="demo" align="center"></p>
			<table class="myTable1" align="center" border="1" cellpadding="5"
				cellspacing="5" data-filter="true" data-input="#myFilter"
				data-autodividers="true" data-inset="true">

				<tr>
					<td align="center"><b>PLACE</b></td>
					<td align="center"><b>OFFER</b></td>
					<td align="center"><b>OFFER CODE</b></td>
					<td align="center"><b>EXPIRY DATE</b>
					<td align="center"><b>EXPIRY TIME</b>
				</tr>
				<c:forEach var="adv" items="${offerList}">
					<tr>
						<td align="center">${adv.place}</td>
						<td align="center">${adv.offer}</td>
						<td align="center">${adv.offerCode}</td>
						<td align="center">${adv.expiryDate}</td>
						<td align="center">${adv.expiryTime}</td>
						<td align="center"><a class="button"
							href="mailto:someone@example.com?Subject=Boston%20Travel%20Guide&body=Welcome%20To%20The%20Offerzone%20Of%20Boston%20Travel%20Guide.%20Here%20Is%20Offer%20For%20You%20Place:%20${adv.place}%20Offer:%20${adv.offer}%20OfferCode:%20${adv.offerCode}%20Expiry%20Date:%20${adv.expiryDate}%20Expiry%20Time:%20${adv.expiryTime}">Send</a></td>
					</tr>
				</c:forEach>
			</table>
		
	<div align="center">
		<button onclick="myFunction()"
			style="height: 30px; width: 150px">View Map</button>
		<br> <br>
	</div>
	</div>
	</div>
</body>
</html>