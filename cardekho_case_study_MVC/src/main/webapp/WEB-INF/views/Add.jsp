
<%@page import="java.util.List"%>
<%@page import="com.jspiders.cardekho_case_study_mvc.Pojo.CarPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<%
List<CarPojo> cars = (List<CarPojo>) request.getAttribute("cars");
String msg = (String) request.getAttribute("msg");
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

input:hover {
	
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

	<div align="center">
		<form action="./add" method="post">
			<h3>Car's Added Form</h3>
			<table>

				<tr>
					<td>Car Name</td>
					<td><input type="text" name="carName" id="name"
						required="required" autofocus="autofocus"></td>
				</tr>

				<tr>
					<td>Car Brand</td>
					<td><input type="text" name="carBrand" required="required"></td>
				</tr>

				<tr>
					<td>Car Source Fual</td>
					<td><input type="text" name="carFual" id=""
						required="required"></td>
				</tr>
				<tr>
					<td>Car Price</td>
					<td><input type="number" name="carPrice" id=""
						required="required"></td>
				</tr>



			</table>
			<br> <input type="submit" id="sub" value="Click For Added Car">
			<br> <br>
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
		<table id="data" border="1">

			<tr>
				<th>Car Id</th>
				<th>Car Name</th>
				<th>Car Brand</th>
				<th>Car Fual</th>
				<th>Car Price</th>
			</tr>

			<%
			for (CarPojo pojo : cars) {
			%>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getCarName()%>
				<td><%=pojo.getCarFual()%>
				<td><%=pojo.getCarBrand()%>
				<td><%=pojo.getCarPrice()%>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>


	</div>
</body>
</html>