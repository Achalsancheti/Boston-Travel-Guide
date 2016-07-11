<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%
	//get the category list
	com.achal.spring.dao.CategoryDAO categorydao = new com.achal.spring.dao.CategoryDAO();
	java.util.List categoryList = categorydao.list();
	pageContext.setAttribute("categories", categoryList);
%>

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
<title>Manage Places</title>
<script type="text/javascript">
	var xmlHttp;
	xmlHttp = GetXmlHttpObject();
	function deleteData(id) {
		if (xmlHttp == null) {
			alert("Your browser does not support AJAX!");
			return;
		}
		var a = document.getElementById('myTextA' + id).value;
		var b = document.getElementById('myTextB' + id).value;
		var c = document.getElementById('myTextC' + id).value;
		var d = document.getElementById('myTextD' + id).value;
		var e = document.getElementById('myTextE' + id).value;

		var query = "action=text&id=" + a + "&atitle=" + b + "&message=" + c
				+ "&location=" + d + "&phoneNumber=" + e;

		xmlHttp.onreadystatechange = function stateChanged() {
			if (xmlHttp.readyState == 4) {

				var json = JSON.parse(xmlHttp.responseText);

				document.getElementById("success").innerHTML = json.successmsg;
			}
		};
		xmlHttp.open("POST", "manage.htm", true);
		xmlHttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xmlHttp.send(query);
		return false;
	}

	var xmlHttp;
	xmlHttp = GetXmlHttpObject();
	function approveData(val) {
		if (xmlHttp == null) {
			alert("Your browser does not support AJAX!");
			return;
		}
		var a = document.getElementById('myTextB' + val).value;

		var query = "action=textbox&atitle=" + a;

		xmlHttp.onreadystatechange = function stateChanged() {
			if (xmlHttp.readyState == 4) {

				var json = JSON.parse(xmlHttp.responseText);

				document.getElementById("success").innerHTML = json.successmsg;
			}
		};
		xmlHttp.open("POST", "approve.htm", true);
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
	function deleteRow(r) {
		var i = r.parentNode.parentNode.rowIndex;
		document.getElementById("myTable").deleteRow(i);
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
	<form:form action="manage.htm" method="post"
		commandName="advertisement">

		<div align="center">
			<a href="contents.jsp">Home</a>
			<h2 align="center">
				<font size="6">Advertisement Posted</font>
			</h2>
		</div>


		<table id="myTable" class="myTable1" align="center" border="1"
			cellpadding="3" cellspacing="3">

			<div align="center">
				<span id="success" style="color: green"></span>
			</div>

			<tr>
				<td align="center" style="font-size: 130%;"><b>ID</b></td>
				<td align="center" style="font-size: 130%;"><b>CATEGORY</b></td>
				<td align="center" style="font-size: 130%;"><b>PLACE</b></td>
				<td align="center" style="font-size: 130%;"><b>MESSAGE</b></td>
				<td align="center" style="font-size: 130%;"><b>LOCATION</b></td>
				<td align="center" style="font-size: 130%;"><b>PHONE NUMBER</b>
				<td align="center" style="font-size: 130%;"><b>PHOTO</b>
			</tr>
			<c:forEach var="adv" begin="0" items="${advertisement}"
				varStatus="status">
				<c:set var="i" value="${status.index}" />
				<c:if test="${adv.status != 'Approved'}">
					<tr>
						<td align="center"><input type="text" id="myTextA${i}"
							style="font-size: 130%;" name='id${i}' value="${adv.category}" /></td>

						<c:forEach var="categ" items="${categories}">
							<c:if test="${adv.category == categ.id}">
								<td align="center"><input type="text"
									style="font-size: 130%;" value="${categ.title}" /></td>
							</c:if>
						</c:forEach>


						<td align="center"><input type="text" id="myTextB${i}"
							style="font-size: 130%;" name='atitle${i}' value="${adv.title}" /></td>
						<td align="center"><input type="text" id="myTextC${i}"
							style="font-size: 130%;" name='message${i}'
							value="${adv.message}" /></td>
						<td align="center"><input type="text" id="myTextD${i}"
							style="font-size: 130%;" name='location${i}'
							value="${adv.location}" /></td>
						<td align="center"><input type="text" id="myTextE${i}"
							style="font-size: 130%;" name='phoneNumber${i}'
							value="${adv.phoneNumber}" /></td>
						<td align="center"><img height="300" width="300"
							src="${adv.photoName}" /></td>
						<td align="center"><input type="button" value="Delete"
							class="button" onclick="deleteData('${i}'),deleteRow(this)"></td>
						<td align="center"><input type="button" value="Approve"
							class="button" onclick="approveData('${i}')"></td>
					</tr>
				</c:if>
			</c:forEach>

		</table>
		<br />
		<br />

	</form:form>
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