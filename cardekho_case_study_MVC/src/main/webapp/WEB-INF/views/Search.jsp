<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.jspiders.cardekho_case_study_mvc.Pojo.CarPojo"%>
<jsp:include page="NavBar.jsp" />

<%
CarPojo pojo = (CarPojo) request.getAttribute("car");
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
	<h1>search</h1>

	<div align="center">

		<form action="./search" method="post">

			<table border="1">

				<tr>
					<td>Enter ID</td>
					<td><input type="text" name="id"></td>
			</table>
			<input type="submit" value="Search>>>">

		</form>

		<%
		if (msg != null) {
		%>
		<h3><%=msg%></h3>
		<%
		}
		%>

		<%
		if (pojo != null) {
		%>
		<table id="data" border="1">
			<tr>
				<th>CAR ID</th>
				<th>CAR NAME</th>
				<th>CAR BRAND</th>
				<th>CAR FUAL</th>
				<th>CAR PRICE</th>
			</tr>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getCarName()%></td>
				<td><%=pojo.getCarBrand()%></td>
				<td><%=pojo.getCarFual()%></td>
				<td><%=pojo.getCarPrice()%></td>
			</tr>
		</table>
		<%
		}
		%>
	</div>

</body>
</html>