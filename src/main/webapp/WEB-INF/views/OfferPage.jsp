<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Add Offer Form</title>
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
<script>
	function enableButton() {
		document.getElementById("button2").disabled = false;
	}
</script>
</head>
<body>
	<div align="center">
		<fieldset style="width: 700px; background-color: #99ccff;">
			<div align="left">
				<a href="contents.jsp">Home</a>
			</div>
			<h2 align="center">
				<font size="6">Post An Offer</font>
			</h2>

			<form:form action="offer.htm" commandName="offer" method="post">

				<table align="center">
					<tr>
						<td><b><font size="5">Place:</font></b></td>
						<td><form:input path="place" size="20"
								pattern='([A-Z]{1}[a-z]{1,30})' placeholder="Enter Place"
								style="font-size:16pt;" /> <font color="red"><form:errors
									path="place" /></font></td>
					</tr>

					<tr>
						<td><b><font size="5">Offer:</font></b></td>
						<td><form:input path="offer" size="20" pattern="[a-zA-Z0-9]+\s[a-zA-Z0-9]+"
								placeholder="Enter Offer" style="font-size:16pt;" /> <font
							color="red"><form:errors path="offer" /></font></td>
					</tr>

					<tr>
						<td><b><font size="5">Offer Code:</font></b></td>
						<td><form:input path="offerCode" pattern="[a-zA-Z0-9]+"
								size="20" placeholder="Enter Offer Code" style="font-size:16pt;" />
							<font color="red"><form:errors path="offerCode" /></font></td>
					</tr>


					<tr>
						<td><b><font size="5">Expiry Date:</font></b></td>
						<td><form:input type="date" path="expiryDate"
								min="2016-04-27" size="20" style="font-size:16pt;" /> <font
							color="red"><form:errors path="expiryDate" /></font></td>
					</tr>

					<tr>
						<td><b><font size="5">Expiry Time:</font></b></td>
						<td><form:input type="time" path="expiryTime" size="20"
								style="font-size:16pt;" /> <font color="red"><form:errors
									path="expiryTime" /></font></td>
					</tr>

					<tr>
						<td><br> <br> <input type="submit"
							value="Create Offer" id="button2" disabled
							style="height: 30px; width: 100px" /></td>
					</tr>
				</table>

			</form:form>
			<form:form target="paypal" action="https://www.paypal.com/cgi-bin/webscr"
					method="post">

					<input type="hidden" name="cmd" value="_cart"> <input
						type="hidden" name="business" value="sancheti.a@husky.neu.edu">
					<input type="hidden" name="lc" value="US"> <input
						type="hidden" name="item_name" value="Post An Offer"> <input
						type="hidden" name="amount" value="50.00"> <input
						type="hidden" name="currency_code" value="USD"> <input
						type="hidden" name="button_subtype" value="products"> <input
						type="hidden" name="no_note" value="0"> <input
						type="hidden" name="add" value="1"> <input type="hidden"
						name="bn" value="PP-ShopCartBF:btn_cart_LG.gif:NonHostedGuest">
					<input type="image"
						src="http://samedayexpress.ca/wp-content/uploads/2014/04/paynow_button.png"
						border="0" name="submit" onclick="enableButton()"
						alt="PayPal - The safer, easier way to pay online!"> <img
						alt="" border="0"
						src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif"
						width="1" height="1">
				</form:form>


		</fieldset>
	</div>
</body>
</html>