
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">


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
	background-color:navy;
}

.button1:hover {
	background-color: blue;
}

.mar1 {
	font-size: 30px;
	color: green	;
}

.body_main1 {
	
	background: linear-gradient(rgba(0, 0, 0, .3) 70%, rgba(0, 0, 0, .3)
		-70%),
		url(https://cdn.pixabay.com/photo/2016/12/09/11/33/smartphone-1894723__340.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	/* background: rgba(76, 175, 80, 0.3) */
	height: 100%;
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
.searchPro{
position: absolute;
left: 420px;
}
.searchPro input[type=text]{
padding:10px;
font-size: 16px;
float:left;
}
.searchPro button{
float: left;
padding:10px;
 background: #2196F3;
  font-size: 17px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
}
.c_user {
    border-top: none;
    border-left: none;
    border-right: none;
    width: 300px;
    height: 25px;
    margin-left: 30px;
}
.user_det{
margin:60px;
position: absolute;
left: 250px;
}
body{
background-color:cornsilk;
}
	form  { display: table;      }
p     { display: table-row;  }
label { display: table-cell;position: absolute;right: 90px;  }
input { display: table-cell;position: absolute;left: 80px; }

* {
	margin: 0;
	padding: 0;
}
</style>

<body >
	<h2 class="h2_1">Mobile Sales App</h2>


	<div style="position: relative;top: -10px;" class="top_nav">

		<ul>
			<li><a  href="MobilePage">Home</a></li>
			<li><a href="ViewOrders1">My Orders</a></li>
			<li><a href="ViewCart">Cart</a></li>
			<li><a class="active" href="MyProfile">My Profile</a></li>
			<li><a href="contactUs.jsp">Contact us</a></li>
			<li><a href="aboutUs.jsp">About us</a></li>
			<li style="float: right;"><a href="logOut">Logout</a></li>


		</ul>


	</div>
	<img style="border-radius: 100px;position: absolute;top:0px;left: 500px; " width="40px" alt="" src="assets/images/mobile112.png">
	
	<br>
	<c:forEach items="${listAllDetails}" var="listAllDetail">
		
		<div class="user_det">
		
		<form action="updateUser" method="post">
		<p>
		<h2 style="position: absolute;left: 80px;">MyProfile</h2><br><br><br>
		</p>
		<p>
		<label>Name : </label>
		 <input type="text"  required class="c_user" name="userName" pattern="[A-Za-z.\s]{3,40}" value="${listAllDetail.name}">	<br><br>
		</p>
		<p>
	    <label>Email :</label>
	     <input type="text" required class="c_user" readonly name="userEmail" value="${listAllDetail.email}">	<br><br>
		</p>
		<p>
		<label>Phone :</label>
		<input class="c_user" required type="text" pattern="[6789]{1}[0-9]{9}" maxlength="10" name="userPhone" value="${listAllDetail.phoneNumber}">	<br><br>
		</p>
		<p>
		<label>Wallet :</label>
		<input type="text" required class="c_user" name="userWallet" readonly value="${listAllDetail.wallet}">
	
		<br><br>
		</p>
		<p>
		<button style="margin-left: 100px" class="btn btn-primary" type="submit">Update</button>
		</p>
		</form>
			<div >
		<details style="position:absolute;left: 450px ;top: 210px;padding: 4px;">
		<summary style=" padding: 4px;" class="btn btn-secondary" >Recharge</summary>
		<p><form action="addWallet" method="post">
					<p ><br>
						
						<input hidden="" style=" display: table-cell;position: absolute;left: 80px;" type="text" name="walletUserId"
							value="${listAllDetail.userId}" readonly pattern="[0-9]{1,8}"
							maxlength="8" required></p>
							<p>
							<label style=" display: table-cell;position: absolute;right:  20px;">Wallet:</label>
							 <input style=" display: table-cell;position: absolute;left: 70px;" type="text" name="walletAmount" pattern="[1-9][0-9]{1,8}"
							maxlength="8" title="Only enter positive number" required><br> <br>
						<button style=" display: table-cell;position: absolute;left:  20px;" type="submit" class="btn btn-success">Add</button>
						<br> <br></p>
					</form>
		</details>	</div>
		</div>
	</c:forEach>

	
	
	
</body>
</html>