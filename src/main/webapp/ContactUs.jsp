<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<title>ContactUs</title>
</head>
<style>
.h2_1 {
	text-align: center;
	background-color: bisque;
}

.container {
	text-align: center;
	position: absolute;
	top: 120px;
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

.b_reg {
	padding: 12px;
	margin-left: 50px;
	background-color: rgb(83, 83, 204);
	border-radius: 20px;
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

.c_user2 {
	border-top: none;
	border-left: none;
	border-right: none;
	width: 300px;
	height: 20px;
}

table td, th {
	padding: 10px;
}
input{
margin-top:10px; 
}

body {
	background-color: cornsilk;
}
	form  { display: table;      }
p     { display: table-row;  }
label { display: table-cell;position: absolute;right: 1000px;  }
input { display: table-cell;position: absolute;left: 200px; }

* {
	margin: 0;
	padding: 0;
}
</style>
<body bgcolor="cornsilk">
	<h2 class="h2_1">Mobile Sales App</h2>

	<div style="position: relative; top: -10px;" class="top_nav">

		<ul>
			<li><a  href="MobilePage">Home</a></li>
			<li><a href="ViewOrders1">My Orders</a></li>
			<li><a href="ViewCart.jsp">Cart</a></li>
			<li><a href="MyProfile.jsp">My Profile</a></li>
			<li><a class="active" href="ContactUs.jsp">Contact us</a></li>
			<li><a href="AboutUs.jsp">About us</a></li>
			<li style="float: right;"><a href="logOut">Logout</a></li>


		</ul>


	</div>
	<img style="border-radius: 100px;position: absolute;top:0px;left: 500px; " width="40px" alt="" src="assets/images/mobile112.png">
	
	<br>
	
	<br>
	<br>
	<div style="position:absolute;left:200px; margin-top: 50px;" class="container">



			<form action="contactUs" method="post">
			<h1 style="margin-left: 200px;">Contact Us</h1>
				<p>
					<label for="">Name:</label>
					<input class="c_user2" name="name1" type="text"
						autocomplete="off" pattern="[A-Za-z]{3,40}"
						title="Only enter A-Z ,a-z and enter  min 3 to max 40 " required><br>
					<br>
				</p>
				<p>

					<label for="">Email:</label>
					<input class="c_user2" name="email" autocomplete="off"
						pattern="[a-z][a-z0-9_.]+@[a-z0-9.]+[.][a-z]+" type="email"
						title="Enter valid email ex(example12@gmail.com)" required><br>
					<br>
				</p>
				<p>
					<label for="">Phone :</label>
					<input class="c_user2" autocomplete="off"
						name="phone_number" type="text" pattern="[6789]{1}+[0-9]{9}"
						maxlength="10" title="Enter only 10 digit number" required><br>
					<br>
				</p>
				
				<p>
					<label for="">Description :</label>
					<input style="margin-left: 0px" class="c_user2"
						name="name1" type="text" autocomplete="off"
						pattern="[a-zA-Z0-9\s,[]]{3,40}"
						title="Only enter A-Z ,a-z and enter  min 3 to max 40 " required><br>
					<br>
				</p>
		
		<br>
				<p>
				<button style="margin-left: 150px" type="submit"
					class="btn btn-primary">Submit</button>
		</p>
	
	</form>
	</div>

	

</body>
</html>