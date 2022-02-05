<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="assets/css/navigation.css">

<link rel="stylesheet" href="assets/css/admin.css">
<title>AdminPage</title>



</head>

<body>
	<h2 class="h2_1">Mobile Sales App</h2>

	<div style="position: relative; top: -10px;" class="top_nav">

		<ul>


			<li style="float: right;"><a href="logOut">Logout</a></li>
			<li style="float: right;"><a class="active" href="adminMain.jsp">Admin</a></li>



		</ul>


	</div>
	<img
		style="border-radius: 100px; position: absolute; top: 0px; left: 500px;"
		width="40px" alt="" src="assets/images/mobile112.png">

	<div class="body_main1">
		<br>

		<div class="add_con1">
			<div class="btn btn-block">
				<br> <a class="btn btn-secondary " style="margin-left: 40px"
					href="addProduct.jsp">Add Products</a><br> <br> <a
					class="btn btn-secondary btn-block" style="margin-left: 40px"
					href="ViewProduct">View Products</a><br> <br> <a
					class="btn btn-secondary btn-block" style="margin-left: 40px"
					href="ViewUser">View All Users</a><br> <br><a
					class="btn btn-secondary btn-block" style="margin-left: 40px"
					href="viewSales">View All Sales</a><br> <br> <a
					class="btn btn-secondary btn-block" style="margin-left: 40px"
					href="ViewContactUs1">View ContactUs</a><br> <br> <a
					class="btn btn-secondary btn-block" style="margin-left: 40px"
					href="InActiveUsers">InActive Users</a><br> <br>
			</div>
		</div>
	</div>






</body>
</html>