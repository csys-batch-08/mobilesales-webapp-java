<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Register page</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="assets/css/login.css">





</head>
<script>
	function match() {

		let psd1 = document.getElementById("pwd1");
		let psd2 = document.getElementById("pwd2");
		if (psd1.value.trim() != psd2.value.trim()) {
			document.getElementById("pws").innerHTML = "Password must be same";
			// alert()
			return false;
		} else {

			return true;
		}
	}
</script>


<body>
	<div class="full">

		<div class="containe">
			<div class="container mt-1">
				<form action="reg" class="was-validated" onsubmit="return match()"
					method="post">

					<h2 class="c_register" style="position: absolute; left: 120px;">Register
					</h2>
					<br>
					<br> <label class="form-label" for="">Name:</label><br> <input
						autofocus autocomplete="off" class="form-control" name="name1"
						type="text" pattern="[A-Za-z\s]{3,40}"
						title="Only enter A-Z ,a-z and enter  min 3 to max 40 " required>

					<label class="form-label">Email:</label><br> <input
						autocomplete="off" class="form-control" name="email"
						pattern="[a-z][a-z0-9_.]+@[a-z0-9.]+[.][a-z]+" type="email"
						title="Enter valid email ex(example12@gmail.com)" required>

					<label class="form-label">Phone number:</label><br> <input
						autocomplete="off" class="form-control" name="phone_number"
						type="text" pattern="[6789]{1}[0-9]{9}" maxlength="10"
						title="Enter only 10 digit number" required> <label
						class="form-label">Password:</label><br> <input
						autocomplete="off" class="form-control" id="pwd1" name="password"
						type="password"
						pattern="(?=.*\d)(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}"
						title="Enter atleast one upper case and one lower case and one number ,and atleast 8 or more character"
						required> <label class="form-label">Confirm
						Password:</label><br> <input autocomplete="off" class="form-control"
						id="pwd2" name="confirm_password" type="password"
						pattern="((?=.*\d)(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}"
						title="Enter atleast one upper case and one lower case and one number ,and atleast 8 or more character"
						required>
					<p id="pws" style="color: red;"></p>
					<br>

					<button class="btn btn-primary	">Register</button>

				</form>
			</div>
		</div>
		<br>
		<br>

	</div>









</body>



</html>