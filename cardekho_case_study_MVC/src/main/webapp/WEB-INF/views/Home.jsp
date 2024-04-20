<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body {
	background-color: #f1f1f1;
	background-image:
		url("https://cdn.pixabay.com/photo/2016/12/03/18/57/car-1880381_1280.jpg");
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed; s
	display: flex;
}

#details {
	height: 100px;
	widows: 300px;
	color: white;
	text-shadow: 0px 0px 10px white;
	text-align: center;
}

h1 {
	color: white;
	text-align: center;
	font-family: sans-serif;
	text-shadow: 5px 5px 5px black;
}

h1:hover {
	color: orange;
}

.car-card {
	height: 300px;
	width: 300px;
	border: 1px solid #e0e0e0;
	border-radius: 10px;
	overflow: hidden;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
	margin: 20px;
	background-color: #f1f1f1;
	position: relative;
	top: -30px;
}

.car-card:hover{
box-shadow: 10px 5px 10px black;

}

#img {
	height: 200px;
	width: 100vw;
	background-image:
		url("https://cdn.pixabay.com/photo/2017/03/27/14/56/auto-2179220_1280.jpg");
	background-repeat: no-repeat;
	background-size: contain;
	border: none;
}


#img2 {
	height: 200px;
	width: 100vw;
	background-image:
		url("https://cdn.pixabay.com/photo/2016/11/23/17/25/woman-1853939_1280.jpg");
	background-repeat: no-repeat;
	background-size: contain;
	border: none;
}

#img3 {
	height: 200px;
	width: 100vw;
	background-image:
		url("https://media.istockphoto.com/id/1339028214/photo/happy-stylish-parents-with-their-cute-lovely-children-are-making-funny-selfie-on-smart-phone.jpg?s=1024x1024&w=is&k=20&c=eoC7Vfx7ZxpKvwryVwpjg8IdJuc10mRziiZQQHjaBzw=");
	background-repeat: no-repeat;
	background-size: contain;
	border: none;
}

#img4 {
	height: 200px;
	width: 100vw;
	background-image:
		url("https://media.istockphoto.com/id/1445465706/photo/mid-adult-woman-receiving-her-takeaway-order-from-a-saleswoman-at-the-drive-through.jpg?s=1024x1024&w=is&k=20&c=SNtwqLLjsrk7vwmRlHkYGy-F89zR6wq6wYY0K9bHBnM=");
	background-repeat: no-repeat;
	background-size: contain;
	border: none;
}

.car-details {
	padding: 15px;
	text-align: center;
}

.car-description {
	font-size: 14px;
	color: black;
	margin-bottom: 10px;
}

.btn {
	display: block;
	width: 95%;
	padding: 10px;
	text-align: center;
	background-color: #3498db;
	color: #fff;
	text-decoration: none;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.btn:hover {
	background-color: blue;;
}

.parent {
	display: flex;
	position: relative;
	left: 70px;
	top: 200px;
}

</style>
<body>
	<h3>>>>>>WELCOME TO CAR_DEKHO_CASE_STUDY_WEBSITE<<<<</h3>
	<details id="details">
		<h3>This guide provides comprehensive information about CRUD
			Operations on cars and how to manipulate their operations effectively.
			Whether you're a new car owner or expand your knowledge, this
			resource covers various aspects of car Name, car Brand, car source
			Type, car Price ,maintenance, and safety.</h3>
	</details>
	<div class="parent">
		<div class="car-card" style="text-align: center;">

			<div id="img"></div>

			<div class="car-details">

				<div class="car-description">Added Your Car.</div>

				<a href="./add" class="btn">Add Car's</a>
			</div>
		</div>


		<div class="car-card">

			<div id="img2"></div>

			<div class="car-details">

				<div class="car-description">Updated Your Car .</div>

				<a href="./update" class="btn">Update Car</a>
			</div>
		</div>

		<div class="car-card" style="text-align: center">

			<div id="img3"></div>

			<div class="car-details">

				<div class="car-description">Remove Your Car.</div>

				<a href="./remove" class="btn">Remove Car</a>
			</div>
		</div>

		<div class="car-card" style="text-align: center">

			<div id="img4"></div>

			<div class="car-details">

				<div class="car-description">Search your Car.</div>

				<a href="./search" class="btn">Search Car</a>
			</div>
		</div>
	</div>




</body>
</html>

</body>
</html>