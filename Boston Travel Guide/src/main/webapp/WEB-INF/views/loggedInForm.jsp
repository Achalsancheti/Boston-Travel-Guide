<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logged-In Form</title>
<style>

.submit {
    background-color: #e63900;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}

a:link, a:visited {
    background-color: #f44336;
    color: white;
    padding: 14px 25px;
    text-align: center;	
    text-decoration: none;
    display: inline-block;
}


a:hover, a:active {
    background-color: red;
}

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
}

</style>
</head>

<body>

	<img src="http://logonoid.com/images/btg-logo.png" width="100"
		height="140">
	<font size="8"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Boston
			Travel Guide</b></font>
	<form action="logout.htm">
			<div class="right" align="center">
			<font size="5"><b>Hello ${user.userName}</b></font><br/>
			<a href="offers.htm" target="contents">Offers</a>
			<a href="http://www.subway.com/menu/PDFS/MenuPDF/USA_Menu.pdf" target="contents">Today's Special Offer</a>
			<a href="recommended.htm" target="contents">Recommended</a>
			<a href="mailto:someone@example.com?Subject=Boston%20Travel%20Guide&body=Register%20With%20Boston%20Travel%20Guide.%20The%20Best%20Site%20To%20Know%20About%20Boston.">Tell a friend</a>
			<input type="submit" class="submit" value="Logout" style="height: 48px; width: 120px">
			
			</div>
			</form>
	<font size="4" align="center">
		<p>Welcome To Boston Travel Guide. Find The Best Places Around
			You.</p>
	</font>
</body>
</html>