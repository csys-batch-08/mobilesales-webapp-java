
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="assets/javascript/orderScript.js"></script>
<title>ViewOrders</title>
</head>
<style>
@import url('https://fonts.googleapis.com/css2?family=Heebo&family=Roboto:ital@1&display=swap');


*{
font-family:Heebo;
}
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

.searchPro {
	position: absolute;
	left: 420px;
}

.searchPro input[type=date] {
	padding: 4px;
	font-size: 16px;
	float: left;
}

.searchPro button {
	float: left;
	padding: 4px;
	background: #2196F3;
	font-size: 17px;
	border: 1px solid grey;
	border-left: none;
	cursor: pointer;
}

.but_log {
	margin-top: 40px;
}

.btn_add {
	text-decoration: none;
	padding: 12px;
	color: black;
	background-color: lightblue;
	border-radius: 22px;
}

body {
	background-color: cornsilk;
}

.btn_add:hover {
	background-color: cornflowerblue;
}

table {
	background-color: white;
}

#product {
	width: 90%;
	margin-left: 60px;
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
			<li><a href="MobilePage">Home</a></li>
			<li><a class="active" href="ViewOrders1">My Orders</a></li>
			<li><a href="ViewCart">Cart</a></li>
			<li><a href="MyProfile">My Profile</a></li>
			<li><a href="contactUs.jsp">Contact us</a></li>
			<li><a href="aboutUs.jsp">About us</a></li>
			<li style="float: right;"><a href="logOut">Logout</a></li>



		</ul>


	</div>
	<img
		style="border-radius: 100px; position: absolute; top: 0px; left: 500px;"
		width="40px" alt="" src="assets/images/mobile112.png">

	<br>
	<br>




	<div class="searchPro">
		<form action="SearchOrder">
			<input type="date" id="search" name="OrderDate" required>
			<button class="btn btn-primary" type="submit">Search</button>
		</form>
	</div>
	<br>
	<br>
	<br>
	<script type="text/javascript">
		let today = new Date().toISOString().slice(0, 10);

		console.log(today);
		document.getElementById("search").max = today;
	</script>
	<c:if test="${sessionScope.userId1!=null}">
		<table aria-describedby="Show All home places" id="product"
			class="table table-hover table-striped">

			<tr style="background-color: cornflowerblue">
				<th>Serial No</th>
				<th>Product</th>
				<th>Order Status</th>
				<th>Price</th>
				<th>Order Date</th>
				<th>Delivery Address</th>
				<th>Cancel Order</th>
			</tr>



			<c:set var="serialNumber" value="1" scope="page"></c:set>
			<c:forEach items="${sessionScope.orderList}" var="orderList">
				<tr>
					
					<td>${serialNumber}</td>
					<td><img width="110px;" alt="${orderList.productId}"
						src="${orderList.url}"></td>
					<td>${orderList.status}</td>
					<td> &#x20b9;${orderList.price }</td>
					<td><fmt:parseDate value="${orderList.date}"
							pattern="yyyy-MM-dd'T'HH:mm" var="orderDate" type="both" /> <fmt:formatDate
							pattern="dd-MM-yyyy HH:mm" value="${orderDate}" /></td>
					<td>${orderList.address}</td>
					<td>



						<div class="container mt-3">


							<button type="button" class="btn btn-danger"
								data-bs-toggle="modal" data-bs-target="#myModal_${serialNumber}">Cancel
							</button>
						</div>
						<div class="modal fade" id="myModal_${serialNumber}">
							<div class="modal-dialog">
								<div class="modal-content">

									<div class="modal-header">
										<h4 class="modal-title">Cancel Order</h4>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal"></button>
									</div>


									<div class="modal-body">
										<div><form action="">
											<input type="hidden" name="cancelId"
												value="${orderList.orderId }" readonly><br>

											<p>Do you want to cancel your order(${orderList.orderId }) ?</p>
											<button class="btn btn-success" type="submit"
												onclick="Cancel('${orderList.status}','${orderList.orderId }','${orderList.price }','${orderList.userId}')"
												class="btn_add">Confirm</button>
										</form>
										</div>
									</div>


									<div class="modal-footer">
										<button type="button" class="btn btn-danger"
											data-bs-dismiss="modal">Close</button>
									</div>

								</div>
							</div>
						</div>

					</td>
				</tr>
				<c:set var="serialNumber" value="${serialNumber+1 }" scope="page"></c:set>
			</c:forEach>



		</table>
	</c:if>
	<c:if test="${sessionScope.userId1==null}">
		<h1 style="color: red; margin-left: 500px; margin-top: 150px">Order
			is not placed yet</h1>
	</c:if>




</body>
</html>