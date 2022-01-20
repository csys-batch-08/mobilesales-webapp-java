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
margin:100px;
position: absolute;
left: 300px;
}
body{
background-color:cornsilk;
}
	form  { display: table;      }
p     { display: table-row;  }
label { display: table-cell;position: absolute;right: 90px;  }
input { display: table-cell;position: absolute;left: 100px; }

* {
	margin: 0;
	padding: 0;
}
</style>

<body bgcolor="cornsilk">
	<h2 class="h2_1">Mobile Sales App</h2>


	<div style="position: relative;top: -10px;" class="top_nav">

		<ul>
			<li><a  href="MobilePage.jsp	">Home</a></li>
			<li><a href="ViewOrders.jsp">My Orders</a></li>
			<li><a href="ViewCart.jsp">Cart</a></li>
			<li><a class="active" href="MyProfile.jsp">My Profile</a></li>
			<li><a href="ContactUs.jsp">Contact us</a></li>
			<li><a href="AboutUs.jsp">About us</a></li>
			<li style="float: right;"><a href="logOut">Logout</a></li>
		

		</ul>


	</div>
	<img style="border-radius: 100px;position: absolute;top:0px;left: 500px; " width="40px" alt="" src="assets/images/mobile112.png">
	
	<br>
	<%
	String query="select * from users_table where pk_user_id='"+userId+"'";
	Connection con =ConnectionUtil.connect();
	Statement st=con.createStatement();
	ResultSet rs= st.executeQuery(query);
	if(rs.next()){
		%>
		
		<div class="user_det">
		
		<form action="updateUser" method="post">
		<p>
		<h2 style="position: absolute;left: 80px;">MyProfile</h2><br><br><br>
		</p>
		<p>
		<label>Name : </label>
		 <input type="text"  required class="c_user" name="userName" pattern="[A-Za-z.\s]{3,40}" value="<%= rs.getString(2)%>">	<br><br>
		</p>
		<p>
	    <label>Email :</label>
	     <input type="text" required class="c_user" readonly name="userEmail" value="<%= rs.getString(3)%>">	<br><br>
		</p>
		<p>
		<label>Phone :</label>
		<input class="c_user" required type="text" pattern="[6789]{1}[0-9]{9}" maxlength="10" name="userPhone" value="<%= rs.getString(4)%>">	<br><br>
		</p>
		<p>
		<label>Wallet :</label>
		<input type="text" required class="c_user" name="userWallet" readonly value="<%= rs.getString(6)%>">	<br><br>
		</p>
		<p>
		<button style="margin-left: 100px" class="btn btn-primary" type="submit">Update</button>
		</p>
		</form>
		</div>
		
		<%}
	String message=(String)session.getAttribute("msg");
	if(message!=null){%>
	<script type="text/javascript">
	alert('<%= message%>');
	</script>
		
		<%	}
	session.removeAttribute("msg");
	
	%>
	
	
	
</body>
</html>