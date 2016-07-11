<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Add User Form</title>
<style>
body {
	background-image:
		url("http://paper-backgrounds.com/textureimages/2012/08/light-brown-wood-furniture-texture.jpg");
	width
	="2200";
	height
	="400";
}
</style>
<script type="text/javascript">
	function check(value) {
		xmlHttp = GetXmlHttpObject()
		var url = "checkajax.jsp";
		url = url + "?e=" + value;
		xmlHttp.onreadystatechange = stateChanged
		xmlHttp.open("GET", url, true)
		xmlHttp.send(null)
	}
	function stateChanged() {
		if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {
			var showdata = xmlHttp.responseText;
			if(showdata.match("You Can Register Now!!!!")){
				document.getElementById("button").disabled = false;
			}else{
				document.getElementById("button").disabled = true;
			}
			document.getElementById("mydiv").innerHTML = showdata;
		}
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
</script>
</head>
<body oncontextmenu="return false">
	<div align="center">
		<fieldset style="width: 700px; background-color: #99ccff;">
			<div align="left">
				<a href="contents.jsp">Home</a>
			</div>
			<h2 align="center">
				<font size="6">Register a New User</font>
			</h2>

			<form:form action="adduser.htm" commandName="user" method="post"
				enctype="multipart/form-data" name="form">

				<table align="center">
				<tr><font size="4" color="red"><div id="mydiv"></div></font></tr>
					<tr>
						<td><b><font size="5">First Name:</font></b></td>
						<td><form:input path="firstName" size="20"
								placeholder="Enter firstname" value='${cookie.userName.value}' pattern='([A-Z]{1}[a-z]{1,30})'
								style="font-size:16pt;" /> <font color="red"><form:errors
									path="firstName" /></font></td>
					</tr>

					<tr>
						<td><b><font size="5">Last Name:</font></b></td>
						<td><form:input path="lastName" size="20"
								placeholder="Enter lastname" pattern='([A-Z]{1}[a-z]{1,30})' style="font-size:16pt;" /> <font
							color="red"><form:errors path="lastName" /></font></td>
					</tr>


					<tr>
						<td><b><font size="5">User Name:</font></b></td>
						<td><form:input path="userName" onkeyup="check(this.value);" pattern="[a-zA-Z0-9]{5,15}"
								size="20" placeholder="Enter username" style="font-size:16pt;"
								name="e" id="e" />
						
						<td><font color="red"><form:errors path="userName" /></font>
						</td>




					</tr>

					<tr>
						<td><b><font size="5">Password:</font></b></td>
						<td><form:password path="password" size="20" pattern="[a-zA-Z0-9]{5,15}"
								placeholder="Enter password" style="font-size:16pt;" /> <font
							color="red"><form:errors path="password" /></font></td>
					</tr>

					<tr>
						<td><b><font size="5">Role Type:</font></b></td>
						<td><form:radiobutton path="roleType" value="User"
								style="font-size:16pt;" /><font size="4">User </font> <form:radiobutton
								path="roleType" value="Advertiser" style="font-size:16pt;" /><font
							size="4">Advertiser </font> <form:errors cssStyle="color:red"
								path="roleType" /><br /> <br /></td>

					</tr>

					<tr>
						<td><b><font size="5">Email Id:</font></b></td>
						<td><form:input path="email.emailId" size="20"
								placeholder="Enter email id"
								pattern="^[_a-zA-Z0-9-]+(\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.(([0-9]{1,3})|([a-zA-Z]{2,3})|(aero|coop|info|museum|name))$"
								title="Please enter in a valid email address"
								style="font-size:16pt;" /> <font color="red"><form:errors
									path="email.emailId" /></font></td>
					</tr>

					<tr>
						<td><b><font size="5">Phone Number:</font></b></td>
						<td><form:input path="number.phoneNumber" size="20"
								placeholder="Enter phone number"
								pattern="^(?:(?:\+?1\s*(?:[.-]\s*)?)?(?:\(\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\s*\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\s*(?:[.-]\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\s*(?:[.-]\s*)?([0-9]{4})(?:\s*(?:#|x\.?|ext\.?|extension)\s*(\d+))?$"
								title="Please enter in a valid phone number"
								style="font-size:16pt;" /> <font color="red"><form:errors
									path="number.phoneNumber" /></font></td>
					</tr>

					<tr>
						<td><b><font size="5">Gender:</font></b></td>
						<td><form:radiobutton path="gender" value="M"
								style="font-size:16pt;" /><font size="4">Male </font> <form:radiobutton
								path="gender" value="F" style="font-size:16pt;" /><font
							size="4">Female</font> <form:errors cssStyle="color:red"
								path="gender" /><br /> <br /></td>

					</tr>

					<tr>
						<td><b><font size="5">ZipCode:</font></b></td>
						<td><form:input path="zipCode" size="20" pattern="([0-9]{5})"
								placeholder="Enter zipcode" style="font-size:16pt;" /> <font
							color="red"><form:errors path="zipCode" /></font></td>
					</tr>

					<tr>
						<td><b><font size="5">Select Photo:</font></b></td>
						<td><form:input path="photo" type="file" /> <form:errors
								cssStyle="color:red" path="photo" /></td>
					</tr>


					<tr>
					<td><br> <br> <input type="reset"
							value="Reset" style="height: 30px; width: 100px" /></td>
						<td><br><br><input type="submit" id="button"
							value="Create User" style="height: 30px; width: 100px" /></td>
					</tr>
				</table>

			</form:form>
		</fieldset>
	</div>
</body>
</html>