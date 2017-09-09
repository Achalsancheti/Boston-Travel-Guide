<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script>
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
	width: 1100px;
	background-color: #99ccff;
}
</style>
</head>
<body oncontextmenu="return false">
	<img src="http://logonoid.com/images/btg-logo.png" width="100"
		height="140">
	<font size="8"><b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbspBoston
			Travel Guide</b></font>
	<div class="right">
		<fieldset>

			<form:form action="login.htm" commandName="user" method="post">

				<font size="5"><b>UserName :</b> <input path="userName"
					name='userName'  placeholder="Enter username"><font size="2" color="red">Correct Username Required</font>
					 <b>Password
						:</b> <input type="password" path='password' name='password'
					placeholder="Enter password"><font size="2" color="red">Correct Password Required</font> <input type="submit"
					value="Login" style="height: 30px; width: 80px"> <a
					href="adduser.htm" target="contents">Signup</a></font>
				<div align="center">
					<br>
					<input type="radio" name="roleType" value="User"> User
			<input type="radio" name="roleType" value="Advertiser"> Advertiser<font size="2" color="red">Correct RoleType Required</font>
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