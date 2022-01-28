<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style type="text/css">
.text-info {
	margin-top: -50px;
}

.cont {
	position: absolute;
	background-color: white;
	left: 500px;
	top: 100px;
	padding: 30px;
	border-radius: 40px;
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

	
}

.c_sub {
	padding: 12px;
	margin-left: 100px;
	background-color: rgb(83, 83, 204);
	border-radius: 20px;s
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
.btn{

width: 300px;
}
.form-control{

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

			<div class="container mt-1">
			<form action="add1" method="post" class="was-validated">
				<h3 class="c_login">Login</h3>
				<label class="form-label" for="">Email</label><br> <input
					autocomplete="off" autofocus class="form-control"
					pattern="[a-z][a-z0-9_.]+@[a-z0-9.]+[.][a-z]+"
					title="Enter valid email ex(example12@gmail.com)" name="username"
					type="email" required><br>  <label
					class="form-label" for="">Password</label><br> <input
					autocomplete="off" class="form-control"
					pattern="(?=.*\d)(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}"
					title="Enter atleast one upper case, one lowercase, specialcharacter and one number,and atleast 8 or more character"
					name="password" type="password" required><br>
				<br>
				<button class="btn btn-primary btn-block" type="submit">Login
				</button><br>
				<br> <a class="btn btn-primary btn-block" href="Register.jsp">Register</a><br>
				<br> <a style="margin-left: 80px;"  href="ForgotPassword.jsp">Forgot
					password</a><br> <br>
					<c:if test="${loginError!=null}">
					<h6 style="color: red ; margin-left: 60px;">${loginError}</h6>
					
					</c:if>
					<c:remove var="loginError" scope="session" />	
				
			</form>
			</div>

			



		</div>
	</div>

</body>
</html>