
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.mobilesalesapp.impl.OrderImpl"
	import="java.sql.*" import="com.mobilesalesapp.model.OrderPojo"%>
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
body{
background-color: cornsilk;
}

.btn_add:hover {
	background-color: cornflowerblue;
}
table{
background-color: rgb(248, 213, 168);
}

* {
	margin: 0;
	padding: 0;
}
</style>
<body  >
	<h2 class="h2_1">Mobile Sales App</h2>

	<div style="position: relative;top: -10px;" class="top_nav">

		<ul>
			<li><a href="MobilePage.jsp">Home</a></li>
			<li><a class="active" href="ViewOrders.jsp">My Orders</a></li>
			<li><a href="ViewCart.jsp">Cart</a></li>
			<li><a href="MyProfile.jsp">My Profile</a></li>
			<li><a href="ContactUs.jsp">Contact us</a></li>
			<li><a href="AboutUs.jsp">About us</a></li>
			<li style="float: right;"><a href="logOut">Logout</a></li>


		</ul>


	</div>
	<img style="border-radius: 100px;position: absolute;top:0px;left: 500px; " width="40px" alt="" src="assets/images/mobile112.png">
	
	<br>
	<br>

	<%
	String user = (String) session.getAttribute("userId");
	//System.out.println("my" + user);
	int userId = Integer.parseInt(user);
//	System.out.println("my1	" + userId);
	OrderPojo orderPojo = new OrderPojo(userId);
	OrderImpl order = new OrderImpl();
	ResultSet rs = order.viewAllOrders(orderPojo);
	ResultSet rs1 = order.viewAllOrders(orderPojo);
	%>
	<%
	if (rs1.next()) {
		
	%>


	<div class="searchPro"">
		<form action="SearchOrder.jsp">
			<input type="date" id="search" name="OrderDate" 
				 requried>
			<button class="btn btn-primary" type="submit">Search</button>
		</form>
	</div>
	<br>
	<br>
	<br>
	<script type="text/javascript">
		let today = new Date().toISOString().slice(0, 10);
	
		console.log(today);
		document.getElementById("search").max =today;
		
	</script>

	<table class="table table-hover table-striped" style="width: 90%; margin-left: 60px;">
		<tr style="background-color:cornflowerblue ">
			
			<th>Product</th>
			<th>Order Status</th>
			<th>Price</th>
			<th>Order Date</th>
			<th>Delivery Address</th>
			<th>Cancel Order</th>
		</tr>




		<%
		while (rs.next()) {
			System.out.println("url id "+rs.getInt(6));
			int productId=rs.getInt(6);
			OrderImpl orderImpl =new OrderImpl();
			
			String url=orderImpl.getUrl(productId);
			
		%>
		<tr>
			
			<td> <img width="100px" alt="null" src="<%=url%>"> </td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getDouble(3)%></td>
			<td><%=rs.getString(4)%></td>
			<td><%=rs.getString(5)%></td>
			<td>
			
					Order Id :<input type="text" name="cancelId"
						value="<%=rs.getInt(1)%>" readonly><br>
					<br>

					<button class="btn btn-danger" type="submit" onclick="Cancel('<%=rs.getString(2)%>','<%=rs.getInt(1)%>')" class="btn_add">Cancel</button>
				
			</td>
		</tr>

		<%
		}
		%>



	</table>

	<%
	} else {
	%>
	<h1 style="color: red; margin-left: 500px; margin-top: 150px">Order
		is not placed yet</h1>
	<%
	}
	%>
	<script type="text/javascript">
	function Cancel(status,id) {
		console.log('on'+status);
		var url1="cancelOrder?orderStatus="+status+"&orderId="+id;
		if(window.XMLHttpRequest){  
    		request=new XMLHttpRequest();  
    		}  
    		else if(window.ActiveXObject){  
    		request=new ActiveXObject("Microsoft.XMLHTTP");  
    		} 
	
	   	try  
    	{  
    	request.onreadystatechange=getInfo;  
    	request.open("GET",url1,true);  
    	request.send();  
    	}  
    	catch(e)  
    	{  
    	alert("Unable to connect to server");  
    	}
        
      
    } 
    
    function getInfo(){  
    	if(request.readyState==4){  
    	var val=request.responseText;
    	 alert(val);  
    	}
		
	}
	</script>


</body>
</html>