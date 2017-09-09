<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Post Comments</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
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

	$(document).ready(function() {
		$("input").focus(function() {
			$(this).css("background-color", "#ffe6e6");
		});
		$("input").blur(function() {
			$(this).css("background-color", "#ffe6e6");
		});
	});
</script>
<style>
img {
	position: absolute;
	left: 0px;
	top: 0px;
	z-index: -1;
}

body {
	margin: 25;
	padding: 0;
	background-image:
		url("http://bedrooms1.com/wp-content/uploads/2014/05/simple-blue-opera-background-light-49001.jpg");
}

.right {
	float: right;
	width: 800px;
	background-color: #99ccff;
}
</style>
</head>
<body onload="changeHashOnLoad(); " oncontextmenu="return false">
	<img src="http://logonoid.com/images/btg-logo.png" width="100"
		height="140">
	<font size="8"><b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbspBoston
			Travel Guide</b></font>
	<div class="right">
		<fieldset>

			<form:form action="login.htm" commandName="user" method="post">

				<font size="5"><b>UserName :</b> <input path="userName"
					name='userName'  placeholder="Enter username">
					
					<b>Password	:</b> <input type="password" path='password' name='password'
					placeholder="Enter password">
					
					<input type="submit" value="Login" style="height: 30px; width: 80px"> <a
					href="adduser.htm" target="contents">Signup</a></font>
				<div align="center">
					<br>
					<input type="radio" name="roleType" value="User"> User
			<input type="radio" name="roleType" value="Advertiser"> Advertiser
			
					<input type='checkbox' name='rememberMe' value="rememberMe">
					Keep me logged in
				</div>
			</form:form>
		</fieldset>
	</div>
	<font size="4" align="center">
		<p>Welcome To Boston Travel Guide. Find The Best Places Around
			You.</p>
	</font>
</body>
</html>