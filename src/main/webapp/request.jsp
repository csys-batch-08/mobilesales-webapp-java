<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Request Page</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style type="text/css">
.text-info {
	margin-top: -50px;
}

.cont {
	position: absolute;
	background-color: white;
	left: 500px;
	top: 100px;
	padding: 40px;
	border-radius: 40px;
	padding-bottom: 60px;
}

.c_login {
	font-size: 30px;
	color: black;
	margin-left: 100px;
	/* text-align: ; */
}

body {
	
}

.c_user {
	border-top: none;
	border-left: none;
	border-right: none;
	width: 300px;
	height: 25px;
}

.c_sub {
	padding: 12px;
	margin-left: 100px;
	background-color: rgb(83, 83, 204);
	border-radius: 20px;
}

.c_sub:hover {
	background-color: gray;
	color: black;
}

.c_reg {
	padding: 12px;
	background-color: rgb(83, 83, 204);
	border-radius: 20px;
	text-decoration: none;
	margin-left: 92px;
	border-color: black;
	color: black;
}

.c_reg:hover {
	background-color: gray;
	color: black;
}

.full {
	background: linear-gradient(rgba(0, 0, 0, .3) 50%, rgba(0, 0, 0, .3)
		-50%),
		url(https://www.kindpng.com/picc/m/478-4787076_mobile-frame-png-full-hd-mobiles-kartik-creation.png);
	background-repeat: no-repeat;
	background-size: cover;
	height: 100vh;
}

* {
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>
	<div class="full">
		<div class="cont">

			<form action="req" method="post">
				<h3 class="c_login">Request</h3>
				<label class="c_lab" for="">Email</label><br> <input
					autocomplete="off" autofocus class="c_user"
					pattern="[a-z][a-z0-9_.]+@[a-z0-9.]+[.][a-z]+" readonly
					title="Enter valid email ex(example12@gmail.com)" value="${email }"
					name="username" type="email" required><br> <br> <label
					class="c_lab" for="">Reason</label><br> <input
					autocomplete="off" class="c_user" pattern="[A-Za-z.\s]{3,80}"
					title="Enter valid character" name="reason" type="text" required><br>
				<br> <br>
				<button style="margin-left: 100px;"
					class="btn btn-primary btn-block" type="submit">Submit</button>





			</form>



		</div>
	</div>

</body>
</html>