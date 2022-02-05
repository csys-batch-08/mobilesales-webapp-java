<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">


<title>ViewContactUs</title>
</head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 20px;
}

.h2_1 {
	text-align: center;
	background-color: bisque;
}

.top_nav {
	/* background-color: brown;
        padding: 9px; */
	
}

.top_nav_in1 {
	position: relative;
	left: 500px;
	padding: 8px;
}

.top_nav_bu1 {
	position: relative;
	left: 520px;
	padding: 8px;
	background-color: cornflowerblue;
}

.top_nav_bu1 :hover {
	background-color: darkgreen;
	color: darkkhaki;
}

.table1 td {
	padding: 15px;
}

.button1 {
	text-decoration: none;
	position: relative;
	left: 60px;
	padding: 12px;
	padding-left: 32px;
	padding-right: 32px;
	color: blanchedalmond;
	border-radius: 12px;
	border-color: black;
	background-color: red;
}

.button1:hover {
	background-color: blue;
}

.mar1 {
	font-size: 30px;
	color: crimson;
}

.body_main {
	margin-top: 120px;
	margin-left: 240px;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: brown;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 12px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: goldenrod;
}

.active {
	background-color: grey;
}

.phoneInfo {
	margin-left: 250px;
	margin-top: -270px;
	font-size: 20px;
}

.but_log a {
	text-decoration: none;
	color: white;
	padding: 12px;
	margin-top: 20px;
	margin-left: 100px;
	background-color: rgb(83, 83, 204);
	border-radius: 20px;
}

.but_log {
	margin-top: 40px;
}

body {
	background-color: cornsilk;
}

table {
	background-color: white;
}

#conatct {
	width: 85%;
	margin-left: 70px;
}

* {
	margin: 0;
	padding: 0;
}
</style>
<body>
	<h2 class="h2_1">Mobile Sales App</h2>

	<div style="position: relative; top: -10px;" class="top_nav">

		<ul>

			<li style="float: right;"><a href="logOut">Logout</a></li>
			<li style="float: right;"><a href="adminMain.jsp">Admin</a></li>

		</ul>


	</div>
	<img
		style="border-radius: 100px; position: absolute; top: 0px; left: 500px;"
		width="40px" alt="" src="assets/images/mobile112.png">

	<br>
	<br>



	<table aria-describedby="Show All home places" id="conatct"
		class="table table-hover table-striped">
		<tr style="background-color: cornflowerblue">
			<th>Serial No</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone_number</th>
			<th>Description</th>


		</tr>

		<c:set var="serialNumber" value="1" scope="page"></c:set>
		<c:forEach items="${viewContact}" var="v">



			<tr>
				<td>${serialNumber}</td>
				<td>${v.name}</td>
				<td>${v.email}</td>
				<td>${v.phoneNumber}</td>
				<td>${v.description}</td>
			</tr>
			<c:set var="serialNumber" value="${serialNumber+1 }" scope="page"></c:set>
		</c:forEach>

	</table>

</body>
</html>