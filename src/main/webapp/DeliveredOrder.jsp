
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<title>ViewOrders</title>
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
.btn_add {
	padding: 12px;
	background-color: lightbrown;
	border-radius: 22px;
}

.btn_add:hover {
	background-color: cornflowerblue;
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
.but_log a{
	text-decoration:none;
	color:white;
 	padding: 12px;
 	margin-top:20px;
    margin-left: 100px;
    background-color: rgb(83, 83, 204);
    border-radius: 20px;

}
.but_log{
margin-top:40px;
}
body{
background-color:cornsilk;
}
table{
background-color: rgb(248, 213, 168);
}

* {
	margin: 0;
	padding: 0;
}
</style>
<body bgcolor="cornsilk">
	<h2 class="h2_1">Mobile Sales App</h2>

	<div style="position: relative;top: -10px;" class="top_nav">

		<ul>

			<li style="float: right;"><a href="logOut">Logout</a></li>
			<li style="float: right;"><a href="AdminMain.jsp">Admin</a></li>

		</ul>


	</div>
	<img style="border-radius: 100px;position: absolute;top:0px;left: 500px; " width="40px" alt="" src="assets/images/mobile112.png">
	
	<br><br>
	
  <c:if test="${userId==null}">
    	
    <table style="width: 80%;margin-left: 100px;">
    <tr style="background-color: cornflowerblue">
     <th>Order Id</th>
    <th>Order Status</th>
    <th>Price</th>
    <th>Order Date</th>
    <th>Delivery Address</th>
    <th>Cancel Order</th>
    </tr>

    
 <c:forEach items="${orderDetails}" var="o">
  	
    <tr>
    <td>${o.orderId }</td>
    <td>${o.status }</td>
    <td>${o.price }</td>
    <td>${o.date }</td>
    <td>${o.address}</td>
    <td>
 
    <a class="btn btn-success" href="deliveredOrder?orderId=${o.orderId }&deliveryStatus=${o.status }">Delivered</a>
    </td>
    </tr>
  
    	</c:forEach>
    		
    	
   
    </table>
    </c:if>

<c:if test="${userId!=null}">
    	<h1 style="color: red ;margin-left: 500px;margin-top: 150px">Order is not placed yet</h1>
   </c:if>




</body>
</html>