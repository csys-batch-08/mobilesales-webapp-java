<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet" href="assets/css/login.css">
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
						type="email" required><br> <label class="form-label"
						for="">Password</label><br> <input autocomplete="off"
						class="form-control"
						pattern="(?=.*\d)(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}"
						title="Enter atleast one upper case, one lowercase, specialcharacter and one number,and atleast 8 or more character"
						name="password" type="password" required><br> <br>
					<button class="btn btn-primary btn-block" type="submit">Login
					</button>
					<br> <br> <a class="btn btn-primary btn-block"
						href="register.jsp">Register</a><br> <br> <a
						style="margin-left: 80px;" href="forgotPassword.jsp">Forgot
						password</a>
					<c:if test="${loginError!=null}">
						<div class="alert alert-danger">
							<h6 style="color: red; margin-left: 30px;">${loginError}</h6>
						</div>
					</c:if>
					<c:remove var="loginError" scope="session" />
					<c:if test="${request!=null}">
						<div class="alert alert-success">
							<h6 style="color: green; margin-left: 60px;">${request}</h6>
						</div>
					</c:if>
					<c:remove var="request" scope="session" />

				</form>
			</div>





		</div>
	</div>

</body>
</html>