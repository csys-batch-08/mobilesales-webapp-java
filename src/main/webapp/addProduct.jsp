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

		<div class="add_con">
			<form action="addproduct" method="post">
				<br>

				<h2 style="margin-left: 120px;">Add product</h2>
				<br>
				<p>
					<label class="lable">Product Name :</label> <input type="text"
						name="product_name" pattern="[a-zA-Z0-9\s,[]]{3,40}"
						id="brand_textbox" required class="add_inputs1"><br>
					<br>
				</p>
				<p>
					<label class="add_label1">Description :</label> <input type="text"
						name="description" id="brand_textbox" pattern="[a-zA-Z\s]{3,60}"
						required class="add_inputs1"><br>
					<br>
				</p>
				<p>
					<label class="add_label1">Standard_cost :</label> <input
						type="text" name="standard_cost" id="brand_textbox"
						pattern="[0-9]{1,8}" maxlength="8" required class="add_inputs1"><br>
					<br>
				</p>
				<p>
					<label class="add_label2">List Price :</label> <input type="text"
						name="list_price" id="brand_textbox" pattern="[0-9]{1,8}"
						maxlength="8" required class="add_inputs1"><br>
					<br>
				</p>
				<button type="submit" style="margin-left: 130px"
					class="btn btn-success">Submit</button>
				<br>
				<br>


			</form>
			<br> <br>


		</div>
	</div>




</body>
</html>