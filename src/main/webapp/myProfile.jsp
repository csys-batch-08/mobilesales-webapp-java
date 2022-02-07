
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
<script type="text/javascript" src="assets/javascript/myProfile.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.6.5/sweetalert2.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.6.5/sweetalert2.common.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.6.5/sweetalert2.min.js"></script>

<title>MobileProfile</title>
<link rel="stylesheet" href="assets/css/user.css">
</head>


<body>
<jsp:include page="userHeader.jsp"></jsp:include>
		<br>
	<c:forEach items="${listAllDetails}" var="listAllDetail">

		<div class="user_det">
			<div class="profile">

				<p>
				<h2 style="position: absolute; left: 150px;">MyProfile</h2>
				</p>
				<br> <br> <br>

				<p>
					<label>Name : </label> <input type="text" required class="c_user"
						name="userName" id="userName" pattern="[A-Za-z.\s]{3,40}"
						value="${listAllDetail.name}"> <br> <br>
				</p>
				<p>
					<label>Email :</label> <input type="text" required class="c_user"
						readonly name="userEmail" id="userEmail"
						value="${listAllDetail.email}"> <br> <br>
				</p>
				<p>
					<label>Phone :</label> <input class="c_user" required type="text"
						pattern="[6789]{1}[0-9]{9}" maxlength="10" name="userPhone"
						id="userPhone" value="${listAllDetail.phoneNumber}"> <br>
					<br>
				</p>
				<p>
					<input type="text" required class="c_user" name="userWallet"
						id="userWallet" readonly value="${listAllDetail.wallet}">
					<label for="userWallet">Wallet :</label> <br> <br>
				</p>
				<p>
					<button style="margin-left: 120px" class="btn btn-primary"
						onclick="updateProfile()" type="submit">Update</button>


				</p>
				<button style="margin-left: 113px;margin-top: 10px;"  type="button" class="btn btn-primary" data-bs-toggle="modal"
					data-bs-target="#myModal">Recharge</button>

				<div class="modal" id="myModal">
					<div class="modal-dialog">
						<div class="modal-content">

						
							<div class="modal-header">
								<h4 class="modal-title">Recharge Wallet</h4>
								<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
							</div>

							<div class="modal-body">
								<form action="addWallet" method="post">
								<p>
								 <input type="text" name="walletAmount"
										pattern="[1-9][0-9]{1,8}" maxlength="8"
										title="Only enter positive number" required> Wallet :<br>
								
									</p>
									<br> <input
										style="display: table-cell; position: absolute; left: 80px;"
										type="hidden" name="walletUserId"
										value="${listAllDetail.userId}" readonly pattern="[0-9]{1,8}"
										maxlength="8" required>



									<button type="submit" class="btn btn-success">Submit</button>


								</form>
							</div>


							<div class="modal-footer">
								<button type="button" class="btn btn-danger"
									data-bs-dismiss="modal">Close</button>
							</div>

						</div>
					</div>
				</div>


				<div id="snackbar">Profile Updated Successfully</div>


				<div></div>
			</div>
		</div>
	</c:forEach>
	

</body>
</html>