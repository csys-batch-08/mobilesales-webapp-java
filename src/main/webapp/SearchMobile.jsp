<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"
	import ="com.mobilesalesapp.util.*" %>
<%
if (session.getAttribute("name") == (null)) {
	response.sendRedirect("index.jsp");
}
String name = (String) session.getAttribute("name");
String userId1 = (String) session.getAttribute("userId");

double wallet = (double) session.getAttribute("wallet");
int userId = Integer.parseInt(userId1);
System.out.println(userId);
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
	
	background: linear-gradient(rgba(0, 0, 0, .3) 70%, rgba(0, 0, 0, .3)
		-70%),
		url(https://images.unsplash.com/photo-1506102383123-c8ef1e872756?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8Mjd8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60);
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
.table_right {
	margin-right: 200px
}

* {
	margin: 0;
	padding: 0;
}
</style>

<body bgcolor="cornsilk">
	<h2 class="h2_1">Mobile Sales App</h2>


	<div class="top_nav">

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
	
	<br>

	<div class="body_main">
		<br>
		<h3 style="margin-left: 200px;"><%=name%></h3>
		<h3 style="margin-left: 200px;"><%="Wallet Amount: " + wallet%></h3>



		<marquee class="mar1" behavior="" direction="">New
			Smartphone Offer Available upto 15% Discount</marquee><br><br>
	<div class="searchPro">	
<form action="SearchMobile.jsp">
<input type="text" name="search"  >
<button type="submit">Search</button>
</form>
</div>	<br><br><br>


	<table class="table table-hover table-striped" style="margin-left: 222px;" id="table2" class="table1">
			<%
			String search=( request.getParameter("search")).toLowerCase();
			//System.out.println(search+" searches ");
			String query = "select * from products where lower(product_name) like '"+search+"%'";
				Connection con = ConnectionUtil.connect();
				Statement st = con.createStatement();
				Statement st1 = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				ResultSet rs1 = st1.executeQuery(query);
				int i = 0;
				if(rs1.next()){
				while (i <= 1) {
					if (rs.next()) {
						System.out.println("proId"+rs.getInt(1));
			%>
			<tr>



				<th><a href="MobileInfo.jsp?product_id=<%=rs.getInt(1)%>"> <img
						src="<%=rs.getString(6)%>" alt=""></a></th>
			</tr>

			<tr>

				<td><br> <%=rs.getString(2)%></td>

			</tr>
			<tr>

				<td><br> <%=rs.getString(5)%></td>

			</tr>
			<tr>

				<td><a id="but_id" class="button1" href="MobileInfo.jsp?product_id=<%=rs.getInt(1)%>">Buy</a>
				</td>

			</tr>

			<%
			}
			i++;
			}
			%>
		</table>


		<table style="margin-left: 622px; margin-top: -1050px" class="table1">
			<div class="table_right">
				<%
				int j = 0;
				while (j <= 1) {
					if (rs.next()) {
				%>
				<tr>


					<th><a href="MobileInfo.jsp?product_id=<%=rs.getInt(1)%>"> <img
							src="<%=rs.getString(6)%>" alt=""></a></th>
				</tr>

				<tr>

					<td><br> <%=rs.getString(2)%></td>

				</tr>
				<tr>

					<td><br> <%=rs.getString(5)%></td>

				</tr>
				<tr>

					<td><a id="but_id" class="button1" href="MobileInfo.jsp?product_id=<%=rs.getInt(1)%>">Buy</a>
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




		<table style="margin-left: 622px;" class="table1">
			<div class="table_right">
				<%
				int k = 0;
				while (k <= 1) {
					if (rs.next()) {
				%>
				<tr>


					<th><a href="MobileInfo.jsp?product_id=<%=rs.getInt(1)%>"> <img
							src="<%=rs.getString(6)%>" alt=""></a></th>
				</tr>

				<tr>

					<td><br> <%=rs.getString(2)%></td>

				</tr>
				<tr>

					<td><br> <%=rs.getString(5)%></td>

				</tr>
				<tr>

					<td><a id="but_id" class="button1" href="MobileInfo.jsp?product_id=<%=rs.getInt(1)%>">Buy</a>
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


		<table style="margin-left: 222px; margin-top: -1030px" class="table1">
			<div class="table_right">
				<%
				int l = 0;
				while (l <= 1) {
					if (rs.next()) {
				%>
				<tr>


					<th><a href="MobileInfo.jsp?product_id=<%=rs.getInt(1)%>"> <img
							src="<%=rs.getString(6)%>" alt=""></a></th>
				</tr>

				<tr>

					<td><br> <%=rs.getString(2)%></td>

				</tr>
				<tr>

					<td><br> <%=rs.getString(5)%></td>

				</tr>
				<tr>

					<td><a id="but_id" class="button1" href="MobileInfo.jsp?product_id=<%=rs.getInt(1)%>">Buy</a>
				</td>

				</tr>
				<br>

				<%
				}

				l++;
				}}
				else{
				%>
				<h2 style="color: red; margin:100px;position:absolute; left: 350px">Product Not Found</h2>
				<%} %>
		</table>
</div>


</div>
</body>

</html>