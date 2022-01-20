<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"
	import ="com.mobilesalesapp.util.*" %>
<%
if (session.getAttribute("name") == (null)) {
	response.sendRedirect("index.jsp");
}
String name = (String) session.getAttribute("name");
int userId = Integer.parseInt(session.getAttribute("userId").toString());

String query1="select * from users_table where pk_user_id='"+userId+"'";
Connection con1 =ConnectionUtil.connect();
Statement st1=con1.createStatement();
ResultSet rs1= st1.executeQuery(query1);
double wallet=0;
if(rs1.next()){
	wallet=rs1.getDouble(6);
}
System.out.println(userId);
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

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
bod{
background-image: url("https://image.freepik.com/free-psd/smartphone-screen-mockup-glowing-neon-lights_53876-98580.jpg");
background-repeat:repeat;
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
	color: green	;
}

.body_main1 {
	
	background: linear-gradient(rgba(0, 0, 0, .3) 60%, rgba(0, 0, 0, .3)
		-70%),
		url(https://image.freepik.com/free-psd/smartphone-screen-mockup-glowing-neon-lights_53876-98580.jpg);
	background-repeat:repeat;
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
.img1{
position: absolute;
left: 100px;
}

* {
	margin: 0;
	padding: 0;
}
</style>

<body class="" style="background-color:  cornsilk">
	<h2 class="h2_1">Mobile Sales App</h2>

	<div style="position: relative; top: -10px;" class="top_nav">

		<ul>
			<li><a class="active" href="MobilePage.jsp	">Home</a></li>
			<li><a href="ViewOrders.jsp">My Orders</a></li>
			<li><a href="ViewCart.jsp">Cart</a></li>
			<li><a href="MyProfile.jsp">My Profile</a></li>
			<li><a href="ContactUs.jsp">Contact us</a></li>
			<li><a href="AboutUs.jsp">About us</a></li>
			<li style="float: right;"><a href="logOut">Logout</a></li>
		

		</ul>


	</div>
	<img style="border-radius: 100px;position: absolute;top:0px;left: 500px; " width="40px" alt="" src="assets/images/mobile112.png">

	<div class="body_main"><br>

		
		<h5 style="margin-left: 200px;">Welcome :<%=name%></h5>
		<h5 style="margin-left: 200px;"><%="Wallet Amount: " + wallet%></h5>



		<marquee class="mar1" behavior="" direction="">New
			Smartphone Offer Available upto 15% Discount</marquee><br>
<div class="searchPro">			
<form action="SearchMobile.jsp">
<input type="text" name="search"  >
<button type="submit">Search</button>
</form>
</div><br><br><br><br>



	<table style="margin-left: 222px;" id="table2" class="table1">
			<%
			String query = "select * from products ";
				Connection con = ConnectionUtil.connect();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				int i = 0;
				while (i <= 1) {
					if (rs.next()) {
						System.out.println("proId"+rs.getInt(1));
			%>
			<tr>



				<th><a  style="margin-left: 50px;" href="MobileInfo.jsp?product_id=<%=rs.getInt(1)%>"> <img
						src="<%=rs.getString(6)%>" alt=""></a></th>
			</tr>

			<tr>

				<td><br> <%=rs.getString(2)%></td>

			</tr>
			<tr>

				<td><br> <%=rs.getString(5)%></td>

			</tr>
			<tr>

				<td><a style="border-radius: 20px;" id="but_id" class="btn btn-primary" href="MobileInfo.jsp?product_id=<%=rs.getInt(1)%>">View</a>
				</td>

			</tr>

			<%
			}
			i++;
			}
			%>
		</table>


		<table style="margin-left: 622px; margin-top: -1090px" class="table1">
			<div class="table_right">
				<%
				int j = 0;
				while (j <= 1) {
					if (rs.next()) {
				%>
				<tr>

					<div class="img1">
					<th><a style="margin-left: 80px;" href="MobileInfo.jsp?product_id=<%=rs.getInt(1)%>"> <img
							src="<%=rs.getString(6)%>" alt=""></a></th>
							</div>
				</tr>

				<tr>

					<td><br> <%=rs.getString(2)%></td>

				</tr>
				<tr>

					<td><br> <%=rs.getString(5)%></td>

				</tr>
				<tr>

					<td ><a id="but_id" style="border-radius: 20px;" class="btn btn-primary" href="MobileInfo.jsp?product_id=<%=rs.getInt(1)%>">View</a>
				</td>

				</tr>
				<br>

				<%
				}
				j++;
				}
				%>
			</div>
		</table>




		<table style="margin-left: 642px;margin-top: -30px;" class="table1">
			<div class="table_right">
				<%
				int k = 0;
				while (k <= 1) {
					if (rs.next()) {
				%>
				<tr>


					<th><a  style="margin-left: 60px;" href="MobileInfo.jsp?product_id=<%=rs.getInt(1)%>"> <img
							src="<%=rs.getString(6)%>" alt=""></a></th>
				</tr>

				<tr>

					<td><br> <%=rs.getString(2)%></td>

				</tr>
				<tr>

					<td><br> <%=rs.getString(5)%></td>

				</tr>
				<tr>

					<td><a id="but_id" style="border-radius: 20px;" class="btn btn-primary" href="MobileInfo.jsp?product_id=<%=rs.getInt(1)%>">View</a>
				</td>

				</tr>
				<br>

				<%
				}

				k++;
				}
				%>
			</div>
		</table>


		<table style="margin-left: 212px; margin-top: -1080px" class="table1">
			<div class="table_right">
				<%
				int l = 0;
				while (l <= 1) {
					if (rs.next()) {
				%>
				<tr>


					<th><a  style="margin-left: 60px;" href="MobileInfo.jsp?product_id=<%=rs.getInt(1)%>"> <img
							src="<%=rs.getString(6)%>" alt=""></a></th>
				</tr>

				<tr>

					<td><br> <%=rs.getString(2)%></td>

				</tr>
				<tr>

					<td><br> <%=rs.getString(5)%></td>

				</tr>
				<tr>

					<td><a id="but_id" style="border-radius: 20px;" class="btn btn-primary" href="MobileInfo.jsp?product_id=<%=rs.getInt(1)%>">View</a>
				</td>

				</tr>
				<br>

				<%
				}

				l++;
				}
				%>
			
		</table>
</div>
</body>

</html>
