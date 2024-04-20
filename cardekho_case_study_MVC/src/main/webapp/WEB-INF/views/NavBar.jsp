<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<style type="text/css">
body {
	background-color: #f1f1f1;
	background-image: url("https://images.pexels.com/photos/11589799/pexels-photo-11589799.jpeg");
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
	
}
fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: red;
}

ul {
	list-style-type: none;
	overflow: hidden;
	border:2px solid white;
	background-color: transparent;
	
}

li {
	float: right;
}

li a {
	display: block;
	margin: 0px;
	padding: 15px;
	text-decoration: none;
	background-color: black;
	border-color: white;
}

li a:hover {
	background-color: orange;
}

h3{
	color: white;
	text-align: center;
	font-family: sans-serif;
	text-shadow: 5px 5px 5px black;
}
</style>
</head>
<body>
	<ul>

		<li><a style="color: white;" href="./logout">Logout</a></li>

		<li><a style="color: white;" href="./remove">Remove Car's</a></li>
		<li><a style="color: white;" href="./search">Search Car's</a></li>
		<li><a style="color: white;" href="./update">Update Car's</a></li>
		<li><a style="color: white;" href="./add">Add Car's</a></li>
		<li><a style="color: white;" href="./home">Home</a></li>
	</ul>

</body>
</html>