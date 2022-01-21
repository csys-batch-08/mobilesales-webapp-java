<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.mobilesalesapp.impl.*"
	import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<title>InActiveUsers</title>
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

.active {
	background-color: grey;
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
			<li style="float: right;"><a class="active" href="AdminMain.jsp">Admin</a></li>
			


		</ul>
	</div>
	<img style="border-radius: 100px;position: absolute;top:0px;left: 500px; " width="40px" alt="" src="assets/images/mobile112.png">
	
	<div class="full">
	<br>


	
		<%
		UserImpl userDao = new UserImpl();
		ResultSet ns = userDao.inActiveUserDetails();
		%>
		<table style="width: 90%; margin-left: 50px;">
			<tr style="background-color: cornflowerblue">
				<th>Name</th>
				<th>Email</th>
				<th>Phone Number</th>
				<th>Request</th>
				
				<th>Action</th>

			</tr>
			<%
			while (ns.next()) {
			%>


			<tr>
				<td><%=ns.getString(2)%></td>
				<td><%=ns.getString(3)%></td>
				<td><%=ns.getLong(4)%></td>
				<td><%=ns.getString(5)%></td>
		
				<td>
					<a class="btn btn-dark" href="activeUser?userId=<%=ns.getInt(1)%>">Active</a>
					
				</td>

			</tr>
			<%
			}
			%>
		</table>
	</div>
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if ((session.getAttribute("role") == null)) {
		response.sendRedirect("index.jsp");
	}
	%>

	

</body>
</html>