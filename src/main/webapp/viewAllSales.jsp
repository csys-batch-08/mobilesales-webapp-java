<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">


<title>UsersList</title>
</head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 10px;
	
}
body{
background-color:cornsilk;
}
table {
	background-color: rgb(248, 213, 168);
}


.full1 {
	background: linear-gradient(rgba(0, 0, 0, .3) 70%, rgba(0, 0, 0, .3)
		-70%),
		url(https://images.unsplash.com/photo-1506102383123-c8ef1e872756?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8Mjd8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60);
	background-repeat: no-repeat;
	background-size: cover;
	/* background: rgba(76, 175, 80, 0.3) */
	height: 100%;
}

.btn_add {
	padding: 12px;
	background-color: lightbrown;
	border-radius: 22px;
}

.btn_add:hover {
	background-color: cornflowerblue;
}

.btn_add1 {
	text-decoration: none;
	color: black;
	padding: 12px;
	background-color: lightblue;
	border-radius: 22px;
}

.btn_add1:hover {
	background-color: cornflowerblue;
}

.h2_1 {
	text-align: center;
	background-color: bisque;
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
#product {
	width: 95%;
	margin-left: 40px;
}

.active {
	background-color: grey;
}
table{
background-color:white;
}
#user{
width: 90%; margin-left: 50px;
}
.input-group{
margin-left:1000px;
width: 20%;
}

* {
	margin: 0;
	padding: 0;
}
</style>
<body >
	<h2 class="h2_1">Mobile Sales App</h2>

	<div style="position: relative;top: -10px;" class="top_nav">

		<ul>
			<li style="float: right;"><a href="logOut">Logout</a></li>
			<li style="float: right;"><a class="active" href="adminMain.jsp">Admin</a></li>
			


		</ul>
	</div>
	<img style="border-radius: 100px;position: absolute;top:0px;left: 500px; " width="40px" alt="" src="assets/images/mobile112.png">
	
	<div class="full">
	<br>





	<div class="searchPro">
		<form action="SearchSales">
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

		<table aria-describedby="Show All home places" id="product"
			class="table table-hover table-striped">

			<tr style="background-color: cornflowerblue">
				<th>Serial No</th>
				<th>Product</th>
				<th>Order Id</th>
				<th>Order Status</th>
				<th>Price</th>
				<th>Order Date</th>
				<th>Delivery Address</th>
			
			</tr>



			<c:set var="serialNumber" value="1" scope="page"></c:set>
			<c:forEach items="${sessionScope.salesList}" var="orderList">
				<tr>
					
					<td>${serialNumber}</td>
				<td><img width="110px;" alt="Mobiles"
						src="${orderList.url}"></td>
						<td>${orderList.orderId }</td>
					<td>${orderList.status}</td>
					<td> &#x20b9;${orderList.price }</td>
					<td><fmt:parseDate value="${orderList.date}"
							pattern="yyyy-MM-dd'T'HH:mm" var="orderDate" type="both" /> <fmt:formatDate
							pattern="dd-MM-yyyy HH:mm" value="${orderDate}" /></td>
					<td>${orderList.address}</td>
				
				</tr>
				<c:set var="serialNumber" value="${serialNumber+1 }" scope="page"></c:set>
			</c:forEach>



		</table>
	
	</div>




</body>
</html>