<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
body {
	background-image:
		url("https://www.xmple.com/wallpaper/linear-white-gradient-blue-highlight-1920x1080-c2-ffffff-87cefa-l-67-a-60-f-21.svg");
	width
	="2500";
	height
	="900";
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
<title>Registered User</title>
<script type="text/javascript">
	var xmlHttp;
	xmlHttp = GetXmlHttpObject();
	function deleteData(id) {
		if (xmlHttp == null) {
			alert("Your browser does not support AJAX!");
			return;
		}
		var a = document.getElementById('myTextA' + id).value;
		

		var query = "action=text&personID=" + a;

		xmlHttp.onreadystatechange = function stateChanged() {
			if (xmlHttp.readyState == 4) {

				var json = JSON.parse(xmlHttp.responseText);

				document.getElementById("success").innerHTML = json.successmsg;
			}
		};
		xmlHttp.open("POST", "registered.htm", true);
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
</script>
</head>
<body>
	<form:form action="registered.htm" method="post" commandName="user">
		
				<div align="center">
					<a href="contents.jsp">Home</a>
					<h2 align="center">
						<font size="6">Registered Users</font>
					</h2>
				</div>
				<table id="myTable" class="myTable1" align="center" border="1"
					cellpadding="3" cellspacing="3">
					<div align="center">
						<span id="success" style="color: green"></span>
					</div>
					<tr>
						<td align="center" style="font-size: 130%;"><b>ID</b></td>
						<td align="center" style="font-size: 130%;"><b>FIRST NAME</b></td>
						<td align="center" style="font-size: 130%;"><b>LAST NAME</b></td>
						<td align="center" style="font-size: 130%;"><b>POST</b></td>
						<td align="center" style="font-size: 130%;"><b>GENDER</b></td>
						<td align="center" style="font-size: 130%;"><b>EMAIL ID</b></td>
						<td align="center" style="font-size: 130%;"><b>PHONE NUMBER</b></td>
						<td align="center" style="font-size: 130%;"><b>ZIPCODE</b>
						<td align="center" style="font-size: 130%;"><b>PHOTO</b></td>
					</tr>
					<c:forEach var="user" begin="0" items="${userList}"
						varStatus="status">
						<c:set var="i" value="${status.index}" />
						<tr>
							<td align="center"><input type="text" id="myTextA${i}" style="font-size: 130%;"
								name='personID${i}' value="${user.personID}" /></td>
							<td align="center"><input type="text" id="myTextB${i}" style="font-size: 130%;"
								name='firstName${i}' value="${user.firstName}" /></td>
							<td align="center"><input type="text" id="myTextC${i}" style="font-size: 130%;"
								name='lastName${i}' value="${user.lastName}" /></td>
							<td align="center"><input type="text" id="myTextD${i}" style="font-size: 130%;"
								name='roleType${i}' value="${user.roleType}" /></td>
							<td align="center"><input type="text" id="myTextE${i}" style="font-size: 130%;"
								name='gender${i}' value="${user.gender}" /></td>
							<td align="center"><input type="text" id="myTextF${i}" style="font-size: 130%;"
								name='email${i}' value="${user.email.emailId}" /></td>
							<td align="center"><input type="text" id="myTextG${i}" style="font-size: 130%;"
								name='number${i}' value="${user.number.phoneNumber}" /></td>
							<td align="center"><input type="text" id="myTextH${i}" style="font-size: 130%;"
								name='zipCode${i}' value="${user.zipCode}" /></td>
							<td align="center"><img height="300" width="300"
								src="${user.photoName}" /></td>
							<td align="center"><input type="button" value="Delete" class="button"
								onclick="deleteData('${i}'),deleteRow(this)">
						</tr>
					</c:forEach>
				</table>
	</form:form>
</body>

</html>