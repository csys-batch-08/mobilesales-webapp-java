<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
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

.active {
	background-color: grey;
}
table {
	background-color: white;
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
			<form class="input-group mb-7" action="SearchUsers">
				<input class="form-control" type="text" pattern="[A-Za-z]{1,40}" name="search">
				<button class="btn btn-primary" type="submit">Search</button>
			</form>
		</div>
		<br>
	
		
		<table aria-describedby="Show All home places" id="user" class="table table-hover table-striped" >
			<tr style="background-color: cornflowerblue">
				<th>Serial No</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone Number</th>
				
				<th>Action</th>
				<th>Orders</th>
				<th>Inactive</th>

			</tr>
			<c:set var="serialNumber" value="1" scope="page"></c:set>
			<c:forEach items="${userDetails}" var="userDetail">

			<tr>
				<td>${serialNumber}</td>
				<td>${userDetail.name}</td>
				<td>${userDetail.email}</td>
				<td>${userDetail.phoneNumber}</td>
				<td>${userDetail.wallet}</td>
			
				<td>
			
					<a class="btn btn-primary" href="DeliveredOrder?userId=${userDetail.userId}">View Order</a>

				</td>
				<td>
					<div class="container mt-3">


						<button type="button" class="btn btn-dark"
							data-bs-toggle="modal" data-bs-target="#myModal_${serialNumber}">InActive
						</button>
					</div> 
					<div class="modal fade" id="myModal_${serialNumber}">
						<div class="modal-dialog">
							<div class="modal-content">

								<div class="modal-header">
									<h4 class="modal-title">User Inactivation</h4>
									<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
								</div>

							
								<div class="modal-body">
									<div>
					
					
					<p>Do you want to InActive this user(${userDetail.name}) ?</p>
				<a class="btn btn-success" href="inActive?userId=${userDetail.userId}">Confirm</a>
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
	</div>


</body>
</html>