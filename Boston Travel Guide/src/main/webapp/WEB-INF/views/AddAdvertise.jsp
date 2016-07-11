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
<title>Add Advert Form</title>
<style>
body {
	background-image:
		url("http://paper-backgrounds.com/textureimages/2012/08/light-brown-wood-furniture-texture.jpg");
	width
	="2500";
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
				<font size="6">Post An Advertisement</font>
			</h2>

			<form:form action="addadvertisement.htm" commandName="advertisement"
				method="post" enctype="multipart/form-data">

				<table>

					<tr>
						<td><b><font size="5">Category:</font></b></td>
						<td><form:select path="category_name">
								<c:forEach var="categ" items="${categories}">
									<form:option value="${categ.title}" />
								</c:forEach>
							</form:select></td>
					</tr>

					<tr>
						<br />
						<td><b><font size="5">Advertisement Title:</font></b></td>
						<td><form:input path="title" size="20"
								style="font-size:16pt;" pattern='([A-Z]{1}[a-z]{1,30})'
								placeholder="Enter Title" /> <font color="red"><form:errors
									path="title" /></font></td>
					</tr>

					<tr>
						<td><b><font size="5">Message:</font></b></td>
						<td><form:input path="message" size="20"
								style="font-size:16pt;" pattern='([A-Z]{1}[a-z]{1,30})'
								placeholder="Enter Message" /> <font color="red"><form:errors
									path="message" /></font></td>
					</tr>

					<tr>
						<td><b><font size="5">Posted By:</font></b></td>
						<td><form:input path="postedBy" size="20"
								style="font-size:16pt;" pattern='([A-Z]{1}[a-z]{1,30})'
								placeholder="Enter Name" /> <font color="red"><form:errors
									path="postedBy" /></font></td>
					</tr>

					<tr>
						<td><b><font size="5">Select Photo:</font></b></td>
						<td><form:input path="photo" type="file" /> <form:errors
								cssStyle="color:red" path="photo" /></td>
					</tr>

					<tr>
						<td><b><font size="5">Phone Number:</font></b></td>
						<td><form:input path="phoneNumber" size="20"
								placeholder="Enter Phone Number"
								pattern="^(?:(?:\+?1\s*(?:[.-]\s*)?)?(?:\(\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\s*\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\s*(?:[.-]\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\s*(?:[.-]\s*)?([0-9]{4})(?:\s*(?:#|x\.?|ext\.?|extension)\s*(\d+))?$"
								title="Please enter in a valid phone number"
								style="font-size:16pt;" /> <font color="red"><form:errors
									path="phoneNumber" /></font></td>
					</tr>

					<tr>
						<td><b><font size="5">Location:</font></b></td>
						<td><form:input path="location" size="20"
								pattern='[a-zA-Z0-9]{5,30}'
								placeholder="Enter Location" style="font-size:16pt;" /> <font
							color="red"><form:errors path="location" /></font></td>
					</tr>

					<tr>
						<td><br> <br> <input type="submit" id="button2" disabled
							value="Post Advertisement" style="height: 45px; width: 150px" /></td>
					</tr>
				</table>

			</form:form>
			<form:form target="paypal" action="https://www.paypal.com/cgi-bin/webscr" method="post">
							<input type="hidden" name="cmd" value="_cart">
							<input type="hidden" name="business" value="achalsancheti@gmail.com">
							<input type="hidden" name="lc" value="US">
							<input type="hidden" name="item_name" value="Advertisement Post">
							<input type="hidden" name="amount" value="100.00">
							<input type="hidden" name="currency_code" value="USD">
							<input type="hidden" name="button_subtype" value="products">
							<input type="hidden" name="no_note" value="0">
							<input type="hidden" name="add" value="1">
							<input type="hidden" name="bn" value="PP-ShopCartBF:btn_cart_LG.gif:NonHostedGuest">
							<input type="image" src="http://samedayexpress.ca/wp-content/uploads/2014/04/paynow_button.png" onclick="enableButton()"
								border="0" name="submit" alt="PayPal - The safer, easier way to pay online!"> <img
								alt="" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif"
								width="1" height="1">
								
						</form:form>
		</fieldset>
	</div>
</body>
</html>