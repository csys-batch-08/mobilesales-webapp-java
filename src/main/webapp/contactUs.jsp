<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet" href="assets/css/user.css">
<title>ContactUs</title>
</head>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Heebo&family=Roboto:ital@1&display=swap');
</style>
<body>
<jsp:include page="userHeader.jsp"></jsp:include>

	<br>
	<br>
	<div class="container2">



		<form action="contactUs" method="post">
			<h1 style="margin-left: 200px;">Contact Us</h1>
			<p>
				<label for="">Name:</label> <input class="c_user" name="name1"
					type="text" id="name1" autocomplete="off" pattern="[A-Za-z]{3,40}"
					title="Only enter A-Z ,a-z and enter  min 3 to max 40 " required><br>
				<br>
			</p>
			<p>

				<label for="">Email:</label> <input class="c_user" name="email"
					autocomplete="off" id="email" pattern="[a-z][a-z0-9_.]+@[a-z0-9.]+[.][a-z]+"
					type="email" title="Enter valid email ex(example12@gmail.com)"
					required><br> <br>
			</p>
			<p>
				<label for="">Phone :</label> <input class="c_user"
					autocomplete="off" id="phone_number" name="phone_number" type="text"
					pattern="[6789]{1}+[0-9]{9}" maxlength="10"
					title="Enter only 10 digit number" required><br> <br>
			</p>

			<p>
				<label for="">Description :</label> <input style="margin-left: 0px"
					class="c_user" name="description" id="description" type="text" autocomplete="off"
					pattern="[a-zA-Z0-9\s,[]]{3,40}"
					title="Only enter A-Z ,a-z and enter  min 3 to max 40 " required><br>
				<br>
			</p>

			<br>
			<p>
				<button style="margin-left: 250px" type="submit"
					class="btn btn-primary">Submit</button>
			</p>

		</form>
	</div>



</body>
</html>