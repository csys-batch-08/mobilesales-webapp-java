
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<title>Mobile_page</title>
</head>
<style>
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

bod {
	background-image:
		url("https://image.freepik.com/free-psd/smartphone-screen-mockup-glowing-neon-lights_53876-98580.jpg");
	background-repeat: repeat;
	background-size: 700px;
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

#table_id {
	margin-right: 200px;
}

.table1 {
	padding: 15px;
}

.table1 td {
	padding: 12px;
	text-align: center;
}

.button1 {
	text-decoration: none;
	position: relative;
	top: 20px;
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
	color: green;
}

.body_main1 {
	background: linear-gradient(rgba(0, 0, 0, .3) 60%, rgba(0, 0, 0, .3)
		-70%),
		url(https://image.freepik.com/free-psd/smartphone-screen-mockup-glowing-neon-lights_53876-98580.jpg);
	background-repeat: repeat;
	background-size: 700px;
	/* background: rgba(76, 175, 80, 0.3) */
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

#but_id {
	position: relative;
	top: -8px;
}

#but_id1 {
	position: relative;
	top: -8px;
}

.table_right {
	margin-right: 200px
}

.searchPro {
	position: absolute;
	left: 420px;
}

.searchPro input[type=text] {
	padding: 10px;
	font-size: 16px;
	float: left;
}

.searchPro button {
	float: left;
	padding: 10px;
	background: #2196F3;
	font-size: 17px;
	border: 1px solid grey;
	border-left: none;
	cursor: pointer;
}
#pets {
margin-left: 75px;
margin-top: 20px;
line-height: 2;
font-size: 20px;
}

#pets p {
margin-left: 40px;
font-weight: bold;
}

#pets button {
margin-left: 50px;
margin-top: 5px;
width: 120px;
height: 30px;
background-color: rgb(16, 177, 16);
border-radius: 10px;
border: none;
color: white;
font-size: 17px;
font-weight: bold;
box-shadow: 0 0 5px black;
}
#pets button:hover {
background-color: white;
color: black;
}

#pets img {
width: 170px;
height: 280px;
border-radius: 10px;
}
#petdetails {
width: 100px;
}

.img1 {
	position: absolute;
	left: 100px;
}

* {
	margin: 0;
	padding: 0;
}
</style>

<body class="" style="background-color: cornsilk">
	<h2 class="h2_1">Mobile Sales App</h2>

	<div style="position: relative; top: -10px;" class="top_nav">

		<ul>
			<li><a class="active" href="MobilePage">Home</a></li>
			<li><a href="ViewOrders1">My Orders</a></li>
			<li><a href="ViewCart.jsp">Cart</a></li>
			<li><a href="MyProfile.jsp">My Profile</a></li>
			<li><a href="ContactUs.jsp">Contact us</a></li>
			<li><a href="AboutUs.jsp">About us</a></li>
			<li style="float: right;"><a href="logOut">Logout</a></li>


		</ul>


	</div>
	<img
		style="border-radius: 100px; position: absolute; top: 0px; left: 500px;"
		width="40px" alt="" src="assets/images/mobile112.png">

	<div class="body_main">
		<br>


		<h5 style="margin-left: 200px;">
			Welcome :${sessionScope.name}</h5>
		<h5 style="margin-left: 200px;">Wallet Amount:${sessionScope.wallet}  </h5>



		<marquee class="mar1" >New
			Smartphone Offer Available upto 15% Discount</marquee>
		<br>
		<div class="searchPro">
			<form action="SearchMobile">
				<input type="text" pattern="[A-Za-z]{1,40}" name="search">
				<button type="submit">Search</button>
			</form>
		</div>
		<br>
		<br>
		<br>
		<br>


		<table>
			<tbody>
				<tr>
					<c:set var="count" value="1" />
					<c:forEach items="${sessionScope.searchList}" var="p">
						<td>
							<table id="pets">
								<tbody>
									<!-- Pet Image -->
									<tr>
										<td><img src="${p.url}" alt="petimage"></td>

									
										<td>
											
											
											<p> ${p.productName}</p>
											
											<p> Rs. ${p.listCost}</p>
											
											<p><a style="border-radius: 20px;position: relative  ;left: 10px;top: 10px;" id="but_id" class="btn btn-primary" href="MobileInfo?productId=${p.id }">View</a></p>
										</td>
				
									</tr>
								</tbody>
							</table>
						</td>
						<c:choose>
							<c:when test="${count==2}">
								<c:set var="count" value="1" />
				</tr>
				<tr>
					</c:when>
					<c:otherwise>
						<c:set var="count" value="2" />
					</c:otherwise>
					</c:choose>
					</c:forEach>
				</tr>
			</tbody>
		</table>

	</div>
</body>

</html>
