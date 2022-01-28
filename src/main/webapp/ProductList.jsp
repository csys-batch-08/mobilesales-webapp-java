<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">


<title>Product List</title>
</head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 10px;
}

.btn_add {
	padding: 12px;
	background-color: lightbrown;
	border-radius: 22px;
}

.btn_add:hover {
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
	background-color: rgb(248, 213, 168);
}
#product{
width: 90%; 
margin-left: 70px;

}


body{
background-color:cornsilk;
}

* {
	margin: 0;
	padding: 0;
}
</style>
<body >
	<h2 class="h2_1">Mobile Sales App</h2>

	<div style="position: relative; top: -10px;" class="top_nav">

		<ul>

			<li style="float: right;"><a href="logOut">Logout</a></li>
			<li style="float: right;"><a class="active" href="adminMain.jsp">Admin</a></li>



		</ul>


	</div>
	<img style="border-radius: 100px;position: absolute;top:0px;left: 500px; " width="40px" alt="" src="assets/images/mobile112.png">
	
	<br>
	<br>
	<br>
	

	<table id="product" class="table table-hover table-striped" >
		<tr style="background-color: cornflowerblue">
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Description</th>
			<th>Standard Price</th>
			<th>List Price</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		
		<c:forEach items="${viewProducts}" var="viewProducts">

		<tr>
			<td>${viewProducts.id}</td>
			<td>${viewProducts.productName}</td>
			<td>${viewProducts.description}</td>
			<td>${viewProducts.standardCost}</td>
			<td>${viewProducts.listCost}</td>
			<td>

				<form action="updateProduct" method="post">

					Product Id : <input type="text" name="updateId"
						value="${viewProducts.id}"  readonly id="brand_textbox"
						pattern="[0-9]{1,8}" maxlength="8" required class="updateId"><br>
					<br> <label class="add_label1">Standard_cost :</label> <input
						type="text" name="updateStandardPrice" id="brand_textbox"
						pattern="[0-9]{1,8}" maxlength="8" required class="add_inputs1"><br>
					<br> <label class="add_label2">List Price :</label> <input
						type="text" name="updateListPrice" id="brand_textbox"
						pattern="[0-9]{1,8}" maxlength="8" required class="add_inputs2"><br>
					<br>
					<button type="submit" class="btn btn-success">Update</button>
					<br> <br>

				</form>
			</td>
			<td>
				<form action="deleteProduct" method="post">
					Product Id : <input type="text" value="${viewProducts.id}" readonly
						name="deleteId" id="brand_textbox" pattern="[0-9]{1,8}"
						maxlength="8" required class="deleteId"><br> <br>
					<button type="submit" class="btn btn-danger">Delete</button>
					<br> <br>

				</form>
			</td>
		</tr>
		</c:forEach>
	</table>


	
</body>
</html>