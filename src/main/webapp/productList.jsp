<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>


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

#product {
	width: 90%;
	margin-left: 70px;
}

body {
	background-color: cornsilk;
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

	
	<br>
		<div class="searchPro">
			<form class="input-group mb-7" action="SearchProduct">
				<input class="form-control" type="text" pattern="[A-Za-z]{1,40}" name="search">
				<button class="btn btn-primary" type="submit">Search</button>
			</form>
		</div>
		<br>


	<table aria-describedby="Show All home places" id="product"
		class="table table-hover table-striped">
		<tr style="background-color: cornflowerblue">
			<th>Serial No</th>
			<th>Product Name</th>
			<th>Description</th>
			<th>Standard Price</th>
			<th>List Price</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:set var="serialNumber" value="1" scope="page"></c:set>
		<c:forEach items="${viewProducts}" var="viewProducts">

			<tr>
				<td>${serialNumber}</td>
				<td>${viewProducts.productName}</td>
				<td>${viewProducts.description}</td>
				<td>${viewProducts.standardCost}</td>
				<td>${viewProducts.listCost}</td>
				<td>

					<div class="container mt-3">


						<button type="button" class="btn btn-primary"
							data-bs-toggle="modal" data-bs-target="#myModal_${serialNumber}">Update
						</button>
					</div> <!-- The Modal -->
					<div class="modal fade" id="myModal_${serialNumber}">
						<div class="modal-dialog">
							<div class="modal-content">

								<!-- Modal Header -->
								<div class="modal-header">
									<h4 class="modal-title">Update Price</h4>
									<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
								</div>

								<!-- Modal body -->
								<div class="modal-body">
									<form action="updateProduct" method="post">

										Product Id : <input type="text" name="updateId"
											value="${viewProducts.id}" readonly id="brand_textbox"
											pattern="[0-9]{1,8}" maxlength="8" required class="updateId"><br>
										<br> <label class="add_label1">Standard_cost :</label> <input
											type="text" name="updateStandardPrice" id="brand_textbox"
											pattern="[0-9]{1,8}" maxlength="8" required
											class="add_inputs1"><br> <br> <label
											class="add_label2">List Price :</label> <input type="text"
											name="updateListPrice" id="brand_textbox"
											pattern="[0-9]{1,8}" maxlength="8" required
											class="add_inputs2"><br> <br>
										<button type="submit" class="btn btn-success">Confirm</button>
										<br> <br>

									</form>
								</div>

								<!-- Modal footer -->
								<div class="modal-footer">
									<button type="button" class="btn btn-danger"
										data-bs-dismiss="modal">Close</button>
								</div>

							</div>
						</div>
					</div>



				</td>
				<td>
				
					<div class="container mt-3">


						<button type="button" class="btn btn-danger"
							data-bs-toggle="modal" data-bs-target="#myModal1_${serialNumber}">Delete
						</button>
					</div> <!-- The Modal -->
					<div class="modal fade" id="myModal1_${serialNumber}">
						<div class="modal-dialog">
							<div class="modal-content">

								<!-- Modal Header -->
								<div class="modal-header">
									<h4 class="modal-title">Delete Product</h4>
									<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
								</div>

								<!-- Modal body -->
								<div class="modal-body">
								<p>Do you want to Delete this Product(${viewProducts.productName})</p>
									<form action="deleteProduct" method="post">
						 <input type="hidden" value="${viewProducts.id}"
							readonly name="deleteId" id="brand_textbox" pattern="[0-9]{1,8}"
							maxlength="8" required class="deleteId"><br>
						<button type="submit" class="btn btn-primary">Confirm</button>
						<br> 

					</form>
								</div>

								<!-- Modal footer -->
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


</body>
</html>