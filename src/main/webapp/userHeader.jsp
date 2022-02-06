<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header file</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="assets/css/header.css">
</head>
<body>
	<h2 class="h2_1">Mobile Sales App</h2>
	<div class="top_nav">

		<ul>
		<li></li>
			<li><a class="active" href="MobilePage">Home</a></li>
			<li><a href="ViewOrders1">My Orders</a></li>
			<li><a href="ViewCart">Cart</a></li>
			<li><a href="MyProfile">My Profile</a></li>
			<li><a href="contactUs.jsp">Contact us</a></li>
			<li><a href="aboutUs.jsp">About us</a></li>
			<li style="float: right;"><a href="logOut">Logout</a></li>
			<li>
				<div class="searchPro1">
					<form class="input-group mb-7" action="SearchMobile">
						<input class="form-control" type="text" pattern="[A-Za-z]{1,40}"
							name="search">
						<button class="btn btn-primary" type="submit">Search</button>

					</form>
				</div>

			</li>

		</ul>


	</div>
	<img class="imgs" alt="icon" src="assets/images/mobile112.png">
</body>
</html>