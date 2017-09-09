<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
body {
	background-image:
		url("https://www.xmple.com/wallpaper/linear-white-gradient-blue-highlight-1920x1080-c2-ffffff-87cefa-l-67-a-60-f-21.svg");
	width
	="1900";
	height
	="800";
}

.myTable1 {
	width: 100%;
	text-align: center;
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
<title>Restaurent</title>
<script type="text/javascript">
	var xmlHttp;
	xmlHttp = GetXmlHttpObject();
	function check(id) {

		if (xmlHttp == null) {
			alert("Your browser does not support AJAX!");
			return;
		}

		var a = document.getElementById('myTextA' + id).value;

		var query = "action=textbox&title=" + a;

		xmlHttp.onreadystatechange = function stateChanged() {
			if (xmlHttp.readyState == 4) {

				var json = JSON.parse(xmlHttp.responseText);

				document.getElementById("success").innerHTML = json.successmsg;
			}
		};

		xmlHttp.open("POST", "restaurent.htm", true);
		xmlHttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xmlHttp.send(query);
		return false;
	}

	function GetXmlHttpObject() {
		var xmlHttp = null;
		try {
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		return xmlHttp;
	}

	function disable(id) {
		var i = '#Recommend' + id;
		$(i).prop("disabled", true);
		$(i).attr("value", "Recommended")

		var a = '#myTextA' + id;
		var b = '#myTextB' + id;
		var c = '#myTextC' + id;
		var d = '#myTextD' + id;

		$(a).prop("disabled", true);
		$(b).prop("disabled", true);
		$(c).prop("disabled", true);
		$(d).prop("disabled", true);

		$(a).css("background", 'lightgreen');
		$(b).css("background", 'lightgreen');
		$(c).css("background", 'lightgreen');
		$(d).css("background", 'lightgreen');
	}
	function registrationFormDisplay() {
		if (document.getElementById("registrationForm").style.display === "none") {
			//if no registration form, then it will create one, if it exists, it will move to the else loop.
			document.getElementById("registrationForm").style.display = "block";
			document.getElementById("myForm").reset();
		} else {
			document.getElementById("registrationForm").style.display = "none";
			//this is the div id which is redirected to the called id in the page below.
		}
	}
</script>
</head>
<body>
	<form action="restaurent.htm" method="post" commandName="advertisement">


		<div align="center">

			<a href="contents.jsp">Home</a>
			<h2 align="center">
				<font size="6">Restaurents In Boston</font>
			</h2>

		</div>

		<table class="myTable1" align="center" border="1" cellpadding="3"
			cellspacing="3">

			<div align="center">
				<span id="success" style="color: green; size: 90%;"></span>
			</div>

			<tr>
				<td align="center" style="font-size: 130%;"><b>PLACE</b></td>
				<td align="center" style="font-size: 130%;"><b>MESSAGE</b></td>
				<td align="center" style="font-size: 130%;"><b>LOCATION</b></td>
				<td align="center" style="font-size: 130%;"><b>PHONE NUMBER</b>
				<td align="center" style="font-size: 130%;"><b>PHOTO</b>
			</tr>
			<c:forEach var="adv" begin="0" items="${advertisement}"
				varStatus="status">
				<c:set var="i" value="${status.index}" />
				<c:if test="${adv.status == 'Approved'}">
					<tr>
						<td align="center"><input type="text" id="myTextA${i}"
							name='title${i}' style="font-size: 130%;" value="${adv.title}"
							style="" /></td>
						<td align="center"><input type="text" id="myTextB${i}"
							value="${adv.message}" style="font-size: 130%;" /></td>
						<td align="center"><input type="text" id="myTextC${i}"
							value="${adv.location}" style="font-size: 130%;" /></td>
						<td align="center"><input type="text" id="myTextD${i}"
							value="${adv.phoneNumber}" style="font-size: 130%;" /></td>

						<td align="center"><img height="300" width="300"
							src="${adv.photoName}" /></td>
						<td align="center"><a
							href="mailto:someone@example.com?Subject=Boston%20Travel%20Guide&body=Place:%20${adv.title},%20Message:%20${adv.message},%20Location:%20${adv.location},%20PhoneNumber:%20${adv.phoneNumber}.%20"
							class="button">Send</a></td>
						<td align="center"><a
							href="http://www.twfoodrestaurant.com/menus/dinner.pdf"
							class="button">View Menu</a></td>
						<td align="center"><input type="button" id="Recommend${i}"
							value="Recommend" class="button"
							onclick="check('${i}'),disable('${i}')"></td>
					</tr>
				</c:if>
			</c:forEach>
		</table>

	</form>
	<div align="center">
		<button onclick="registrationFormDisplay()"
			style="height: 30px; width: 80px">View Map</button>
		<br> <br>
	</div>
	<div id="registrationForm" style="display: none;">

		<form id="myForm" align="center">
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m10!1m8!1m3!1d60346.40780835085!2d-71.07155395034205!3d42.36801736375855!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sus!4v1459635794139"
				width="1500" height="860" frameborder="0" style="border: 0"
				allowfullscreen></iframe>
		</form>
	</div>
</body>
</html>