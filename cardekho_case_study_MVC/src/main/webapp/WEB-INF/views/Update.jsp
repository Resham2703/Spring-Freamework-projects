<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.jspiders.cardekho_case_study_mvc.Pojo.CarPojo"%>
<%@page import="java.util.List"%>

<jsp:include page="NavBar.jsp" />
<%
List<CarPojo> cars = (List<CarPojo>) request.getAttribute("cars");
String msg = (String) request.getAttribute("msg");
CarPojo pojo = (CarPojo) request.getAttribute("pojo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>


input {

	font-stretch: 30px;
	height: 30px;
	width: 400px;
	border: none;
	border-bottom: 1px solid white;
	color: blue;
	font-weight: bold;
	background-color: white;
}



table {
	color: black;
	font-weight: 10px;
	
	box-shadow: 2px 2px 2px black;
	border: none;
	border-bottom: thick;
	background-color: white;
	
}

tr {
	box-shadow: 2px 2px 2px black;
	border: none;
	border-bottom: thick;
}

td {
	height: 30px;
	width: 100px;
	font-family: fantasy;
	font-size: 15px;
	box-shadow: 2px 2px 2px black;
	border: none;
	border-bottom: thick;
}
</style>

<body>
	<h1>update</h1>

	<div align="center">
		<%
		if (pojo == null) {
		%>
		<form action="./update" method="post">

			<table border="1">
				<tr>
					<td>Enter Id</td>
					<td><input type="text" name="id"></td>
				</tr>
			</table>

			<input type="submit" value="Continue>>>">

		</form>
		<%
		if (msg != null) {
		%>
		<h3><%=msg%></h3>
		<%
		}
		%>

		<%
		if (cars != null) {
		%>
		<table border="1">

			<tr>
				<th>Car Id</th>

				<th>Car Name</th>
				<th>Car Brand</th>
				<th>Car Fual</th>
				<th>Car Price</th>
			</tr>

			<%
			for (CarPojo car : cars) {
			%>
			<tr>
				<td><%=car.getId()%></td>
				<td><%=car.getCarName()%></td>
				<td><%=car.getCarBrand()%></td>
				<td><%=car.getCarFual()%></td>
				<td><%=car.getCarPrice()%></td>
			</tr>
			<%
			}
			}
			%>
		</table>
		<%
		} else {
		%>

		<form action="./updateCar" method="post">
			<table border="1">
				<tr>
					<td>Car Id</td>
					<td><%=pojo.getId()%></td>
					<td><input type="number" name="id" value="<%=pojo.getId()%>"
						hidden="true"></td>
				</tr>
				<tr>
					<td>Car Name</td>
					<td><%=pojo.getCarName()%></td>
					<td><input type="text" name="carName"
						value="<%=pojo.getCarName()%>"></td>
				</tr>
				<tr>
					<td>Car Brand</td>
					<td><%=pojo.getCarBrand()%></td>
					<td><input type="text" name="carBrand"
						value="<%=pojo.getCarBrand()%>"></td>
				</tr>
				<tr>
					<td>Car Fuel</td>
					<td><%=pojo.getCarFual()%></td>
					<td><input type="text" name="carFual"
						value="<%=pojo.getCarFual()%>"></td>

				</tr>
				<tr>
					<td>Car Price</td>
					<td><%=pojo.getCarPrice()%></td>
					<td><input type="number" name="carPrice"
						value="<%=pojo.getCarPrice()%>"></td>
				</tr>

			</table>
			<input type="submit" value="Update">
		</form>


		<%
		}
		%>



	</div>

</body>
</html>