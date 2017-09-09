<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Add Category Form</title>
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
</head>
<body>
	<div align="center">


		<fieldset style="width: 400px; background-color: #99ccff;">
			<div align="left">
				<a href="contents.jsp">Home</a>
			</div>
			<h2><font size="6">Add a New Category</font></h2>

			<form:form action="addcategory.htm" commandName="category"
				method="post">

				<h2 align="center"><font size="4">Category Title:</font></h2>

				<form:select path="title">
					<option></option>
					<option value="Restaurent">Restaurent</option>
					<option value="Museum">Museum</option>
					<option value="NightClub">NightClub</option>
					<option value="Hotel">Hotel</option>
					
				</form:select>
				<font color="red"><form:errors path="title" /></font>
				<br />
				<br />
				<input type="submit" value="Create Category" style="height: 40px; width: 150px" />

			</form:form>
		</fieldset>
	</div>
</body>
</html>